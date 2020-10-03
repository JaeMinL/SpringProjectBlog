package org.zerock.controller;

import org.zerock.domain.AmapDTO;
import org.zerock.domain.PicsVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import lombok.AllArgsConstructor; 
import lombok.extern.log4j.Log4j;

import org.zerock.service.*;

@Controller
@Log4j
@AllArgsConstructor
public class AmapController {
	
	private PicsService picsService;
	
	@RequestMapping("/amap")
	public String amap(Model model) {
		log.info("/amap......");
		Calendar cal = new GregorianCalendar();
		List<PicsVO> picsList = picsService.getGpsInfo();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		for(int i=0; i<picsList.size(); i++){
	        cal.setTime(picsList.get(i).getTaken_dt());
	        int year = cal.get(Calendar.YEAR);
	        int month = cal.get(Calendar.MONTH)+1;
	        int dday = cal.get(Calendar.DATE);
			hashMap.put(picsList.get(i).getFl_nm() , ""+year+"년 "+month+"월 "+dday+"일");
		}
		
		model.addAttribute("hashMap", hashMap);
		model.addAttribute("list", picsList);
		
		return "amap";
	}

}
