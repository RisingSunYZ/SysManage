package com.hfmx.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="SysMenu")
public class TSysMenu {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TSysMenu other = (TSysMenu) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)
	@JoinColumn(name = "pid")
	public TSysMenu getParent() {
		return parent;
	}

	public void setParent(TSysMenu parent) {
		this.parent = parent;
	}

	public String getUrl() {
		return url;
	}

	public String getText() {
		return text;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int id;
	public TSysMenu parent;
	public String url;
	public String text;
	public boolean checked=false;
	public String state="closed";
	public String iconCls;
	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	 

	public String getState() {
		return state;
	}

	 

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setState(String state) {
		this.state = state;
	}
}
