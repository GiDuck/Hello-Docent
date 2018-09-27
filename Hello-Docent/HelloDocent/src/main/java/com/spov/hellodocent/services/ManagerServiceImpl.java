package com.spov.hellodocent.services;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spov.hellodocent.domain.DocentInfoDTO;
import com.spov.hellodocent.domain.RequestDocentDTO;
import com.spov.hellodocent.persistence.ManagerDAO;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Inject
	private ManagerDAO managerDAO;
	
	@Override
	public List<RequestDocentDTO> getRequestDocent() {

		return managerDAO.getRequestDocent();
	}

	@Override
	public RequestDocentDTO getRequestDocentOne(String req_id) {
		return managerDAO.getRequestDocentOne(req_id);
	}

	@Override
	public void removeRequestDocent(String req_id) {
		 managerDAO.removeRequestDocent(req_id);		
	}

	@Override
	public void updateIsDocent(String uid) {
		 managerDAO.updateIsDocent(uid);		
	}

	@Override
	public void insertDocentInfo(DocentInfoDTO info) {
		 managerDAO.insertDocentInfo(info);		
		
	}

	@Override
	public void updateDocentInfo(DocentInfoDTO info) {
		 managerDAO.updateDocentInfo(info);		
		
	}
	
	public void approveDocentInvoker(RequestDocentDTO reqDto) {
		
		DocentInfoDTO info = new DocentInfoDTO();
		info.setDi_carrer(reqDto.getReq_professional());
		info.setDi_introduce(reqDto.getReq_introduce());
		info.setDi_vertifiedTime(new Date());
		info.setDi_iuid(reqDto.getReq_id());
		info.setDi_certificationPath(null);
		
		
		
		managerDAO.insertDocentInfo(info);
		managerDAO.updateIsDocent(info.getDi_iuid());
		managerDAO.removeRequestDocent(info.getDi_iuid());
		managerDAO.updateIsDocent(info.getDi_iuid());
		
		
	}

	
	
	
	
}
