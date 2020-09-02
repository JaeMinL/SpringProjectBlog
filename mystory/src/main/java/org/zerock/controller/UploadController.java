package org.zerock.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.UploadFileDTO;
import org.zerock.service.UploadImageService;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.jpeg.JpegDirectory;

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
		
		//List<UploadFileDTO> list = new ArrayList<>();
		 
		String uploadPath = "/Users/jamm/tmp/pictures";
		
		for(MultipartFile multipartFile : uploadImage) {
			log.info("--------------------------------------------------");
			log.info("Upload Image Name: " + multipartFile.getOriginalFilename());
			log.info("Upload Image Size: " + multipartFile.getSize());
 			
			//UploadFileDTO dto = new UploadFileDTO();
			
			File saveFile;
			//make folder
			File tmp = new File(uploadPath, multipartFile.getOriginalFilename());
			
			try{
				multipartFile.transferTo(tmp);
				
				//make folder
				uploadPath = getFolder(uploadPath, tmp);
				log.info("upload file to "+ uploadPath + "/.........");
				
				//convert type to JPEG
				saveFile = uploadImageService.toJpeg(multipartFile, uploadPath, tmp);
				log.info("Type to JPEG......");
			
				//save image to the folder
				multipartFile.transferTo(saveFile);
				
				
				//Date date = uploadImageService.insertdb(saveFile);
				uploadImageService.insertdb(saveFile);
				log.info("Insert Data in DB Successfully.......");
				
			
//				dto.setFl_nm(multipartFile.getOriginalFilename());
//				dto.setTaken_dt(date);
//				list.add(dto);

				// 메타데이터 출력 
//				for(Directory dir: metadata.getDirectories()) {
//					for(Tag tag : dir.getTags()) {
//						if(tag.getTagName().equals("User Comment")) continue;
//						System.out.print("[");
//						System.out.print(tag.getDirectoryName());
//						System.out.print("]");
//						System.out.print(tag.getTagName());
//						System.out.print("-");
//						System.out.println(tag.getDescription());
//					}
//					for(String error : dir.getErrors()) {
//						System.err.println("ERROR: " + error);
//					}
//				}
				
				tmp.delete();
			} catch(Exception e) {
				tmp.delete();
				log.error(e.getMessage());
			}//end catch
		} //end for
		//return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	private String getFolder(String path, File saveFile) {
		String uploadPath = path;
		File uploadFolder;
		
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(saveFile);
			
			ExifSubIFDDirectory e = null;
			if( (e = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class)) != null){
				Calendar cal = new GregorianCalendar();
	            Date originalDate = e.getDateOriginal();
	            cal.setTime(originalDate);
	            
	            int year = cal.get(Calendar.YEAR);
	            int month = cal.get(Calendar.MONTH)+1;
	            uploadPath = uploadPath + "/" + year + "/" + month;
			}
			else { //maybe screenshot
				uploadPath =uploadPath + "/etc";
				System.out.println("uploadPath/etc ?????: "+ uploadPath );
			}
			//디렉토리 생성 
            uploadFolder = new File(uploadPath);
            if(uploadFolder.exists() == false) {
            	uploadFolder.mkdirs();
            }
			
 
            //log.info(originalDate.toString());	
			
		} catch (ImageProcessingException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		
		return uploadPath;
		
	}
	
}
