package com.hfmx.service.classes;

import java.util.List;

import com.hfmx.model.TAcademy;
import com.hfmx.model.TMajor;

public interface IMajorService {

	
	
	public List<TAcademy> findAca() throws Exception;
	
	public List<TMajor> findMaj(String id) throws Exception;
	
	public List<TMajor> findMajByName(String name) throws Exception;
}
