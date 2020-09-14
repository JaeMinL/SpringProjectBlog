package org.zerock.service;

import java.io.File;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImageService {
	
	public File toJpeg(MultipartFile multipartFile, String uploadPath, File tmpOriginFile);
	
	public Date insertdb(File imageFile);
	
	public void updatedb(File newImg, Date taken_dt);
}
