package com.hfmx.utils;

public class AjaxMsg {
	/** 是否成功 **/
	private boolean success;
	/** 提示信息 **/
	private String msg;
	/** 其他信息 **/
	private Object result;

	public AjaxMsg() {
	}

	public AjaxMsg(boolean success, String msg) {
		this.setSuccess(success);
		this.setMsg(msg);
	}

	public AjaxMsg(boolean success, String msg, Object result) {
		this.setSuccess(success);
		this.setMsg(msg);
		this.setResult(result);
	}

	public String getMsg() {
		return msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
