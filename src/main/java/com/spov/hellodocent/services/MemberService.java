package com.spov.hellodocent.services;

import java.util.Map;

import com.spov.hellodocent.domain.MemberDTO;
import com.spov.hellodocent.domain.RequestDocentDTO;

public interface MemberService {
	
	public void insertMember(MemberDTO member);
	public MemberDTO findUser(String key);
	public Map<String, String> getMemberSimpleInfo(String id);
	public MemberDTO getMemberInfo(String uid);
	public void deleteMember(String uid);
	public void insertRequestDocent(RequestDocentDTO dto);
	public void updateMemberInfo(Map<String, String> param);

}
