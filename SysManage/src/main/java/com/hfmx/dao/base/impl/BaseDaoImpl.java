package com.hfmx.dao.base.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.hfmx.dao.base.IBaseDao;
import com.hfmx.utils.DAOHelper;

@Component("baseDaoImpl")
public class BaseDaoImpl<T, ID extends Serializable> implements IBaseDao<T, ID> {

	protected EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * sql jdbcTemplate
	 */
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Resource(name = "jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// /**
	// * mssql jdbcTemplate
	// */
	// private JdbcTemplate mssqlJdbcTemplate;
	//
	// public JdbcTemplate getMssqlJdbcTemplate() {
	// return mssqlJdbcTemplate;
	// }
	//
	// @Resource(name = "mssqlJdbcTemplate")
	// public void setMssqlJdbcTemplate(JdbcTemplate mssqlJdbcTemplate) {
	// this.mssqlJdbcTemplate = mssqlJdbcTemplate;
	// }

	/**
	 * 保存实体
	 */
	public void save(T entity) {
		em.persist(entity);
	}

	/**
	 * 删除实体
	 */
	public void delete(T entity) {
		em.remove(entity);
	}

	/**
	 * 根据ID删除实体
	 */
	public void delete(Class<T> entityClass, ID id) {
		
		//System.out.println(em.getReference(entityClass, id));
		em.remove(em.getReference(entityClass, id));
	}

	/**
	 * 根据ID集合批量删除实体
	 */
	public void delete(Class<T> entityClass, ID[] ids) {
		for (Object id : ids) {
			em.remove(em.getReference(entityClass, id));
		}
	}

	/**
	 * 更新实体
	 */
	public void update(T entity) {
		em.merge(entity);
	}

	/**
	 * 根据HQL语句更新实体
	 */
	public int update(String hql, Map<String, Object> params) {
		Query query = em.createQuery(hql);
		if (null != params && params.size() > 0) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.executeUpdate();
	}

	/**
	 * 根据SQL语句更新实体
	 */
	public int update(String sql) {
		Query query = em.createNativeQuery(sql);
		return query.executeUpdate();
	}

	/**
	 * 根据ID查询实体
	 */
	public T find(Class<T> entityClass, ID id) {
		return em.find(entityClass, id);
	}

	/**
	 * 根据HQL语句查询实体
	 */
	public List<T> search(String hql, Map<String, Object> params) {
		return search(hql, params, -1, -1);
	}

	/**
	 * 根据SQL语句查询实体
	 */
	public List<T> search(Class<T> entityClass, String sql) {
		return search(entityClass, sql, -1, -1);
	}

	/**
	 * 根据SQL语句查询 返回数组集合
	 */
	public List<Object[]> searchForArray(String sql) {
		List<Object[]> queryResult = jdbcTemplate.query(sql, new ResultSetExtractor<List<Object[]>>() {

			public List<Object[]> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Object[]> result = new ArrayList<Object[]>();
				while (rs.next()) {

					ResultSetMetaData rsmd = rs.getMetaData();
					int columns = rsmd.getColumnCount();
					Object[] objects = new Object[columns];
					for (int i = 1; i <= columns; i++) {
						objects[i - 1] = rs.getObject(i);
					}
					result.add(objects);
				}
				return result;
			}
		});
		return queryResult;
	}

	/**
	 * 根据SQL语句查询 返回Map集合
	 */
	public List<Map<String, Object>> searchForMap(String sql) {
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * mySql数据库******根据SQL语句分页查询返回Map集合
	 */
	public List<Map<String, Object>> searchForMap(String sql, int firstIndex, int maxResult) {
		if (!sql.isEmpty()) {
			String listsql = "select o.* from (" + sql + ") o limit " + firstIndex + "," + (maxResult);
			// System.out.println("sql=" + listsql);
			return jdbcTemplate.queryForList(listsql);
		}
		return null;
	}

	// /**
	// * oracle 数据库******根据SQL语句分页查询返回Map集合 (未测试)
	// */
	// public List<Map<String, Object>> searchForMap_Oracle(String sql,
	// int firstIndex, int maxResult) {
	// if (!sql.isEmpty()) {
	// // 第一种查询方式(待测试)
	// String listsql = "select o.* from (" + sql + ") o rownum>"
	// + firstIndex + " and rownum<=" + (firstIndex + maxResult);
	// // // 第二种查询方式(待测试)
	// // String listsql = "select * from (select ROWNUM R,o.* from (" +
	// // sql
	// // + ") o where rownum<" + (firstIndex + maxResult)
	// // + ") e where e.R>=" + firstIndex;
	// return jdbcTemplate.queryForList(listsql);
	// }
	// return null;
	// }
	//
	// /**
	// * MSSQL 数据库******根据SQL语句分页查询返回Map集合 (适用于SQL2005及以后版本)****测试通过
	// */
	// public List<Map<String, Object>> searchForMap_MSSQL(String sql,
	// int firstIndex, int maxResult, String orderColumn) {
	// if (!sql.isEmpty()) {
	// String listsql = "select top " + (maxResult)
	// + " o.* from (select row_number() over(order by "
	// + orderColumn + " ) as rownumber,* from (" + sql
	// + ") as oo) as o where rownumber>" + firstIndex;
	// System.out.println("sql:" + listsql);
	// return this.mssqlJdbcTemplate.queryForList(listsql);
	// }
	// return null;
	// }
	//
	// /**
	// * MSSQL语句查询
	// *
	// * @param sql
	// */
	// public void search_MSSQL(String sql) {
	// List<Map<String, Object>> result = this.mssqlJdbcTemplate
	// .queryForList(sql);
	// for (Map<String, Object> map : result) {
	// for (String key : map.keySet()) {
	// System.out.println("key:" + key);
	// System.out.println("value:" + map.get(key));
	// }
	// }
	// }

	/**
	 * 根据HQL语句分页查询实体
	 */
	@SuppressWarnings("unchecked")
	public List<T> search(String hql, Map<String, Object> params, int firstindex, int maxresult) {
		List<T> result = new ArrayList<T>();
		Query query = em.createQuery(hql);
		if (null != params && params.size() > 0) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		if (firstindex > -1 && maxresult > -1) {
			query.setFirstResult(firstindex);
			query.setMaxResults(maxresult);
		}
		result = (List<T>) query.getResultList();
		return result;
	}

	/**
	 * 根据SQL语句分页查询实体
	 */
	@SuppressWarnings("unchecked")
	public List<T> search(Class<T> entityClass, String sql, int firstindex, int maxresult) {
		Query query = em.createNativeQuery(sql, entityClass);
		List<T> result = new ArrayList<T>();
		if (firstindex > -1 && maxresult > -1) {
			query.setFirstResult(firstindex);
			query.setMaxResults(maxresult);
		}
		result = (List<T>) query.getResultList();
		return result;
	}

	/**
	 * 统计实体数量
	 */
	public long count(Class<T> entityClass) {
		String entityName = DAOHelper.getEntityName(entityClass);
		Query query = em.createQuery("select count(o) from " + entityName + " o ");

		return query.getSingleResult() == null ? 0 : (Long.valueOf(query.getSingleResult().toString()));

	}

	/**
	 * 根据HQL约束统计数量
	 */
	public long count(String hql, Map<String, Object> params) {
		Query query = em.createQuery(hql);
		if (null != params && params.size() > 0) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.getSingleResult() == null ? 0 : (Long.valueOf(query.getSingleResult().toString()));
	}

	/**
	 * 根据SQL约束统计数量
	 */
	public long count(String sql) {
        Query query = em.createNativeQuery(sql);
        // return query.getSingleResult() == null ? 0 : ((Long) query
        // .getSingleResult()).longValue();
        Object o=query.getSingleResult();
        return o == null ? 0 : (Long.valueOf(o.toString()));

}
}
