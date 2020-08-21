package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.UserVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/alog/*")
@Log4j
public class AlogController{

//	public UserModel hostInfo() {
//		UserModel host = UserModel.builder()
//				.introduct("소개 솰랴살라")
//				.name("LeeJam")
//				.instaID("jaemin_zammm")
//				.email("email@gmail.com")
//				.phoneNo("010-0000-0000")
//				.build();
//		return host;
//	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String basic(Model model) {
		//model.addAttribute("host", hostInfo());
		//UserModel host = new UserModel();
//		//UserModel host = new UserModel("소개 솰랴살라", "LeeJam", "jaemin_zammm", ("010-0000-0000", "email@gmail.com");
//		
//		host.setIntroduct("소개 솰랴살라");
//		host.setName("LeeJam");
//		host.setInstaID("jaemin_zammm");
//		host.setPhoneNo("010-0000-0000");
//		host.setEmail("email@gmail.com");
//
//		model.addAttribute("host", host);
		model.addAttribute("serverTime", "kkkk");
		//model.addAttribute("intro", host.getIntroduct());
		

		log.info("First Page_(Home)");
		
		return "album";
	}
//	public ModelAndView basic() {
//		ModelAndView model = new ModelAndView("/home");
//		//UserModel host = new hostInfo();
//		model.addObject(hostInfo());
//		
//		return model;
//	}
	
	
	@GetMapping("/album")
	public String album() {
		return "album";
	}

}