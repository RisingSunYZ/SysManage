package com.hfmx.utils.exception;

/**
 * 自定义业务异常
 * 
 * @author 黄稳
 * 
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 7687159893577342188L;
	private String code;

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String code, String message) {
		super(message);
		this.code = code;
	}

	public BusinessException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
