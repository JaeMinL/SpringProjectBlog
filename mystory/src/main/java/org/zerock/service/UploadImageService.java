package org.zerock.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImageService {
	public File toJpeg(MultipartFile multipartFile, String uploadPath);
	
	public boolean insertdb(File imageFile);
}
