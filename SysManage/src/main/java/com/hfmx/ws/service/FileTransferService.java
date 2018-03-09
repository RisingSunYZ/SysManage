package com.hfmx.ws.service;

import javax.jws.WebService;

import com.hfmx.ws.service.model.MyFile;

@WebService
public interface FileTransferService {
	
	public void uploadFile(MyFile file);
	
	public MyFile downloadFile(MyFile file);
}
