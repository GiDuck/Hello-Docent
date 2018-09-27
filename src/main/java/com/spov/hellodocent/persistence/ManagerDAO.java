package com.spov.hellodocent.persistence;

import java.util.List;

import com.spov.hellodocent.domain.DocentInfoDTO;
import com.spov.hellodocent.domain.RequestDocentDTO;

public interface ManagerDAO {

	public List<RequestDocentDTO> getRequestDocent();
	
	public RequestDocentDTO getRequestDocentOne(String req_id);
	
	public void removeRequestDocent(String req_id);
	
	public void updateIsDocent(String uid);
	
	public void insertDocentInfo(DocentInfoDTO info);
	
	public void updateDocentInfo(DocentInfoDTO info);
}
