package com.hfmx.service.book;

import java.util.List;
import java.util.Map;

import com.hfmx.model.TBook;
import com.hfmx.model.TBookModel;
import com.hfmx.utils.DataGrid;
import com.hfmx.utils.PageInfo;
import com.hfmx.utils.Tree;

public interface IBookSearchService {
	/**
	 * 根据ID获取图书model
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TBookModel searchModel(int id) throws Exception;

	/**
	 * 通过查询获取实体
	 * 
	 * @param sql
	 * @return
	 */
	public List<TBook> searchBySQL(String sql) throws Exception;

	/**
	 * 获取分页数据
	 */
	public DataGrid<Map<String, Object>> getlist(PageInfo page, String modelids) throws Exception;

	/**
	 * 获取读者信息
	 * 
	 * @param bookid
	 * @return
	 */
	public DataGrid<Map<String, Object>> getreaderdata(int bookid) throws Exception;

	/**
	 * 获取model树
	 * 
	 * @return
	 */
	public List<Tree> getmodeltree() throws Exception;
}
