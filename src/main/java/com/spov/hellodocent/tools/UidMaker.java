package com.spov.hellodocent.tools;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

public class UidMaker {

	
	private static SecureRandom random = new SecureRandom();
	
	
	public static String getUid() {
		
		return String.valueOf(new BigInteger(130, random).toString());
		
	}
	
	public static String getUUid() {
		
		return UUID.randomUUID().toString();
		
	}
	
	
}
