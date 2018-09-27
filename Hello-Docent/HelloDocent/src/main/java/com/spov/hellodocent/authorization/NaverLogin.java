package com.spov.hellodocent.authorization;

import java.util.HashMap;
import java.util.Map;

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
import com.spov.hellodocent.domain.MemberDTO;
import com.spov.hellodocent.encrypto.EncryptoMember;
/*

네이버 소셜 로그인과 관련된 작업을 하는 클래스임.

*/
import com.spov.hellodocent.tools.UidMaker;

public class NaverLogin implements OAuthLogin {

	private String client_id;
	private String secret_code;
	private String scope;
	private String redirectUri;
	private String naver_based_Uri;
	private String naver_request_profile_Uri;

	private String accessToken;
	private String refreshToken;
	private String typeToken;
	private String state;

	private MemberDTO memberDto;

	@Override
	public String URLBuildUp() {

		
		state = UidMaker.getUid();
		StringBuffer baseURL = new StringBuffer(naver_based_Uri);
		baseURL.append("/authorize?").append("response_type=code&").append("client_id=").append(client_id).append("&")
				.append("redirect_uri=").append(redirectUri).append("&").append("state=").append(state);

		String requestURL = baseURL.toString();
		System.out.println("/naver url build, url : " + requestURL);

		return requestURL;
	}

	@Override
	public void GetAccessToken(String code) {

		//인증된 Code가 parameter로 들어온다.
		System.out.println("Naver Access Token Get Method.....");
		StringBuffer baseURL = new StringBuffer(naver_based_Uri);
		baseURL.append("/authorize");

		String requestUri = baseURL.toString();

		System.out.println("request get AccessToken : " + requestUri);
		System.out.println(code + " " + client_id + " " + redirectUri + " " + secret_code);

		RestTemplate template = new RestTemplate();
		MultiValueMap<String, String> post_param = new LinkedMultiValueMap<String, String>();
		

		//header를 utf-8로 맞추고 url은 인코딩 함.
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		
		
		//네이버사로 AccessToken을 요청한다.
		baseURL = new StringBuffer(naver_based_Uri);
		baseURL.append("/token?").append("client_id=").append(client_id).append("&").append("client_secret=")
				.append(secret_code).append("&").append("grant_type=authorization_code").append("&").append("state=")
				.append(state).append("&").append("code=").append(code);

		HttpEntity<String> entity = new HttpEntity<String>(headers);


		ResponseEntity<String> response = template.exchange(baseURL.toString(), HttpMethod.GET, entity, String.class);

		System.out.println("naver response header code... : " + response.getHeaders());
		System.out.println(response.getBody());

		//받아온 AccessToken과 메타정보를 꺼낸다.
		try {
			ObjectMapper mapper = new ObjectMapper();
			HashMap<String, String> param = (mapper.readValue(response.getBody(),
					new TypeReference<HashMap<String, String>>() {
					}));
			System.out.println("naver accessToken..... " + param.get("access_token"));
			System.out.println("naver refreshToken.... " + param.get("refresh_token"));
			System.out.println("naver expires time..... " + param.get("expires_in"));
			System.out.println("Authorization Type..... " + param.get("token_type"));

			accessToken = param.get("access_token");
			typeToken = param.get("token_type");

			Long expired = Long.valueOf(param.get("expires_in"));
			String refreshToken = param.get("refresh_token");

			//만약 AccessToken이 만료되었다면 RefreshToken을 사용해 재요청.
			if (expired > System.currentTimeMillis() && refreshToken != null) {

				System.out.println("Naver token was expired... Request refreshToken to Kakao..");

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
			System.out.println("요청 uri : " + naver_request_profile_Uri);
			
			//받아온 AccessToken을 다시 네이버사로 요청하여 사용자에 대한 정보를 받아온다.
			HttpHeaders setHeader = new HttpHeaders();
			setHeader.set("Authorization","Bearer " + accessToken);
			setHeader.set("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			setHeader.set("Pragma", "no-cache");
			entity = new HttpEntity<String>(setHeader);
			response = template.exchange(naver_request_profile_Uri, HttpMethod.GET, entity, String.class);


			System.out.println("Get Data for Users... naver.... : " + response.getBody());

			
			//Json Format으로 들어온 데이터를 파싱한다.
			
			Gson gson = new Gson();	
			
			@SuppressWarnings("unchecked")
			Map<String, Map> memberInfo = gson.fromJson(response.getBody(), Map.class);
			
			System.out.println(memberInfo);		
			System.out.println(memberInfo.get("message"));
			System.out.println(memberInfo.get("response").get("nickname"));
			
			Map<String, String>container = memberInfo.get("response");
			
			System.out.println(container);
			memberDto = new MemberDTO();
			memberDto.setUser_email(container.get("email"));
			memberDto.setUser_loginType("naver");
			memberDto.setUser_profilePhoto(container.get("profile_image"));
			memberDto.setUser_nick(container.get("nickname"));
			memberDto.setUser_isDocent("audience");
			memberDto.setUser_uid(container.get("id"));
			memberDto.setUser_iuid(UidMaker.getUid());
			
			
			
			
			
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

	@Override
	public MemberDTO GetUserInfo() {
			
		return  (MemberDTO)new EncryptoMember().Encrypto(memberDto);
	}

	@Override
	public boolean RevokeToken(String accessToken) {
		// TODO Auto-generated method stub
		return false;
	}

	/* --------------------- Bean Inject를 위한 setters ----------------------- */


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



	public void setNaver_based_Uri(String naver_based_Uri) {
		this.naver_based_Uri = naver_based_Uri;
	}



	public void setNaver_request_profile_Uri(String naver_request_profile_Uri) {
		this.naver_request_profile_Uri = naver_request_profile_Uri;
	}

}
