package com.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.el.parser.ParseException;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.entity.Article;
import com.entity.ArticleIndexSearch;
import com.entity.Course;
import com.entity.CourseIndexSearcher;
/**
 * 
 *@desc:lucene索引
 *@author chunhui
 *@date:Dec 12, 20189:42:01 AM
 */
public class TestLucene extends  FileManager{
	//关于课程在索引库中存储的字段
	private static final String COURSE_ID = "courseId";	//该课程的ID
	private static final String COURSE_TITLE = "courseTitle";	//课程标题
	private static final String COURSE_SYNOPSIS = "courseSynopsis";	//课程简介
	private static final String COURSE_INTRODUCTION = "courseIntroduction";	//课程介绍
	//关于文章在索引库中存储的字段
	private static final String ARTICLE_ID="articleId";//文章id
	private static final String ARTICLE_TITLE="articleTitle";//文章标题
	private static final String ARTICLE_INTRODUCTION="articleIntroduction";//文章介绍
	private static final String ARTICLE_CONTENT="articleContent";//文章正文
	private static final String PUBLICATIONTIME="publicationTime";
	private int lastId1;
	//关于咨询师在索引库中存储的字段
	/**
	 * 
	 *@desc:建立索引
	 *@param listCourses
	 *@return:void
	 * @throws IOException 
	 *@trhows
	 */
	public void createIndex(List<Course> listCourses,List<Article> listArticles) throws IOException{
	
		IndexWriter writer=null;
	      try{
    		//创建索引写入器 	
	        Directory d = FSDirectory.open(new File("d:/lucene/"));
	        Analyzer analyzer = getAnalyzer();
	        writer = new IndexWriter(d, analyzer, true, IndexWriter.MaxFieldLength.LIMITED);
	        for(int i=0;i<listCourses.size();i++) {
	        	  Document doc=new Document();
	        	  doc.add(new Field(COURSE_ID,String.valueOf(listCourses.get(i).getCourseId()),Store.YES,Index.ANALYZED));
		          doc.add(new Field(COURSE_TITLE, listCourses.get(i).getCourseName(), Store.YES,Index.ANALYZED));
		          doc.add(new Field(COURSE_SYNOPSIS, listCourses.get(i).getCourseSynopsis(), Store.YES,Index.ANALYZED));
		          doc.add(new Field(COURSE_INTRODUCTION, listCourses.get(i).getCourseIntroduction(), Store.YES,Index.ANALYZED));
		          writer.addDocument(doc);  
	          }
	        
	        for(int j=0;j<listArticles.size();j++) {
	        	Document doc=new Document();
	        	doc.add(new Field(ARTICLE_ID, String.valueOf(listArticles.get(j).getArticleId()),Store.YES,Index.ANALYZED));
	        	doc.add(new Field(ARTICLE_TITLE,listArticles.get(j).getArticleName() ,Store.YES,Index.ANALYZED));
	        	doc.add(new Field(ARTICLE_INTRODUCTION,listArticles.get(j).getArticleIntroduction() ,Store.YES,Index.ANALYZED));
	        	doc.add(new Field(ARTICLE_CONTENT,listArticles.get(j).getArticleContent() ,Store.YES,Index.ANALYZED));
	        	doc.add(new Field(PUBLICATIONTIME,listArticles.get(j).getArticlePublishTime().toString() ,Store.YES,Index.ANALYZED));
	        	writer.addDocument(doc);
	        }
	        
	        writer.commit();
	        writer.close();
	    //    isImplement=true;
	      }
	      catch(IOException e){
	        System.out.println(e);
	      }finally {
	    	  if(writer!=null) {	  
	    		  writer.close();
	    	  }
	      }
	    }
		/**
		 * 
		 *@desc:二分法分词器
		 *@return
		 *@return:Analyzer
		 *@trhows
		 */
	    public static Analyzer getAnalyzer(){
	      return new CJKAnalyzer(Version.LUCENE_30);
	    }
	   /**
	    * 
	    *@desc:查询课程对应的索引
	    *@param queryString要查找的内容
	    *@return
	    *@throws IOException
	    *@throws ParseException
	    *@return:List<CourseIndexSearcher>返回查到的结果集
	 * @throws org.apache.lucene.queryParser.ParseException 
	    *@trhows
	    */
	    public List<CourseIndexSearcher> seacher(String queryString) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException{
	    
	    	//1.创建索引写入器,指出索引在硬盘上的存储位置
		    Directory d = FSDirectory.open(new File("d:/lucene/"));
		    //创建分词器
		   Analyzer analyzer = getAnalyzer();
		    //创建索引查询对象
		   IndexSearcher searcher = new IndexSearcher(d);
		    //待查找字符串对应的字段
		    String[] fields= {COURSE_TITLE,COURSE_SYNOPSIS,COURSE_INTRODUCTION};
		    //Occur.SHOULD代表对应字段应该存在查询值（不必须存在）
	    	Occur[] occurs= {Occur.SHOULD,Occur.SHOULD,Occur.SHOULD};
	    	Query query=MultiFieldQueryParser.parse(Version.LUCENE_30, queryString, fields, occurs, analyzer);
	    	TopDocs topDocs =searcher.search(query, 100);
	    	ScoreDoc[] docs = topDocs.scoreDocs;
	    	List<CourseIndexSearcher> listCour=new ArrayList<CourseIndexSearcher>();
	    	int i=0;
	    	for(i=0;i<docs.length;i++) {
	    		int docId=docs[i].doc;	
	    		Document document = searcher.doc(docId);
	    		CourseIndexSearcher c=new CourseIndexSearcher();
	    		c.setCourseId(String.valueOf(docs[i].doc+1));
	    		c.setCourseTitle(document.get(COURSE_TITLE));
	    		c.setCourseSynopsis(document.get(COURSE_SYNOPSIS));
	    		c.setCourseIntroduction(document.get(COURSE_INTRODUCTION));
	    		listCour.add(c);
	    	}
	    	lastId1=docs[i-1].doc;
	    
	    	return listCour;
	    	
	      }
	    
	    public List<ArticleIndexSearch> seacherArticle(String queryString) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException{
	    
	    	//1.创建索引写入器,指出索引在硬盘上的存储位置
		    Directory d = FSDirectory.open(new File("d:/lucene/"));
		    //创建分词器
		   Analyzer analyzer = getAnalyzer();
		    //创建索引查询对象
		   IndexSearcher searcher = new IndexSearcher(d);
		    //待查找字符串对应的字段
		    String[] fields= {ARTICLE_TITLE,ARTICLE_INTRODUCTION,ARTICLE_CONTENT};
		    //Occur.SHOULD代表对应字段应该存在查询值（不必须存在）
	    	Occur[] occurs= {Occur.SHOULD,Occur.SHOULD,Occur.SHOULD};
	    	Query query=MultiFieldQueryParser.parse(Version.LUCENE_30, queryString, fields, occurs, analyzer);
	    	TopDocs topDocs =searcher.search(query, 100);
	    	ScoreDoc[] docs = topDocs.scoreDocs;
	    	List<ArticleIndexSearch> listArti=new ArrayList<ArticleIndexSearch>();
	    	for(int i=0;i<docs.length;i++) {
	    		int docId=docs[i].doc;
	    		Document document = searcher.doc(docId);
	    		ArticleIndexSearch a=new ArticleIndexSearch();
	    		a.setArticleId(String.valueOf(docs[i].doc-lastId1));
	    		a.setArticleTitle(document.get(ARTICLE_TITLE));
	    		a.setArticleIntroduction(document.get(ARTICLE_INTRODUCTION));
	    		a.setArticleContent(document.get(ARTICLE_CONTENT));
	    		a.setPublicationTime(document.get(PUBLICATIONTIME));
	    		listArti.add(a);
	    	}
	    	return listArti;
	    	
	      }
}
