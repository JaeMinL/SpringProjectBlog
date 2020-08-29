package org.zerock.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import org.zerock.service.UploadImageService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class UploadController {
	
	private UploadImageService uploadImageService;
	
	@GetMapping("/upload")
	public void upload(Model model) {
		
		log.info("upload page......");
	}
	
	@PostMapping("/uploadAction")
	public void uploadAjaxPost(MultipartFile[] uploadImage) {
		log.info("update ajax post.......");
		
		//String uploadPath = "/Users/jamm/git/SpringProjectBlog/mystory/src/main/webapp/resources/imageDB";
		String uploadPath = "/Users/jamm/tmp/pictures";
		
		for(MultipartFile multipartFile : uploadImage) {		
			log.info("--------------------------------------------------");
			log.info("Upload Image Name: " + multipartFile.getOriginalFilename());
			log.info("Upload Image Size: " + multipartFile.getSize());
			
			File saveFile = null;
			//Image Type Convert to JPEG
			try{
				saveFile = uploadImageService.toJpeg(multipartFile, uploadPath);
				
				multipartFile.transferTo(saveFile);
				
				uploadImageService.insertdb(saveFile);
				
			} catch(Exception e) {
				log.error(e.getMessage());
			}//end catch
		} //end for
		
	}
	
}
