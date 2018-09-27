package com.spov.hellodocent.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spov.hellodocent.domain.CommentaryDTO;
import com.spov.hellodocent.persistence.CommentaryDAO;

@Service
public class CommentaryServiceImpl implements CommentaryService {

	
	@Inject
	private CommentaryDAO comDAO;
	
	@Override
	public CommentaryDTO getCommentary(String id) {
		return comDAO.getCommentary(id);
	}

	
	
	
	@Override
	public List<Map<String, String>> getCommentaryByDisplayId(String id) {
		
		 return comDAO.getCommentaryByDisplayId(id);
	}


	@Override
	public void removeCommentary(String id) {
		comDAO.removeCommentary(id);
		
	}

	@Override
	public void updateCommentray(CommentaryDTO commentary) {
		comDAO.updateCommentray(commentary);
		
	}

	@Override
	public String getCommentaryCostInfo(String id) {
		// TODO Auto-generated method stub
		return comDAO.getCommentaryCostInfo(id);
	}

	@Override
	public void removeCommentaryTags(String id) {
		comDAO.removeCommentaryTags(id);
		
	}

	@Override
	public void updateCommentaryCost(Map<String, String> param) {
	
		comDAO.updateCommentaryCost(param);
		
	}

	@Override
	public List<String> getCommentaryTags(String id) {
		
		return comDAO.getCommentaryTags(id);
		
	}




	@Override
	public List<Map<String, String>> getMyCommentary(String id, int pageNum) {
	
		Map<String, String> param = new HashMap<>();
		param.put("id", id);
		param.put("prefix", String.valueOf((pageNum-1)*10));
		param.put("suffix", String.valueOf((pageNum-1)*10 + 10));
		
		
		return comDAO.getMyCommentary(param);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
