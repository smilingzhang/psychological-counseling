package com.psychologicalcounseling.util;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.Param;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;

import com.psychologicalcounseling.entity.Page;

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
	protected SessionFactory sessionFactory;

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
			query.setParameter(i, params[i]);
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
			query.setParameter(i, params[i]);
		}
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
	/**
	 * 
	 *@desc:  带条件的插入数据
	 *@param sql   sql语句   ,因为hql语句不能实现插入（带条件）的操作，必须用sql
	 *@param param  传入参数
	 *@return
	 *@return:int  返回影响的条数
	 *@trhows
	 */
	@SuppressWarnings("unchecked")
	protected int insert(String sql, Object... params) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);

		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i , params[i]);
		}
		
		return query.executeUpdate();
	}
	/**
	 * @desc 根据hql，按条件查询数据数量
	 * @param hql hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return 数据数量
	 * @throws Exception
	 */
	public Long findCount(String hql, Object ... params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return (Long) query.uniqueResult();
	}
	/**
	 * @desc 根据hql，按条件进行投影查询
	 * @param hql hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return List集合，集合中数据是对象数组
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findByProjection(String hql, Object ... params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return query.list();
	}
	/**
	 * @desc 根据hql，按条件进行分页的投影查询
	 * @param pageNum 页码
	 * @param pageSize 每页数据个数
	 * @param hql hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return List集合，集合中数据是对象数组
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findByProjection(int pageNum, int pageSize, String hql, Object ... params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	// **************SQL***************************
		/**
		 * @desc 通过原生SQL进行新增，修改，删除
		 * @param sql sql语句
		 * @param params sql语句中占位符对应的参数
		 * @return 执行sql语句所影响的行数
		 * @throws Exception
		 */
		public int excuteBySql(String sql, Object ... params) throws Exception {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			return query.executeUpdate();
		}

		/**
		 * @desc 通过原生SQL进行查询，返回单个结果集，以Map<String, Object>形式存放
		 * @param sql sql语句
		 * @param params sql语句中占位符对应的参数
		 * @return 查询出的数据
		 * @throws Exception
		 */
		@SuppressWarnings("unchecked")
		public Map<String, Object> findOneBySql(String sql, Object ... params) throws Exception {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			return (Map<String, Object>) query.uniqueResult();
		}

		/**
		 * @desc 通过原生SQL进行查询，返回多个结果集，以List<Map<String, Object>>形式存放
		 * @param sql sql语句
		 * @param params sql语句中占位符对应的参数
		 * @return 
		 * @throws Exception
		 */
		@SuppressWarnings("unchecked")
		public List<Map<String, Object>> findBySql(String sql, Object ... params) throws Exception {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			return query.list();
		}

		/**
		 * @desc 分页原生SQL进行统计数量
		 * @param sql sql语句
		 * @param params sql语句中占位符对应的参数
		 * @return 统计的数量
		 * @throws Exception
		 */
		public Long findCountBySql(String sql, Object ... params) throws Exception {
			SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			BigInteger countResult = (BigInteger) query.uniqueResult();
			return Long.valueOf(countResult.toString());
		}

		/**
		 * @desc 分页原生SQL进行查询
		 * @param sql sql语句
		 * @param params sql语句中占位符对应的参数
		 * @param pageNum 页码
		 * @param pageSize 每页数据个数
		 * @return 
		 * @throws Exception
		 */
		@SuppressWarnings("unchecked")
		public List<Map<String, Object>> findBySql(int pageNum, int pageSize, String sql, Object... params)
				throws Exception {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			query.setFirstResult((pageNum - 1) * pageSize);
			query.setMaxResults(pageSize);
			return query.list();
		}
		/**
		 * @desc 根据hql语句，查询单个实体类的对象
		 * @param hql hql语句
		 * @param params hql语句中占位符对应的参数
		 * @return 单个实体类的对象
		 * @throws Exception
		 */
		@SuppressWarnings("unchecked")
		public T findOne(String hql, Object ... params) throws Exception {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			return (T) query.uniqueResult();
		}
		/**
		 * 
		 * @desc 根据hql语句，按条件查询数据
		 * @param hql hql语句
		 * @param params hql语句中占位符对应的参数
		 * @return 按条件查询出数据的List集合
		 * @throws Exception
		 */
		@SuppressWarnings("unchecked")
		public List<T> find(String hql, Object[] ... params) throws Exception {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			return query.list();
		}
		/**
		 * @desc 根据hql，按条件进行分页的投影查询
		 * @param pageNum 页码
		 * @param pageSize 每页数据个数
		 * @param hqlCount 用于统计数量的hql语句
		 * @param hqlList 用于查询的hql语句
		 * @param params hql语句中占位符对应的参数
		 * @return Page对象
		 * @throws Exception
		 */
		public Page<Object[]> findPageByProjection(int pageNum, int pageSize, String hqlCount, String hqlList,
				Object ... params) throws Exception {
			long total = findCount(hqlCount, params);
			List<Object[]> rows = findByProjection(pageNum, pageSize, hqlList, params);
			return new Page<Object[]>(pageNum, pageSize, (int) total, rows);
		}

}
