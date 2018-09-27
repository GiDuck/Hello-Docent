package com.spov.hellodocent.persistence;

import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.CommentaryDTO;
import com.spov.hellodocent.domain.ResourceDTO;

public interface UploadDAO {

	public void insertTempImageUrl(ResourceDTO param);
	public void deleteTempImageUrl(String keyword);
	public void insertCommentary(CommentaryDTO commentary);
	public void insertTags(Map<String, String> param);
	public void insertComResource(List<ResourceDTO> param);
	public void deleteTempResource(String id);
	public void insertCostInfo(Map<String, String> param);
	public List<String> selectTempResource(String id);
	public String selectImageResource(String id);
	public void deleteComResource(String id);

}
