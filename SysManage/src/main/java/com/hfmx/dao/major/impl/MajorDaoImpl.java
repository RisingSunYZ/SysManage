package com.hfmx.dao.major.impl;

import org.springframework.stereotype.Repository;

import com.hfmx.dao.base.impl.BaseDaoImpl;
import com.hfmx.dao.major.IMajorDao;
import com.hfmx.model.TMajor;
@Repository("majorDao")
public class MajorDaoImpl extends BaseDaoImpl<TMajor, String> implements IMajorDao {


}
