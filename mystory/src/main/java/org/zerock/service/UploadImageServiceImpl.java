package org.zerock.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AlbumVO;
import org.zerock.domain.PicsVO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;


@Log4j
@Service
@AllArgsConstructor
public class UploadImageServiceImpl implements UploadImageService{
	private PicsService picsService;
	private AlbumService albumService;

	private static int thumb_w = 100;
	private static int thumb_h = 100;
	
	public File toJpeg(MultipartFile multipartFile, String uploadPath, File tmpOriginFile) {
		log.info("Image Type Check.........");
		
		String filename = multipartFile.getOriginalFilename();
		File imageFile;
		
		//to make unique file name
		UUID uuid = UUID.randomUUID();
		
		int pos = filename.lastIndexOf(".");
		String OnlyImageName = pos > 0 ? filename.substring(0, pos) : filename;

		try {
			if(multipartFile.getContentType().toLowerCase().contains("jpeg")){
				imageFile = new File(uploadPath, uuid.toString() + "_" + filename);
				return imageFile;
			}
			else if (multipartFile.getContentType().toLowerCase().contains("jpg")) { //Convert Image jpg to JPEG
				imageFile =  new File(uploadPath, uuid.toString() + "_" + OnlyImageName+".jpeg");
				return imageFile;
			}
			else {					//Convert Image PNG to JPEG
				BufferedImage bufferedImage;
				
				bufferedImage = ImageIO.read(tmpOriginFile);
	
				BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), 
						bufferedImage.getHeight(), 
						BufferedImage.TYPE_INT_RGB);
				newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
				
				imageFile = new File(uploadPath, uuid.toString() + "_" + OnlyImageName +".jpeg");
			
				ImageIO.write(newBufferedImage, "jpeg", imageFile);
				
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
	
	public Date insertdb(File imageFile){
		PicsVO picsVO = new PicsVO();
		AlbumVO  albumVO = new AlbumVO();
		
		
		log.info("Insert In DB.......");
		Double gpsLA = null;
		Double gpsLO = null;
		Date taken_dt = null;
		
		try {
        	Metadata metadata = ImageMetadataReader.readMetadata(imageFile);
       
            ExifSubIFDDirectory e = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            
            if (e != null){
            	//set taken_dt
	            taken_dt = e.getDateOriginal();
	            Calendar cal = Calendar.getInstance();  
	            cal.setTime(taken_dt);  
	            cal.set(Calendar.HOUR_OF_DAY, 0);  
	            cal.set(Calendar.MINUTE, 0);  
	            cal.set(Calendar.SECOND, 0);  
	            cal.set(Calendar.MILLISECOND, 0);
	            taken_dt = cal.getTime();
	            picsVO.setTaken_dt(taken_dt);
	            albumVO.setTaken_dt(taken_dt);
	            //System.out.println("Upload Image Taken Date: " + taken_dt);
	            
	            System.out.println("Upload Image Taken Date: " + taken_dt); //Sun Aug 16 00:00:00 KST 2020
	          
	            }else { //maybe screenshot :  no meta data of SubIFDDirectory
	            ;}

            
//            ExifThumbnailDirectory thumb_directory = metadata.getFirstDirectoryOfType(ExifThumbnailDirectory.class);
//            System.out.println(thumb_directory.getName());
            //섬네일 처리???
            
            FileOutputStream thumbnail = new FileOutputStream(new File(imageFile.getParent(), "s_"+imageFile.getName()));
            Thumbnailator.createThumbnail((InputStream)new FileInputStream(imageFile.getAbsolutePath()), thumbnail, thumb_w, thumb_h);
            thumbnail.close();
           
            //set Double gps_la, gps_lo 
            Collection <GpsDirectory> gpsDirectories = metadata.getDirectoriesOfType(GpsDirectory.class);
            for (GpsDirectory gpsDirectory : gpsDirectories) {
            	GeoLocation geoLocation = gpsDirectory.getGeoLocation();
            	
            	if(geoLocation != null && !geoLocation.isZero()) {
            		gpsLA = geoLocation.getLatitude();
            		gpsLO = geoLocation.getLongitude();
            		picsVO.setGps_la(gpsLA);
                    picsVO.setGps_lo(gpsLO);
            		log.info("Upload Image GPS: " + gpsLA + ", " + gpsLO);
            	} else {log.info("Upload Image GPS is null ");}
            }
            picsVO.setFl_nm(imageFile.getName());
            	
        	// Make object of PicsVO
            picsService.register(picsVO);
                
            //Make object of AlbumVO
            if(taken_dt != null && !albumService.isDate(taken_dt)) {
            	albumVO.setFl_nm(imageFile.getName());
            	albumService.register(albumVO);
            }
            
            return taken_dt;
        } catch (ImageProcessingException e) {
        	log.error(e.getMessage());
        	//return null;
        	return null;
        } catch (IOException e) {
        	log.error(e.getMessage());
        	//return null;
        	return null;
        } 
	}
	
	public void updatedb(File newImg, Date taken_dt) {
		//pics에 파일 ㅣ읆으로 찾아서 업데이트
		PicsVO newPics = new PicsVO();
		newPics.setFl_nm(newImg.getName());
		newPics.setTaken_dt(taken_dt);
		
		picsService.updatePics(newPics);
		
		//album에 해당 날짜 존재하는지 확인 없ㅇ면 추가 
		if(!albumService.isDate(taken_dt)) { //add new AlbumVO
			AlbumVO newAlbum = new AlbumVO();
			newAlbum.setFl_nm(newImg.getName());
			newAlbum.setTaken_dt(taken_dt);
			albumService.register(newAlbum);
		}
	}
}
