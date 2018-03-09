package com.hfmx.service.medicine;

import java.util.List;

import com.hfmx.model.TMedicine;
import com.hfmx.utils.DataGrid;
import com.hfmx.utils.PageInfo;

public interface IMedicineService {
	/**
	 * 通过查询获取实体
	 * 
	 * @param sql
	 * @return
	 */
	public List<TMedicine> searchBySQL(String sql) throws Exception;

	/**
	 * 获取分页数据
	 */
	public DataGrid getlist(PageInfo page) throws Exception;
}
