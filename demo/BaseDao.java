package com.util;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 * 
 * @desc:用于Spring整合hibernate时，对数据持久层的操作，把冗余的操作抽取出来
 * @author chunhui
 * @date:Nov 19, 20182:34:00 PM
 */

public class BaseDao<T> {
	/**
	 * 注入session工厂
	 */
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @desc:根据主键ID加载实体
	 * @param entityClazz
	 * @param id
	 *            接收任意实现了该接口的类的对象或者自定义的int Integer String等
	 * @return
	 * @return:T
	 * @trhows
	 */
	public T get(Class<T> entityClazz, Serializable id) {
		return sessionFactory.getCurrentSession().get(entityClazz, id);
	}

	/**
	 * 
	 * @desc:保存实体
	 * @param entity
	 * @return
	 * @return:Serializable 返回的是保存的实体所对应的主键值
	 * @trhows
	 */
	public Serializable save(T entity) {
		return sessionFactory.getCurrentSession().save(entity);
	}

	/**
	 * 
	 * @desc:更新实体
	 * @param entity
	 * @return:void
	 * @trhows
	 */
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	/**
	 * 
	 * @desc:删除实体
	 * @param entity
	 * @return:void
	 * @trhows
	 */
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	/**
	 * 
	 * @desc:根据ID 删除实体
	 * @param entityClazz
	 * @param id
	 * @return
	 * @return:boolean 返回值为true，说明影响行数>1，成功
	 * @trhows
	 */
	public boolean delete(Class<T> entityClazz, Serializable id) {
		String hql = "delete " + entityClazz.getSimpleName() + " en where en.id = ?0";
		return (sessionFactory.getCurrentSession().createQuery(hql).setParameter("0", id).executeUpdate()) > 0;

	}

	/**
	 * 
	 * @desc:获取所有实体
	 * @param entityClazz
	 * @return
	 * @return:List<T>
	 * @trhows
	 */
	public List<T> findAll(Class<T> entityClazz) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en";
		return find(hql);
	}

	/**
	 * 
	 * @desc:获取实体总数
	 * @param entityClazz
	 * @return
	 * @return:long
	 * @trhows
	 */
	public long findCount(Class<T> entityClazz) {
		String hql = "select count(*) from " + entityClazz.getSimpleName();
		List<T> list = find(hql);
		if (list != null && list.size() == 1) {
			return (Long) list.get(0);
		}
		return 0;
	}

	/**
	 * 
	 * @desc:根据HQL语句查询实体
	 * @param hql
	 * @return
	 * @return:List<T>
	 * @trhows
	 */
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	/**
	 * 
	 * @desc:根据带占位符参数HQL语句查询实体
	 * @param hql待查询的hql语句
	 * @param params
	 *            参数
	 * @return
	 * @return:List<T>
	 * @trhows
	 */
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return query.list();
	}

	/**
	 * 
	 * @desc:使用hql 语句进行分页查询操作
	 * @param hql
	 *            需要查询的hql语句
	 * @param pageNo
	 *            查询第pageNo页的记录
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return
	 * @return:List<T> 当前页的所有记录产品
	 * @trhows
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}

	/**
	 * 
	 * @desc:使用hql语句进行分页查询操作
	 * @param hql
	 *            需要查询的hql语句
	 * @param pageNo
	 *            查询第pageNo页的记录
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @param params
	 *            如果hql带占位符，params用于传入占位符参数
	 * @return
	 * @return:List<T>当前页的所有记录
	 * @trhows
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return query.setFirstResult((pageNo - 1) + pageSize).setMaxResults(pageSize).list();
	}

}
