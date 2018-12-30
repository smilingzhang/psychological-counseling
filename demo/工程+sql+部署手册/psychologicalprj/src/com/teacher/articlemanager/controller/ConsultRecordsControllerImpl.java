package com.teacher.articlemanager.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Article;
import com.entity.BusinessType;
import com.entity.ConsultationRecord;
import com.entity.ListenRecord;
import com.entity.Teacher;
import com.entity.TypeTable;
import com.entity.User;
import com.google.gson.Gson;
import com.psychologicalcounseling.user.service.UserService;
import com.entity.Artshow;
import com.entity.FinLisRecord;
import com.teacher.articlemanager.service.ConsultRecordsServiceImpl;
import com.teacher.articlemanager.service.DeleteArticleServiceImpl;
import com.teacher.articlemanager.service.OperateArticleServiceImpl;
import com.teacher.articlemanager.service.PublishArticleServiceImpl;
import com.teacher.articlemanager.service.SelectArticleServiceImpl;
import com.teacher.articlemanager.service.TypetableServiceImpl;
import com.util.Page;
import com.util.SubTime;

@Controller
@RequestMapping(value="/consultTeacher")
public class ConsultRecordsControllerImpl {
	
	@Resource
	private ConsultRecordsServiceImpl consultRecordsServiceImpl;
	@Resource
	private PublishArticleServiceImpl publishArticleServiceImpl;
	@Resource
	private TypetableServiceImpl typetableServiceImpl;
	@Resource
	private SelectArticleServiceImpl selectArticleServiceImpl;
	@Resource
	private DeleteArticleServiceImpl deleteArticleServiceImpl;
	@Resource
	private OperateArticleServiceImpl operateArticleServiceImpl;
	private Logger logger = Logger.getLogger(ConsultRecordsControllerImpl.class);
	
	/**
	 * 查询文章所有的类别
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/articleTypeTable")
	@ResponseBody
	public void articleTypeTable(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int businesstypeWorkType =  5;
		List<TypeTable> typetableList = this.typetableServiceImpl.findtypeTable(businesstypeWorkType);
		
		session.setAttribute("typetableList", typetableList);
		request.getRequestDispatcher("/consultTeacher/articleshow").forward(request, response);
	}
	
	/**
	 * 咨询记录（已咨询、未咨询、已取消）
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="/consultRecord")
	@ResponseBody
	public void publish(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		
		
		int teacherId = 4;
		
		String pagenum1 = request.getParameter("pageNum1");        //获取页码
		int pageNum1;
		if(pagenum1==""||pagenum1==null) {
			pageNum1=1;
		}else {
			pageNum1 = Integer.parseInt(pagenum1);
		}
		
		//定义分页大小
		int pageSize1 = 8;

		//分页查询咨询师的咨询订单（包括已咨询、未咨询、已取消）
		List<ConsultationRecord> finishedList = this.consultRecordsServiceImpl.findFinishedConsultationRecordByPage(pageNum1,pageSize1,teacherId);
		List<ConsultationRecord> todoList = this.consultRecordsServiceImpl.findTodoConsultationRecordByPage(pageNum1,pageSize1,teacherId);
		List<ConsultationRecord> canceledList = this.consultRecordsServiceImpl.findCanceledConsultationRecordByPage(pageNum1,pageSize1,teacherId);
		
		//查询出咨询师的订单数量（包括已咨询，未咨询、已取消）
		int finishedCount = this.consultRecordsServiceImpl.findCountFinishedConsultationRecord(teacherId);
		int canceledCount = this.consultRecordsServiceImpl.findCountCanceledConsultationRecord(teacherId);
		int todoCount = this.consultRecordsServiceImpl.findCountTodoConsultationRecord(teacherId);
		
		//创建Page对象（包括已咨询，未咨询，已取消）
		Page<ConsultationRecord> finishedPage = new Page<ConsultationRecord>(pageNum1,pageSize1);
		finishedPage.setList(finishedList);
		finishedPage.setTotalCount(finishedCount);
		Page<ConsultationRecord> todoPage = new Page<ConsultationRecord>(pageNum1,pageSize1);
		todoPage.setList(todoList);
		todoPage.setTotalCount(todoCount);
		Page<ConsultationRecord> canceledPage = new Page<ConsultationRecord>(pageNum1,pageSize1);
		canceledPage.setList(canceledList);
		canceledPage.setTotalCount(canceledCount);
		
		request.setAttribute("finishedConsultPage", finishedPage);
		request.setAttribute("todoConsultPage", todoPage);
		request.setAttribute("canceledConsultPage", canceledPage);
		request.setAttribute("finishedConsultCount", finishedCount);
		request.setAttribute("todoConsultCount", todoCount);
		request.setAttribute("canceledConsultCount", canceledCount);
		
		request.getRequestDispatcher("/consultTeacher/ListenRecords").forward(request, response);
	}
	
	/**
	 * 倾听记录（已倾听、未倾听、已取消）
	 * @param request
	 * @param session
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/ListenRecords")
	public void listenRecords(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws ParseException {


		int teacherId = 4;         
		
		String pagenum2 = request.getParameter("pageNum2");        //获取页码
		int pageNum2;
		if(pagenum2==""||pagenum2==null) {
			pageNum2 = 1;
		}else {
			pageNum2 = Integer.parseInt(pagenum2);
		}
		
		int pageSize2 = 8;
		//分页查询咨询师的倾听记录表（已倾听、未倾听、已取消）
		List<ListenRecord> finishedList = this.consultRecordsServiceImpl.findFinishedListenRecordByPage(pageNum2, pageSize2, teacherId);
		List<FinLisRecord> finLisRecordList = new ArrayList<FinLisRecord>();
		for(int i = 0;i<finishedList.size();i++) {
			String st = finishedList.get(i).getListenrecordStartTime();
			String et = finishedList.get(i).getListenrecordEndTime();
			SubTime submit = new SubTime();
			long listentime = submit.subTimeMinutesDivTenUpstairs(st, et);
			FinLisRecord finLisRecord = new FinLisRecord();
			finLisRecord.setListenRecord(finishedList.get(i));
			finLisRecord.setListenTime(listentime);
			finLisRecordList.add(finLisRecord);
		}
		List<ListenRecord> todoList = this.consultRecordsServiceImpl.findTodoListenRecordByPage(pageNum2, pageSize2, teacherId);
		List<ListenRecord> canceledList = this.consultRecordsServiceImpl.findCanceledListenRecordByPage(pageNum2, pageSize2, teacherId);
		
		//查询出咨询师的倾听数量
		int finishedCount = this.consultRecordsServiceImpl.findCountfinishedListenRecord(teacherId);
		int todoCount = this.consultRecordsServiceImpl.findCounttodoListenRecord(teacherId);
		int canceledCount = this.consultRecordsServiceImpl.findCountcanceledListenRecord(teacherId);
		
		//创建page对象（包括已倾听，未倾听，已取消）
		Page<FinLisRecord> finishedPage = new Page<FinLisRecord>(pageNum2,pageSize2);
		finishedPage.setList(finLisRecordList);
		finishedPage.setTotalCount(finishedCount);
		Page<ListenRecord> todoPage = new Page<ListenRecord>(pageNum2,pageSize2);
		todoPage.setList(todoList);
		todoPage.setTotalCount(todoCount);
		Page<ListenRecord> canceledPage = new Page<ListenRecord>(pageNum2,pageSize2);
		canceledPage.setList(canceledList);
		canceledPage.setTotalCount(canceledCount);
		
		request.setAttribute("finishedListenPage", finishedPage);
		request.setAttribute("todoListenPage", todoPage);
		request.setAttribute("canceledListenPage", canceledPage);
		request.setAttribute("finishedListenCount", finishedCount);
		request.setAttribute("todoListenCount", todoCount);
		request.setAttribute("canceledListenCount",canceledCount);
		try {
			request.getRequestDispatcher("/background?teacherId=4&page=2").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 文章管理列表展示
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="/articleshow")
	public void articlelistshow(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		int teacherId = 4;
		
		String pagenum3 = request.getParameter("pageNum3");
		int pageNum3;
		if(pagenum3==""||pagenum3==null) {
			pageNum3 = 1;
		}else {
			pageNum3 = Integer.parseInt(pagenum3);
		}
		
		int pageSize3 = 8;
		//查出咨询师发表文章的总数
		int articleCount = this.selectArticleServiceImpl.findArticleCount(teacherId);
		
		//分页查询咨询师的文章
		List<Article> articleList = this.selectArticleServiceImpl.findArticleByPage(pageNum3, pageSize3, teacherId);
		
		List<Artshow> artshowList = new ArrayList<Artshow>();
		for(int i = 0;i<articleList.size();i++) {
			int articleId = articleList.get(i).getArticleId();
			//查询出咨询师文章的类别
			List<TypeTable> typetableList = this.selectArticleServiceImpl.findTypeTableById(articleId);
			//查询出评论的数量
			int evaluateCount = this.selectArticleServiceImpl.findEvaluateCountById(articleId); 
			//新建artshow对象
			Artshow<TypeTable> artshow = new Artshow<TypeTable>();
			artshow.setArticleId(articleId);
			artshow.setTypetableList(typetableList);
			artshow.setArticleName(articleList.get(i).getArticleName());
			artshow.setArticleIntroduction(articleList.get(i).getArticleIntroduction());
			artshow.setArticleLookNumber(articleList.get(i).getArticleLookNumber());
			artshow.setEvaluateCount(evaluateCount);
			artshow.setArticlePublishTime(articleList.get(i).getArticlePublishTime());
			//将artshow对象插入列表
			artshowList.add(artshow);
		}
		
		Page<Artshow> artshowPage = new Page<Artshow>(pageNum3,pageSize3);
		artshowPage.setList(artshowList);
		artshowPage.setTotalCount(articleCount);
		
		request.setAttribute("artshowPage", artshowPage);
		request.setAttribute("artshowList", artshowList);
		request.setAttribute("articleCount", articleCount);
		request.getRequestDispatcher("/consultTeacher/consultRecord").forward(request, response);
	}
	
	/**
	 * 发表文章
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="/publishArticle")
	public void publisharticle(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {

		
		int teacherId = 4;
		//获取咨询师
		Teacher teacher = this.publishArticleServiceImpl.findTeacherByUserId(teacherId);  
		
		//获取文章名字
		String articleName = request.getParameter("articleName");     
		
		/**
		 * 图片上传下载没写
		 */
		
		
		//获取文章的简介
		String articleIntroduction = request.getParameter("articleIntroduction");	 
		logger.info(articleIntroduction);
		
		//获取文章的内容
		String articleContent = request.getParameter("articleContent");        
		logger.info(articleContent);
		
		//创建article对象
		Article article = new Article();
		article.setArticleName(articleName);
		article.setArticleImgPath("teacher.png");
		article.setArticleIntroduction(articleIntroduction);
		article.setArticleContent(articleContent);
		article.setArticlePublishTime(new Date());
		article.setArticleLookNumber(0);
		article.setTeacher(teacher);
		
		//将获取的文章插入文章表（article）【还需要插入业务类别表】
		this.publishArticleServiceImpl.AddpassageToArticle(article);       
		
		//查询出文章Id(方便创建businessType表)
		int businesstypeWordId = this.publishArticleServiceImpl.findArticleIdByArticleNameAndTeacher(articleName, teacher);
		
		 //获取文章的类别
		String id = request.getParameter("articletype");       
		int typeTableId = Integer.parseInt(id);
		TypeTable typeTable = this.publishArticleServiceImpl.findTypeTableByTypeTableId(typeTableId);
		
		//创建businesstype对象
		BusinessType businessType = new BusinessType();        
		businessType.setBusinesstypeWorkType(5);
		businessType.setBusinesstypeWorkId(businesstypeWordId);
		businessType.setTypeTable(typeTable);
		
		//将文章插入businesstype数据库表中
		this.publishArticleServiceImpl.AddpassageToBusinessType(businessType);
		
		request.setAttribute("alert", "文章发表成功");
		request.getRequestDispatcher("/consultTeacher/articleTypeTable").forward(request, response);;
	}
	
	@RequestMapping(value="/upload")
	@ResponseBody
	public String uploadImage(@RequestParam(value="name") String name,HttpServletRequest request,HttpServletResponse response) {
		String rootPath="c:/";
		InputStream is;
		
		try {
			is = request.getInputStream();
			logger.info("name:"+name);
			FileOutputStream fos = new FileOutputStream(rootPath+"/"+name);
			byte [] cache = new byte[is.available()];
			fos.write(cache);
			is.close();
			fos.flush();
			fos.close();
			logger.info("上传成功");
			return "{result:200}";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{result:'failed',message:'文件内容包含违规信息'}";
		}
	}
	
	@RequestMapping(value="/deleteArticle",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String deleteArticle(@RequestParam(value="articleId") int articleId,HttpServletRequest request,HttpServletResponse response) {
		this.deleteArticleServiceImpl.deleteArticle(articleId);
		int teacherId = 4;
		
		String pagenum3 = request.getParameter("pageNum3");
		int pageNum3;
		if(pagenum3==""||pagenum3==null) {
			pageNum3 = 1;
		}else {
			pageNum3 = Integer.parseInt(pagenum3);
		}
		
		int pageSize3 = 8;
		//查出咨询师发表文章的总数
		int articleCount = this.selectArticleServiceImpl.findArticleCount(teacherId);
		
		//分页查询咨询师的文章
		List<Article> articleList = this.selectArticleServiceImpl.findArticleByPage(pageNum3, pageSize3, teacherId);
		
		List<Artshow> artshowList = new ArrayList<Artshow>();
		for(int i = 0;i<articleList.size();i++) {
			int articleIds = articleList.get(i).getArticleId();
			//查询出咨询师文章的类别
			List<TypeTable> typetableList = this.selectArticleServiceImpl.findTypeTableById(articleIds);
			//查询出评论的数量
			int evaluateCount = this.selectArticleServiceImpl.findEvaluateCountById(articleIds); 
			//新建artshow对象
			Artshow<TypeTable> artshow = new Artshow<TypeTable>();
			artshow.setArticleId(articleIds);
			artshow.setTypetableList(typetableList);
			artshow.setArticleName(articleList.get(i).getArticleName());
			artshow.setArticleIntroduction(articleList.get(i).getArticleIntroduction());
			artshow.setArticleLookNumber(articleList.get(i).getArticleLookNumber());
			artshow.setEvaluateCount(evaluateCount);
			artshow.setArticlePublishTime(articleList.get(i).getArticlePublishTime());
			//将artshow对象插入列表
			artshowList.add(artshow);
		}
		
		Page<Artshow> artshowPage = new Page<Artshow>(pageNum3,pageSize3);
		artshowPage.setList(artshowList);
		artshowPage.setTotalCount(articleCount);
		Gson json = new Gson();
		String msg = json.toJson(artshowPage);
		return msg;
		
	}
	
	/**
	 * 根据文章Id删除文章
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="/deleteArticle")
	public void deleteArticle(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		//获取文章Id
		String articleid = request.getParameter("articleId");
		int articleId = Integer.parseInt(articleid);
		logger.info(articleId);
		//根据文章Id删除文章对应的businesstype
		this.operateArticleServiceImpl.deleteBusinessType(articleId);
		//根据文章Id删除文章
		this.operateArticleServiceImpl.deleteArticle(articleId);
		
		request.getRequestDispatcher("/consultTeacher/articleTypeTable").forward(request, response);
	}
	
	@RequestMapping(value="/usermessage",method=RequestMethod.POST)
	@ResponseBody
	public User userMassage(@RequestParam(value="userId") String userId,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		logger.info("userId:"+userId);
		int userid = Integer.parseInt(userId);
		//根据用户Id 查询用户信息
		User user = this.consultRecordsServiceImpl.findUserByUserId(userid);
		return user;
	}

	
}




























