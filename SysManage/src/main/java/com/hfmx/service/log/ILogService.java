package com.hfmx.service.log;


import com.hfmx.model.TLogOperation;

public interface ILogService {
	public boolean save(TLogOperation log);
	public long count();
}
