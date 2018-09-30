package com.spov.hellodocent.encrypto;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.net.URLCodec;

public abstract class EncryptoUtil {

	private final String key = "vlwkskfkclzlsrhdwnrychsclzlsakatmxjcl"; // 피자나라치킨공주교촌치킨맘스터치

	protected AES256Util aes256;
	protected URLCodec codec;

	public EncryptoUtil() {
		super();
		try {
			aes256 = new AES256Util(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		codec =  new URLCodec();
	
	}
	
	
	public abstract Object Encrypto(Object object);
	public abstract Object Decrypto(Object object);
	
	
	
	
	
	
	

}
