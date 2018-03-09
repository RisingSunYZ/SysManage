package com.hfmx.control.file;

import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hfmx.control.base.BaseController;
import com.hfmx.service.file.IFileService;
import com.hfmx.utils.AjaxMsg;

@Controller
@Scope("prototype")
@RequestMapping("/file")
public class FileControl extends BaseController {
	/** 文件保存路径 **/
	private static final String UPLOADDIR = "file/";
	@Resource(name = "fileService")
	private IFileService fileService;

	@RequestMapping(value = "/upload.do")
	public void upload(HttpServletRequest request, HttpServletResponse response) {
		// 主路径
		String context = request.getSession().getServletContext().getRealPath("/");
		// 表单数据获取缓存区
		// String storeDir = FileControl.UPLOADDIR + "directory/";
		// 临时缓存目录
		String tempDir = FileControl.UPLOADDIR + "template/";
		// 文件保存路径
		String uploadDir = FileControl.UPLOADDIR + DateFormatUtils.format(new Date(), "yyyyMM") + "/";
		// AjaxMsg result = fileService.uploadfile(request, context, storeDir, tempDir, uploadDir);
		AjaxMsg result = fileService.uploadfile(request, context, tempDir, uploadDir);
		this.writeJson(response, result);
	}

	@RequestMapping(value = "/progress.do")
	public void progress(HttpServletRequest request, HttpServletResponse response) {
		this.writeJson(response, fileService.progress(request));
	}

	@RequestMapping(value = "/delete/{id}.do")
	public void delete(HttpServletResponse response, @PathVariable("id") String fileid) throws Exception {
		this.writeJson(response, fileService.delete(fileid));
	}

}
