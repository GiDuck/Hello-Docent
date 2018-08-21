package com.spov.hellodocent.domain;

public class MemberDTO {

	private String user_nick;
	private String user_iuid;
	private String user_uid;
	private String user_email;
	private String user_loginType;
	private String user_profilePhoto;
	private String user_isDocent;

	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public String getUser_iuid() {
		return user_iuid;
	}

	public void setUser_iuid(String user_iuid) {
		this.user_iuid = user_iuid;
	}

	public String getUser_uid() {
		return user_uid;
	}

	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_loginType() {
		return user_loginType;
	}

	public void setUser_loginType(String user_loginType) {
		this.user_loginType = user_loginType;
	}

	public String getUser_profilePhoto() {
		return user_profilePhoto;
	}

	public void setUser_profilePhoto(String user_profilePhoto) {
		this.user_profilePhoto = user_profilePhoto;
	}

	public String getUser_isDocent() {
		return user_isDocent;
	}

	public void setUser_isDocent(String user_isDocent) {
		this.user_isDocent = user_isDocent;
	}
	
	

	@Override
	public String toString() {
	
		System.out.println("MEMBER DTO");
		System.out.println(user_nick+" "+user_iuid+" "+user_uid+" "+user_email+" "+user_loginType+" "+user_profilePhoto+" "+user_isDocent);
	
		return super.toString();
	}
	

}
