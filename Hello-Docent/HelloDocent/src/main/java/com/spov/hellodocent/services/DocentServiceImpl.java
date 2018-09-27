package com.spov.hellodocent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spov.hellodocent.domain.DocentInfoDTO;
import com.spov.hellodocent.persistence.DocentDAO;

@Service
public class DocentServiceImpl implements DocentService {

	@Autowired
	private DocentDAO docentDAO; 
	
	
	@Override
	public void docentInfoUpdate(DocentInfoDTO info) {
		docentDAO.docentInfoUpdate(info);		
	}

	@Override
	public DocentInfoDTO getDocentInfo(String id) {
		return 	docentDAO.getDocentInfo(id);		

	}

	
	
	
}
