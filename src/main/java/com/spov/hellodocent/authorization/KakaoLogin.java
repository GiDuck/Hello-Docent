package com.spov.hellodocent.authorization;

import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spov.hellodocent.domain.KakaoDTO;
import com.spov.hellodocent.domain.MemberDTO;
import com.spov.hellodocent.encrypto.EncryptoMember;
import com.spov.hellodocent.tools.UidMaker;

public class KakaoLogin implements OAuthLogin {

	private String client_id;
	private String secret_code;
	private String scope;
	private String redirectUri;
	private String kakao_based_Uri;

	private String accessToken;
	private String refreshToken;
	private String typeToken;

	private MemberDTO memberDto;

	@Override
	public String URLBuildUp() {

		StringBuffer baseURL = new StringBuffer(kakao_based_Uri);
		baseURL.append("/oauth/authorize?client_id=").append(client_id).append("&").append("redirect_uri=")
				.append(redirectUri).append("&").append("response_type=code");

		String requestURL = baseURL.toString();
		System.out.println("/kakao url build, url : " + requestURL);

		return requestURL;
	}

	@Override
	public void GetAccessToken(String code) {

		System.out.println("Kakao Access Token Get Method.....");
		StringBuffer baseURL = new StringBuffer(kakao_based_Uri);
		baseURL.append("/oauth/token");

		String requestUri = baseURL.toString();

		HttpHeaders headers = new HttpHeaders();

		System.out.println("request get AccessToken : " + requestUri);

		System.out.println(code + " " + client_id + " " + redirectUri + " " + secret_code);

		RestTemplate template = new RestTemplate();
		MultiValueMap<String, String> post_param = new LinkedMultiValueMap<String, String>();
		post_param.add("grant_type", "authorization_code");
		post_param.add("client_id", client_id);
		post_param.add("redirect_uri", redirectUri);
		post_param.add("code", code);
		post_param.add("client_secret", secret_code);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(post_param,
				headers);

		ResponseEntity<String> response = template.postForEntity(requestUri, request, String.class);
		System.out.println("kakao response header code... : " + response.getStatusCode());

		try {
			ObjectMapper mapper = new ObjectMapper();
			HashMap<String, String> param = (mapper.readValue(response.getBody(),
					new TypeReference<HashMap<String, String>>() {
					}));
			System.out.println("kakao accessToken..... " + param.get("access_token"));
			System.out.println("kakao refreshToken.... " + param.get("refresh_token"));
			System.out.println("kakao expires time..... " + param.get("expires_in"));
			System.out.println("Authorization Type..... " + param.get("token_type"));

			accessToken = param.get("access_token");
			typeToken = param.get("token_type");

			Long expired = Long.valueOf(param.get("expires_in"));
			String refreshToken = param.get("refresh_token");
			if (expired > System.currentTimeMillis() && refreshToken != null) {

				System.out.println("Kakao token was expired... Request refreshToken to Kakao..");

				post_param = new LinkedMultiValueMap<String, String>();
				post_param.add("grant_type", "authorization_code");
				post_param.add("client_id", client_id);
				post_param.add("refresh_token", refreshToken);
				post_param.add("client_secret", secret_code);

				response = template.postForEntity(requestUri, post_param, String.class);

			} else if (expired < System.currentTimeMillis() && refreshToken == null) {

				System.out.println("토큰 유효기간이 만료 되었으나 RefreshToken이 없습니다.");

			}

			System.out.println("현재 엑세스 토큰은? : " + typeToken + " " + accessToken);

			template = new RestTemplate();
			HttpHeaders setHeader = new HttpHeaders();
			setHeader.set("Authorization", "bearer" + " " + accessToken);
			setHeader.set("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			setHeader.set("Accept", "application/json");

			System.out.println("made header token : ... " + setHeader.getAccept());
			System.out.println("made header token : ... " + setHeader.getContentType());
			System.out.println("made header token : ... " + setHeader.toString());

			baseURL = new StringBuffer("https://kapi.kakao.com").append("/v2/user/me");
			requestUri = baseURL.toString();
			HttpEntity request1 = new HttpEntity(setHeader);

			// HttpEntity<String> newentitiy= new HttpEntity<String>(setHeader);

			response = template.exchange(requestUri, HttpMethod.POST, request1, String.class);
			System.out.println(response.getBody());

			Gson gson = new GsonBuilder().create();

			@SuppressWarnings("unchecked")
			KakaoDTO newParam = gson.fromJson(response.getBody(), KakaoDTO.class);

			
			memberDto = new MemberDTO();
			memberDto.setUser_loginType("kakao");
			memberDto.setUser_profilePhoto(newParam.getProperties().get("profile_image"));
			memberDto.setUser_nick(newParam.getProperties().get("nickname"));
			memberDto.setUser_uid(String.valueOf(newParam.getId()));
			memberDto.setUser_iuid(UidMaker.getUUid());
			memberDto.setUser_isDocent("audience");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Override
	public MemberDTO GetUserInfo() {

		return (MemberDTO) new EncryptoMember().Encrypto(memberDto);

	}

	@Override
	public boolean RevokeToken(String accessToken) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	/*Inject을 위한 Setters*/
	


	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}


	public void setSecret_code(String secret_code) {
		this.secret_code = secret_code;
	}



	public void setScope(String scope) {
		this.scope = scope;
	}


	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}


	public void setKakao_based_Uri(String kakao_based_Uri) {
		this.kakao_based_Uri = kakao_based_Uri;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
