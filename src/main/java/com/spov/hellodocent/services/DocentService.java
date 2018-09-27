package com.spov.hellodocent.services;

import com.spov.hellodocent.domain.DocentInfoDTO;

public interface DocentService {

	public void docentInfoUpdate(DocentInfoDTO info);
	public DocentInfoDTO getDocentInfo(String id);
	
}
