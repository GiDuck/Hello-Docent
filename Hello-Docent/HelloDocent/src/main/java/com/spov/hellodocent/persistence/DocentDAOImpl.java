package com.spov.hellodocent.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spov.hellodocent.domain.DocentInfoDTO;

@Repository
public class DocentDAOImpl implements DocentDAO {

	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.spov.hellodocent.mappers.docentMapper";

	@Override
	public void docentInfoUpdate(DocentInfoDTO info) {
		sqlSession.update(namespace+".docentInfoUpdate", info);
	}

	@Override
	public DocentInfoDTO getDocentInfo(String id) {
		
		return sqlSession.selectOne(namespace+".getDocentInfo", id);
	}
	
	
	
	
	
	
}
