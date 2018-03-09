package com.hfmx.service.user.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hfmx.dao.user.IUserMenuDao;

import com.hfmx.model.TSysMenu;
import com.hfmx.service.base.impl.BaseServiceImpl;
import com.hfmx.service.user.IUserMenuService;

@Component("userMenuService")
public class UserMenuServiceImpl extends BaseServiceImpl<TSysMenu, Serializable>
		implements IUserMenuService {
	@Autowired
	private IUserMenuDao userMenuImpl;

	public List<TSysMenu> tree(TSysMenu menu) {
		String hql = "from  SysMenu where  ";
		Map<String, Object> params = new HashMap<String, Object>();
		if (menu == null || menu.getId() == 0) {
			hql += "  parent=null";
		} else {
			hql += "  parent.id=:id";
			params.put("id", menu.getId());
		}
		hql += " order by id asc";
		List<TSysMenu> menus = userMenuImpl.search(hql, params);
		System.out.println(menus.size());
		return menus;

		  
	}

}
