package com.spov.hellodocent.encrypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AES256Cipher {
	private static volatile AES256Cipher INSTANCE;

	final static String secretKey = "1234567891234567"; //32bit
	static String IV = ""; //16bit

	public static AES256Cipher getInstance() {
		if (INSTANCE == null) {
			synchronized (AES256Cipher.class) {
				if (INSTANCE == null)
					INSTANCE = new AES256Cipher();
			}
		}
		return INSTANCE;
	}

	private AES256Cipher() {
		IV = secretKey.substring(0, 16);
	}

	//암호화
	public static String AES_Encode(String str) {
		String encodedString = null;
		try {
			byte[] keyData = secretKey.getBytes();
			SecretKey secureKey = new SecretKeySpec(keyData, "AES");

			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));

			byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
			encodedString = new String(Base64.encodeBase64(encrypted));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedString;
	}

	//복호화
	public static String AES_Decode(String str) {
		String decodedString = null;
		try {
			byte[] keyData = secretKey.getBytes();
			SecretKey secureKey = new SecretKeySpec(keyData, "AES");

			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));

			byte[] byteStr = Base64.decodeBase64(str.getBytes());
			decodedString = new String(c.doFinal(byteStr), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decodedString;
	}
}