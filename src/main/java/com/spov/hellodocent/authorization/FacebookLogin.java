package com.spov.hellodocent.authorization;

import org.apache.log4j.Logger;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;

import com.spov.hellodocent.domain.MemberDTO;
import com.spov.hellodocent.encrypto.EncryptoMember;
import com.spov.hellodocent.tools.UidMaker;

public class FacebookLogin implements OAuthLogin {

	private static Logger logger = Logger.getLogger(FacebookLogin.class);
	
	// 페이스북 oAuth 관련
	private FacebookConnectionFactory facebookConnectionFactory;

	// oAuth2 인증 절차에 필요한 파라미터값들을 전달
	private OAuth2Parameters oAuth2Parameters;
	
	private String accessToken;
	private AccessGrant accessGrant;
	
	
	

	public FacebookLogin(FacebookConnectionFactory facebookConnectionFactory, OAuth2Parameters oAuth2Parameters) {
		this.facebookConnectionFactory = facebookConnectionFactory;
		this.oAuth2Parameters = oAuth2Parameters;
	}

	@Override
	public String URLBuildUp() {
		OAuth2Operations oauthOperations = facebookConnectionFactory.getOAuthOperations();
		String facebook_url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, oAuth2Parameters);
		System.out.println("/facebook url build, url : " + facebook_url);

		
		
		return facebook_url;
	}

	@Override
	public void GetAccessToken(String code) {
		try {
			 String redirectUri = oAuth2Parameters.getRedirectUri();
			System.out.println("페이스북 콜백 진입");
			System.out.println("Redirect URI : " + redirectUri);
			System.out.println("Code : " + code);

			OAuth2Operations oauthOperations = facebookConnectionFactory.getOAuthOperations();
			accessGrant = oauthOperations.exchangeForAccess(code, redirectUri, null);
			accessToken = accessGrant.getAccessToken();
			System.out.println("AccessToken: " + accessToken);
			Long expireTime = accessGrant.getExpireTime();
		
			
			if (expireTime != null && expireTime < System.currentTimeMillis()) {
				accessToken = accessGrant.getRefreshToken();
				System.out.println("accessToken is expired. refresh token = {}"+ accessToken);
			};
					
		
		} catch (Exception e) {

			e.printStackTrace();

		}
		
		
	}

	@Override
	public MemberDTO GetUserInfo() {
		// TODO Auto-generated method stub
		Connection<Facebook> connection = facebookConnectionFactory.createConnection(accessGrant);
		Facebook facebook = connection == null ? new FacebookTemplate(accessToken) : connection.getApi();
		UserOperations userOperations = facebook.userOperations();
		MemberDTO member = new MemberDTO();
		try

		{
		
			String [] fields = { "id", "email",  "name"};
			User userProfile = facebook.fetchObject("me", User.class, fields);
			System.out.println("유저이메일 : " + userProfile.getEmail());
			System.out.println("유저 id : " + userProfile.getId());
			System.out.println("유저 name : " + userProfile.getName());
			
			member.setUser_loginType("facebook");
			member.setUser_email(userProfile.getEmail());
			member.setUser_uid(userProfile.getId());
			member.setUser_nick(userProfile.getName());
			member.setUser_iuid(UidMaker.getUUid());
			member.setUser_isDocent("audience");


		
			
		} catch (MissingAuthorizationException e) {
			e.printStackTrace();
			member = null;
		}
		
		return (MemberDTO) new EncryptoMember().Encrypto(member);
		
		
		
	}

	@Override
	public boolean RevokeToken(String accessToken) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getAccessToken() {
		return accessToken;
	}

	
	
	

}
