package com.spov.hellodocent.persistence;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spov.hellodocent.domain.MuseumEventDTO;

@Repository
public class MuseumDAOImpl implements MuseumDAO {

	@Inject
	private SqlSession sqlSession;
	

	
	private static final String namespace = "com.spov.hellodocent.mappers.museumMapper";



	@Override
	public String findMuseumKey(String name) {
		return sqlSession.selectOne(namespace+".selectMuseumKey", name);

	}


	@Override
	public List<MuseumEventDTO> getMuseumEvents() {

		return sqlSession.selectList(namespace+".getMuseumEvents");
	}

	@Override
	public String getMuseumType(String id) {

		
		return sqlSession.selectOne(namespace+".getMuseumType", id);
	}
	

	@Override
	public List<MuseumEventDTO> getLimitMuseumEvent() {

		return sqlSession.selectList(namespace+".getMuseumEventsLimit"); 
	}

	@Override
	public List<String> getLocalList() {
		
		return sqlSession.selectList(namespace+".getMuseumLocalList");
	}

	@Override
	public List<String> getPlaceList(String keyword) {
		
		return sqlSession.selectList(namespace+".getMuseumPlaceList", keyword);
	}

	@Override
	public List<MuseumEventDTO> getMuseumEventForQuery(Map<String, Object> container) {
		return sqlSession.selectList(namespace+".getMuseumEventsQuery", container);
	}

	@Override
	public List<Map<String, String>> getMuseumPlaceFullList(Map<String, String> container) {
	
		return sqlSession.selectList(namespace+".getMuseumPlaceFullList", container);
	}
	
	@Override
	public List<Map<String, String>> getMuseumPlaceFullListByIds(List<String> container) {
	
		return sqlSession.selectList(namespace+".getMuseumPlaceFullListByIds", container);
	}
	

	@Override
	public List<Map<String, String>> getGeoLocation(Map<String, String> container) {
		return sqlSession.selectList(namespace+".selectGeoLocation", container);
	}

	@Override
	public Map<String, String> getMuseumDetailInfo(String id) {
		return sqlSession.selectOne(namespace+".getMuseumDetailInfo", id);
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
