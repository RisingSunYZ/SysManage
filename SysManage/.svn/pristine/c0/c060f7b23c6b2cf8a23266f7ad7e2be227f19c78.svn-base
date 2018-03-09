package com.hfmx.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "bookmodel")
public class TBookModel {
	private int id;
	private String model;
	private TBookModel parent;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "pid")
	public TBookModel getParent() {
		return parent;
	}

	public void setParent(TBookModel parent) {
		this.parent = parent;
	}
}
