package com.spov.hellodocent.domain;

public class LoginSessionDTO {

	private String user_iuid;
	private String user_isDocent;
	private String user_nick;
	private String user_photo;

	

	public LoginSessionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public LoginSessionDTO(String user_iuid, String user_isDocent, String user_nick, String user_photo) {
		super();
		this.user_iuid = user_iuid;
		this.user_isDocent = user_isDocent;
		this.user_nick = user_nick;
		this.user_photo = user_photo;
	}



	public String getUser_iuid() {
		return user_iuid;
	}
	public void setUser_iuid(String user_iuid) {
		this.user_iuid = user_iuid;
	}
	
	public String getUser_isDocent() {
		return user_isDocent;
	}
	public void setUser_isDocent(String user_isDocent) {
		this.user_isDocent = user_isDocent;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public String getUser_photo() {
		return user_photo;
	}

	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
	System.out.println("Session Info... ");
	System.out.println("user_iuid : " + user_iuid + "  " + "user_isDocent : " 
	+ user_isDocent +" " +"user_photo : " + user_photo + "user_nick" + user_nick);
		return super.toString();
	}
	
	
	
}


