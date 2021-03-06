package com.spov.hellodocent.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spov.hellodocent.domain.LoginSessionDTO;
import com.spov.hellodocent.services.BlogService;
import com.spov.hellodocent.services.CommentaryService;

@Controller
@RequestMapping("/content")
public class ContentsController {

	@Inject
	BlogService blogService;
	
	@Inject
	CommentaryService comService;
	
	
	
	@RequestMapping("/getDocentContent")
	public String getDocentContent(HttpSession session, Model model) {
		
	LoginSessionDTO userVO = (LoginSessionDTO)session.getAttribute("userVO");
		
	
	if(userVO.getUser_isDocent().equals("docent")){
		
		List<Map<String, String>> blogs = blogService.getMyBlog(userVO.getUser_iuid(),1);
		List<Map<String, String>> coms = comService.getMyCommentary(userVO.getUser_iuid(),1);
		model.addAttribute("blog", blogs);
		model.addAttribute("commentary", coms);
		return "content/getDocentContents";
		
	}
		
	return "redirect:/";
		
		
		
	}
	
	
	
}
