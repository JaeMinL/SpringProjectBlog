package org.zerock.controller;

import java.text.DateFormat;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.zerock.domain.AlbumVO;
import org.zerock.service.AlbumService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.zerock.domain.UserVO;

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
	private AlbumService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public String home(Model model) {
		log.info("home........");
		
		UserVO host = new UserVO();
		
		model.addAttribute("host", host);
		//model.addAttribute("host", "host");
		model.addAttribute("ymlist", service.getYMList());
		model.addAttribute("list", service.getList());
		
		return "home";
	}

}
