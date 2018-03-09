package com.hfmx.dao.log.impl;


import org.springframework.stereotype.Component;

import com.hfmx.dao.base.impl.BaseDaoImpl;
import com.hfmx.dao.log.ILogDao;
import com.hfmx.model.TLogOperation;

@Component("logDao")
public class LogDaoImpl extends BaseDaoImpl<TLogOperation, Integer> implements ILogDao {

	

}
