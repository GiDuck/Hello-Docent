package com.spov.hellodocent.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spov.hellodocent.domain.CommentaryDTO;

@Repository
public class CommentaryDAOImpl implements CommentaryDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.spov.hellodocent.mappers.commentaryMapper";

	@Override
	public CommentaryDTO getCommentary(String id) {
	
		return sqlSession.selectOne(namespace+".getCommentary", id);
	
	}

	@Override
	public void removeCommentary(String id) {
	
		
		sqlSession.delete(namespace+".removeCommentary", id);
	}

	@Override
	public void updateCommentray(CommentaryDTO commentary) {

		
		sqlSession.update(namespace+".updateCommentray", commentary);
		
	}

	@Override
	public String getCommentaryCostInfo(String id) {
		
		return sqlSession.selectOne(namespace+".getCommentaryCostInfo", id);
	}

	@Override
	public void removeCommentaryTags(String id) {
	
		
		sqlSession.delete(namespace + ".removeCommentaryTags", id);
		
	}

	@Override
	public void updateCommentaryCost(Map<String, String> param) {
		sqlSession.update(namespace+".updateCommentaryCost", param);
		
	}

	@Override
	public List<String> getCommentaryTags(String id) {
	
	return sqlSession.selectList(namespace+".getCommentaryTags", id);
	
	}

	@Override
	public List<Map<String, String>> getCommentaryByDisplayId(String id) {
		return sqlSession.selectList(namespace+".getCommentaryByDisplayId", id);
		
	}

	@Override
	public List<Map<String, String>> getMyCommentary(Map<String, String> param) {
		return sqlSession.selectList(namespace+".getMyCommentary", param);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
