package com.spov.hellodocent.persistence;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spov.hellodocent.domain.MemberDTO;
import com.spov.hellodocent.domain.RequestDocentDTO;
@Repository
public class MemeberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.spov.hellodocent.mappers.memberMapper";

	@Override
	public void insertMember(MemberDTO member) {

		
		sqlSession.insert(namespace+".insertMember", member);
		
	}

	@Override
	public MemberDTO findUser(String key) {
	
		
		return sqlSession.selectOne(namespace+".findUser", key);
		
	}

	@Override
	public Map<String, String> getMemberSimpleInfo(String id) {
		
		return sqlSession.selectOne(namespace + ".getMemberSimpleInfo", id);

	}

	@Override
	public MemberDTO getMemberInfo(String uid) {

		return sqlSession.selectOne(namespace + ".getMemberInfo", uid);
	}

	@Override
	public void deleteMember(String uid) {
	
		sqlSession.delete(namespace+".deleteMemeber", uid);
		
	}

	@Override
	public void insertRequestDocent(RequestDocentDTO dto) {
	
		sqlSession.insert(namespace+".insertRequestDocent", dto);
		
	}

	@Override
	public void updateMemberInfo(Map<String, String> param) {

		sqlSession.update(namespace+".updateMemberInfo", param);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
