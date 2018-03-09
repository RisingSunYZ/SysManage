package com.hfmx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;



@Entity
@Table(name="logoperation")
public class TLogOperation {
	private int id;
	/**操作用户的名称*/
	private String userName="游客";
	/**操作用户的id*/
	private String userId;
	/**操作内容*/
	private String content;
	/**操作时间*/
	private Date time;
	/**操作结果*/
	private String result;
	/**操作用户的ip*/
	private String ip;
	
	public TLogOperation(){
		
	}
	
	public TLogOperation(HttpServletRequest request,String content){
		String userName=request.getSession().getAttribute("sessioninfo").toString();
		if(userName!=null&&!userName.isEmpty()){
			this.userName=userName;
		}
		this.content=content;
		this.time=new Date();
	}
	
	public TLogOperation(String userName, String content) {
		super();
		this.userName = userName;
		this.content = content;
		this.time = new Date();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
