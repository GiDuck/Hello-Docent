package com.spov.hellodocent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spov.hellodocent.domain.SearchDTO;
import com.spov.hellodocent.services.DisplayService;

@Controller
@RequestMapping("/display")
public class DisplayController {

	private static final Logger logger = LoggerFactory.getLogger(DisplayController.class);

	@Inject
	DisplayService displayService;
	
	
	@RequestMapping("/findDisplayForDocent")
	public String findDisplayForDoenct(@RequestParam("prefix") String prefix, 
			@RequestParam("suffix") String suffix,
			@RequestParam("token") String token,
			Model model) {
		
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("prefix", prefix);
		param.put("suffix", suffix);
		param.put("token", token);
		
		List<Map<String, String>> museumInfo = displayService.getMuseumInfo();
		List<Map<String, String>> displayInfo = displayService.getDisplayInfo(param);

		model.addAttribute("museumInfo",museumInfo);
		model.addAttribute("displayInfo",displayInfo);
		model.addAttribute("prefix",prefix);
		model.addAttribute("suffix", suffix);
		
		
		return "display/findDisplayForDocent";
	}
	
	
	
	@RequestMapping(value="/findDisplayForDocentByKeyword", method=RequestMethod.GET)
	public String findDisplayForDocentByKeyword(@RequestParam("keyword") String keyword, 
			@RequestParam("prefix") String prefix, @RequestParam("suffix") String suffix, Model model) {
		
		System.out.println("들어온 param : " + keyword + " " + prefix + " " + suffix);
		List<Map<String, String>> museumInfo = displayService.getMuseumInfoByKeyword(keyword);
		List<Map<String, String>> displayInfo = displayService.getDisplayInfoByKeyword(keyword, null, prefix, suffix);
		
		

		model.addAttribute("museumInfo",museumInfo);
		model.addAttribute("displayInfo",displayInfo);
		model.addAttribute("keyword", keyword);
		model.addAttribute("prefix",prefix);
		model.addAttribute("suffix", suffix);
		
		return "display/findDisplayForDocent";
	}
	
	@ResponseBody
	@RequestMapping(value="/findDisplayForDocentByKeywordJson", method= RequestMethod.POST)
	public List<Map<String, String>> findDisplayForDocentByKeyword(@RequestBody Map<String, Object> param, Model model) {
		
		System.out.println("들어온 param : " + param);

		

		List<Map<String, String>> displayInfo = displayService.getDisplayInfoByKeyword((String)param.get("keyword"), 
				(List<String>)param.get("museums"), String.valueOf(param.get("prefix")), String.valueOf(param.get("suffix")));
	
		System.out.println("out data --> " + displayInfo);
		
		return displayInfo;
	
	}
	
	
/*	@RequestMapping(value="/findDisplayByKeyword", method=RequestMethod.GET)
	public String findDisplayByKeyword(@RequestParam("keyword") String keyword, 
			@RequestParam("prefix") String prefix, @RequestParam("suffix") String suffix, Model model) {
		
		System.out.println("들어온 param : " + keyword + " " + prefix + " " + suffix);
		List<Map<String, String>> museumInfo = displayService.getMuseumInfoByKeyword(keyword);
		List<Map<String, String>> displayInfo = displayService.getDisplayInfoByKeyword(keyword, null, prefix, suffix);
		
		

		model.addAttribute("museumInfo",museumInfo);
		model.addAttribute("displayInfo",displayInfo);
		model.addAttribute("keyword", keyword);
		model.addAttribute("prefix",prefix);
		model.addAttribute("suffix", suffix);
		
		return "display/findDisplay";
	}
	*/
	
	
	@RequestMapping("/findDisplay")
	public String findDisplay(@RequestParam("prefix") String prefix, 
			@RequestParam("suffix") String suffix,
			@RequestParam("keyword") String keyword,
			Model model) {
		
		
		
		SearchDTO search = new SearchDTO();
		search.setKeyword(keyword);
		search.setPrefix(prefix);
		search.setSuffix(suffix);
		
		List<Map<String, String>> museumInfo = displayService.getMuseumInfoDefault();
		List<Map<String, String>> displayInfo = displayService.getDisplayInfoDefault(search);
		
		

		model.addAttribute("museumInfo",museumInfo);
		model.addAttribute("displayInfo",displayInfo);
		model.addAttribute("keyword", keyword);
		model.addAttribute("prefix",prefix);
		model.addAttribute("suffix", suffix);
		
		
		
		return "display/findDisplay";
		
	}
	
	
	
	
	
	
	
	@RequestMapping("/findDisplayDetail")
	public String findDisplayDetail(@RequestParam("id")String id, Model model) {
		
		
		Map<String, String> displaySimpleInfo = displayService.getDisplayInfoSimple(id);
		System.out.println("들어온 id : " + id);
		model.addAttribute("dispId", id);
		model.addAttribute("disInfo", displaySimpleInfo);
		
		return "display/findDisplayDetail";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getDisplaySimpleInfo", method=RequestMethod.GET)
	public List<Map<String ,String>> getDisplayInfo(@RequestParam("museumId") String id, Model model) {
		
		return displayService.getDisplayInfoSimpleCard(id);
		
	}
	
	
	
	
	
	
}
