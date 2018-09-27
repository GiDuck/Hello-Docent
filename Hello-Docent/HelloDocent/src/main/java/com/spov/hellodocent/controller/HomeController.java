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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {

		List<MuseumEventDTO> events = new ArrayList<MuseumEventDTO>();
		LoginSessionDTO dto = (LoginSessionDTO)session.getAttribute("userVO");
		
		if(dto!=null) {
		
			logger.info("환영합니다 고객님" + dto.getUser_iuid());
			
		}else {
			
			logger.info("세션 정보 없음");
		}
		
		
		/*dto = new LoginSessionDTO();
		dto.setUser_isDocent("docent");
		dto.setUser_iuid("I3OJY8FCZJ2R5oiBrhIkud6rxnfmhBdVMGNtVMRjLB9n5BdFW5K/tVotBqPqK/8z");
		dto.setUser_nick("8rOj7kuOWv6i4oYnywVcmQ==");
		dto.setUser_photo("OfGKoqOiz2nO8+pTYAHZ6ilVPDRMD+lHrqj0oXABGC8AF3Jx0CA5rcvZj7geFGR0Pj41iSGymAoufFEbm0kdgvAlytXMUqKtdJnFi/jn5BViD/OXdlqIDU4gTnlMWYVzhiejzyNrhCZYDqyfB2PAvzTwiV/IsP6ySyH4PFw2T7E=");
		
		session.setAttribute("userVO", dto);
		*/
		events = museumService.getMuseumEvents();
		
		
		model.addAttribute("events", events);
		
		
		return "home/home";
	}


	

	

}
