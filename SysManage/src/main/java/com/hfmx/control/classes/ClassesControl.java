package com.hfmx.control.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hfmx.control.base.BaseController;
import com.hfmx.model.TClasses;
import com.hfmx.model.TLogOperation;
import com.hfmx.model.TTeacher;
import com.hfmx.service.classes.IClassesManageService;
import com.hfmx.service.classes.IClassesSearchService;
import com.hfmx.service.classes.IMajorService;
import com.hfmx.utils.AjaxMsg;
import com.hfmx.utils.FileUtil;
import com.hfmx.utils.PageInfo;

@Controller
@Scope("prototype")
@RequestMapping("/classes")
public class ClassesControl extends BaseController{
	
	@Resource(name="classesManage")
	public IClassesManageService manage;
	@Resource(name="classesSearch")
	public IClassesSearchService search;
	@Resource(name="majorService")
	public IMajorService ms;
	
	/**
	 * 跳转添加页面
	 * @return
	 */
	@RequestMapping("/forwardAdd.do")
	public String forwardAdd(){
		return "classes/add";
	}
	
	/**
	 * 跳转修改界面
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/forwardEdit/{id}.do")
	public String forwardEdit(HttpServletRequest request, @PathVariable("id") int id) throws Exception{
		TClasses clazz = search.searchModel(id);
		AjaxMsg message = clazz == null ? new AjaxMsg(false, "修改的班级不存在！") : new AjaxMsg(true, "");
		request.setAttribute("clazz", clazz);
		request.setAttribute("AjaxMsg", message);
		getLogService().save(new TLogOperation("游客", "修改班级编号id为" + id));
		return "classes/edit";
	}
	
	
	/**
	 * grid的分页显示
	 * @param response
	 * @param pageInfo
	 * @param modelids
	 * @throws Exception
	 */
	@RequestMapping("/grid.do")
	public void showGrid(HttpServletResponse response, PageInfo pageInfo, String modelids) throws Exception {
		this.writeJson(response, search.getlist(pageInfo, modelids));
	}
	
	
	/**
	 * 批量删除
	 * @param response
	 * @param ids
	 * @throws Exception
	 */
	@RequestMapping("/delete/{ids}.do")
	public void delete(HttpServletResponse response, @PathVariable("ids") String ids) throws Exception {
		this.writeJson(response, manage.delete(ids));
	}
	/**
	 * 获取学院信息
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/academy.do")
	public void academy(HttpServletResponse response)throws Exception {
		this.writeJson(response, ms.findAca());
	}
	/**
	 * 根据Id获取专业信息
	 * @param response
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping("/major/{id}.do")
	public void major(HttpServletResponse response,@PathVariable("id") String id) throws Exception {
		this.writeJson(response, ms.findMaj(id));
	}
	/**
	 * 根据name获取专业信息
	 * @param response
	 * @param name
	 * @throws Exception
	 */
	@RequestMapping(value ="/majorByName/{name}.do")
	public void majorByName(HttpServletResponse response,@PathVariable("name") String name) throws Exception {
		String str = new String(name.getBytes("ISO-8859-1"), "utf-8");
		this.writeJson(response, ms.findMajByName(str));
	}
	
	
	/**
	 * 添加班级
	 * @param response
	 * @param clazz
	 * @throws Exception
	 */
	@RequestMapping("/add.do")
	public void add(HttpServletRequest request, HttpServletResponse response,TClasses clazz,MultipartFile Logo) throws Exception {
		String fileName = FileUtil.fileUpload(Logo, request);
		clazz.setClassLogo(fileName);
		this.writeJson(response, manage.add(clazz));
	}
	/**
	 * 更新班级
	 * @param response
	 * @param clazz
	 * @throws Exception
	 */
	@RequestMapping("/upd.do")
	public void upd(HttpServletRequest request,HttpServletResponse response,TClasses clazz,MultipartFile Logo) throws Exception {
		//上传新文件，删除老文件
		String oldfile = clazz.getClassLogo();
		String fileName = FileUtil.fileUpload(Logo, request);
		clazz.setClassLogo(fileName);
		FileUtil.fileDelete(oldfile, request);
		this.writeJson(response, manage.upd(clazz));
	}
	
	/**
	 * 显示logo
	 * @param request
	 * @param response
	 * @param filename
	 * @throws Exception
	 */
	@RequestMapping("/image/{filename}.do")
	public void image(HttpServletRequest request,HttpServletResponse response,@PathVariable String filename) throws Exception{
		ServletContext sc=request.getSession().getServletContext();
		String path="image/";
		String dir=sc.getRealPath(path);
		System.out.println(dir);
		InputStream in = new FileInputStream(new File(dir,filename));
		OutputStream out = response.getOutputStream();
		byte[] b = new byte[1024*8];
		while(-1!=(in.read(b))){
			out.write(b);
		}
		out.close();
		in.close();
	}
	
	/**
	 * 添加教师为游离状态
	 * @param response
	 * @param tch
	 * @throws Exception
	 */
	@RequestMapping("/addTeacher.do")
	public void addTeacher(HttpServletResponse response,String teacherNo,String teacherName,String teacherSex,Date teacherCreatedate,String ischarger) throws Exception {
		TTeacher tch = new TTeacher(teacherNo, teacherName, teacherSex,teacherCreatedate);
		if("是".equals(ischarger)||"true".equals(ischarger))
			tch.setIscharger(true);
		else
			tch.setIscharger(false);
		this.writeJson(response, manage.addTch(tch));
	}
	/**
	 * 回滚教师名单
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/rollback.do")
	public void rollback(HttpServletResponse response) throws Exception {
	}
	
	/**
	 * 查看班级老师
	 * @param response
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping("/showteacher/{id}.do")
	public void showTeacher(HttpServletResponse response,PageInfo page,@PathVariable("id")String id)throws Exception {
		this.writeJson(response,search.getTeacherData(page,Integer.parseInt(id)));
	}
	
	/**
	 * 添加老师至数据库
	 * @param response
	 * @param tch
	 * @throws Exception
	 */
	@RequestMapping("/addTeacher1/{cid}.do")
	public void addTeacher1(HttpServletResponse response,String teacherNo,String teacherName,String teacherSex,Date teacherCreatedate,String ischarger,@PathVariable("cid")String cid) throws Exception {
		TTeacher tch = new TTeacher(teacherNo, teacherName, teacherSex,teacherCreatedate);
		
		System.out.println(cid+"我前面是cid");
		
		if("是".equals(ischarger)||"true".equals(ischarger))
			tch.setIscharger(true);
		else
			tch.setIscharger(false);
		TClasses clz = new TClasses();
		clz.setId(Integer.parseInt(cid));
		tch.setClazz(clz);
		this.writeJson(response, manage.addTeacher(tch));
	}
	
	/**
	 * 修改老师信息
	 * @param response
	 * @param tch
	 * @throws Exception
	 */
	@RequestMapping("/updTeacher/{cid}.do")
	public void updTeacher(HttpServletResponse response,int id,String teacherNo,String teacherName,String teacherSex,Date teacherCreatedate,String ischarger,@PathVariable("cid")String cid) throws Exception {
		TTeacher tch = new TTeacher(id, teacherNo, teacherName, teacherSex,teacherCreatedate);
		if("是".equals(ischarger)||"true".equals(ischarger))
			tch.setIscharger(true);
		else
			tch.setIscharger(false);
		TClasses clz = new TClasses();
		clz.setId(Integer.parseInt(cid));
		tch.setClazz(clz);
		this.writeJson(response, manage.updTeacher(tch));
	}
	
	/**
	 * 根据ID删除老师
	 * @param response
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping("/delTeacher/{id}.do")
	public void delTeacher(HttpServletResponse response,@PathVariable("id")String id) throws Exception{
		this.writeJson(response, manage.delTeacher(Integer.parseInt(id)));
	}
	
	
	/**
	 * 根据No删除老师
	 * @param response
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping("/delTeacher1/{teacherNo}.do")
	public void delTeacher1(HttpServletResponse response,@PathVariable("teacherNo")String teacherNo) throws Exception{
		this.writeJson(response, manage.delTeacherByNo(teacherNo));
	}
	
	/**
	 * 添加页面老师grid
	 * @param response
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping("/addgrid.do")
	public void addgrid(HttpServletResponse response,PageInfo page) throws Exception{
		this.writeJson(response, search.getTeacherData(page, null));
	}
	
	/**
	 * 删除游离态教师（没有classId的教师）
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delDetachedTch.do")
	public void delDetachedTch(HttpServletResponse response) throws Exception{
		this.writeJson(response, manage.delDetachedTch());
	}
	
	
	@RequestMapping("/testClassName/{name}.do")
	public void testClassName(HttpServletResponse response,@PathVariable("name")String name) throws Exception{
		String str = new String(name.getBytes("ISO-8859-1"), "utf-8");
		this.writeJson(response, search.testClassName(str));
	}
	
	@RequestMapping("/testTeacherNo/{id}.do")
	public void testTeacherNo(HttpServletResponse response,@PathVariable("id")String id) throws Exception{
		this.writeJson(response, search.testTeacherNo(id));
	}
}
