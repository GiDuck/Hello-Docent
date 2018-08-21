package com.spov.hellodocent.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spov.hellodocent.domain.BlogDTO;
import com.spov.hellodocent.domain.ResourceDTO;
import com.spov.hellodocent.persistence.BlogDAO;
import com.spov.hellodocent.persistence.UploadDAO;

@Service
public class BlogServiceImpl implements BlogService {

	@Inject
	private BlogDAO blogDAO;
	
	@Inject
	private UploadDAO uploadDAO;

	@Override
	public void insertBlog(BlogDTO blog) {
	
		blogDAO.insertBlog(blog);
		
	}

	@Override
	public void insertTags(List<String> param,  String ref) {
		

		Map<String, String> temp= new HashMap<>();
		
		for(String tag : param) {
			try {
			temp.put("tag_ref", ref);
			temp.put("tag_name", tag);
			
			blogDAO.insertTags(temp);
			
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}finally {
				temp.clear();
				
			}
		
		}
		
		
		
		
	}

	@Override
	public List<String> insertBlogResource(String ref, List<String> images) {

	//param = 컨트롤러로 부터 건네받은 실제 html상에 삽입된 리소스의 목록이다.

		
		//upload url들을 ResourceDTO 타입의 List로 만들어 준다.
		List<ResourceDTO> toUploadImages = new ArrayList<>();
		Date today = new Date();
		for(String image : images) {
			
			System.out.println("IMAGE : " + image);
			ResourceDTO resource = new ResourceDTO();
			resource.setRes_ref(ref);
			resource.setRes_type("image");
			resource.setRes_url(image);
			resource.setRes_date(today);
			toUploadImages.add(resource);
			
			
		}
		
	
		
		//임시 테이블에 올라가있는 리소스 목록을 가지고 온다. (해당 해설 id로  연결돼있는)
		List<String> tempFileUrl = uploadDAO.selectTempResource(ref);

		//삭제할 리소스 URL 목록
		List<String> toRemoveFiles = new ArrayList<String>();
		
		/*실제 html에 삽입되어 있지 않은 이미지들을 골라 삭제할 리스트에 담는다.*/
		
		for(String temp : tempFileUrl) {
		
			if(!images.contains(temp)) {
				toRemoveFiles.add(temp);
				
			}

		}

		blogDAO.insertBlogResource(toUploadImages);
		
		return toRemoveFiles;
		
	}
	
	/*블로그 포스팅 가져오기*/

	@Override
	public BlogDTO selectBlog(String id) {
	
		return blogDAO.selectBlog(id);
	}

	
	/*블로그 태그 가져오기*/
	@Override
	public List<String> getBlogTags(String id) {
	
		return blogDAO.getBlogTags(id);
	}


	/*블로그 포스팅 수정하기*/
	
	
	@Override
	public void updateBlog(BlogDTO blog) {
		blogDAO.updateBlog(blog);		
	}

	
	/*블로그 태그 삭제*/
	
	@Override
	public void removeBlogTags(String id) {
		blogDAO.removeBlogTags(id);
		
	}
	

	
	/*블로그 포스팅 삭제*/
	

	@Override
	public void removeBlog(String id) {
	
		blogDAO.removeBlog(id);
		
	}
	
	/*블로그 리소스 삭제*/

	@Override
	public void removeBlogResource(String id) {
	
		blogDAO.removeBlogResource(id);
		
	}
	
	
	@Override
	public String selectBlogImageResource(String id) {
	
		
		return blogDAO.selectBlogImageResource(id);
	}

	@Override
	public List<Map<String, String>> getBlogList(int pageNum, String keyword) {
	
		Map<String, String> param = new HashMap<>();
		int prefix = (pageNum-1) * 10;
		int suffix = prefix + 10;
		
		param.put("prefix", String.valueOf(prefix));
		param.put("suffix", String.valueOf(suffix));
		param.put("keyword", keyword);
		
		System.out.println("prefix : " + prefix + "  " + "suffix : " + suffix);
		
		
		return blogDAO.getBlogList(param);
	
	}

	@Override
	public String getBlogLength(String keyword) {
		return blogDAO.getBlogLength(keyword);
	}

	@Override
	public List<Map<String, String>> getMyBlog(String id, int pageNum) {
	
		Map<String, String> param = new HashMap<>();
		param.put("id",id);
		param.put("prefix", String.valueOf((pageNum-1)*10));
		param.put("suffix", String.valueOf((pageNum-1)*10 + 9));
		
		
		return blogDAO.getBlogList(param);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
