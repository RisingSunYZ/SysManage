package com.hfmx.dao.file.impl;

import org.springframework.stereotype.Repository;

import com.hfmx.dao.base.impl.BaseDaoImpl;
import com.hfmx.dao.file.IFileDao;
import com.hfmx.model.TFile;

@Repository("fileDao")
public class FileDaoImpl extends BaseDaoImpl<TFile, String> implements IFileDao {

}
