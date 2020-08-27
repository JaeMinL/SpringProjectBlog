package org.zerock.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AlbumVO;
import org.zerock.domain.PicsVO;
import org.zerock.service.AlbumService;
import org.zerock.service.PicsService;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import org.zerock.service.ImageCvtService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class UploadController {
	
	private PicsService picService;
	private AlbumService albumService;
	
	private ImageCvtService imageCvtService;
	
	@GetMapping("/upload")
	public void upload(Model model) {
		
		log.info("upload page......");
	}
	
	@PostMapping("/uploadAction")
	public void uploadAjaxPost(MultipartFile[] uploadImage) {
		log.info("update ajax post.......");
		
		String uploadPath = "/Users/jamm/tmp/image";
		
		for(MultipartFile multipartFile : uploadImage) {		
			log.info("--------------------------------------------------");
			log.info("Upload Image Name: " + multipartFile.getOriginalFilename());
			log.info("Upload Image Size: " + multipartFile.getSize());
			
			File saveFile = null;
			//Image Type Convert to JPEG
			try{
				saveFile = imageCvtService.toJpeg(multipartFile, uploadPath);
				
				//insertdb(saveFile);
				
				multipartFile.transferTo(saveFile);
				
			} catch(Exception e) {
				log.error(e.getMessage());
			}//end catch
		} //end for
		
	}
	
	private void insertdb(File file) {
		PicsVO picsVO;
		AlbumVO  albumVO;
		
//	 	DB Insert
//		picsVO = new PicsVO();
//		albumVO = new AlbumVO();
//		Metadata metadata;
//		try {
//			metadata = ImageMetadataReader.readMetadata(file);
//			
//			for (Directory directory : metadata.getDirectories()) {
//			    for (Tag tag : directory.getTags()) {
//			        System.out.format("[%s] - %s = %s",
//			            directory.getName(), tag.getTagName(), tag.getDescription());
//			    }
//			    if (directory.hasErrors()) {
//			        for (String error : directory.getErrors()) {
//			            System.err.format("ERROR: %s", error);
//			        }
//			    }
//			}
//			picsVO.setFl_nm(multipartFile.getOriginalFilename());
//			
//			picService.register(picsVO);
			
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//			
//		}
		
		
	}

}
