package com.hfmx.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "book")
public class TBook {
	private int id;
	private String code;
	private String name;
	private TBookModel model;
	private String weight;
	private float baseprice = 0f;
	private float marketprice = 0f;
	private float sellprice = 0f;
	private int sellcount = 0;
	private int clickcount = 0;
	private boolean visible = true;
	private Date createdate = new Date();
	private String description;
	private String note;
	private List<TBookReader> readers;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getSellcount() {
		return sellcount;
	}

	public void setSellcount(int sellcount) {
		this.sellcount = sellcount;
	}

	public int getClickcount() {
		return clickcount;
	}

	public void setClickcount(int clickcount) {
		this.clickcount = clickcount;
	}

	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(columnDefinition="text")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "model")
	public TBookModel getModel() {
		return model;
	}

	public void setModel(TBookModel model) {
		this.model = model;
	}

	@OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
	public List<TBookReader> getReaders() {
		return readers;
	}

	public void setReaders(List<TBookReader> readers) {
		this.readers = readers;
	}
}
