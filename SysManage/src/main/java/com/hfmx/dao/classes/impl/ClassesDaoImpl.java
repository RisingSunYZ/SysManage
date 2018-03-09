package com.hfmx.dao.classes.impl;

import org.springframework.stereotype.Repository;

import com.hfmx.dao.base.impl.BaseDaoImpl;
import com.hfmx.dao.classes.IClassesDao;
import com.hfmx.model.TClasses;

@Repository("classesDao")
public class ClassesDaoImpl extends BaseDaoImpl<TClasses, Integer> implements IClassesDao{

}
