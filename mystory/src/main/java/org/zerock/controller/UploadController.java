package org.zerock.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class UploadController {
	
	private UploadImageService uploadImageService;
	
	private static String basePath = "/Users/jamm/tmp/pictures";
	
	@GetMapping("/upload")
	public void upload(Model model) {
		
		log.info("upload page......");
	}
	
	@PostMapping(value = "/uploadAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<UploadFileDTO>> uploadAjaxPost(MultipartFile[] uploadImage) {
		log.info("update ajax post.......");
		
		List<UploadFileDTO> list = new ArrayList<>();
		
		for(MultipartFile multipartFile : uploadImage) {
			log.info("--------------------------------------------------");
			log.info("Upload Image Name: " + multipartFile.getOriginalFilename());
			log.info("Upload Image Size: " + multipartFile.getSize());
 			
			UploadFileDTO uploadFileDTO = new UploadFileDTO();
			
			File saveFile;
			//make folder
			File tmp = new File(basePath, multipartFile.getOriginalFilename());
			
			try{
				multipartFile.transferTo(tmp);
				
				//make folder
				String uploadPath = getFolder(tmp);
				log.info("upload file to "+ uploadPath + "/.........");
				//convert type to JPEG
				saveFile = uploadImageService.toJpeg(multipartFile, uploadPath, tmp);
				log.info("Type to JPEG......");
				//save image to the folder
				multipartFile.transferTo(saveFile);
				
				
				//Date date = uploadImageService.insertdb(saveFile);
				Date taken_dt = uploadImageService.insertdb(saveFile);
				log.info("Insert Data in DB Successfully.......");
				
				uploadFileDTO.setFl_nm(saveFile.getName());
				if(taken_dt != null) uploadFileDTO.setTaken_dt(taken_dt);
//				System.out.println(uploadFileDTO.getTaken_dt().toString());
				list.add(uploadFileDTO);
				
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
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	private String getFolder(File saveFile) {
		String uploadPath = basePath;
		File uploadFolder;
		
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(saveFile);
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
//
			
			ExifSubIFDDirectory e = null;
			if( (e = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class)) != null
					&& e.getDateOriginal() != null){
				uploadPath = getSavePath(e.getDateOriginal());
			}
			else { //maybe screenshot
				uploadPath = basePath + "/etc";
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

	private String getSavePath(Date date) {
		Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
		
		return basePath + "/" + year + "/" + month;
	}
	
	private String thumbnailPath(String path){
		return "s_"+ path;
	}
	
	@PostMapping("/updateAction")
	@ResponseBody
	public ResponseEntity<String> updateDate(String newTakenDt, String thumbnailPath) {
		log.info("UpdateAction.........");
		String destPath;
		File updatePath; 
		Date taken_dt;
		//System.out.println(imgPath);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			taken_dt = fmt.parse(newTakenDt);
			destPath = getSavePath(taken_dt);
			//목적지 폴더 생성해서 옮기기
			updatePath = new File(destPath);
	        if(updatePath.exists() == false) {
	        	updatePath.mkdirs();
	        }
			
			File from_thumb = new File("/Users/jamm/tmp/"+thumbnailPath);
			String originImg = from_thumb.getPath().replace("s_", "");
			File from_origin = new File(originImg);
	        
	        System.out.println(thumbnailPath+"------------------------");
			
	        File to_origin = new File(destPath +"/"+ from_origin.getName());
	        File to_thumb = new File(destPath +"/"+ from_thumb.getName());
	        
	        System.out.println(from_origin.getPath() +"---->"+ to_origin.getPath());
	        System.out.println(from_thumb.getPath() +"---->"+ to_thumb.getPath());
	        
	        java.nio.file.Files.move(from_origin.toPath(), to_origin.toPath());
	        java.nio.file.Files.move(from_thumb.toPath(), to_thumb.toPath());

	        uploadImageService.updatedb(to_origin, taken_dt);
	        
	        from_origin.delete();
	        from_thumb.delete();
			
		} catch (ParseException e) {log.info(e.getMessage()); 
		} catch (IOException e) {log.info(e.getMessage());
		}

		
		//원본 삭제 섬네일도!!! 
		//db수
		return new ResponseEntity<String>("Updated", HttpStatus.OK);
	}	
	


}
