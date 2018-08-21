package com.spov.hellodocent.persistence;

import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.CommentaryDTO;

public interface CommentaryDAO {
	
	public CommentaryDTO getCommentary(String id);
	public List<Map<String, String>> getCommentaryByDisplayId(String id);
	public void removeCommentary(String id);
	public void updateCommentray (CommentaryDTO commentary);
	public String getCommentaryCostInfo(String id);
	public void removeCommentaryTags(String id);
	public void updateCommentaryCost(Map<String, String> id);
	public List<String> getCommentaryTags(String id);
	public List<Map<String, String>> getMyCommentary (Map<String, String> param);
}
