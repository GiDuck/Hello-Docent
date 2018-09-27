package com.spov.hellodocent.persistence;

import com.spov.hellodocent.domain.DocentInfoDTO;

public interface DocentDAO {

	
	public void docentInfoUpdate(DocentInfoDTO info);
	public DocentInfoDTO getDocentInfo(String id);
	
	
}
