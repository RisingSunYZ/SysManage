package com.hfmx.utils.upload;

/**
 * 进度条实体类
 * 
 * @author mjsh
 * 
 */
public class MXProgressEntity {
	/** 已经上传到服务器的字节数 **/
	private long pBytesRead = 0L;
	/** 所有文件的总大小 **/
	private long pContentLength = 0L;
	/** 第几个文件 **/
	private int pItems;

	@Override
	public String toString() {
		return "ProgressEntity [pBytesRead=" + pBytesRead + ", pContentLength=" + pContentLength + ", pItems=" + pItems
				+ "]";
	}

	public long getpBytesRead() {
		return pBytesRead;
	}

	public void setpBytesRead(long pBytesRead) {
		this.pBytesRead = pBytesRead;
	}

	public long getpContentLength() {
		return pContentLength;
	}

	public void setpContentLength(long pContentLength) {
		this.pContentLength = pContentLength;
	}

	public int getpItems() {
		return pItems;
	}

	public void setpItems(int pItems) {
		this.pItems = pItems;
	}
}
