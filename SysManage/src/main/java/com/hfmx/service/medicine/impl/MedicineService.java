package com.hfmx.service.medicine.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hfmx.dao.medicine.IMedicineDao;
import com.hfmx.model.TMedicine;
import com.hfmx.service.medicine.IMedicineService;
import com.hfmx.utils.DataGrid;
import com.hfmx.utils.PageInfo;
import com.hfmx.utils.exception.BusinessException;

@Component("medicineService")
@Transactional
public class MedicineService implements IMedicineService {

	@Resource(name="medicineDaoImpl")
	private IMedicineDao dao;
	
	private static Logger logger=Logger.getLogger(MedicineService.class);
	
	@Override
	public List<TMedicine> searchBySQL(String sql) throws Exception {
		try {
			return dao.search(TMedicine.class, sql);
		} catch (Exception e) {
			throw new BusinessException("获取数据出现错误！");
		}
	}

	@Override
	public DataGrid getlist(PageInfo page) throws Exception {
		try {
			StringBuffer buffer_data = new StringBuffer(
					"select * from medicine as b where 1=1 ");
			StringBuffer buffer_count = new StringBuffer("select count(*) from medicine as b where 1=1 ");
			// 修改字段名
			//page = this.modifyField(page);
			// 查询条件
			String searchString = page.getSearchString();
			if (StringUtils.isNotBlank(searchString)) {
				buffer_data.append(" and " + searchString);
				buffer_count.append(" and " + searchString);
			}
			// 排序语句
			buffer_data.append(page.getSortString());
			int[] fm = page.getFirstindexAndMaxresult();
			long total = dao.count(buffer_count.toString());// 记录总数量
			List<Map<String, Object>> list = dao.searchForMap(buffer_data.toString(), fm[0], fm[1]);
			return new DataGrid(total, list);
		} catch (Exception e) {
			logger.error(e.getMessage()+""
					+ "\n"+e.getStackTrace());
			throw new BusinessException("获取分页数据出现错误！");
		}
	}

}