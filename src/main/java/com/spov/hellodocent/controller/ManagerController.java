package com.spov.hellodocent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spov.hellodocent.domain.MemberDTO;
import com.spov.hellodocent.domain.RequestDocentDTO;
import com.spov.hellodocent.encrypto.EncryptoMember;
import com.spov.hellodocent.encrypto.EncryptoRequestDocent;
import com.spov.hellodocent.encrypto.EncryptoString;
import com.spov.hellodocent.services.ManagerService;
import com.spov.hellodocent.services.MemberService;

@Controller
@RequestMapping("/manage")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private MemberService memberService;
	
	@Inject
	private EncryptoRequestDocent encryptoDocent;

	@Inject
	private EncryptoMember encryptoMember;
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String getManagerLoginView(Model model) {

		
		return "system/manage/dashboard";
	}
	
	
	@Transactional
	@RequestMapping(value="/reqDocentInfo", method=RequestMethod.GET)
	public String reqDocentManage(Model model) {
		
		List<RequestDocentDTO> reqDocents = managerService.getRequestDocent();
		List<RequestDocentDTO> container = new ArrayList<>();
		
		for(RequestDocentDTO dto : reqDocents)
		{
			container.add((RequestDocentDTO)encryptoDocent.Decrypto(dto));
						
		}
			
		model.addAttribute("req", container );
		
		return "system/manage/reqDocentManage";
	}
	
	@RequestMapping(value="/getReqDocentDetail", method=RequestMethod.GET)
	public String getReqDocentDetail(@RequestParam("id") String id ,Model model) throws Exception {

		
		
		MemberDTO member = (MemberDTO)encryptoMember.Decrypto(memberService.getMemberInfo(id));
		member.setUser_iuid((String)new EncryptoString().Encrypto(member.getUser_iuid()));
		RequestDocentDTO requestDTO = (RequestDocentDTO)encryptoDocent.Decrypto(managerService.getRequestDocentOne(id));
		
		model.addAttribute("member", member);
		model.addAttribute("request", requestDTO);
		
		return "system/manage/reqDocentDetail";
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping(value="/approveDocent", method=RequestMethod.GET)
	public String approveDocent(@RequestParam("id") String id ,Model model) throws Exception {

		RequestDocentDTO reqDto = managerService.getRequestDocentOne(id);
		managerService.approveDocentInvoker(reqDto); 

	
		return "success";
	
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping(value="/removeRequestDocent", method=RequestMethod.GET)
	public String removeRequestDocent(@RequestParam("id") String id) throws Exception {
		
		managerService.removeRequestDocent(id);
		
		return "sussess";
	}
	
}
