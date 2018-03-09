package com.hfmx.ws.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import javax.jws.WebService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.hfmx.ws.service.FileTransferService;
import com.hfmx.ws.service.model.MyFile;

@WebService(endpointInterface = "com.hfmx.ws.service.FileTransferService", serviceName = "fileTransferServiceImpl")
public class FileTransferServiceImpl implements FileTransferService {

	@Override
	public void uploadFile(MyFile file) {
		OutputStream os = null;
		try {
			if (file.getPosition() != 0) {
				os = FileUtils.openOutputStream(new File(file.getServerFile()),
						true);
			} else {
				os = FileUtils.openOutputStream(new File(file.getClientFile()),
						false);
			}
			os.write(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(os);
		}
	}

	@Override
	public MyFile downloadFile(MyFile file) {
		InputStream is = null;
		try {
			is = new FileInputStream(file.getServerFile());

			is.skip(file.getPosition());
			byte[] bytes = new byte[1024 * 1024];
			int size = is.read(bytes);
			if (size > 0) {
				byte[] fixedBytes = Arrays.copyOfRange(bytes, 0, size);
				file.setBytes(fixedBytes);
			} else {
				file.setBytes(new byte[0]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(is);
		}
		return file;
	}

}
