package com.hfmx.utils;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class PageInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 当前页 **/
	private int page = 1;
	/** 每页显示记录数 **/
	private int rows = 10;
	/** 排序字段 **/
	private String sort;
	/** 排序方式 **/
	private String order;
	/** 查询条件 **/
	private SearchInfo searchInfo = new SearchInfo("");

	/**
	 * 获取firstindex,maxresult
	 * 
	 * @param total
	 * @return
	 */
	public int[] getFirstindexAndMaxresult() {
		return new int[] { rows * (page - 1), rows };
	}

	/**
	 * 获取前台查询条件JSON
	 */
	public void setQueryjson(String queryjson) {
		searchInfo = new SearchInfo(queryjson);
	}

	/**
	 * 修改排序和查询字段名
	 * 
	 * @param oldField
	 * @param newField
	 */
	public void modifyField(String oldField, String newField) {
		// 修改排序字段
		if (StringUtils.isNotBlank(sort) && StringUtils.equals(sort.trim(), oldField.trim())) {
			sort = newField.trim();
		}
		// 修改查询字段
		searchInfo.modifyField(oldField, newField);
	}

	/**
	 * 获取查询条件语句
	 * 
	 * @return
	 */
	public String getSearchString() {
		return searchInfo.toString();
	}

	/**
	 * 获取排序语句
	 * 
	 * @return
	 */
	public String getSortString() {
		if (StringUtils.isNotBlank(sort) && StringUtils.isNotBlank(order))
			return " order by " + sort.trim() + " " + order.trim();
		else
			return "";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public SearchInfo getSearchInfo() {
		return searchInfo;
	}
}
