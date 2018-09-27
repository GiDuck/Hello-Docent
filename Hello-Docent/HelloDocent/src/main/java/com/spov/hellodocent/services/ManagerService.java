package com.spov.hellodocent.services;

import java.util.List;

import com.spov.hellodocent.domain.DocentInfoDTO;
import com.spov.hellodocent.domain.RequestDocentDTO;

public interface ManagerService {
	
	public List<RequestDocentDTO> getRequestDocent();
	
	public RequestDocentDTO getRequestDocentOne(String req_id);
	
	public void removeRequestDocent(String req_id);
	
	public void updateIsDocent(String uid);
	
	public void insertDocentInfo(DocentInfoDTO info);
	
	public void updateDocentInfo(DocentInfoDTO info);
	
	public void approveDocentInvoker(RequestDocentDTO reqDto);

	
}
