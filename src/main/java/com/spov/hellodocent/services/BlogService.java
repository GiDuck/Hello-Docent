package com.spov.hellodocent.services;

import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.BlogDTO;

public interface BlogService {
	
	public void insertBlog(BlogDTO blog);
	public void insertTags(List<String> param,  String ref);
	public List<String> insertBlogResource(String ref, List<String> images);
	public String selectBlogImageResource(String id);
	public BlogDTO selectBlog(String id);
	public List<String> getBlogTags(String id);
	public void updateBlog (BlogDTO blog);
	public void removeBlogTags(String id);
	public void removeBlog(String id);
	public void removeBlogResource(String id);
	public List<Map<String, String>> getBlogList (int pageNum, String keyword);
	public String getBlogLength(String keyword);
	public List<Map<String, String>> getMyBlog(String id, int pageNum);
	
	
}
