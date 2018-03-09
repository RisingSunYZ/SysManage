package com.hfmx.control.sysMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hfmx.control.base.BaseController;
import com.hfmx.model.TSysMenu;
import com.hfmx.model.TUser;
import com.hfmx.service.user.IUserMenuService;
import com.hfmx.utils.AjaxMsg;
import com.hfmx.utils.SessionKey;
import com.hfmx.utils.Tree;
import com.hfmx.utils.UserInfo;


@Controller
@Scope("prototype")
@RequestMapping("/sys")
public class SystemMenuControl extends BaseController{
	@Autowired
	public IUserMenuService userMenuServiceImpl;

	@RequestMapping(value = "/logout.do")	
	public void  logout(HttpServletResponse response,TUser user) {
		AjaxMsg msg = new AjaxMsg();
		System.out.println("do logout");
		this.writeJson(response, msg) ;
	}

	@RequestMapping(value = "/updatePWD.do") 
	public void updatePWD(HttpServletResponse response,TUser user) {
		AjaxMsg msg = new AjaxMsg();
		System.out.println(user.getPassword());
		if (user.getPassword().equals("admin")) {
			msg.setMsg("修改成功");
			msg.setSuccess(true);
		} else {
			msg.setMsg("修改失败");
			msg.setSuccess(false);
		}
		this.writeJson(response, msg);
	}

	@RequestMapping(value = "/loginVali.do")	
	public void loginValidate(HttpServletRequest request,HttpServletResponse response, Model model, TUser user) {
		AjaxMsg msg = new AjaxMsg();
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		if (user.getUserName().equals("admin") && user.getPassword().equals("admin")) {
			msg.setMsg("" + user.getUserName() + "_" + user.getPassword());
			UserInfo userInfo=new UserInfo();
			userInfo.setUser(user);
			request.getSession().setAttribute(SessionKey.UserInfoKey, userInfo);
			msg.setSuccess(true);
		} else {
			msg.setMsg("" + user.getUserName() + "_" + user.getPassword());
			msg.setSuccess(false);
		}
	 this.writeJson(response, msg);
	}
	
    @RequestMapping(value = "regVali.do")
	public void regValidate(HttpServletRequest req,HttpServletResponse res,Model model,TUser user ){
		AjaxMsg msg=new AjaxMsg();
		//TUser u= userMenuServiceImpl.find(user, user.getId());
		if(user.getUserName()!=null){
			msg.setMsg("" + user.getUserName() + "_" + user.getPassword());
			msg.setSuccess(false);
		}else{;
			//userMenuServiceImpl.save(user);
		msg.setSuccess(true);
		}
	}

	@RequestMapping(value = "/sysmenu.do")
	public void  getSysMenu(HttpServletResponse response,HttpServletRequest request, String id) throws Exception{
		 
		 List<TSysMenu> menus = new ArrayList<TSysMenu>();
		TSysMenu menu = new TSysMenu();
		if (id != null) {
			menu.setId(Integer.parseInt(id));
		}
		menus = userMenuServiceImpl.tree(menu);
		List<Tree> trees = new ArrayList<Tree>();
		for (TSysMenu menu2 : menus) {
			Tree node = new Tree();
			node.setId(Integer.toString(menu2.getId()));
			node.setText(menu2.getText());

			HashMap attributes = new HashMap();
			attributes.put("url", menu2.getUrl());
			node.setAttributes(attributes);
			System.out.println("" + node.getAttributes().toString());
			System.out.println(menu2.getUrl());
			if (userMenuServiceImpl.tree(menu2).size() > 0) {
				node.setState("closed");
			}
			if (!menu2.getIconCls().equals("")) {
				node.setIconCls(menu2.getIconCls());
			}
			node.setChecked(menu2.isChecked());
			trees.add(node);
		}
		 this.writeJson(response, trees) ; 
	}
}
