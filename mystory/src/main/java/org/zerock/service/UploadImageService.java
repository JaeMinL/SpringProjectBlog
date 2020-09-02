package org.zerock.service;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.Pair;

public interface UploadImageService {
	
	public File toJpeg(MultipartFile multipartFile, String uploadPath, File tmpOriginFile);
	
	public boolean insertdb(File imageFile);
}
