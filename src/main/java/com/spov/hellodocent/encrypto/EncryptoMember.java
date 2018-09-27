package com.spov.hellodocent.encrypto;

import com.spov.hellodocent.domain.MemberDTO;
import com.spov.hellodocent.tools.UidMaker;

/*
 
MemberDTO를 주고 받을 때 암호화 및 복호화를 하는 클래스.

*/
public class EncryptoMember extends EncryptoUtil {

	
	public EncryptoMember() {

		super();
	}

	
	@Override
	public Object Encrypto(Object object) {

		
			MemberDTO member = (MemberDTO)object;
			
		
			
			
			try {

				//aes256.aesEncode(loginidx)
				if(member.getUser_profilePhoto()!=null) {
				member.setUser_profilePhoto(aes256.aesEncode(member.getUser_profilePhoto()));}
				
				if(member.getUser_email()!=null) {
				member.setUser_email(aes256.aesEncode(member.getUser_email()));}
				
				member.setUser_iuid(aes256.aesEncode(UidMaker.getUUid()));
				member.setUser_isDocent(aes256.aesEncode(member.getUser_isDocent()));
				member.setUser_nick(aes256.aesEncode(member.getUser_nick()));
				member.setUser_loginType(aes256.aesEncode(member.getUser_loginType()));
				member.setUser_uid(aes256.aesEncode(member.getUser_uid()));
				
				System.out.println("암호화 결과 : " + member.getUser_email() + " " +member.getUser_isDocent() + " " + 
						member.getUser_iuid() + " " + member.getUser_nick() + " " + member.getUser_profilePhoto() + " " +
						member.getUser_uid() );
			
				System.out.println("암호화 결과 : " + " " +member.getUser_isDocent().getBytes().length + " " + 
						member.getUser_iuid().getBytes().length + " " + member.getUser_nick().getBytes().length + " "+
						member.getUser_uid().getBytes().length );
				
				
				//aes256.aesEncode(loginidx)
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		
		
		return member;
	}

	
	
	

	@Override
	public Object Decrypto(Object object) {
		
		MemberDTO member = (MemberDTO)object;
		
		
		try {
			
			if(member.getUser_profilePhoto()!=null) {
				member.setUser_profilePhoto(aes256.aesDecode(member.getUser_profilePhoto()));}
				
			if(member.getUser_email()!=null) {
				member.setUser_email(aes256.aesDecode(member.getUser_email()));}
		
			member.setUser_iuid(aes256.aesDecode(member.getUser_iuid()));
			member.setUser_isDocent(aes256.aesDecode(member.getUser_isDocent()));
			member.setUser_nick(aes256.aesDecode(member.getUser_nick()));
			member.setUser_loginType(aes256.aesDecode(member.getUser_loginType()));
			member.setUser_uid(aes256.aesDecode(member.getUser_uid()));
			
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return member;
	}
	
/*	public EncryptoMember() {

		super();
	}

	
	@Override
	public Object Encrypto(Object object) {

		
			MemberDTO member = (MemberDTO)object;
			
		
			
			
			try {

				//aes256.aesEncode(loginidx)
				if(member.getUser_profilePhoto()!=null) {
				member.setUser_profilePhoto(codec.encode(aes256.aesEncode(member.getUser_profilePhoto())));}
				
				if(member.getUser_email()!=null) {
				member.setUser_email(aes256.aesEncode(member.getUser_email()));}
				
				member.setUser_iuid(aes256.aesEncode(UidMaker.getUid()));
				member.setUser_isDocent(codec.encode(aes256.aesEncode(member.getUser_isDocent())));
				member.setUser_nick(codec.encode(aes256.aesEncode(member.getUser_nick())));
				member.setUser_loginType(codec.encode(aes256.aesEncode(member.getUser_loginType())));
				member.setUser_uid(codec.encode(aes256.aesEncode(member.getUser_uid())));
				
				System.out.println("암호화 결과 : " + member.getUser_email() + " " +member.getUser_isDocent() + " " + 
						member.getUser_iuid() + " " + member.getUser_nick() + " " + member.getUser_profilePhoto() + " " +
						member.getUser_uid() );
			
				System.out.println("암호화 결과 : " + " " +member.getUser_isDocent().getBytes().length + " " + 
						member.getUser_iuid().getBytes().length + " " + member.getUser_nick().getBytes().length + " "+
						member.getUser_uid().getBytes().length );
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		
		
		return member;
	}

	
	
	

	@Override
	public Object Decrypto(Object object) {
		
		MemberDTO member = (MemberDTO)object;
		
		
		try {
			
			if(member.getUser_profilePhoto()!=null) {
				member.setUser_profilePhoto(aes256.aesDecode(member.getUser_profilePhoto()));}
				
			if(member.getUser_email()!=null) {
				member.setUser_email(aes256.aesDecode(member.getUser_email()));}
		
			member.setUser_iuid(UidMaker.getUid());
			member.setUser_isDocent(aes256.aesDecode(member.getUser_isDocent()));
			member.setUser_nick(aes256.aesDecode(member.getUser_nick()));
			member.setUser_loginType(aes256.aesDecode(member.getUser_loginType()));
			member.setUser_uid(member.getUser_uid());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return member;
	}
	*/
	
	

}
