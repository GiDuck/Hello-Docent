package com.spov.hellodocent.conf;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value="session")
@Component("sessionContext")
public class SessionContext {

	private String user_iuid;
	private String user_isDocent;
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
	
	
	
	
	
}
