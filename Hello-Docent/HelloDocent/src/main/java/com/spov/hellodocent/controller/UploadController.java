package com.spov.hellodocent.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spov.hellodocent.domain.ResourceDTO;
import com.spov.hellodocent.encrypto.EncryptoString;
import com.spov.hellodocent.services.UploadService;
import com.spov.hellodocent.tools.FileManager;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Autowired
	private UploadService uploadService;
	

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);	
	
	@Transactional
	@ResponseBody
	@RequestMapping(value="/imageUpload",method=RequestMethod.POST)
	public Map<String, String> uploadImage(@RequestParam("image") List<MultipartFile> files,
			@RequestParam("boardUid") String boardUid, @RequestParam("id") String id, HttpServletResponse response) throws Exception {
		
		logger.info("boardUid : " + boardUid);
		logger.info("id : " + id);
		logger.info("originName : " + files.get(0).getOriginalFilename());
		logger.info("size : " + files.get(0).getSize()/1024 +"kb");
		logger.info("content-Type : " + files.get(0).getContentType());
		
		FileManager maker = FileManager.getInstance();
		logger.info("byte array : " + files.get(0).getBytes());
		String responseURL = maker.uploadImage(uploadPath, files.get(0).getOriginalFilename(), id, files.get(0).getBytes());
		logger.info("ResponseURL --> " + responseURL );
		
		
		ResourceDTO param = new ResourceDTO();
		param.setRes_ref(id);
		param.setRes_type("image");
		param.setRes_url(responseURL);
		param.setRes_date(new Date());
	
		
		uploadService.insertTempImageUrl(param);
		
		Map<String, String> returnVal = new HashMap<>();
		returnVal.put("link",responseURL);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		
		
		return returnVal;
	}
	
	
	@Transactional
	@RequestMapping(value="/deleteImage", method=RequestMethod.GET)
	public String deleteImage(@RequestParam("src") String src) {
		
		try {
		uploadService.deleteTempImageUrl(src);
		FileManager manager = FileManager.getInstance();
		manager.deleteImage(uploadPath+(src.substring(4)));
		logger.info("delete Path : " + uploadPath+(src.substring(4)));
		
		
		return "success";
		
		}catch(Exception e) {

			logger.debug("Delete Image Exception", e);
		return "error";
		}
		
		
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getSingleImage", method=RequestMethod.GET)
	public String getImageList(@RequestParam("id") String id, HttpServletResponse response) throws Exception{
		
		System.out.println("이미지 찾는 id : " + id);
		
		
		
		
		return uploadService.selectImageResource(id);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/updateProfilePhoto", method=RequestMethod.POST, produces = "text/plain; charset=utf-8")
	public String updateProfilePhoto(MultipartFile file, String id) throws Exception{
		
		String uploadUrl = null;
		
		if(file != null) {
			

		logger.info("들어온 file.. " +  file);
		logger.info("들어온 file.. " +  file.getOriginalFilename());
		logger.info("들어온 file.. " +  file.getSize());
		logger.info("들어온 id" + id);
			
		FileManager fileManger = FileManager.getInstance();
		EncryptoString encrypto = new EncryptoString();
		String userId = (String)encrypto.Decrypto(id);
		
		String url = fileManger.uploadImage(uploadPath, file.getOriginalFilename(), userId, file.getBytes());

		
		ResourceDTO resource = new ResourceDTO();
		resource.setRes_ref(id);
		resource.setRes_type("profile");
		resource.setRes_date(new Date());
		resource.setRes_url(url);
		uploadService.insertTempImageUrl(resource);
		
		uploadUrl = url;

		}
		
		return uploadUrl;
		
		
	}
	
	


	
	
	
	
	
	
}
