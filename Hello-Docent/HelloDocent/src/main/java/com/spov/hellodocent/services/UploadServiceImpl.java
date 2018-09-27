package com.spov.hellodocent.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spov.hellodocent.domain.CommentaryDTO;
import com.spov.hellodocent.domain.ResourceDTO;
import com.spov.hellodocent.persistence.UploadDAO;

@Service
public class UploadServiceImpl implements UploadService {

	@Inject
	UploadDAO uploadDAO;

	@Override
	public void insertTempImageUrl(ResourceDTO param) {
		
		uploadDAO.insertTempImageUrl(param);
		
	}

	@Override
	public void deleteTempImageUrl(String keyword) {
		
		uploadDAO.deleteTempImageUrl(keyword);
		
	}

	@Override
	public void insertCommentary(CommentaryDTO commentary) {

		uploadDAO.insertCommentary(commentary);
	}

	@Override
	public void insertTags(String[] param, String ref) {
		
		
		Map<String, String> temp= new HashMap<>();
		
		for(String tag : param) {
			try {
			temp.put("tag_ref", ref);
			temp.put("tag_name", tag);
			uploadDAO.insertTags(temp);
			
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}finally {
				temp.clear();
				
			}
		
		}
		
		
	}

	@Override
	public List<String> insertComResource(String ref, String[] images) {
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
		
		//배열로 받은 실제 html에 삽입되어 있는 url 목록을 list로 변환해 준다.
		List<String> imageList = Arrays.asList(images);
		
		//임시 테이블에 올라가있는 리소스 목록을 가지고 온다. (해당 해설 id로  연결돼있는)
		List<String> tempFileUrl = uploadDAO.selectTempResource(ref);

		//삭제할 리소스 URL 목록
		List<String> toRemoveFiles = new ArrayList<String>();
		
		/*실제 html에 삽입되어 있지 않은 이미지들을 골라 삭제할 리스트에 담는다.*/
		
		for(String temp : tempFileUrl) {
		
			if(!imageList.contains(temp)) {
				toRemoveFiles.add(temp);
				
			}

		}

		uploadDAO.insertComResource(toUploadImages);
		
		return toRemoveFiles;
	}

	@Override
	public List<String> selectTempResource(String id) {
		
		return uploadDAO.selectTempResource(id);
	}

	@Override
	public void deleteTempResource(String id) {

		uploadDAO.deleteTempResource(id);
		
	}

	@Override
	public void insertCostInfo(String id, String price) {	
		
		Map<String, String> param = new HashMap<>();
		param.put("id", id);
		param.put("price", price);	

		uploadDAO.insertCostInfo(param);		
		
	}

	@Override
	public String selectImageResource(String id) {
	
		
		return uploadDAO.selectImageResource(id);
	}

	@Override
	public void deleteComResource(String id) {
		uploadDAO.deleteComResource(id);		
	}

	
	
}
