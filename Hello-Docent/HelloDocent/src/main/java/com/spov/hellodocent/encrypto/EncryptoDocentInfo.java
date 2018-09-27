package com.spov.hellodocent.encrypto;

import com.spov.hellodocent.domain.DocentInfoDTO;

public class EncryptoDocentInfo extends EncryptoUtil {

	@Override
	public Object Encrypto(Object object) {

		DocentInfoDTO info = (DocentInfoDTO)object;
		
		try {
		info.setDi_carrer(aes256.aesEncode(info.getDi_carrer()));
				
		if(info.getDi_introduce()!=null) {
		info.setDi_introduce(aes256.aesEncode(info.getDi_introduce()));}
		
		if(info.getDi_certificationPath()!=null) {
		info.setDi_certificationPath(aes256.aesEncode(info.getDi_certificationPath()));}


		}catch(Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public Object Decrypto(Object object) {
	DocentInfoDTO info = (DocentInfoDTO)object;
		
		try {
		info.setDi_carrer(aes256.aesDecode(info.getDi_carrer()));
		
		if(info.getDi_introduce()!=null) {
		info.setDi_introduce(aes256.aesDecode(info.getDi_introduce()));}
		
		if(info.getDi_certificationPath()!=null) {
		info.setDi_certificationPath(aes256.aesDecode(info.getDi_certificationPath()));}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return info;	}

	
	
}
