package com.hfmx.service.log.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hfmx.dao.log.ILogDao;
import com.hfmx.model.TLogOperation;
import com.hfmx.service.log.ILogService;

@Component("logService")
@Transactional
public class LogService implements ILogService {

	@Resource(name="logDao")
	private ILogDao logDao;
	
	@Override
	public boolean save(TLogOperation log) {
		 logDao.save(log);
		 return true;
	}

	@Override
	public long count() {
		return logDao.count(TLogOperation.class);
	}


}
