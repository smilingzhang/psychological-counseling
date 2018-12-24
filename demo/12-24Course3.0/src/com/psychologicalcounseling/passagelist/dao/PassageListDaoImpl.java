package com.psychologicalcounseling.passagelist.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.Article;
import com.psychologicalcounseling.entity.BusinessType;
import com.psychologicalcounseling.entity.TypeTable;
/**
 * 孙明伟
 * @author ASUS
 *
 */
@Repository
public class PassageListDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查询该业务类型对应的所有业务类别
	 * @param businesstypeWorkType
	 * @return
	 */
	public List<TypeTable> selectTypeTableList(int businesstypeWorkType){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select distinct typeTable from BusinessType where businesstypeWorkType = ?");
		q.setInteger(0, businesstypeWorkType);
		return q.list();
	}
	
	/**
	 * 根据业务类别Id查询对应的业务类别
	 * @param typetableId
	 * @return
	 */
	public TypeTable selectTypeTable(int typetableId) {                           
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from TypeTable where typetableId = ?");
		q.setInteger(0, typetableId);
		TypeTable typeTable = (TypeTable)q.uniqueResult();
		return typeTable;
	}
	/**
	 * 根据业务类型Id 和 业务类别Id查询出对应的List<BusinessType>
	 * @param businesstypeWorkType
	 * @param typeTable
	 * @return
	 */
	public List<BusinessType> selectBusinessTypeList(int businesstypeWorkType,TypeTable typeTable){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from BusinessType where businesstypeWorkType = ? and typeTable.typetableId = ?");
		q.setInteger(0, businesstypeWorkType);
		q.setInteger(1,typeTable.getTypetableId());
		return q.list();
	}
	/**
	 * 通过业务Id查询对应的文章
	 * @param businesstypeWorkId
	 * @return
	 */
	public Article selectArticle(int businesstypeWorkId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Article where articleId = ?");
		q.setInteger(0, businesstypeWorkId);
		Article article = (Article)q.uniqueResult();
		return article;
	}
	/**
	 * 查询出符合要求的文章数量count
	 * @param businesstypeWorkType
	 * @param typeTable
	 * @return
	 */
	public int selectCount(int businesstypeWorkType,TypeTable typeTable) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from BusinessType where businesstypeWorkType = ? and typeTable.typetableId = ?");
		q.setInteger(0, businesstypeWorkType);
		q.setInteger(1, typeTable.getTypetableId());
		int count = q.list().size();
		System.out.println("count----"+count);
		return count;
	}
	/**
	 * 分页查询出类别表
	 * @param pageNum
	 * @param pageSize
	 * @param businesstypeWorkType
	 * @param typeTable
	 * @return
	 */
	public List<BusinessType> selectBusinessTypeByPage(int pageNum,int pageSize,int businesstypeWorkType,TypeTable typeTable){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from BusinessType where businesstypeWorkType = ? and typeTable.typetableId = ?");
		q.setInteger(0, businesstypeWorkType);
		q.setInteger(1, typeTable.getTypetableId());
		q.setFirstResult((pageNum-1)*pageSize);
		q.setMaxResults(pageSize);
		System.out.println("pageNum------"+pageNum);
		return q.list();
	}
}
