package com.hfmx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "file")
public class TFile {
	private String uuid;
	/** 文件名称 **/
	private String name;
	/** 文件路径 **/
	private String path;
	/** 访问地址 **/
	private String url;
	/** 创建时间 **/
	private Date createdate = new Date();
	/** 标志是否在用 **/
	private boolean flag = false;

	@Id
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
