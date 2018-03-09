package com.hfmx.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * EasyUI tree模型
 */
public class Tree implements java.io.Serializable {
	private static final long serialVersionUID = -146960362437091341L;
	private String id;
	private String text;
	private String state = "open";// open,closed
	private boolean checked = false;
	private List<Tree> children = new ArrayList<Tree>();
	private boolean isParent;
	private String iconCls;
	private String pid;
	private HashMap<String, String> attributes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public boolean isIsParent() {
		return isParent;
	}

	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}

	

}
