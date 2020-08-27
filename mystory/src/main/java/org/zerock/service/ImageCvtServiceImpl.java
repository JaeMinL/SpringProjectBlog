package org.zerock.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ImageCvtServiceImpl implements ImageCvtService{
	
	public File toJpeg(MultipartFile multipartFile, String uploadPath) {
		
		log.info("Image Type Check.........");
		
		String filename = multipartFile.getOriginalFilename();
		
		int pos = filename.lastIndexOf(".");
		String OnlyImageName = pos > 0 ? filename.substring(0, pos) : filename;

		
		if(multipartFile.getContentType().toLowerCase().contains("jpeg")){
			return new File(uploadPath, filename);
		}
		else if (multipartFile.getContentType().toLowerCase().contains("jpg")) { //Convert Image jpg to JPEG
			return new File(uploadPath, OnlyImageName+".jpeg");
		}
		else {					//Convert Image PNG to JPEG
			BufferedImage bufferedImage;
			File saveFile;
			File inputFile;
			try{
				inputFile = new File(uploadPath, filename);
				multipartFile.transferTo(inputFile);
				
				bufferedImage = ImageIO.read(inputFile);

				BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), 
						bufferedImage.getHeight(), 
						BufferedImage.TYPE_INT_RGB);
				newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
				saveFile = new File(uploadPath, OnlyImageName +".jpeg");
				
				ImageIO.write(newBufferedImage, "jpeg", saveFile);
				
				inputFile.delete();
				
				return saveFile;
				
			} catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		return null;
	}
}
