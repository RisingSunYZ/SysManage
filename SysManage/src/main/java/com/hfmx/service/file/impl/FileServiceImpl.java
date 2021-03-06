package com.hfmx.service.file.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hfmx.dao.file.IFileDao;
import com.hfmx.model.TFile;
import com.hfmx.service.file.IFileService;
import com.hfmx.utils.AjaxMsg;
import com.hfmx.utils.exception.BusinessException;
import com.hfmx.utils.upload.MXProgressEntity;
import com.hfmx.utils.upload.MXProgressListener;

@Service("fileService")
public class FileServiceImpl implements IFileService {
	@Resource(name = "fileDao")
	private IFileDao dao;
	private Logger logger = Logger.getLogger(FileServiceImpl.class);

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BusinessException.class)
	public AjaxMsg add(TFile t) throws Exception {
		try {
			dao.save(t);
			return new AjaxMsg(true, "添加成功！");
		} catch (Exception e) {
			logger.warn("添加记录失败！");
			throw new BusinessException("添加记录出错！", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BusinessException.class)
	public AjaxMsg update(TFile t) throws Exception {
		try {
			dao.update(t);
			return new AjaxMsg(true, "修改成功！");
		} catch (Exception e) {
			logger.warn("修改记录失败！");
			throw new BusinessException("修改记录出错！", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BusinessException.class)
	public AjaxMsg delete(String uuid) throws Exception {
		if (StringUtils.isBlank(uuid)) {
			return new AjaxMsg(false, "请选择需要删除的文件！", null);
		}
		String filepath;
		try {
			TFile file = this.find(uuid);
			filepath = file.getPath();
		} catch (Exception e) {
			return new AjaxMsg(false, "文件不存在！", null);
		}
		try {
			dao.delete(TFile.class, uuid);
			if (StringUtils.isNotBlank(filepath)) {
				File f = new File(filepath);
				if (f.isFile() && f.exists())
					f.delete();
			}
			return new AjaxMsg(true, "删除成功！");
		} catch (Exception e) {
			logger.warn("文件删除失败！");
			throw new BusinessException("文件删除失败！", e);
		}
	}

	@Override
	public TFile find(String uuid) throws Exception {
		try {
			return dao.find(TFile.class, uuid);
		} catch (Exception e) {
			throw new BusinessException("找不到该记录！", e);
		}
	}

	/**
	 * 从缓存区获取文件，并保存文件
	 * 
	 * @param request
	 * @param context根目录
	 * @param storeDir表单数据获取缓存区
	 * @param uploadDir临时缓存目录
	 * @param tempDir文件保存路径
	 * @return
	 */
	@Override
	public AjaxMsg uploadfile(HttpServletRequest request, String context, String storeDir, String tempDir, String uploadDir) {
		// 表单数据获取缓存区
		File storeFile = new File(context + storeDir);
		if (!storeFile.exists())
			storeFile.mkdirs();
		try {
			// 判断是否是上传表单
			if (ServletFileUpload.isMultipartContent(request)) {
				// DiskFileItemFactory创建FileItem实例，通过一个阀值来决定存放在内存或者硬盘中
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 设置阀值，默认10k，超过这个阀值，FileItem将直接写入到factory设置的临时文件夹
				factory.setSizeThreshold(1024 * 100);
				// 设置临时文件夹，默认为系统Temp文件路径，获取调用System.getProperty("java.io.tmpdir")
				factory.setRepository(storeFile);
				// ServletFileUpload提供创建FileItem的工厂模式DiskFileItemFactory实例
				ServletFileUpload fileUpload = new ServletFileUpload(factory);
				// 设置一个完整的请求允许的最大大小(注意是完整请求，包括非file类型的表单input)
				fileUpload.setSizeMax(1024 * 1024 * 100);
				fileUpload.setHeaderEncoding("UTF-8");
				fileUpload.setProgressListener(new MXProgressListener(request.getSession()));
				List<FileItem> items = fileUpload.parseRequest(request);
				// 是否将文件保存入数据库
				boolean save = true;
				// 文件信息
				Map<String, String> result = null;
				// 先获取表单元素
				for (FileItem item : items) {
					if (item.isFormField()) {
						// 表单元素
						String name = item.getFieldName();
						String value = item.getString("UTF-8");
						if (name.equals("save")) {
							if (StringUtils.isNotBlank(value))
								save = Boolean.valueOf(value);
							continue;
						}
					} else {
						// 文件元素
						// 获得上传文件的文件名
						String fileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
						result = savefile(item.getInputStream(), fileName, context, uploadDir, tempDir, save);
					}
				}
				return new AjaxMsg(true, "上传成功!", result);
			} else
				return new AjaxMsg(false, "请设置表单的enctype属性为multipart/form-data!", null);
		} catch (FileUploadException e) {
			String msg = e instanceof SizeLimitExceededException ? "上传文件太大！" : "上传文件发生错误！";
			return new AjaxMsg(false, msg, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxMsg(false, "上传失败！", null);
		}
	}

	/**
	 * 从request数据流中获取文件，并保存文件
	 * 
	 * @param request
	 * @param context根目录
	 * @param uploadDir临时缓存目录
	 * @param tempDir文件保存路径
	 * @return
	 */
	@Override
	public AjaxMsg uploadfile(HttpServletRequest request, String context, String tempDir, String uploadDir) {
		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				ServletFileUpload fileUpload = new ServletFileUpload();
				fileUpload.setSizeMax(1024 * 1024 * 100);
				fileUpload.setHeaderEncoding("UTF-8");
				fileUpload.setProgressListener(new MXProgressListener(request.getSession()));
				FileItemIterator iter = fileUpload.getItemIterator(request);
				System.out.println(iter+"111111111");
				// 是否将文件保存入数据库
				boolean save = true;
				// 文件信息
				Map<String, String> result = null;
				while (iter.hasNext()) {
					System.out.println("看看我有没有进来");
					FileItemStream item = iter.next();
					if (item.isFormField()) {
						// 表单元素
						System.out.println("看看我有没有再进来");
						String fieldname = item.getFieldName();
						InputStream ins = item.openStream();
						String value = Streams.asString(ins);
						if (fieldname.equals("save")) {
							if (StringUtils.isNotBlank(value))
								save = Boolean.valueOf(value);
							continue;
						}
					} else {
						// 文件元素
						// 获得上传文件的文件名
						System.out.println("filename:" + item.getName());
						String fileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
						result = savefile(item.openStream(), fileName, context, uploadDir, tempDir, save);
					}
				}
				return new AjaxMsg(true, "上传成功!", result);
			} else
				return new AjaxMsg(false, "请设置表单的enctype属性为multipart/form-data!", null);
		} catch (FileUploadException e) {
			String msg = e instanceof SizeLimitExceededException ? "上传文件太大！" : "上传文件发生错误！";
			return new AjaxMsg(false, msg, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxMsg(false, "上传失败！", null);
		}
	}

	/**
	 * 获取进度条信息
	 * 
	 * @param request
	 * @return
	 */
	public MXProgressEntity progress(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("upload_ps") != null)
			return (MXProgressEntity) session.getAttribute("upload_ps");
		else
			return null;
	}

	/**
	 * 保存文件
	 */
	private Map<String, String> savefile(InputStream stream, String filename, String context, String tempDir, String uploadDir, boolean save)
			throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		String fileid = UUID.randomUUID().toString();
		String newfilename = fileid + filename.substring(filename.lastIndexOf(".") );// 新文件名
		String saveDir = save ? context + uploadDir : context + tempDir;// 文件保存位置
		String url = save ? uploadDir + newfilename : tempDir + newfilename;// 文件访问地址
		String path = saveDir + newfilename;// 文件具体地址
		File filedir = new File(saveDir);
		if (!filedir.exists()) {
			// 创建文件夹要用 file.mkdirs(),不能用 file.mkdir(),否则在linux下运行失败
			filedir.mkdirs();
		}
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(path)));
		BufferedInputStream bis = new BufferedInputStream(stream);
		byte[] buffer = new byte[4096];
		int bytes_read;
		while ((bytes_read = bis.read(buffer)) != -1) {
			bos.write(buffer, 0, bytes_read);
		}
		bis.close();
		bos.flush();
		bos.close();
		// 存入数据库
		if (save) {
			TFile t = new TFile();
			t.setUuid(fileid);
			t.setName(filename);
			t.setPath(path);
			t.setUrl(url);
			t.setFlag(false);
			this.add(t);
		}
		result.put("fileid", fileid);
		result.put("fileName", filename);
		result.put("url", url);
		return result;
	}

}
