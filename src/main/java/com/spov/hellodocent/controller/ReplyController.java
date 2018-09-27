package com.spov.hellodocent.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spov.hellodocent.domain.BlogReplyDTO;
import com.spov.hellodocent.domain.CommentaryReplyDTO;
import com.spov.hellodocent.services.ReplyService;
import com.spov.hellodocent.tools.UidMaker;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	
	private static Logger logger = Logger.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyService replyService;	
	
	
	
	//해설 댓글 insert
	@ResponseBody
	@RequestMapping(value="/insertCommentaryReply", method=RequestMethod.POST)
	public String insertCommentaryReply(@RequestBody String json , Model model) throws Exception {
		
		System.out.println("JSON : " + json);
		Gson gson = new GsonBuilder().create();
		CommentaryReplyDTO reply = gson.fromJson(json, CommentaryReplyDTO.class);
		reply.setCMTR_ID(UidMaker.getUUid());
		
	
		
		replyService.insertCommentaryReply(reply);
		

		
		return "success";
		
	}
	
	/*해설 댓글 가져오기*/
	@ResponseBody
	@RequestMapping(value="/selectCommentaryReply", method=RequestMethod.GET)
	public Map<String, List<CommentaryReplyDTO>> getCommentaryReply(@RequestParam("id") String id) throws Exception{
		
		System.out.println("들어온 id.. " + id);
		
		return replyService.selectCommentaryReply(id);
		
	}
	
	
	
	//해설 댓글 remove
	@ResponseBody
	@RequestMapping(value="/removeCommentaryReply", method=RequestMethod.GET)
	public String removeCommentaryReply(@RequestParam("id") String id) throws Exception{
		
		System.out.println("들어온 id.. " + id);
		
		replyService.removeCommentaryReply(id);
		
		return "success";
				
		
	}
	
	
	//해설 댓글 update
	@ResponseBody
	@RequestMapping(value="/updateCommentaryReply", method=RequestMethod.POST)
	public String updateCommentaryReply(@RequestBody String json , Model model) throws Exception{
		
		SimpleDateFormat format = new SimpleDateFormat();
		System.out.println("JSON : " + json);
		Gson gson = new GsonBuilder()
				.create();
		CommentaryReplyDTO reply = new CommentaryReplyDTO();
		HashMap<String, String> mapContainer = (HashMap)gson.fromJson(json, HashMap.class);
		
		System.out.println("map : " + mapContainer);
		
		reply.setCMTR_CONTENT(mapContainer.get("cmtr_CONTENT"));
		reply.setCMTR_ID(mapContainer.get("cmtr_ID"));
		reply.setCMTR_REPREF(mapContainer.get("cmtr_REFREP"));
		
		reply.toString();
		
	
		
		replyService.updateCommentaryReply(reply);
		

		
		return "success";
		
	}
	
	
	
	
	/*------------------------- 블로그 댓글 ----------------------------*/
	
	
	
	//해설 댓글 insert
		@ResponseBody
		@RequestMapping(value="/insertBlogReply", method=RequestMethod.POST)
		public String insertBlogReply(@RequestBody String json , Model model) throws Exception {
			
			System.out.println("JSON : " + json);
			Gson gson = new GsonBuilder().create();
			BlogReplyDTO reply = gson.fromJson(json, BlogReplyDTO.class);
			reply.setColr_id(UidMaker.getUUid());
			

			
			replyService.insertBlogReply(reply);
			

			
			return "success";
			
		}
		
		/*해설 댓글 가져오기*/
		@ResponseBody
		@RequestMapping(value="/selectBlogReply", method=RequestMethod.GET)
		public Map<String, List<BlogReplyDTO>> getBlogReply(@RequestParam("id") String id) throws Exception{
			
			System.out.println("들어온 id.. " + id);
			
			return replyService.selectBlogReply(id);
			
		}
		
		
		
		//해설 댓글 remove
		@ResponseBody
		@RequestMapping(value="/removeBlogReply", method=RequestMethod.GET)
		public String removeBlogReply(@RequestParam("id") String id) throws Exception{
			
			System.out.println("들어온 id.. " + id);
			
			replyService.removeBlogReply(id);
			
			return "success";
					
			
		}
		
		
		//해설 댓글 update
		@ResponseBody
		@RequestMapping(value="/updateBlogReply", method=RequestMethod.POST)
		public String updateBlogReply(@RequestBody String json , Model model) throws Exception{
			
			SimpleDateFormat format = new SimpleDateFormat();
			System.out.println("JSON : " + json);
			Gson gson = new GsonBuilder()
					.create();
			BlogReplyDTO reply = new BlogReplyDTO();
			HashMap<String, String> mapContainer = (HashMap)gson.fromJson(json, HashMap.class);
			
			System.out.println("map : " + mapContainer);
			
			reply.setColr_content(mapContainer.get("colr_content"));
			reply.setColr_id(mapContainer.get("colr_id"));
			reply.setColr_repref(mapContainer.get("colr_refrep"));
			
			reply.toString();
			
		
			
			replyService.updateBlogReply(reply);
			

			
			return "success";
			
		}
		


	
	
	
	
}
