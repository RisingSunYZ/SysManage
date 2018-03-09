package com.hfmx.service.file;

import javax.servlet.http.HttpServletRequest;

import com.hfmx.model.TFile;
import com.hfmx.utils.AjaxMsg;
import com.hfmx.utils.upload.MXProgressEntity;

public interface IFileService {
	/**
	 * 添加
	 * 
	 * @param f
	 */
	public AjaxMsg add(TFile t) throws Exception;

	/**
	 * 更新
	 * 
	 * @param f
	 */
	public AjaxMsg update(TFile t) throws Exception;

	/**
	 * 删除
	 * 
	 * @param ids
	 */
	public AjaxMsg delete(String uuid) throws Exception;

	/**
	 * 获取实体类
	 * 
	 * @param id
	 * @return
	 */
	public TFile find(String uuid) throws Exception;

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
	public AjaxMsg uploadfile(HttpServletRequest request, String context, String storeDir, String tempDir, String uploadDir);

	/**
	 * 从request数据流中获取文件，并保存文件
	 * 
	 * @param request
	 * @param context根目录
	 * @param uploadDir临时缓存目录
	 * @param tempDir文件保存路径
	 * @return
	 */
	public AjaxMsg uploadfile(HttpServletRequest request, String context, String tempDir, String uploadDir);

	/**
	 * 获取进度条信息
	 * 
	 * @param request
	 * @return
	 */
	public MXProgressEntity progress(HttpServletRequest request);
}
