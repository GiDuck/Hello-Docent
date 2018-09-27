package com.spov.hellodocent.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spov.hellodocent.domain.DocentInfoDTO;
import com.spov.hellodocent.domain.RequestDocentDTO;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.spov.hellodocent.mappers.managerMapper";

	@Override
	public List<RequestDocentDTO> getRequestDocent() {

		return sqlSession.selectList(namespace+".getRequestDocentList");
	}

	@Override
	public RequestDocentDTO getRequestDocentOne(String req_id) {
	
		return sqlSession.selectOne(namespace+".getRequestDocentOne", req_id);
	
	}

	@Override
	public void removeRequestDocent(String req_id) {
		sqlSession.delete(namespace+".removeRequestDocent", req_id);
		
	}

	@Override
	public void updateIsDocent(String uid) {
		sqlSession.update(namespace+".updateIsDocent", uid);
		
	}

	@Override
	public void insertDocentInfo(DocentInfoDTO info) {
		sqlSession.update(namespace+".insertDocentInfo", info);
		
	}

	@Override
	public void updateDocentInfo(DocentInfoDTO info) {
		sqlSession.update(namespace+".updateDocentInfo", info);
		
	} 
	
	
	
	
	
}
