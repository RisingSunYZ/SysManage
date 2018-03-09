package com.hfmx.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static String fileUpload(MultipartFile file,
			HttpServletRequest request, Integer id) throws IOException {
		if(!file.isEmpty()){
			String fileName=file.getOriginalFilename();
			fileName=id+fileName.substring(fileName.lastIndexOf("."));
			ServletContext sc=request.getSession().getServletContext();
			String path="image/"+id+"/head";
			String dir=sc.getRealPath(path);
			System.out.println("我是dir："+dir);
			FileUtils.writeByteArrayToFile(new File(dir,fileName), file.getBytes());
			return fileName;
		}else{
			return null;
		}
	}

	public static String fileUUID_Upload(MultipartFile file,
			HttpServletRequest request, Integer id,Integer albumid) throws IOException {
		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename(); // 得到上传时的文件名
			// 获取新的文件名
			long sysTime=System.nanoTime();
			String fname=filename.substring(filename.lastIndexOf("."));
			filename=sysTime+fname;
			ServletContext sc= request.getSession().getServletContext();
			String path= "images/"+id+"/"+albumid;
			String dir=sc.getRealPath(path);
			FileUtils.writeByteArrayToFile(new File(dir,filename), file.getBytes());			
			return filename;
		} else {
			return null;
		}
	}
	
	public static String fileUpload(MultipartFile file,
			HttpServletRequest request) throws IOException {
		if(!file.isEmpty()){
			String fileName=file.getOriginalFilename();
			fileName=UUID.randomUUID().toString().substring(0, 8)+fileName.substring(fileName.lastIndexOf("."));
			ServletContext sc=request.getSession().getServletContext();
			String path="image/";
			String dir=sc.getRealPath(path);
			FileUtils.writeByteArrayToFile(new File(dir,fileName), file.getBytes());
			return fileName;
		}else{
			return null;
		}
	}
	
	public static void fileDelete(String OldfileName,
			HttpServletRequest request) throws IOException{
		if(OldfileName.equals("")||OldfileName==null)
			return ;
		else{
			ServletContext sc=request.getSession().getServletContext();
			String path="image/";
			String dir=sc.getRealPath(path);
			File oldfile = new File(dir, OldfileName);
			oldfile.delete();
		}
		
		
	}
}

