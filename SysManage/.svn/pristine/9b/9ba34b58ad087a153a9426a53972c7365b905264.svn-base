package com.hfmx.service.base.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hfmx.dao.base.IBaseDao;
import com.hfmx.service.base.IBaseService;
import com.hfmx.utils.exception.BusinessException;

@Component("baseServiceImpl")
@Transactional
public class BaseServiceImpl<T, ID extends Serializable> implements IBaseService<T, ID> {
	private IBaseDao<T, ID> baseDaoImpl;

	public IBaseDao<T, ID> getBaseDaoImpl() {
		return baseDaoImpl;
	}

	@Resource(name = "baseDaoImpl")
	public void setBaseDaoImpl(IBaseDao<T, ID> baseDaoImpl) {
		this.baseDaoImpl = baseDaoImpl;
	}

	/**
	 * 保存实体
	 */
	public void save(T entity) {
		this.baseDaoImpl.save(entity);
	}

	/**
	 * 删除实体
	 */
	public void delete(T entity) {
		this.baseDaoImpl.delete(entity);
	}

	/**
	 * 根据ID删除实体
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BusinessException.class)
	public void delete(Class<T> entityClass, ID id) {
		try {
			this.baseDaoImpl.delete(entityClass, id);
		} catch (EntityNotFoundException ex) {
			throw new BusinessException("删除失败");
		}
	}

	/**
	 * 根据ID集合批量删除实体
	 */
	public void delete(Class<T> entityClass, ID[] ids) {
		this.baseDaoImpl.delete(entityClass, ids);
	}

	/**
	 * 更新实体
	 */
	public void update(T entity) {
		this.baseDaoImpl.update(entity);
	}

	/**
	 * 根据HQL语句更新实体
	 */
	public int update(String hql, Map<String, Object> params) {
		return this.baseDaoImpl.update(hql, params);
	}

	/**
	 * 根据SQL语句更新实体
	 */
	public int update(String sql) {
		return this.baseDaoImpl.update(sql);
	}

	/**
	 * 根据ID查询实体
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public T find(Class<T> entityClass, ID id) {
		return this.baseDaoImpl.find(entityClass, id);
	}

	/**
	 * 根据HQL语句查询实体
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> search(String hql, Map<String, Object> params) {
		return this.baseDaoImpl.search(hql, params);
	}

	/**
	 * 根据SQL语句查询实体
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> search(Class<T> entityClass, String sql) {
		return this.baseDaoImpl.search(entityClass, sql);
	}

	/**
	 * 根据SQL语句查询 返回数组集合
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Object[]> searchForArray(String sql) {
		return this.baseDaoImpl.searchForArray(sql);
	}

	/**
	 * 根据SQL语句查询 返回Map集合
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Map<String, Object>> searchForMap(String sql) {
		return this.baseDaoImpl.searchForMap(sql);
	}

	/**
	 * 根据SQL语句分页 查询 返回Map集合
	 */
	public List<Map<String, Object>> searchForMap(String sql, int firstIndex, int maxResult) {
		return this.baseDaoImpl.searchForMap(sql, firstIndex, maxResult);
	}

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
	// int firstIndex, int maxResult, String orderColumn) {
	// return this.baseDaoImpl.searchForMap_MSSQL(sql, firstIndex, maxResult,
	// orderColumn);
	// }
	//
	// /**
	// * 测试MSSQL查询
	// */
	// public void search_MSSQL(String sql) {
	// this.baseDaoImpl.search_MSSQL(sql);
	// }

	/**
	 * 根据HQL语句分页查询实体
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> search(String hql, Map<String, Object> params, int firstindex, int maxresult) {
		return this.baseDaoImpl.search(hql, params, firstindex, maxresult);
	}

	/**
	 * 根据SQL语句分页查询实体
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> search(Class<T> entityClass, String sql, int firstindex, int maxresult) {
		return this.baseDaoImpl.search(entityClass, sql, firstindex, maxresult);
	}

	/**
	 * 统计实体数量
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public long count(Class<T> entityClass) {
		return this.baseDaoImpl.count(entityClass);
	}

	/**
	 * 根据HQL约束统计数量
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public long count(String hql, Map<String, Object> params) {
		return this.baseDaoImpl.count(hql, params);
	}

	/**
	 * 根据SQL约束统计数量
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public long count(String sql) {
		return this.baseDaoImpl.count(sql);
	}
}
