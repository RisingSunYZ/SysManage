package com.hfmx.control.medicine;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hfmx.control.base.BaseController;
import com.hfmx.service.medicine.IMedicineService;
import com.hfmx.utils.PageInfo;

@Controller
@Scope("prototype")
@RequestMapping("/medicine")
public class MedicineControl  extends BaseController{
	
	@Resource(name="medicineService")
	public IMedicineService service;
	
	
	@RequestMapping(value="list.do")
	public String forwordList(){
		return "medicine/list";
	}
	
	@RequestMapping(value="forAdd.do")
	public String forwordAdd(){
		return "medicine/add";
	}
	
	@RequestMapping(value = "/forwardUpdate/{id}.do")
	public String forwardShow(HttpServletRequest request, @PathVariable("id") int id) throws Exception {
		/*FBook fmodel = manage.findForm(id);
		AjaxMsg message = fmodel == null ? new AjaxMsg(false, "查看的图书不存在！") : new AjaxMsg(true, "");
		request.setAttribute("fmodel", fmodel);
		request.setAttribute("AjaxMsg", message);*/
		return "medicine/update";
	}
	
	
	/**
	 * 管理页面获取分页数据
	 * 
	 * @param response
	 * @param pageInfo
	 */
	@RequestMapping(value = "/grid.do")
	public void listgrid(HttpServletResponse response, PageInfo pageInfo) throws Exception {
		this.writeJson(response, service.getlist(pageInfo));
	}
}
