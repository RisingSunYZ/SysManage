package com.hfmx.control.exception;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hfmx.service.base.IExceptionService;
import com.hfmx.utils.exception.AjaxUtils;
import com.hfmx.utils.exception.BusinessException;
import com.hfmx.utils.exception.ParameterException;

@Controller
public class ExceptionControl{
	
   @Resource
   private IExceptionService iExceptionService;
   
   @RequestMapping(value = "/controller.do", method = RequestMethod.GET)
   private void controller(HttpServletResponse Response,Integer id) throws Exception{
	   switch(id) {   
       case 1:   
           throw new BusinessException("10", "controller10");   
       case 2:   
           throw new BusinessException("20", "controller20");   
       case 3:   
           throw new BusinessException("30", "controller30");   
       case 4:   
           throw new BusinessException("40", "controller40");   
       case 5:   
           throw new BusinessException("50", "controller50");   
       default:   
           throw new ParameterException("Controller Parameter Error");   
       }  
   }
   
   @RequestMapping(value = "/service.do", method = RequestMethod.GET)   
   public void service(HttpServletResponse response, Integer id) throws Exception {   
	   iExceptionService.exception(id);   
   }   
      
   @RequestMapping(value = "/dao.do", method = RequestMethod.GET)   
   public void dao(HttpServletResponse response, Integer id) throws Exception {   
	   iExceptionService.dao(id);   
   }   

   @RequestMapping(value = "/controllerAjax.do", method = RequestMethod.GET)   
   public void controllerAjax(HttpServletResponse response, Integer id) throws Exception {   
       try {   
    	   iExceptionService.dao(id);   
           AjaxUtils.rendJson(response, true, "操作成功");   
       } catch(Exception be) {   
           AjaxUtils.rendJson(response, false, "操作失败");   
       }   
   }   

}
