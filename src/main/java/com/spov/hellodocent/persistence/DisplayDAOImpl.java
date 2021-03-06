package com.spov.hellodocent.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spov.hellodocent.domain.SearchDTO;

@Repository
public class DisplayDAOImpl implements DisplayDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.spov.hellodocent.mappers.displayMapper";

	@Override
	public List<Map<String, String>> getDisplayInfo(Map<String, String> params) {
	
		return sqlSession.selectList(namespace+".getDisplayInfo", params);

	}
	
	
	@Override
	public List<Map<String, String>> getDisplayInfoDefault(SearchDTO param) {
		return sqlSession.selectList(namespace+".getDisplayInfoDefault", param);
	}

	@Override
	public List<Map<String, String>> getMuseumInfo() {
		return sqlSession.selectList(namespace+".getMuseumInfo");
	}
	
	@Override
	public List<Map<String, String>> getMuseumInfoDefault() {
		return sqlSession.selectList(namespace+".getMuseumInfoDefault");
	}


	@Override
	public Map<String, String> getDisplayInfoSimple(String keyword) {

		return sqlSession.selectOne(namespace+".getDisplayInfoSimple", keyword);
	}


	@Override
	public List<Map<String, String>> getDisplayInfoSimpleCard(String keyword) {

		return sqlSession.selectList(namespace+".getDisplayInfoSimpleCard", keyword);
	}


	@Override
	public List<Map<String, String>> getDisplayInfoByKeyword(SearchDTO param) {
		return sqlSession.selectList(namespace+".getDisplayInfoByKeyword", param);
	}


	@Override
	public List<Map<String, String>> getMuseumInfoByKeyword(List<String> wordList) {
		return sqlSession.selectList(namespace+".getMuseumInfoByKeyword", wordList);
	}

	



	
	

	
	
	

	
	
	
	
}
