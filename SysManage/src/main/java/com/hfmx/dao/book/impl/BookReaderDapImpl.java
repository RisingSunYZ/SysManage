package com.hfmx.dao.book.impl;

import org.springframework.stereotype.Repository;

import com.hfmx.dao.base.impl.BaseDaoImpl;
import com.hfmx.dao.book.IBookReaderDao;
import com.hfmx.model.TBookReader;

@Repository("bookReaderDao")
public class BookReaderDapImpl extends BaseDaoImpl<TBookReader, Integer> implements IBookReaderDao {

}
