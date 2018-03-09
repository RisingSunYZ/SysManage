package com.hfmx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="medicine")
public class TMedicine {
	private int id;
	/** 药品名称 */
	private String name;
	/** 产品类别(中药，化学药品)  */
	private String type;
	/** 批准文号 */
	private String pcode;
	/** 批准日期 */
	private Date pDate;
	/** 原文号 */
	private String rcode;
	/** 药品规格 */
	private String spec;
	/** 药品本位码 */
	private String scode;
	/** 本位码备注  */
	private String scodeNote;
	/** 生产企业 */
	private String enterPrise;
	/** 药品剂型 */
	private String form;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getScodeNote() {
		return scodeNote;
	}
	public void setScodeNote(String scodeNote) {
		this.scodeNote = scodeNote;
	}
	public String getEnterPrise() {
		return enterPrise;
	}
	public void setEnterPrise(String enterPrise) {
		this.enterPrise = enterPrise;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	
}
