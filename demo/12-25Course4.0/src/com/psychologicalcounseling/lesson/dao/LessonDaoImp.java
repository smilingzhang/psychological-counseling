package com.psychologicalcounseling.lesson.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.BusinessType;
import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.entity.CourseCatalog;
import com.psychologicalcounseling.entity.Evaluate;
import com.psychologicalcounseling.entity.GoodAt;
import com.psychologicalcounseling.entity.Page;
import com.psychologicalcounseling.entity.Teacher;
import com.psychologicalcounseling.entity.TypeTable;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.util.BaseDao;
import com.psychologicalcounseling.util.CourseNumComparator;
import com.psychologicalcounseling.util.CoursePriceComparator;
import com.psychologicalcounseling.util.CourseRebateComparator;

@Repository
public class LessonDaoImp {
	
			@Resource
			private SessionFactory sessionFactory;

/* course-list页* /
			
			/**
			 * 查询幻灯片免费人气课程
			 * @return
			 */
			public List<Course> selectFreeLesson(){
				Session session = this.sessionFactory.getCurrentSession();
				Query query = session.createQuery("from Course cou where cou.coursePrice = 0 order by cou.courseStudentNumber ");
				query.setFirstResult(0);
				query.setMaxResults(3);
				List <Course> course = query.list();
				return course;
			}
			
			/**
			 * 查询course-list top 默认四个课程
			 * @return
			 */
			public List<Course> selectTopLesson() {
				Session session = this.sessionFactory.getCurrentSession();
				Query query = session.createQuery("from Course cou where cou.coursePrice > 0 order by cou.courseStudentNumber ");
				query.setFirstResult(0);
				query.setMaxResults(4);
				List <Course> course = query.list();
				return course;	
				
			}
			
			
			

			
			
			/**
			 * 查询course-list课程的类型
			 * @param courseId
			 * @return
			 */
			public Set<TypeTable> selectLessonStyle() {
				Session session = this.sessionFactory.getCurrentSession();
				Query query = session.createQuery("from BusinessType type where type.businesstypeWorkType = 3 order by businesstypeWorkId ");
				List <BusinessType> list = query.list();
				Set <TypeTable> type = new HashSet();
				for(BusinessType temp:list) {
					type.add(temp.getTypeTable());
				}
				 List<TypeTable> types = new ArrayList<TypeTable>(type);
				return type;	
				
			}
			
		    /**
			 *  查询course-list  end课程查找类型排序的分页课程
			 * @return
		     * @throws ClassNotFoundException 
			 */
			public Page selectEndLesson(int style,int order,int pageNum,int pageSize){
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String sqlc="jdbc:mysql://127.0.0.1:3306/psychological_counseling?useUnicode=true&characterEncoding=UTF-8";
				Connection conn;
				try {
					conn = DriverManager.getConnection(sqlc,"root","");
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				int count = 0;
				Page pageCourses = new Page(pageNum,pageSize);
				List<Course> courses = new ArrayList();
				String sql = "";
				String sqls = "";
				if(style == 0) {
					if(order == 0) {
						sql = "select * from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3) limit "+(pageNum-1)*pageSize+","+pageSize;
						sqls = "select count(*) from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3)";
					}
					if(order == 1) {
						sql = "select * from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3) and coursePrice = 0 limit "+(pageNum-1)*pageSize+","+pageSize;	
						sqls = "select count(*) from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3) and coursePrice = 0";
					}
					if(order == 2) {
						sql = "select * from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3) and coursePrice > 0 limit "+(pageNum-1)*pageSize+","+pageSize;
						sqls = "select count(*) from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3) and coursePrice > 0";
						
					}
					if(order == 3) {
						sql = "select * from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3) order by courseStudentNumber desc limit "+(pageNum-1)*pageSize+","+pageSize;
						sqls = "select count(*) from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3)";
					}
					if(order == 4) {
						sql = "select * from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3) order by courseRebate desc limit "+(pageNum-1)*pageSize+","+pageSize;
						sqls = "select count(*) from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3)";
					}
				}else {
					if(order == 0) {
						sql = "select * from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3 and typetableId= "+style+") limit "+(pageNum-1)*pageSize+","+pageSize;
						sqls = "select count(*) from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3 and typetableId= "+style+")";
					}
				
					if(order == 1) {
						sql = "select * from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3 and typetableId= "+style+") and coursePrice = 0 limit "+(pageNum-1)*pageSize+","+pageSize;	
						sqls = "select count(*) from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3 and typetableId= "+style+") and coursePrice = 0" ;
					}
					if(order == 2) {
						sql = "select * from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3 and typetableId= "+style+") and coursePrice > 0 limit "+(pageNum-1)*pageSize+","+pageSize;
						sqls = "select count(*) from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3 and typetableId= "+style+") and coursePrice > 0" ;
					}
					if(order == 3) {
						sql = "select * from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3 and typetableId= "+style+") order by courseStudentNumber desc limit "+(pageNum-1)*pageSize+","+pageSize;
						sqls = "select count(*) from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3 and typetableId= "+style+")";
					}
					if(order == 4) {
						sql = "select * from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3 and typetableId= "+style+" ) order by courseRebate desc limit "+(pageNum-1)*pageSize+","+pageSize;
						sqls = "select count(*) from course where courseId in (select businesstypeWorkId from businesstype where businesstypeWorkType=3 and typetableId= "+style+")";
					}
				}
				try {
					PreparedStatement countps=conn.prepareStatement(sqls);
					ResultSet countrs=countps.executeQuery();
		
					while(countrs.next()) {
						count = countrs.getInt(1);
						
					}
					PreparedStatement ps=conn.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Course temp=new Course();
						Teacher tea = new Teacher();
						User user = new User();
						temp.setCourseId(rs.getInt(1));
						temp.setCourseName(rs.getString(2));
						int teacherId = rs.getInt(3);
						
						PreparedStatement pss=conn.prepareStatement("select * from user where userId="+teacherId);
						ResultSet rss=pss.executeQuery();
						while(rss.next()) {
							user.setUserId(rss.getInt(1));
							user.setUserNickName(rss.getString(3));
							user.setUserHeadPath(rss.getString(2));
							user.setUserRealName(rss.getString(5));
							tea.setUser(user);
						}
						temp.setTeacher(tea);
						temp.setCoursePrice(rs.getFloat(4));
						temp.setCourseRebate(rs.getFloat(5));
						temp.setCourseIntroduction(rs.getString(6));
						temp.setCourseImgPath(rs.getString(7));
						temp.setCourseStudentNumber(rs.getInt(8));
						temp.setCourseSynopsis(rs.getString(9));
						courses.add(temp);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} 
				pageCourses.setList(courses);
				pageCourses.setTotalCount(count);
				return pageCourses;
			}		
			
			
			
			/**
			 * 查询course-list具体课程介绍
			 * @param courseId
			 * @return
			 */
            
			public Course selectDescription(int courseId) {
				Session session = this.sessionFactory.getCurrentSession();
				Query query = session.createQuery("from Course cou where cou.courseId=?");
				query.setParameter(0, courseId);
				Course course = (Course) query.uniqueResult();
				return course;
			}
			
			/**
			 * 查询course-list 和course具体课程的具体目录
			 * @param courseId
			 * @return
			 */
			
			public List<CourseCatalog> selectContent(int courseId){
				System.out.println(courseId);
				Session session = this.sessionFactory.getCurrentSession();
				//String hql = "from Coursecatalog ctl  where ctl.course= "+courseId;
				//String spl = "select coursecatalogId from coursecatalog where courseId ="+courseId;
				Query query = session.createQuery("from CourseCatalog cou where cou.parentCourseCatalog = null and cou.courseId = ?");
				query.setInteger(0, courseId);
				List<CourseCatalog> list = query.list();
				for(CourseCatalog temp:list) {
					System.out.println(courseId);
					System.out.println(temp.getCoursecatalogName());
				}
				return list;
			}
			
			/**
			 *   查询course-list和course课程讨论区的分页评论
			 * @return
			 */
			public Page selectLessonComment(int courseId,int pageNum,int pageSize){
				Session session = this.sessionFactory.getCurrentSession();
				Page page = new Page(pageNum,pageSize);
				Query queryr = session.createQuery("from Evaluate com where com.evaluateWorkType = 3 and com.evaluateWorkId= ?");
				queryr.setInteger(0, courseId);
				page.setTotalCount(queryr.list().size());
				Query query = session.createQuery("from Evaluate com where com.evaluateWorkType = 3 and com.evaluateWorkId= ? order by com.evaluateTime desc");
				query.setInteger(0, courseId);
				query.setFirstResult((pageNum-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Evaluate> list = query.list();
				for(Evaluate temp:list) {
					System.out.println(temp.getEvaluateComment());
				}
				page.setList(list);
				return page;
			}
			
			
			   /**
	            * course-list和course课程的评论
	            * @param comment
	            * @return
	            */
				public boolean insertLessonComment(Evaluate comment) {
					Session session = this.sessionFactory.getCurrentSession();
					session.save(comment);
					return true;
				}
			
			
			/**
			 * 查询course-instr 老师的相关课程
			 * @param teacherId
			 * @return
			 */
			public  List<Course> selectAboutLesson(int courseId){
				System.out.println(courseId);
				Session session = this.sessionFactory.getCurrentSession();
				Query query0 = session.createQuery("from Course cou where cou.courseId = ?");
				query0.setParameter(0, courseId);
				
			    int teacherId = ((Course)query0.uniqueResult()).getTeacher().getTeacherId();
				Query query = session.createQuery("from Course cou where cou.teacher=?");
				query.setInteger(0, teacherId);
				query.setFirstResult(0);
				query.setMaxResults(5);
		        List<Course> list = query.list();
		        for(Course temp:list) {
		        	System.out.println(temp.getCourseName());
		        }
				return query.list();	
			}

			
          
			
			
			
			/**
			 * 查询要播放的目录视频，根据它的路径
			 * @param src
			 * @return
			 */
			public CourseCatalog selectPlayLessonContent(String src) {
				Session session = this.sessionFactory.getCurrentSession();
				System.out.println(src);
				Query query = session.createQuery("from CourseCatalog cou where cou.coursecatalogResourcePath=?");
				query.setString(0, src);
				return (CourseCatalog) query.uniqueResult();
			}
			
			
			/**
			 * 查询course 课程的相关类似课程
			 * @param teacherId
			 * @return
			 */
			public List<Course> selectAboutTypeLesson(int courseId){
				Session session = this.sessionFactory.getCurrentSession();
				Query query = session.createQuery("from BusinessType cou where cou.businesstypeWorkId=? and businesstypeWorkType = 3");
				query.setInteger(0, courseId);
				BusinessType types = (BusinessType) query.uniqueResult();
				int type = types.getTypeTable().getTypetableId();
				Query query2 = session.createQuery("from BusinessType cou where cou.typeTable=? and businesstypeWorkType=3");
				query2.setInteger(0, type);
				query2.setFirstResult(0);
				query2.setMaxResults(5);
				
				List<BusinessType> type3 = query2.list();
				List<Course> list4 = new ArrayList();
				for(BusinessType temp:type3) {
					if(temp.getBusinesstypeWorkId() != courseId) {
						Query query3 = session.createQuery("from Course cou where cou.courseId=?");
						query3.setParameter(0, temp.getBusinesstypeWorkId());
						list4.add((Course) query3.uniqueResult());
					}
				}
				for(Course temp:list4) {
					System.out.println(temp.getCourseName()+"a");
				}
				return list4;	
			}
			
			public User selectUser(int userId) {
				Session session = this.sessionFactory.getCurrentSession();
				Query query = session.createQuery("from User where userId=?");
				query.setParameter(0, userId);
				return (User)query.uniqueResult();
			}

			
//			/**
//			 * 查询course-list  end默认排序的分页课程
//			 * @return
//			 */
//			public List<Course> selectEndLesson(int pageNum,int pageSize){
//				Session session = this.sessionFactory.getCurrentSession();
//				Query query = session.createQuery("from Course");
//				query.setFirstResult((pageNum-1)*pageSize);
//				query.setMaxResults(pageSize);
//				List <Course> course = query.list();
//				return course;		
//			}
			
//			/**
//			 * 查询要查找的类型
//			 * @param typeName
//			 * @return
//			 */
//			public TypeTable selectStyle(String typeName) {
//				Session session = this.sessionFactory.getCurrentSession();
//				Query query = session.createQuery("from TypeTable type where type.typetableName = ? ");
//				query.setParameter(0, typeName);
//				return (TypeTable) query.uniqueResult();
//			}
			
//			/**
//			 * 查询要播放的视频和目录
//			 * @param courseId
//			 * @return废弃
//			 */
//			public Course selectPlayLesson(int courseId) {
//				Session session = this.sessionFactory.getCurrentSession();
//				Query query = session.createQuery("from Course cou where cou.courseId=?");
//				query.setParameter(0, courseId);
//				return (Course) query.uniqueResult();
//			}
			
			
			
			
			//废弃的分页课程查找
//			Session session = this.sessionFactory.getCurrentSession();
//		      List<BusinessType> type = null;
//		      Page page = new Page(pageNum,pageSize);
//		      List<Course> course = new ArrayList<Course>();
//		      List<Course> courseFree = new ArrayList<Course>();
//		      
//		      if(order == 3||order == 4 || order == 0) {
//		    	  if(style == 0) {
//		    		  Query queryr = session.createQuery("from BusinessType cou where cou.businesstypeWorkType=3");
//			    	  page.setTotalCount(queryr.list().size());
//			    	  Query query = session.createQuery("from BusinessType cou where cou.businesstypeWorkType=3");
//			    	  query.setFirstResult((pageNum-1)*pageSize);
//					  query.setMaxResults(pageSize);
//					  type = query.list();
//		    	  }else {
//			    	  Query queryr = session.createQuery("from BusinessType cou where cou.businesstypeWorkType=3 and cou.typeTable=?");
//			    	  queryr.setInteger(0, style);
//			    	  page.setTotalCount(queryr.list().size());
//			          Query query = session.createQuery("from BusinessType cou where cou.businesstypeWorkType=3 and cou.typeTable=?");
//				      query.setInteger(0, style);
//				      type = query.list();
//			      }
//		    	  if(order == 1) {
//					  CourseNumComparator comp = new CourseNumComparator();
//					  Collections.sort(course,comp);
//					  for(Course temp:course) {
//						  System.out.println(temp.getCourseName());
//					  }
//			
//		      }
//		      
//		      
//		      
//		      
//		      
//		      
//		      
//		      
//		      
//		      
//		      if(style == 0) {
//		    	  Query queryr = session.createQuery("from BusinessType cou where cou.businesstypeWorkType=3");
//		    	  page.setTotalCount(queryr.list().size());
//		    	  Query query = session.createQuery("from BusinessType cou where cou.businesstypeWorkType=3");
//				  type = query.list();
//		      }else {
//		    	  Query queryr = session.createQuery("from BusinessType cou where cou.businesstypeWorkType=3 and cou.typeTable=?");
//		    	  queryr.setInteger(0, style);
//		    	  page.setTotalCount(queryr.list().size());
//		          Query query = session.createQuery("from BusinessType cou where cou.businesstypeWorkType=3 and cou.typeTable=?");
//			      query.setInteger(0, style);
//			      type = query.list();
//		      }
//		      
//		      System.out.println(type.size());
//		      System.out.println("firesun");
//			  for(BusinessType temps:type) {
//				  System.out.println(temps.getBusinesstypeWorkId());
//
//			  }
//			  if(order == 4) {
//				  for(int i=0;i<=3;) {
//					  int j = 0;
//					  Query query2 = session.createQuery("from Course cou where cou.courseId=?");
//			          query2.setInteger(0, type.get(j).getBusinesstypeWorkId());
//			          Course temps = (Course) query2.uniqueResult();
//			          if(temps.getCoursePrice() ==0) {
//			        	   course.add(temps);
//			        	   i++;
//			          }
//				  }
//			  }else {
//				  for(int i=0;i<=3;) {
//					  int j = 0;
//					  Query query2 = session.createQuery("from Course cou where cou.courseId=?");
//			          query2.setInteger(0, type.get(j).getBusinesstypeWorkId());
//			          Course temps = (Course) query2.uniqueResult();
//			          if(temps.getCoursePrice() >0) {
//			        	   course.add(temps);
//			        	   i++;
//			          }
//				  }
//			  }
////			  for(BusinessType temp:type) {
////			          Query query2 = session.createQuery("from Course cou where cou.courseId=?");
////			          query2.setInteger(0, temp.getBusinesstypeWorkId());
////			          Course temps = (Course) query2.uniqueResult();
////			          if(order == 4) {
////			        	  if(temps.getCoursePrice() == 0) {
////			        		  course.add(temps);
////			        	  }
////			          }else if(order == 0) {
////			        	  course.add(temps);
////			          }else {
////			        	  if(temps.getCoursePrice() > 0) {
////			        		  course.add(temps);
////			        	  }
////			          }   
////			  }
//			  
//			  if(order == 1) {
//				  CourseNumComparator comp = new CourseNumComparator();
//				  Collections.sort(course,comp);
//				  for(Course temp:course) {
//					  System.out.println(temp.getCourseName());
//				  }
//			  }else if(order == 2) {
//				  CourseRebateComparator comp = new CourseRebateComparator();
//				  Collections.sort(course,comp);
//				  for(Course temp:course) {
//					  System.out.println(temp.getCourseName());
//				  }
//			  }else if(order == 3) {
//				  CoursePriceComparator comp = new CoursePriceComparator();
//				  Collections.sort(course,comp);
//				  for(Course temp:course) {
//					  System.out.println(temp.getCourseName());
//				  }
//			  }else {
//				  
//			  }
//			  page.setList(course);
//		
//		return page;	
		
//	}
	
//			/**
//			 * 插入收藏课程
//			 * @param lesson
//			 * @return
//			 */
//			public boolean updateCollectLesson(Course lesson) {
//				Session session = this.sessionFactory.getCurrentSession();
//				session.save(lesson);
//				return true;
//			}
			
			
			
			

}
