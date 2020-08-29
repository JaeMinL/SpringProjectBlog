package org.zerock.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AlbumVO;
import org.zerock.domain.PicsVO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class UploadImageServiceImpl implements UploadImageService{
	private PicsService picsService;
	private AlbumService albumService;
	
	public File toJpeg(MultipartFile multipartFile, String uploadPath) {
		log.info("Image Type Check.........");
		
		String filename = multipartFile.getOriginalFilename();
		File imageFile;
		
		int pos = filename.lastIndexOf(".");
		String OnlyImageName = pos > 0 ? filename.substring(0, pos) : filename;

		try {
			if(multipartFile.getContentType().toLowerCase().contains("jpeg")){
				imageFile = new File(uploadPath, filename);
				return imageFile;
			}
			else if (multipartFile.getContentType().toLowerCase().contains("jpg")) { //Convert Image jpg to JPEG
				imageFile =  new File(uploadPath, OnlyImageName+".jpeg");
				return imageFile;
			}
			else {					//Convert Image PNG to JPEG
				BufferedImage bufferedImage;
				File inputFile;
				
				inputFile = new File(uploadPath, filename);
				
				multipartFile.transferTo(inputFile);
				
				bufferedImage = ImageIO.read(inputFile);
	
				BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), 
						bufferedImage.getHeight(), 
						BufferedImage.TYPE_INT_RGB);
				newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
				imageFile = new File(uploadPath, OnlyImageName +".jpeg");
				
				ImageIO.write(newBufferedImage, "jpeg", imageFile);
				
				inputFile.delete();
				
				return imageFile;
			}// else end
		} catch (IllegalStateException e) {
			log.info(e.getMessage());
			return null;
		} catch (IOException e) {
			log.info(e.getMessage());
			return null;
		}
	}
	
	public boolean insertdb(File imageFile){
		PicsVO picsVO = new PicsVO();
		AlbumVO  albumVO = new AlbumVO();
		
		log.info("Insert In DB.......");
		Double gpsLA = null;
		Double gpsLO = null;
		
		Calendar calendar = new GregorianCalendar();
		TimeZone timeZone = calendar.getTimeZone();
		
		try {
        	Metadata metadata = ImageMetadataReader.readMetadata(imageFile);
            
            //Taken_dt "YYYY-MM-DD"
            Directory date_directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            Date originalDate = date_directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL, timeZone);
            log.info("Upload Image Taken Date//: " + originalDate.toString()); // Sun Aug 16 12:23:04 KST 2020
            
//            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
//            log.info("Upload Image Taken Date: " + fm.format(originalDate)); //2020-08-16
//            Date taken_dt = fm.parse(fm.format(originalDate));
//            log.info("Upload Image Taken Date: " + taken_dt); //Sun Aug 16 00:00:00 KST 2020
            
//            ExifThumbnailDirectory thumb_directory = metadata.getFirstDirectoryOfType(ExifThumbnailDirectory.class);
//            System.out.println(thumb_directory.getName());
            
            //Double gps_la, gps_lo 
            Collection <GpsDirectory> gpsDirectories = metadata.getDirectoriesOfType(GpsDirectory.class);
            for (GpsDirectory gpsDirectory : gpsDirectories) {
            	GeoLocation geoLocation = gpsDirectory.getGeoLocation();
            	
            	if(geoLocation != null && !geoLocation.isZero()) {
            		gpsLA = geoLocation.getLatitude();
            		gpsLO = geoLocation.getLongitude();
            		log.info("Upload Image GPS: " + gpsLA + ", " + gpsLO);
            	} else {log.info("Upload Image GPS is null ");}
            }
            
            // Make object of PicsVO
            picsVO.setTaken_dt(originalDate);
            picsVO.setFl_nm(imageFile.getName());
            picsVO.setGps_la(gpsLA);
            picsVO.setGps_lo(gpsLO);
            picsService.register(picsVO);
            
            //Make object of AlbumVO
            //섬네일 처리???
            System.out.print("dmdmmdmmdmdmmd  "+albumService.isThumb(originalDate));
            if(!albumService.isThumb(originalDate)) {
            	albumVO.setTaken_dt(originalDate);
            	albumVO.setThumb_fl_nm(imageFile.getName());
            	albumService.register(albumVO);
            }
            //set title & text??
            //
            //
            //
            
            return true;
            
        } catch (ImageProcessingException e) {
        	log.error(e.getMessage());
        } catch (IOException e) {
        	log.error(e.getMessage());
        } 
		
		return false;
	}
}
