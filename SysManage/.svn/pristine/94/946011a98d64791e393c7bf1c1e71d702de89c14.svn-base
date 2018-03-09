package com.hfmx.formmodel;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.hfmx.model.TBook;
import com.hfmx.model.TBookModel;
import com.hfmx.model.TBookReader;
import com.hfmx.service.book.IBookSearchService;
import com.hfmx.utils.JsonParse;
import com.hfmx.utils.exception.BusinessException;

public class FBook {
	private String id;
	private String name;
	private String code;
	private int model;
	private String weight;
	private float baseprice;
	private float marketprice;
	private float sellprice;
	private String sellcount;
	private String clickcount;
	private boolean visible = true;
	private String createdate;
	private String description;
	private String addrows;
	private String editrows;
	private String deleterows;
	private String note;

	public FBook() {
	}

	/**
	 * 将tmodel填充到fmodel中
	 * 
	 * @param tmodel
	 */
	public FBook(TBook tmodel) {
		if (tmodel != null) {
			this.setId(String.valueOf(tmodel.getId()));
			this.setName(tmodel.getName());
			this.setCode(tmodel.getCode());
			this.setModel(tmodel.getModel().getId());
			this.setWeight(tmodel.getWeight());
			this.setBaseprice(tmodel.getBaseprice());
			this.setMarketprice(tmodel.getMarketprice());
			this.setSellprice(tmodel.getSellprice());
			this.setSellcount(String.valueOf(tmodel.getSellcount()));
			this.setClickcount(String.valueOf(tmodel.getClickcount()));
			this.setVisible(tmodel.getVisible());
			this.setCreatedate(DateFormatUtils.format(tmodel.getCreatedate(), "yyyy-MM-dd"));
			this.setDescription(tmodel.getDescription());
			this.setNote(tmodel.getNote());
		}
	}

	/**
	 * 将fmodel填充到tmodel中
	 * 
	 * @param tmodel
	 * @return
	 * @throws Exception
	 */
	public TBook fillTmodel(TBook tmodel, IBookSearchService search) throws Exception {
		if (tmodel == null)
			tmodel = new TBook();
		tmodel.setName(this.getName());
		tmodel.setCode(this.getCode());
		TBookModel model = search.searchModel(this.getModel());
		System.out.println("model:" + (model == null));
		if (model != null)
			tmodel.setModel(model);
		tmodel.setBaseprice(this.getBaseprice());
		tmodel.setMarketprice(this.getMarketprice());
		tmodel.setSellprice(this.getSellprice());
		tmodel.setWeight(this.getWeight());
		tmodel.setDescription(this.getDescription());
		tmodel.setNote(this.getNote());
		if (StringUtils.isNotBlank(this.getSellcount()))
			tmodel.setSellcount(Integer.valueOf(this.getSellcount()));
		else
			tmodel.setSellcount(0);
		if (StringUtils.isNotBlank(this.getClickcount()))
			tmodel.setClickcount(Integer.valueOf(this.getClickcount()));
		else
			tmodel.setClickcount(0);
		tmodel.setVisible(this.getVisible());
		if (StringUtils.isNotBlank(this.getCreatedate()))
			try {
				tmodel.setCreatedate(DateUtils.parseDate(this.getCreatedate(), "yyyy-MM-dd HH:mm:ss"));
			} catch (ParseException e) {
				tmodel.setCreatedate(new Date());
			}
		else
			tmodel.setCreatedate(new Date());
		return tmodel;
	}

	/**
	 * 获取前台传回来的添加行数据
	 * 
	 * @return
	 */
	public List<TBookReader> getAddRowData() throws Exception {
		List<TBookReader> adddata = new ArrayList<TBookReader>();
		if (StringUtils.isNotBlank(addrows)) {
			try {
				String addString = java.net.URLDecoder.decode(addrows, "UTF-8");
				adddata = JsonParse.getList(addString, TBookReader.class);
			} catch (UnsupportedEncodingException e) {
				throw new BusinessException("子表数据获取失败！", e);
			}
		}
		return adddata;
	}

	/**
	 * 获取前台传回来的修改行数据
	 * 
	 * @return
	 */
	public List<TBookReader> getUpdateRowData() throws Exception {
		List<TBookReader> updatedata = new ArrayList<TBookReader>();
		if (StringUtils.isNotBlank(editrows)) {
			try {
				String updateString = java.net.URLDecoder.decode(editrows, "UTF-8");
				updatedata = JsonParse.getList(updateString, TBookReader.class);
			} catch (UnsupportedEncodingException e) {
				throw new BusinessException("子表数据获取失败！", e);
			}
		}
		return updatedata;
	}

	/**
	 * 获取前台传回来的删除行的ID
	 * 
	 * @return
	 */
	public List<String> getDeleteRowData() throws Exception {
		List<String> deletedata = new ArrayList<String>();
		if (StringUtils.isNotBlank(deleterows)) {
			try {
				String deleteString = java.net.URLDecoder.decode(deleterows, "UTF-8");
				deletedata = JsonParse.getList(deleteString, String.class);
			} catch (UnsupportedEncodingException e) {
				throw new BusinessException("子表数据获取失败！", e);
			}
		}
		return deletedata;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public float getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(float baseprice) {
		this.baseprice = baseprice;
	}

	public float getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(float marketprice) {
		this.marketprice = marketprice;
	}

	public float getSellprice() {
		return sellprice;
	}

	public void setSellprice(float sellprice) {
		this.sellprice = sellprice;
	}

	public String getSellcount() {
		return sellcount;
	}

	public void setSellcount(String sellcount) {
		this.sellcount = sellcount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getClickcount() {
		return clickcount;
	}

	public void setClickcount(String clickcount) {
		this.clickcount = clickcount;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public String getAddrows() {
		return addrows;
	}

	public void setAddrows(String addrows) {
		this.addrows = addrows;
	}

	public String getEditrows() {
		return editrows;
	}

	public void setEditrows(String editrows) {
		this.editrows = editrows;
	}

	public String getDeleterows() {
		return deleterows;
	}

	public void setDeleterows(String deleterows) {
		this.deleterows = deleterows;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
