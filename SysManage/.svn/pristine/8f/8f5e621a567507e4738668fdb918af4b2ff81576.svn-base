package com.hfmx.ws.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import com.hfmx.model.TBook;
import com.hfmx.service.book.IBookSearchService;
import com.hfmx.ws.service.IWSBookService;

@WebService(endpointInterface="com.hfmx.ws.service.IWSBookService",serviceName="wsBookServiceImpl")
public class WSBookServiceImpl implements IWSBookService {

	@Resource(name="bookSearch")
	private IBookSearchService service;
	
	@Override
	public List<TBook> searchBySQL(String sql) throws Exception {
		if(service==null){
			System.out.println("出错了");
		};
		return service.searchBySQL(sql);
	}

}
