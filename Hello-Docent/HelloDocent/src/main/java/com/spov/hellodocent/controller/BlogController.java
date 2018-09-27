package com.spov.hellodocent.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

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
import com.spov.hellodocent.domain.BlogCT;
import com.spov.hellodocent.domain.BlogDTO;
import com.spov.hellodocent.services.BlogService;
import com.spov.hellodocent.services.UploadService;
import com.spov.hellodocent.tools.FileManager;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Inject
	private UploadService uploadService;
	
	@Inject
	private BlogService blogService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	

	private static Logger logger = Logger.getLogger(BlogController.class);
	
	/*블로그 메인 뷰페이지*/
	@RequestMapping(value="/blogMain", method=RequestMethod.GET)
	public String getBlogView(@RequestParam("pageNum") int pageNum, 
			@RequestParam("keyword") String keyword, Model model){	
		
		List<Map<String, String>> blogs = blogService.getBlogList(pageNum, keyword);
		System.out.println("pageNum : " + pageNum + " " + "keyword : " + keyword);
		model.addAttribute("blogs", blogs);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("keyword", keyword);
		
		return "blog/blogMain";
	}
	
	/*블로그 포스팅 뷰페이지*/
	@RequestMapping("/blogView")
	public String blogView(@RequestParam("id") String id, Model model) {
		
		BlogDTO blog = blogService.selectBlog(id);
		List<String> tags = blogService.getBlogTags(id);
		model.addAttribute("blog", blog);
		model.addAttribute("tags", tags);

		
		return "blog/blogView";
	}
	
	/*블로그 작성 페이지*/
	@RequestMapping("/blogWriting")
	public String blogWriting(Model model) {
		return "blog/blogWriting";
	}
	
	/*블로그 포스팅 insert*/
	@Transactional
	@RequestMapping(value = "blogInsert", method = RequestMethod.POST)
	public String blogInsert(@RequestBody String json, Model model) {
		
		logger.info("json : " + json);
		
		Gson gson = new Gson();
		BlogCT container = gson.fromJson(json, BlogCT.class);
		List<String> images = container.getImages();
		List<String> tags = container.getTags();
		
		BlogDTO blog = new BlogDTO();
		blog.setCol_content(container.getCol_content());
		blog.setCol_date(new Date(Long.parseLong(container.getCol_date())));
		blog.setCol_id(container.getCol_id());
		blog.setCol_introduce(container.getCol_introduce());
		blog.setCol_title(container.getCol_title());
		blog.setCol_type(container.getCol_type());
		blog.setCol_writeruid(container.getCol_writeruid());
		
		System.out.println("BLOG 들어온 값 : " + images);
		System.out.println("BLOG 들어온 값 : " + tags);

		blogService.insertBlog(blog);
		blogService.insertTags(tags, blog.getCol_id());
		
		List<String> removeFiles = blogService.insertBlogResource(blog.getCol_id(), images);

		
		logger.info("remove file size....  " + removeFiles.size());
		
		
		String removeDir = uploadPath+"\\"+blog.getCol_id();
		
		
		FileManager manager = FileManager.getInstance();
		manager.removeFiles(uploadPath, removeFiles);
		
		
		uploadService.deleteTempResource(blog.getCol_id());
		
		model.addAttribute("id", blog.getCol_id());

		
		
		
		return "/blog/blogView";
	}
	
	
	
	/*블로그 수정 뷰페이지*/
	@RequestMapping(value="/blogModifyView", method=RequestMethod.GET)
	public String BlogModifyView(@RequestParam("id") String id,Model model) {
		
		
		BlogDTO blog = blogService.selectBlog(id);
		Map<String, String>params = new HashMap<>();
		List<String> tags = blogService.getBlogTags(id);
		
		
		model.addAttribute("blog", blog);
		model.addAttribute("tags", tags);
		
		
		return "blog/blogUpdate";
	}
	
	
	/*블로그 포스팅 수정*/	
	@Transactional
	@RequestMapping(value="/blogModify", method=RequestMethod.POST)
	public String modifyBlog(@RequestBody String response)
	{
		
	
		Gson gson = new Gson();
		
		BlogCT container = gson.fromJson(response, BlogCT.class);
		
		System.out.println("container : .. " + container.toString());
		
		BlogDTO blog = new BlogDTO();
		
		blog.setCol_id(container.getCol_id());
		blog.setCol_content(container.getCol_content());
		blog.setCol_type(container.getCol_type());
		blog.setCol_introduce(container.getCol_introduce());
		blog.setCol_title(container.getCol_title());
		
		System.out.println("blog : .. " + blog.toString());

	
		blogService.updateBlog(blog);
		blogService.removeBlogTags(container.getCol_id());
		blogService.insertTags(container.getTags(), container.getCol_id());
		
		
		
		//실제 업로드 될 파일을 테이블에 insert하고, 임시 테이블에 올라가 있던 삭제할 파일 목록을 들고온다. 
		List<String> removeFiles = blogService.insertBlogResource(container.getCol_id(), container.getImages());
		
		logger.info("remove file size....  " + removeFiles.size());
		
		//만약 오류가 났을 경우를 대비한 디렉토리 전체삭제
		String removeDir = uploadPath+"\\"+container.getCol_id();
		
		
		logger.info("remove directory....  " + removeDir);

		FileManager manager = FileManager.getInstance();
		manager.removeFiles(uploadPath, removeFiles);
		//manager.removeDir(removeDir);
		
		uploadService.deleteTempResource(container.getCol_id());
		
		
		return "redirect:/";
	}
	
	
	
	
	
	/*블로그 태그 뽑아오기*/
	@ResponseBody
	@RequestMapping(value="/blogGetTags", method=RequestMethod.GET)
	public List<String> getBlogTags(@RequestParam("id") String id){
		
		return blogService.getBlogTags(id);
		
		
	}
	
	
	
	
	
	
	/*블로그 포스팅 삭제*/
	@Transactional
	@RequestMapping(value="/blogDelete", method=RequestMethod.GET)
	public String deleteBlog(@RequestParam("id") String id) throws Exception
	{
		
		blogService.removeBlog(id);
		FileManager fileManager = FileManager.getInstance();
		fileManager.removeDir(uploadPath+"\\"+id);
		blogService.removeBlogResource(id);
		
		return "redirect:/";
	}
	
	
	/*블로그 이미지 가져오기*/
	@ResponseBody
	@RequestMapping(value="/getSingleBlogImage", method=RequestMethod.GET)
	public String getBlogImage(@RequestParam("id") String id, HttpServletResponse response) throws Exception{
		
		System.out.println("이미지 찾는 id : " + id);
		
		
		
		
		return blogService.selectBlogImageResource(id);
	}
	
	
	/*블로그 사이즈 가져오기*/
	
	@ResponseBody
	@RequestMapping(value="/getBlogSize", method=RequestMethod.GET)
	public String getBlogSize(@RequestParam("keyword") String keyword) throws Exception{
		

		String length = blogService.getBlogLength(keyword);
		
		System.out.println("Blog length : " + length);
		
		return length;
		
		
	}
	
	
	
	
	
	
	
	
}
