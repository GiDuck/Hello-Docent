package com.spov.hellodocent.encrypto;

/*

검색을 위해 Keyword를 보내야 할 때 암호화 및 복호화를 하는 클래스.

*/
public class EncryptoString extends EncryptoUtil {
		

	public EncryptoString() {
		super();
	}

	@Override
	public Object Encrypto(Object object) {

		String search_key = (String)object;
		try {
			search_key = aes256.aesEncode(search_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return search_key;
	}

	@Override
	public Object Decrypto(Object object) {
		
		String search_key=null;
		System.out.println("byte Length : " + ((String)object).getBytes().length);
		
		try {
			search_key = aes256.aesDecode((String)object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return search_key;
	}
	
	
	/*public EncryptoString() {
		super();
	}

	@Override
	public Object Encrypto(Object object) {

		String search_key = (String)object;
		try {
			search_key = codec.encode(aes256.aesEncode(search_key));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return search_key;
	}

	@Override
	public Object Decrypto(Object object) {
		
		String search_key=null;
		System.out.println("byte Length : " + ((String)object).getBytes().length);
		
		try {
			search_key = aes256.AES_Decode((String)object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return search_key;
	}*/
	
	

}
