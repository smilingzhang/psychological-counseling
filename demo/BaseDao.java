package com.util;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 根据主键ID加载实体
	 * 
	 * @param entityClazz
	 * @param id
	 *            接收任意实现了该接口的类的对象或者自定义的int Integer String等
	 * @return T对象
	 */
	public T get(Class<T> entityClazz, Serializable id) {
		return sessionFactory.getCurrentSession().get(entityClazz, id);
	}

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return 保存的这个实体所对应的主键值
	 */
	public Serializable save(T entity) {
		return sessionFactory.getCurrentSession().save(entity);
	}

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	/**
	 * 删除实体
	 * 
	 * @param entity
	 */
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	/**
	 * 根据ID删除实体
	 * 
	 * @param entityClazz
	 * @param id
	 * @return 返回值true,说明影响行数>1，成功
	 */
	public boolean delete(Class<T> entityClazz, Serializable id) {
		String hql = "delete " + entityClazz.getSimpleName() + " en where en.id = ?0";
		return (sessionFactory.getCurrentSession().createQuery(hql).setParameter("0", id).executeUpdate()) > 0;

	}

	/**
	 * 获取所有实体
	 * 
	 * @param entityClazz
	 * @return
	 */
	public List<T> findAll(Class<T> entityClazz) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en";
		return find(hql);
	}

	/**
	 * 获取实体总数
	 * 
	 * @param entityClazz
	 * @return
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
	 * 根据HQL语句查询实体
	 * 
	 * @param hql
	 *            待查询的HQL语句
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	/**
	 * 根据带占位符参数HQL语句查询实体
	 * 
	 * @param hql
	 *            待查询的HQL语句
	 * @param params
	 *            参数
	 * @return
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
	 * 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param pageNo
	 *            查询第pageNo页的记录
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return 当前页的所有产品记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}

	/**
	 * 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param pageNo
	 *            查询第pageNo页的记录
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @param params
	 *            如果hql带占位符参数，params用于传入占位符参数
	 * @return 当前页的所有记录
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
