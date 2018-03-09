package com.hfmx.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBaseDao<T, ID extends Serializable> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * 根据ID删除实体
	 * 
	 * @param id
	 */
	public void delete(Class<T> entityClass, ID id);

	/**
	 * 根据ID集合批量删除实体
	 * 
	 * @param entity
	 * @param ids
	 */
	public void delete(Class<T> entityClass, ID[] ids);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 根据HQL语句更新实体
	 * 
	 * @param entity
	 * @param hql
	 */
	public int update(String hql, Map<String, Object> params);

	/**
	 * 根据SQL语句更新实体
	 * 
	 * @param entity
	 * @param sql
	 */
	public int update(String sql);

	/**
	 * 根据ID查询实体
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public T find(Class<T> entityClass, ID id);

	/**
	 * 根据HQL语句查询实体
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> search(String hql, Map<String, Object> params);

	/**
	 * 根据SQL语句查询实体
	 * 
	 * @param sql
	 * @return
	 */
	public List<T> search(Class<T> entityClass, String sql);

	/**
	 * 综合查询
	 * 
	 * @param sql
	 * @return 返回集合数组
	 */
	public List<Object[]> searchForArray(String sql);

	/**
	 * 综合查询
	 * 
	 * @param sql
	 * @return 返回Map集合
	 */
	public List<Map<String, Object>> searchForMap(String sql);

	/**
	 * 综合查询 分页
	 * 
	 * @param sql
	 * @param firstIndex
	 *            起始索引
	 * @param maxResult
	 *            查询个数
	 * @return
	 */
	public List<Map<String, Object>> searchForMap(String sql, int firstIndex,
			int maxResult);

	// /**
	// * 综合查询 分页 oracle
	// *
	// * @param sql
	// * @param 起始索引
	// * @param 查询个数
	// * @return
	// */
	// public List<Map<String, Object>> searchForMap_Oracle(String sql,
	// int firstIndex, int maxResult);

	// /**
	// * 综合查询分页 MSSQL
	// *
	// * @param sql
	// * @param 起始索引
	// * @param 查询个数
	// * @param 排序列
	// * @return
	// */
	// public List<Map<String, Object>> searchForMap_MSSQL(String sql,
	// int firstIndex, int maxResult, String orderColumn);
	//
	// /**
	// * 测试MSSQL
	// *
	// * @param sql
	// */
	// public void search_MSSQL(String sql);

	/**
	 * 根据HQL语句分页查询实体
	 * 
	 * @param hql
	 * @param params
	 * @param firstindex
	 * @param maxresult
	 * @return
	 */
	public List<T> search(String hql, Map<String, Object> params,
			int firstindex, int maxresult);

	/**
	 * 根据SQL语句分页查询实体
	 * 
	 * @param entityClass
	 * @param sql
	 * @param firstindex
	 * @param maxresult
	 * @return
	 */
	public List<T> search(Class<T> entityClass, String sql, int firstindex,
			int maxresult);

	/**
	 * 统计实体数量
	 * 
	 * @param entity
	 * @return
	 */
	public long count(Class<T> entityClass);

	/**
	 * 根据HQL约束统计数量
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public long count(String hql, Map<String, Object> params);

	/**
	 * 根据SQL约束统计数量
	 * 
	 * @param sql
	 * @return
	 */
	public long count(String sql);
}
