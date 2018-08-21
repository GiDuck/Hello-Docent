package com.spov.hellodocent.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spov.hellodocent.domain.CommentaryDTO;
import com.spov.hellodocent.domain.ResourceDTO;

@Repository
public class UploadDAOImpl implements UploadDAO{
	
	@Inject
	SqlSession sqlSession;
	
	private static final String namespace = "com.spov.hellodocent.mappers.uploadMapper";

	public void insertTempImageUrl(ResourceDTO param) {
		
		
		sqlSession.insert(namespace+".insertTempImageUrl", param);
		
	}

	@Override
	public void deleteTempImageUrl(String keyword) {

		
		sqlSession.delete(namespace+".deleteTempImageUrl", keyword);
		
	}

	@Override
	public void insertCommentary(CommentaryDTO commentary) {

		sqlSession.insert(namespace+".insertCommentrary", commentary);
		
	}

	@Override
	public void insertTags(Map<String, String> param) {
			
		sqlSession.insert(namespace+".insertTags", param);

		
	}

	@Override
	public void insertComResource(List<ResourceDTO> param) {

		sqlSession.insert(namespace+".insertComResource", param);
	
		
	}

	@Override
	public List<String> selectTempResource(String id) {

		
		return sqlSession.selectList(namespace+".selectTempResource", id);

	}

	@Override
	public void deleteTempResource(String id) {

		sqlSession.delete(namespace+".deleteTempResource", id);
		
	}

	@Override
	public void insertCostInfo(Map<String, String> param) {

		
		sqlSession.insert(namespace+".insertCostInfo", param);
		
	}

	@Override
	public String selectImageResource(String id) {
	
		
		
		return sqlSession.selectOne(namespace+".selectImageResource", id);
	}

	
	
	@Override
	public void deleteComResource(String id) {
		
		sqlSession.delete(namespace+".deleteComResource", id);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
