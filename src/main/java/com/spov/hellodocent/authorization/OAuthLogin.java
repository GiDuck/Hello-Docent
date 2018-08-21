package com.spov.hellodocent.authorization;

import com.spov.hellodocent.domain.MemberDTO;

public interface OAuthLogin {
	
	public String URLBuildUp();
	public void GetAccessToken(String code);
	public MemberDTO GetUserInfo();
	public boolean RevokeToken(String accessToken);
	

}
