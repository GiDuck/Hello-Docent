package com.spov.hellodocent.persistence;

import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.BlogDTO;
import com.spov.hellodocent.domain.ResourceDTO;

public interface BlogDAO {

	public void insertBlog(BlogDTO blog);
	public void insertTags(Map<String, String> param);
	public void insertBlogResource(List<ResourceDTO> param);
	public BlogDTO selectBlog(String id);
	public List<String> getBlogTags (String id);
	public void updateBlog (BlogDTO blog);
	public void removeBlogTags (String id);
	public void removeBlog(String id);
	public void removeBlogResource(String id);
	public String selectBlogImageResource(String id);
	public List<Map<String, String>> getBlogList (Map<String, String> param);
	public String getBlogLength(String keyword);
	public List<Map<String, String>> getMyBlog(Map<String, String> param);


	
	
	
	
}
