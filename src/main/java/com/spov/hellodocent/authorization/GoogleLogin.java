package com.spov.hellodocent.authorization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;

import com.spov.hellodocent.domain.MemberDTO;
import com.spov.hellodocent.encrypto.EncryptoMember;
import com.spov.hellodocent.tools.UidMaker;

public class GoogleLogin implements OAuthLogin {

	
	private GoogleConnectionFactory googleConnectionFactory;

	private OAuth2Parameters googleOAuth2Parameters;

	private OAuth2Operations oauthOperations;

	private Connection<Google> connection;

	private Google google;

	private PlusOperations plusOperations;

	private String accessToken;
	
	public GoogleLogin(GoogleConnectionFactory googleConnectionFactory, OAuth2Parameters googleOAuth2Parameters) {

		this.googleConnectionFactory = googleConnectionFactory;
		this.googleOAuth2Parameters = googleOAuth2Parameters;

	}

		
	@Override
	public String URLBuildUp() {
		
		oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		System.out.println("/google url build, url : " + url);
		return url;

	}





	@Override
	public void GetAccessToken(String code) {
		oauthOperations = googleConnectionFactory.getOAuthOperations();

		System.out.println("구글 콜백");
		System.out.println("Code : " + code);
		
		accessToken = null;

		try {
			AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, googleOAuth2Parameters.getRedirectUri(),
					null);

			accessToken = accessGrant.getAccessToken();
			Long expireTime = accessGrant.getExpireTime();

			if (expireTime != null && expireTime < System.currentTimeMillis()) {
				accessToken = accessGrant.getRefreshToken();
				System.out.printf("accessToken is expired. refresh token = {}", accessToken);

			}
			
			System.out.println("Access Token : " + accessToken);

			connection = googleConnectionFactory.createConnection(accessGrant);
			google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}





	@Override
	public MemberDTO GetUserInfo() {

		plusOperations = google.plusOperations();
		Person profile = plusOperations.getGoogleProfile();
		MemberDTO member = new MemberDTO();
		System.out.println("User Uid : " + profile.getId());
		System.out.println("User Name : " + profile.getDisplayName());
		System.out.println("User Email : " + profile.getAccountEmail());
		System.out.println("User Profile : " + profile.getImageUrl());
		
	
		member.setUser_uid(profile.getId());
		member.setUser_loginType("google");
		//TODO 만약 이름값이 NULL값이면 디폴트 닉네임을 넣도록 설정
		member.setUser_nick(profile.getDisplayName());
		member.setUser_email(profile.getAccountEmail());
		//TODO 만약 이미지가 NULL값이면 디폴트 이미지 URL을 넣도록 설정
		member.setUser_profilePhoto(profile.getImageUrl());
		member.setUser_iuid(UidMaker.getUUid());
		member.setUser_isDocent("audience");

		return (MemberDTO) new EncryptoMember().Encrypto(member);
		
	}





	@Override
	public boolean RevokeToken(String accessToken) {
		
		boolean isSuccess = false;
		System.out.println("Closing Token....");
		String revokeUrl = "https://accounts.google.com/o/oauth2/revoke?token=" + accessToken + "";
		
		try {
		URL url = new URL(revokeUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setDoOutput(true);

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	
		isSuccess = true;
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		return isSuccess;
			
	}


	public String getAccessToken() {
		return accessToken;
	}


	
	
	




}
