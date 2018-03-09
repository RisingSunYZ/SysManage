package com.hfmx.utils.exception;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理
 * 
 * @author 黄稳(建) 梅江顺(改 2013-10-17)
 * 
 */
public class MXExceptionHandler implements HandlerExceptionResolver {
	private static Logger logger = Logger.getLogger(MXExceptionHandler.class);

	/**
	 * 异常处理
	 */
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex);
		/**
		 * 自定义业务异常
		 */
		if (ex instanceof BusinessException) {
			logger.error(ex.getMessage(), ex);
			return new ModelAndView("exception/error-business", model);
		}
		/**
		 * 自定义参数异常
		 */
		else if (ex instanceof ParameterException) {
			logger.error(ex.getMessage(), ex);
			return new ModelAndView("exception/error-parameter", model);
		}
		/**
		 * 上传文件大小超过限制范围
		 */
		else if (ex instanceof MultipartException) {
			model.put("ex", new Exception("上传文件大小超过系统限制！"));
			logger.error("上传文件大小超过系统限制！", ex);
			return new ModelAndView("exception/error-business", model);
		}
		/**
		 * 系统异常
		 */
		else {
			logger.error(ex.getMessage(), ex);
			return new ModelAndView("exception/error", model);
		}
	}
}
