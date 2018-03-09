package com.hfmx.service.classes.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hfmx.dao.academy.IAcademyDao;
import com.hfmx.dao.major.IMajorDao;
import com.hfmx.model.TAcademy;
import com.hfmx.model.TMajor;
import com.hfmx.service.classes.IMajorService;

@Service("majorService")
@Transactional
public class MajorService implements IMajorService {
	
	@Resource(name ="academyDao")
	private IAcademyDao adao;
	@Resource(name = "majorDao")
	private IMajorDao mdao;
	
	
	
	@Override
	public List<TAcademy> findAca() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from academy";
		return adao.search(TAcademy.class, sql);
	}
	@Override
	public List<TMajor> findMaj(String id) throws Exception {
		String sql = "select * from major where aid = '"+id+"'";
		return mdao.search(TMajor.class, sql);
	}
	@Override
	public List<TMajor> findMajByName(String name) throws Exception {
		String sql = "select * from major where aid = (select aid from academy where aname = '"+name+"')";
		return mdao.search(TMajor.class, sql);
	}
	
}
