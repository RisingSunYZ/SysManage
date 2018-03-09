package com.hfmx.ws.service;

import java.util.List;

import javax.jws.WebService;

import com.hfmx.model.TBook;

@WebService
public interface IWSBookService {
	/**
	 * 通过查询获取实体
	 * 
	 * @param sql
	 * @return
	 */
	public List<TBook> searchBySQL(String sql) throws Exception;

}
