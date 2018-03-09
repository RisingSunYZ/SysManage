package com.hfmx.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_classes")
public class TClasses {
	private int id;
	private String className;
	private String classAcademy;
	private String classMajor;
	private String classLogo;
	private String classSlogan;
	private Date classCreatedate;
	private String classDescription;
	private List<TTeacher> teachers;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassAcademy() {
		return classAcademy;
	}

	public void setClassAcademy(String classAcademy) {
		this.classAcademy = classAcademy;
	}

	public String getClassMajor() {
		return classMajor;
	}

	public void setClassMajor(String classMajor) {
		this.classMajor = classMajor;
	}

	public String getClassLogo() {
		return classLogo;
	}

	public void setClassLogo(String classLogo) {
		this.classLogo = classLogo;
	}

	public String getClassSlogan() {
		return classSlogan;
	}

	public void setClassSlogan(String classSlogan) {
		this.classSlogan = classSlogan;
	}

	public Date getClassCreatedate() {
		return classCreatedate;
	}

	public void setClassCreatedate(Date classCreatedate) {
		this.classCreatedate = classCreatedate;
	}
	
	@Column(columnDefinition = "text")
	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "clazz")
	public List<TTeacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TTeacher> teachers) {
		this.teachers = teachers;
	}


}
