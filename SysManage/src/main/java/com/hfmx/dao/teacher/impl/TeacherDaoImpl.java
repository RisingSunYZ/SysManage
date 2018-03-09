package com.hfmx.dao.teacher.impl;

import org.springframework.stereotype.Repository;

import com.hfmx.dao.base.impl.BaseDaoImpl;
import com.hfmx.dao.teacher.ITeacherDao;
import com.hfmx.model.TTeacher;

@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDaoImpl<TTeacher, Integer> implements ITeacherDao{

}
