package com.hfmx.service.base.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hfmx.dao.base.impl.ExceptionDaoImpl;
import com.hfmx.service.base.IExceptionService;
import com.hfmx.utils.exception.BusinessException;
import com.hfmx.utils.exception.ParameterException;

@Service("IExceptionService")
public class ExceptionServiceImpl implements IExceptionService {
	@Resource
    private ExceptionDaoImpl exceptionDaoImpl;
	
	
	public void exception(Integer id) throws Exception {
		switch(id) {   
        case 1:   
            throw new BusinessException("11", "service11");   
        case 2:   
            throw new BusinessException("21", "service21");   
        case 3:   
            throw new BusinessException("31", "service31");   
        case 4:   
            throw new BusinessException("41", "service41");   
        case 5:   
            throw new BusinessException("51", "service51");   
        default:   
            throw new ParameterException("Service Parameter Error");   
        }

	}

	public void dao(Integer id) throws Exception {
		exceptionDaoImpl.exception(id);
  
	}

}
