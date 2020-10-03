package org.zerock.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zerock.service.AlbumService;
import org.zerock.service.PicsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.UserVO;
import org.zerock.domain.AlbumVO;
import org.zerock.domain.PicsVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private AlbumService albumService;
	private PicsService picsService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public String home(Model model) {
		log.info("home........");
		
		UserVO host = new UserVO();
		
		model.addAttribute("host", host);
		//model.addAttribute("host", "host");
		model.addAttribute("ymlist", albumService.getYMList());
		model.addAttribute("list", albumService.getList());
		
		HashMap<Date, Integer> cntPics = picsService.cntPics();

		model.addAttribute("cntPicsHash", cntPics);
		
		return "home";
	}
	
	@RequestMapping(value="/daily" , method = RequestMethod.GET)
	public String daily(String date, Model model) {
		log.info("daily........");
//		System.out.println(date);
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyMMdd");
		Date taken_dt;
		List<PicsVO> pics_list = null;
		AlbumVO thumbnail;
		
		try {
			taken_dt = fmt.parse(date);
			
			thumbnail = albumService.read(taken_dt);
			pics_list = picsService.get(taken_dt);
			
//			PicsVO pics = picsService.get(thumbnail.getFl_nm());
//			pics_list.remove(pics);
			
			model.addAttribute("list", pics_list);
//			System.out.println(pics_list);
			model.addAttribute("mainPic", thumbnail);
			
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		
		return "daily";
	}
	

}
