package com.hfmx.service.classes;

import com.hfmx.model.TClasses;
import com.hfmx.model.TTeacher;
import com.hfmx.utils.AjaxMsg;

public interface IClassesManageService {

	/**
	 * 添加
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public AjaxMsg add(TClasses clazz) throws Exception;
	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public AjaxMsg delete(String ids) throws Exception;
	
	
	/**
	 * 修改班级信息
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public AjaxMsg upd(TClasses clazz)throws Exception;
	
	
	/**
	 * 添加教师至缓存
	 * @param tch
	 * @return
	 * @throws Exception
	 */
	public AjaxMsg addTch(TTeacher tch) throws Exception;
	
	/**
	 * 删除游离态教师
	 * @return
	 * @throws Exception
	 */
	public AjaxMsg delDetachedTch() throws Exception;
	
	
	
	/**
	 * 删除老师信息
	 * @param Tch
	 * @return
	 * @throws Exception
	 */
	public AjaxMsg delTeacher(Integer id) throws Exception;
	
	public AjaxMsg delTeacherByNo(String teacherNo) throws Exception;
	
	
	/**
	 * 添加教师至数据库
	 * @param tch
	 * @return
	 * @throws Exception
	 */
	public AjaxMsg addTeacher(TTeacher tch) throws Exception;
	
	/**
	 * 修改老师信息
	 * @param tch
	 * @return
	 * @throws Exception
	 */
	public AjaxMsg updTeacher(TTeacher tch) throws Exception;
	
	
}
