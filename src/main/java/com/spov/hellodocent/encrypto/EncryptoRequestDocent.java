package com.spov.hellodocent.encrypto;

import com.spov.hellodocent.domain.RequestDocentDTO;

public class EncryptoRequestDocent extends EncryptoUtil {

	@Override
	public Object Encrypto(Object object) {
		
		RequestDocentDTO form = (RequestDocentDTO) object;
		
		try {
			
		form.setReq_email(aes256.aesEncode(form.getReq_email()));
		form.setReq_introduce(aes256.aesEncode(form.getReq_introduce()));
		form.setReq_name(aes256.aesEncode(form.getReq_name()));
		form.setReq_telnum(aes256.aesEncode(form.getReq_telnum()));
		form.setReq_professional(aes256.aesEncode(form.getReq_professional()));
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return form;
	}

	@Override
	public Object Decrypto(Object object) {
		
		RequestDocentDTO form = (RequestDocentDTO) object;
		
		try {
			
		form.setReq_email(aes256.aesDecode(form.getReq_email()));
		form.setReq_introduce(aes256.aesDecode(form.getReq_introduce()));
		form.setReq_name(aes256.aesDecode(form.getReq_name()));
		form.setReq_telnum(aes256.aesDecode(form.getReq_telnum()));
		form.setReq_professional(aes256.aesDecode(form.getReq_professional()));
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return form;
		
	}

	
	
	
}
