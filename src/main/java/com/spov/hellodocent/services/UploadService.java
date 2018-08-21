package com.spov.hellodocent.services;

import java.util.List;

import com.spov.hellodocent.domain.CommentaryDTO;
import com.spov.hellodocent.domain.ResourceDTO;

public interface UploadService {


	public void insertTempImageUrl(ResourceDTO param);
	public void deleteTempImageUrl(String keyword);
	public void insertCommentary(CommentaryDTO commentary);
	public void insertTags(String[] param,  String ref);
	public void deleteTempResource(String id);
	public void insertCostInfo(String id, String price);
	public String selectImageResource(String id);
	
	
	
	public List<String> insertComResource(String ref, String[] images);
	public List<String> selectTempResource(String id);
	public void deleteComResource(String id);


	
}
