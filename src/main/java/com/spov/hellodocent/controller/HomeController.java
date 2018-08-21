package com.spov.hellodocent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spov.hellodocent.domain.LoginSessionDTO;
import com.spov.hellodocent.domain.MuseumEventDTO;
import com.spov.hellodocent.services.MuseumService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MuseumService museumService;

	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Model model, HttpSession session) {

		List<MuseumEventDTO> events = new ArrayList<MuseumEventDTO>();
		LoginSessionDTO dto = (LoginSessionDTO)session.getAttribute("userVO");
		
		if(dto!=null) {
		
			logger.info("환영합니다 고객님" + dto.getUser_iuid());
			
		}else {
			
			logger.info("세션 정보 없음");
		}
		
		events = museumService.getMuseumEvents();
		model.addAttribute("events", events);
		
		
		return "member/home";
	}


	

	

}
