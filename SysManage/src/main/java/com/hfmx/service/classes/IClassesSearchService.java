package com.hfmx.service.classes;

import java.util.Map;

import com.hfmx.model.TClasses;
import com.hfmx.utils.AjaxMsg;
import com.hfmx.utils.DataGrid;
import com.hfmx.utils.PageInfo;

public interface IClassesSearchService {

	
	public DataGrid<Map<String, Object>> getTeacherData(PageInfo page,Integer classId) throws Exception ;
	
	/**
	 * 获取分页数据
	 * @param page
	 * @param modelids
	 * @return
	 * @throws Exception
	 */
	public DataGrid<Map<String, Object>> getlist(PageInfo page, String modelids) throws Exception;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TClasses searchModel(int id) throws Exception;

	public AjaxMsg testClassName(String name) throws Exception;

	public AjaxMsg testTeacherNo(String id)throws Exception;
}
