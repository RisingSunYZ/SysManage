package com.hfmx.service.book;

import com.hfmx.formmodel.FBook;
import com.hfmx.model.TBook;
import com.hfmx.utils.AjaxMsg;

public interface IBookManageService {
	/**
	 * 添加
	 * 
	 * @param f
	 */
	public AjaxMsg add(FBook f) throws Exception;

	/**
	 * 更新
	 * 
	 * @param f
	 */
	public AjaxMsg update(FBook f) throws Exception;

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public AjaxMsg delete(String ids) throws Exception;

	/**
	 * 获取实体类
	 * 
	 * @param id
	 * @return
	 */
	public TBook find(int id) throws Exception;

	/**
	 * 获取fmodel
	 * 
	 * @param id
	 * @return
	 */
	public FBook findForm(int id) throws Exception;
}
