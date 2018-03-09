package com.hfmx.service.classes.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.TTCCLayout;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hfmx.dao.classes.IClassesDao;
import com.hfmx.dao.teacher.ITeacherDao;
import com.hfmx.model.TClasses;
import com.hfmx.model.TTeacher;
import com.hfmx.service.classes.IClassesManageService;
import com.hfmx.utils.AjaxMsg;
import com.hfmx.utils.exception.BusinessException;

@Service("classesManage")
@Transactional
public class ClassesManageServiceImpl implements IClassesManageService{

	@Resource(name ="classesDao")
	private IClassesDao cdao;
	@Resource(name ="teacherDao")
	private ITeacherDao tdao;
	private Logger logger = Logger.getLogger(ClassesManageServiceImpl.class);
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BusinessException.class)
	public AjaxMsg add(TClasses clazz) throws Exception {
		if(clazz==null)
			return new AjaxMsg(false, "添加数据未获取到！");
		try{
			
			cdao.save(clazz);
			String tsql = "select * from t_teachers where classId is null";
			List<TTeacher> tlist = tdao.search(TTeacher.class, tsql);
			if(tlist!=null){
				System.out.println(clazz.getClassName());
				String csql = "select * from t_classes where className = '"+clazz.getClassName()+"'";
				int clsid=cdao.search(TClasses.class, csql).get(0).getId();
				
				TClasses cls = new TClasses();
				for (int i = 0; i < tlist.size(); i++) {
					cls.setId(clsid);
					tlist.get(i).setClazz(cls);
					tdao.update(tlist.get(i));
				}
			}
			return new AjaxMsg(true, "添加成功！");
		}catch(Exception e){
			logger.warn("添加记录失败！");
			throw new BusinessException("添加记录出错！", e);
		}
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BusinessException.class)
	public AjaxMsg delete(String ids) throws Exception {
		if (StringUtils.isBlank(ids))
			return new AjaxMsg(false, "请选择需要删除的记录！");
		try {
			String[] idsString = ids.split(",");
			for (String id : idsString) {
				cdao.delete(TClasses.class, Integer.parseInt(id));
			}
			return new AjaxMsg(true, "删除成功！");
		} catch (Exception e) {
			logger.warn("删除记录失败！");
			throw new BusinessException("删除记录出错！", e);
		}
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BusinessException.class)
	public AjaxMsg upd(TClasses clazz) throws Exception {
		if(clazz==null)
			return new AjaxMsg(false, "修改数据未获取到！");
		try {
			cdao.update(clazz);
			return new AjaxMsg(true, "修改成功");
		} catch (Exception e) {
			logger.warn("修改记录失败！");
			throw new BusinessException("修改记录出错！", e);
		}
	}

	
	
	
	@Override
	public AjaxMsg addTch(TTeacher tch) throws Exception {
		try {
			//遍历集合寻找班主任
			String sql = "select * from t_teachers where classId is null";
			List<TTeacher> tlist = tdao.search(TTeacher.class, sql);
			for (int i = 0; i < tlist.size(); i++) {
				if(tlist.get(i).isIscharger()&&tch.isIscharger()){
					return new AjaxMsg(false,"只能存在一位班主任！");
				}
			}
			tdao.save(tch);
			return new AjaxMsg(true, "添加成功！");
		} catch (Exception e) {
			logger.warn("添加记录失败！");
			throw new BusinessException("添加记录出错！", e);
		}
		
	}


	@Override
	public AjaxMsg delDetachedTch() throws Exception {
		try {
			String sql = "select * from t_teachers where classId is null";
			List<TTeacher> list = tdao.search(TTeacher.class, sql);
			for (int i = 0; i < list.size(); i++) {
				tdao.delete(TTeacher.class, list.get(i).getId());
			}
			return new AjaxMsg(true, "清楚记录成功！");
		} catch (Exception e) {
			logger.warn("清楚记录失败！");
			throw new BusinessException("清楚记录出错！", e);
		}
	}



	@Override
	public AjaxMsg delTeacher(Integer id) throws Exception {
		try {
			tdao.delete(TTeacher.class, id);
			return new AjaxMsg(true, "删除成功！");
		} catch (Exception e) {
			logger.warn("删除记录失败！");
			throw new BusinessException("删除记录出错！", e);
		}
	}

	
	@Override
	public AjaxMsg delTeacherByNo(String teacherNo) throws Exception {
		try {
			String sql = "select * from t_teachers where teacherNo = '"+teacherNo+"'";
			List<TTeacher> tlist =tdao.search(TTeacher.class, sql);
			tdao.delete(TTeacher.class, tlist.get(0).getId());
			return new AjaxMsg(true, "删除成功！");
		} catch (Exception e) {
			logger.warn("删除记录失败！");
			throw new BusinessException("删除记录出错！", e);
		}
	}
	

	@Override
	public AjaxMsg addTeacher(TTeacher tch) throws Exception {
		try {
			if(tch.isIscharger()){
				String sql ="select * from t_teachers where classId = "+tch.getClazz().getId()+"";
				List<TTeacher> list = tdao.search(TTeacher.class, sql);
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setIscharger(false);
					tdao.update(list.get(i));
				}
			}
			tdao.save(tch);
			return new AjaxMsg(true, "添加成功！");
		} catch (Exception e) {
			logger.warn("添加记录失败！");
			throw new BusinessException("添加记录出错！", e);
		}
	}


	@Override
	public AjaxMsg updTeacher(TTeacher tch) throws Exception {
		try {
			if(tch.isIscharger()){
				String sql ="select * from t_teachers where classId = "+tch.getClazz().getId()+"";
				List<TTeacher> list = tdao.search(TTeacher.class, sql);
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setIscharger(false);
					tdao.update(list.get(i));
				}
			}
			tdao.update(tch);
			return new AjaxMsg(true,"修改成功！");
		} catch (Exception e) {
			logger.warn("修改记录失败！");
			throw new BusinessException("修改记录出错！", e);
		}
	}


	


	


	
}
