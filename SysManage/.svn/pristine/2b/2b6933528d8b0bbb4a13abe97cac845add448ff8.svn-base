package com.hfmx.utils.upload;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

/**
 * 进度条监听器
 * 
 * @author mjsh
 * 
 */
public class MXProgressListener implements ProgressListener {
	private HttpSession session;

	public MXProgressListener() {
	}

	public MXProgressListener(HttpSession _session) {
		session = _session;
		MXProgressEntity ps = new MXProgressEntity();
		session.setAttribute("upload_ps", ps);
	}

	/**
	 * pBytesRead表示已经上传到服务器的字节数，pContentLength表示所有文件的总大小，pItems表示第几个文件
	 */
	@Override
	public void update(long pBytesRead, long pContentLength, int pItems) {
		MXProgressEntity ps = (MXProgressEntity) session.getAttribute("upload_ps");
		ps.setpBytesRead(pBytesRead);
		ps.setpContentLength(pContentLength);
		ps.setpItems(pItems);
		// 更新
		session.setAttribute("upload_ps", ps);
	}

}
