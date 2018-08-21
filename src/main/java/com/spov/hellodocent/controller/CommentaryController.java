package com.spov.hellodocent.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spov.hellodocent.domain.CommentaryCT;
import com.spov.hellodocent.domain.CommentaryDTO;
import com.spov.hellodocent.services.CommentaryService;
import com.spov.hellodocent.services.DisplayService;
import com.spov.hellodocent.services.UploadService;
import com.spov.hellodocent.tools.FileManager;

@Controller
@RequestMapping("/commentary")
public class CommentaryController {

	@Inject
	CommentaryService comService;
	
	@Inject
	DisplayService displayService;
	
	@Inject
	UploadService uploadService;

	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	private static Logger logger = Logger.getLogger(CommentaryController.class);
	
	
	
	
	
	@Transactional
	@ResponseBody
	@RequestMapping(value="/insertCommentary", method= RequestMethod.POST)
	public String insertCommentray(@RequestBody String json){
		
		
		
		try {
		//GSON을 통한 JSON PARSING
		Gson gson = new GsonBuilder().create();
		CommentaryCT container = gson.fromJson(json, CommentaryCT.class);
		
		logger.info("insert Commentary......");
		container.toString();
		
		//전달할 MODEL 객체에 PUSH
		CommentaryDTO commentary = new CommentaryDTO();

		
		
		try {
		commentary.setCMT_CONTENT(container.getCMT_CONTENT());
		commentary.setCMT_CONTENTTYPE(container.getCMT_CONTENTTYPE());
		commentary.setCMT_DATE(new Date(Long.parseLong(container.getCMT_DATE())));
		commentary.setCMT_ID(container.getCMT_ID());
		commentary.setCMT_INTRODUCE(container.getCMT_INTRODUCE());
		commentary.setCMT_ISFREE(container.getCMT_ISFREE());
		commentary.setCMT_REF(container.getCMT_REF());
		commentary.setCMT_TITLE(container.getCMT_TITLE());
		commentary.setCMT_WRITERUID(container.getCMT_WRITERUID());
		
		System.out.println(commentary.toString());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//해설 ID
		String cmt_id = container.getCMT_ID();
		
		
		//실제 html 상에 존재하는 이미지 (upload 시킬 이미지 list)
		String[] images = container.getCMT_IMAGE_ARRAY();

		
		//해설 정보 insert
		uploadService.insertCommentary(commentary);
		//Tag insert
		uploadService.insertTags(container.getCMT_TAGS(), container.getCMT_ID());
		//실제 업로드 될 파일을 테이블에 insert하고, 임시 테이블에 올라가 있던 삭제할 파일 목록을 들고온다. 
		List<String> removeFiles = uploadService.insertComResource(cmt_id, images);
		
		logger.info("remove file size....  " + removeFiles.size());
		
		
		String removeDir = uploadPath+"\\"+cmt_id;
		
		
		FileManager manager = FileManager.getInstance();
		manager.removeFiles(uploadPath, removeFiles);
		
		
		uploadService.deleteTempResource(cmt_id);
		
		if(container.getCMT_ISFREE().equals("cost")) {
			
			
			uploadService.insertCostInfo(cmt_id, container.getCMT_PRICE());
			
		}
		

		return "success";
		}catch(Exception e) {
			
		e.printStackTrace();
			return "fail";

		}
		
	}
	

	
	
	@RequestMapping(value="/commentrayWriting", method=RequestMethod.GET)
	public String CommentrayWriting(@RequestParam("id") String id, Model model) {
		
		
		Map<String, String>params = new HashMap<>();
		params = displayService.getDisplayInfoSimple(id);

		model.addAttribute("params", params);
		model.addAttribute("display_uid", id);

		

		return "commentary/commentrayWriting";
	}
	
	
	
	@RequestMapping(value="/commentaryView", method=RequestMethod.GET)
	public String CommentaryView(@RequestParam("id") String id, Model model) {
		
		
		CommentaryDTO comInfo = comService.getCommentary(id);
		model.addAttribute("comInfo",comInfo);		
		
		return "commentary/commentaryView";
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getCommentary", method=RequestMethod.GET)
	public List<Map<String, String>> getCommentary(@RequestParam("id") String id, Model model) throws Exception {
		
	
		
		return comService.getCommentaryByDisplayId(id);
		
	}
	
	
	
	
	
	@RequestMapping(value="/commentaryModifyView", method=RequestMethod.GET)
	public String commentaryModifyView(@RequestParam("comId") String comId,@RequestParam("dispId") String dispId, Model model) {
		
		
		CommentaryDTO comInfo = comService.getCommentary(comId);
		Map<String, String>params = new HashMap<>();
		params = displayService.getDisplayInfoSimple(dispId);
		String cost = comService.getCommentaryCostInfo(comId);
		List<String> tags = comService.getCommentaryTags(comId);
		
		
		model.addAttribute("params", params);
		model.addAttribute("comInfo",comInfo);
		model.addAttribute("cost",cost);
		model.addAttribute("tags", tags);
		
		
		return "commentary/commentaryUpdate";
	}

	@ResponseBody
	@RequestMapping(value="/commentaryGetTags", method=RequestMethod.GET)
	public List<String> getCommentaryTags(@RequestParam("id") String id){
		
		return comService.getCommentaryTags(id);
		
		
	}
	
	
	
	
	
	@RequestMapping(value="/commentaryModify", method=RequestMethod.POST)
	public String modifyCommentary(@RequestBody String response)
	{
		
	
		Gson gson = new Gson();
		
		CommentaryCT container = gson.fromJson(response, CommentaryCT.class);
		
		System.out.println("container : .. " + container);
		
		CommentaryDTO commentary = new CommentaryDTO();
		
		commentary.setCMT_ID(container.getCMT_ID());
		commentary.setCMT_CONTENT(container.getCMT_CONTENT());
		commentary.setCMT_CONTENTTYPE(container.getCMT_CONTENTTYPE());
		commentary.setCMT_INTRODUCE(container.getCMT_INTRODUCE());
		commentary.setCMT_ISFREE(container.getCMT_ISFREE());
		commentary.setCMT_TITLE(container.getCMT_TITLE());
	
		comService.updateCommentray(commentary);
		comService.removeCommentaryTags(container.getCMT_ID());
		uploadService.insertTags(container.getCMT_TAGS(), container.getCMT_ID());
		
		
		
		//실제 업로드 될 파일을 테이블에 insert하고, 임시 테이블에 올라가 있던 삭제할 파일 목록을 들고온다. 
		List<String> removeFiles = uploadService.insertComResource(container.getCMT_ID(), container.getCMT_IMAGE_ARRAY());
		
		logger.info("remove file size....  " + removeFiles.size());
		
		//만약 오류가 났을 경우를 대비한 디렉토리 전체삭제
		String removeDir = uploadPath+"\\"+container.getCMT_ID();
		
		
		logger.info("remove directory....  " + removeDir);

		FileManager manager = FileManager.getInstance();
		manager.removeFiles(uploadPath, removeFiles);
		//manager.removeDir(removeDir);
		
		uploadService.deleteTempResource(container.getCMT_ID());
		
		if(container.getCMT_ISFREE().equals("cost")) {
			
			Map<String, String> param = new HashMap<>();
			param.put("id", container.getCMT_ID());
			param.put("price", container.getCMT_PRICE());

			comService.updateCommentaryCost(param);
			
		}
		
		
		return "redirect:/";
	}
	
	/*
	 * 삭제 절차
	1. 해설을 참조하는 모든 리소스 삭제
	2. 해설을 참조하는 모든 댓글 삭제 - cascade로 연쇄 삭제
	3. 해설을 참조하는 가격 정보 삭제 (유료로 설정 헀을 시)  - cascade로 연쇄 삭제
	4. 해설 태그 정보 삭제  - cascade로 연쇄 삭제
	5. 해설 정보 삭제  */
	

	
	@RequestMapping(value="/commentaryDelete", method=RequestMethod.GET)
	public String deleteCommentary(@RequestParam("id") String id) throws Exception
	{
		
		comService.removeCommentary(id);
		FileManager fileManager = FileManager.getInstance();
		fileManager.removeDir(uploadPath+"\\"+id);
		uploadService.deleteComResource(id);
		
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/getCostInfo")
	public String getCostInfo(@RequestParam("id") String id){
		
		return comService.getCommentaryCostInfo(id);
		
	}

	
	
	
	
	
}
