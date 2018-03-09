package com.hfmx.dao.academy.imp;

import org.springframework.stereotype.Repository;

import com.hfmx.dao.academy.IAcademyDao;
import com.hfmx.dao.base.impl.BaseDaoImpl;
import com.hfmx.model.TAcademy;
@Repository("academyDao")
public class AcademyDaoImp extends BaseDaoImpl<TAcademy, String> implements IAcademyDao{

}
