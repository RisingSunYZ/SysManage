package com.hfmx.utils;

import com.hfmx.model.TUser;

/**
 * UserInfo模型，只要登录成功，就需要设置到session里面，便于系统使用
 * 
 * @author  
 * 
 */
public class UserInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private TUser user;

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return user.getUserName();
	}

}
