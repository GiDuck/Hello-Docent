package com.spov.hellodocent.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spov.hellodocent.domain.BlogReplyDTO;
import com.spov.hellodocent.domain.CommentaryReplyDTO;
import com.spov.hellodocent.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO replyDAO;

	
	/*해설 댓글 CRUD*/
	@Override
	public void insertCommentaryReply(CommentaryReplyDTO reply) {
	
		replyDAO.insertCommentaryReply(reply);
		
	}

	@Override
	public Map<String, List<CommentaryReplyDTO>> selectCommentaryReply(String id) {

		List<CommentaryReplyDTO> comList = replyDAO.selectCommentaryReply(id);
		Map<String ,List<CommentaryReplyDTO>> parsedMap = new HashMap<>(); 
		//대댓글이 아닌 일반 댓글들을 저장할 리스트를 지정하고 맵에 push. key는 hasNotAnyRef;
		parsedMap.put("hasNotAnyRef", new ArrayList<CommentaryReplyDTO>());
		
		String refKey = null;
		for(CommentaryReplyDTO reply : comList) {
			
			//참조하고 있는 댓글의 uid (즉, 대댓글이 참조하고 있는 원댓글의 uid)
			refKey = reply.getCMTR_REPREF();
			
			List<CommentaryReplyDTO> temp;
			//참조하고 있는 댓글이 있다면
			if(refKey!=null) {
				
			
				//만약 맵에서 대댓글에 해당하는 댓글의 uid를 키로 가지고 있다면 리스트를 꺼내서 댓글 객체를 저정하고 다시 맵에 푸쉬
				if(parsedMap.containsKey(refKey)) {
					
					temp = parsedMap.get(refKey);
					temp.add(reply);
					parsedMap.put(refKey, temp);
				
				//없으면 새로 리스트를 만들어서 푸쉬
				}else {
					
					temp = new ArrayList<CommentaryReplyDTO>();
					temp.add(reply);
					parsedMap.put(refKey, temp);
					
				}
				
				//참조하고 있는 댓글이 없다면
			}else {
				
				temp = parsedMap.get("hasNotAnyRef");
				temp.add(reply);
				parsedMap.put("hasNotAnyRef", temp);
				
				
				
			}
			
		}
		
		
		return parsedMap;
	}

	@Override
	public void removeCommentaryReply(String id) {
		replyDAO.removeCommentaryReply(id);		
	}

	@Override
	public void updateCommentaryReply(CommentaryReplyDTO reply) {

		replyDAO.updateCommentaryReply(reply);
		
	}
	
	
	
	
	/*블로그 댓글 CRUD*/
	
	
	
	@Override
	public void insertBlogReply(BlogReplyDTO reply) {
	
		replyDAO.insertBlogReply(reply);
		
	}

	@Override
	public Map<String, List<BlogReplyDTO>> selectBlogReply(String id) {

		List<BlogReplyDTO> comList = replyDAO.selectBlogReply(id);
		Map<String ,List<BlogReplyDTO>> parsedMap = new HashMap<>(); 
		//대댓글이 아닌 일반 댓글들을 저장할 리스트를 지정하고 맵에 push. key는 hasNotAnyRef;
		parsedMap.put("hasNotAnyRef", new ArrayList<BlogReplyDTO>());
		
		String refKey = null;
		for(BlogReplyDTO reply : comList) {
			
			//참조하고 있는 댓글의 uid (즉, 대댓글이 참조하고 있는 원댓글의 uid)
			refKey = reply.getColr_repref();
			
			List<BlogReplyDTO> temp;
			//참조하고 있는 댓글이 있다면
			if(refKey!=null) {
				
			
				//만약 맵에서 대댓글에 해당하는 댓글의 uid를 키로 가지고 있다면 리스트를 꺼내서 댓글 객체를 저정하고 다시 맵에 푸쉬
				if(parsedMap.containsKey(refKey)) {
					
					temp = parsedMap.get(refKey);
					temp.add(reply);
					parsedMap.put(refKey, temp);
				
				//없으면 새로 리스트를 만들어서 푸쉬
				}else {
					
					temp = new ArrayList<BlogReplyDTO>();
					temp.add(reply);
					parsedMap.put(refKey, temp);
					
				}
				
				//참조하고 있는 댓글이 없다면
			}else {
				
				temp = parsedMap.get("hasNotAnyRef");
				temp.add(reply);
				parsedMap.put("hasNotAnyRef", temp);
				
				
				
			}
			
		}
		
		
		return parsedMap;
	}

	@Override
	public void removeBlogReply(String id) {
		replyDAO.removeBlogReply(id);		
	}

	@Override
	public void updateBlogReply(BlogReplyDTO reply) {

		replyDAO.updateBlogReply(reply);
		
	}
	
	
	
	
}
