package com.hfmx.service.classes.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hfmx.dao.classes.IClassesDao;
import com.hfmx.dao.teacher.ITeacherDao;
import com.hfmx.model.TClasses;
import com.hfmx.model.TTeacher;
import com.hfmx.service.classes.IClassesSearchService;
import com.hfmx.utils.AjaxMsg;
import com.hfmx.utils.DataGrid;
import com.hfmx.utils.PageInfo;
import com.hfmx.utils.exception.BusinessException;


@Service("classesSearch")
@Transactional
public class ClassesSearchServiceImpl implements IClassesSearchService{

	@Resource(name = "classesDao")
	private IClassesDao cdao;
	@Resource(name = "teacherDao")
	private ITeacherDao tdao;

	public List<TClasses> searchBySQL(String sql) throws Exception {
		try {
			return cdao.search(TClasses.class, sql);
		} catch (Exception e) {
			throw new BusinessException("获取数据出现错误！", e);
		}
	}

	@Override
	public DataGrid<Map<String, Object>> getTeacherData(PageInfo page, Integer classId) throws Exception {
		try {
			StringBuffer buffer_data;
			StringBuffer buffer_count;
			if(classId==null)
			{
				buffer_data = new StringBuffer("select * from t_teachers as t where classId is null");
				buffer_count = new StringBuffer("select count(*) from t_teachers as t where classId is null");
			}else{
				buffer_data = new StringBuffer("select * from t_teachers as t where classId =" + classId);
				buffer_count = new StringBuffer("select count(*) from t_teachers as t where classId=" + classId);
			}
			buffer_data.append(page.getSortString());
			int[] fm = page.getFirstindexAndMaxresult();
			long total = tdao.count(buffer_count.toString());// 记录总数量
			List<Map<String, Object>> list = tdao.searchForMap(buffer_data.toString(),fm[0],fm[1]);
			return new DataGrid<Map<String, Object>>(total, list);
		} catch (Exception e) {
			throw new BusinessException("获取教师信息出现错误！", e);
		}
	}
	
	
	@Override
	public DataGrid<Map<String, Object>> getlist(PageInfo page, String modelids)
			throws Exception {
		try {
			String wherestring = " 1 = 1 ";
			StringBuffer buffer_data = new StringBuffer("select c.* ,t.teacherName from t_classes c left JOIN (select * FROM t_teachers where ischarger = TRUE )t on c.id = t.classId where" + wherestring);
			StringBuffer buffer_count = new StringBuffer("select count(*) from t_classes as c where" + wherestring);
			//查询条件
			String searchString = page.getSearchString();
			if(StringUtils.isNotBlank(searchString)){
				buffer_data.append(" and "+searchString);
				buffer_count.append(" and " + searchString);
			}
			buffer_data.append(page.getSortString());
			int[] fm = page.getFirstindexAndMaxresult();
			long total = cdao.count(buffer_count.toString());// 记录总数量
			List<Map<String, Object>> list = cdao.searchForMap(buffer_data.toString(), fm[0], fm[1]);
			return new DataGrid<Map<String, Object>>(total, list);
		} catch (Exception e) {
			throw new BusinessException("获取分页数据出现错误！", e);
		}
	}

	@Override
	public TClasses searchModel(int id) throws Exception {
		try {
			return cdao.find(TClasses.class, id);
		} catch (Exception e) {
			throw new BusinessException("获取数据出现错误！", e);
		}
	}

	
	@Override
	public AjaxMsg testClassName(String name) throws Exception {
		try {
			String sql = "select * from t_classes where className='"+name+"'";
			List<TClasses> clist = cdao.search(TClasses.class, sql);
			if(clist.size()==0)
				return new AjaxMsg(true, "班级名称可用");
			else
				return new AjaxMsg(false,"班级名称不可用");
		} catch (Exception e) {
			throw new BusinessException("获取数据出现错误！", e);
		}
	}
	
	@Override
	public AjaxMsg testTeacherNo(String id) throws Exception {
		try {
			String sql = "select * from t_teachers where teacherNo='"+id+"'";
			List<TTeacher> tlist = tdao.search(TTeacher.class, sql);
			if(tlist.size()==0)
				return new AjaxMsg(true, "教师编号可用");
			else
				return new AjaxMsg(false,"教师编号不可用");
		} catch (Exception e) {
			throw new BusinessException("获取数据出现错误！", e);
		}
	}
	
}
