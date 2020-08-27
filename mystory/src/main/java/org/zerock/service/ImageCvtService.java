package org.zerock.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface ImageCvtService{
	
	public File toJpeg(MultipartFile multipartFile, String uploadPath);
	
}
