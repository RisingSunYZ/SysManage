package com.hfmx.control.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.hfmx.service.log.ILogService;
import com.hfmx.utils.JsonParse;

public abstract class BaseController {
	
	@Resource(name="logService")
	private ILogService logService;
	
	public ILogService getLogService() {
		return logService;
	}

	public void setLogService(ILogService logService) {
		this.logService = logService;
	}

	/**
	 * 输出HTML脚本
	 */
	protected void writeJson(HttpServletResponse response, Object obj) {
		this.writeJson(response, obj, "utf-8");
	}

	/**
	 * 输出HTML脚本带格式
	 */
	protected void writeJson(HttpServletResponse response, Object obj, String charset) {
		String json = JsonParse.getJson(obj);
		response.setContentType("text/html;charset=" + charset);
		response.setDateHeader("Expires", -10);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}
}
