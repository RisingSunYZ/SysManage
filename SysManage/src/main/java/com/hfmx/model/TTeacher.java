package com.hfmx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_teachers")
public class TTeacher {
	
	private int id;
	private TClasses clazz;
	private String teacherNo;
	private String teacherName;
	private String teacherSex;
	private Date teacherCreatedate;
	private boolean ischarger;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="classId")
	public TClasses getClazz() {
		return clazz;
	}

	public void setClazz(TClasses clazz) {
		this.clazz = clazz;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSex() {
		return teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	public Date getTeacherCreatedate() {
		return teacherCreatedate;
	}

	public void setTeacherCreatedate(Date teacherCreatedate) {
		this.teacherCreatedate = teacherCreatedate;
	}

	public boolean isIscharger() {
		return ischarger;
	}

	public void setIscharger(boolean ischarger) {
		this.ischarger = ischarger;
	}

	public TTeacher() {
		super();
	}

	public TTeacher(int id, String teacherNo, String teacherName,
			String teacherSex, Date teacherCreatedate) {
		super();
		this.id = id;
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.teacherSex = teacherSex;
		this.teacherCreatedate = teacherCreatedate;
	}

	public TTeacher(String teacherNo, String teacherName, String teacherSex,
			Date teacherCreatedate) {
		super();
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.teacherSex = teacherSex;
		this.teacherCreatedate = teacherCreatedate;
	}

	
}
