package com.spov.hellodocent.services;

import java.util.Date;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spov.hellodocent.domain.MemberDTO;
import com.spov.hellodocent.domain.RequestDocentDTO;
import com.spov.hellodocent.encrypto.EncryptoRequestDocent;
import com.spov.hellodocent.encrypto.EncryptoString;
import com.spov.hellodocent.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberdao;

	@Override
	public void insertMember(MemberDTO member) {

		try {
			memberdao.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberDTO findUser(String key) {

		MemberDTO return_key = null;
		try {
			return_key = memberdao.findUser(key);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return return_key;
	}

	@Override
	public Map<String, String> getMemberSimpleInfo(String id) {
	
		return memberdao.getMemberSimpleInfo(id);
	}

	@Override
	public MemberDTO getMemberInfo(String uid) {
		return memberdao.getMemberInfo(uid);
	}

	@Override
	public void deleteMember(String uid) {
	
		memberdao.deleteMember(uid);
		
	}

	@Override
	public void insertRequestDocent(RequestDocentDTO dto) {

		dto.setReq_date(new Date());
		memberdao.insertRequestDocent((RequestDocentDTO) new EncryptoRequestDocent().Encrypto(dto));
		
	}

	@Override
	public void updateMemberInfo(Map<String, String> param) {
	
		EncryptoString encrypto = new EncryptoString();
		
		param.put("nickname", (String)encrypto.Encrypto(param.get("nickname")));
		param.put("email", (String)encrypto.Encrypto(param.get("email")));
		param.put("profilePhoto", (String)encrypto.Encrypto(param.get("profilePhoto")));

		System.out.println("들어가는 map : " + param);
		
		memberdao.updateMemberInfo(param);
		
	}
	
	
	

	
	
	
	
	
	
}
