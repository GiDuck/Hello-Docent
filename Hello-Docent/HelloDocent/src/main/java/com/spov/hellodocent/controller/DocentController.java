package com.spov.hellodocent.controller;

import java.net.URLDecoder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spov.hellodocent.domain.DocentInfoDTO;
import com.spov.hellodocent.domain.LoginSessionDTO;
import com.spov.hellodocent.encrypto.EncryptoDocentInfo;
import com.spov.hellodocent.encrypto.EncryptoString;
import com.spov.hellodocent.services.DocentService;
import com.spov.hellodocent.services.ManagerService;

@Controller
@RequestMapping("/docent")
public class DocentController {

	
	@Autowired
	private DocentService docentService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private EncryptoDocentInfo encryptoDocentInfo;
	
	@Autowired
	private EncryptoString encryptoString;
	
	@RequestMapping(value="/getDocentInfoView", method=RequestMethod.GET)
	public String getDocentInfoView(Model model, HttpSession session) {
		
		String id = ((LoginSessionDTO)session.getAttribute("userVO")).getUser_iuid();
		DocentInfoDTO dto = docentService.getDocentInfo(id);
		
		
		model.addAttribute("info", encryptoDocentInfo.Decrypto(dto));
		

		return "docent/docentInfo";
	}
	
	
	
	@RequestMapping(value="/updateDocentInfo", method=RequestMethod.POST)
	public String updateDocentInfo(@ModelAttribute DocentInfoDTO dto) {
		
		
		docentService.docentInfoUpdate((DocentInfoDTO)encryptoDocentInfo.Encrypto(dto));

		
		return "redirect:/docent/getDocentInfoView";
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getDocentInfoData", method=RequestMethod.GET)
	public DocentInfoDTO getDocentInfoData(@RequestParam("id") String id, Model model) throws Exception {
		
		DocentInfoDTO dto = docentService.getDocentInfo(URLDecoder.decode(id, "utf-8"));

		return (DocentInfoDTO)encryptoDocentInfo.Decrypto(dto);
	}
	
	
}
