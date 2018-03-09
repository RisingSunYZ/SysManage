package com.hfmx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="User")
public class TUser {
	private int id;
	private String userName;
	private String password;
	private boolean sex;
	private int age;	 
	private String email;
	
	public String getPassword() {
		return password;
	}

	public boolean isSex() {
		return sex;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	@Column(name = "username")
	public String getUserName() {
		return userName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
