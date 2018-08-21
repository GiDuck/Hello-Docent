package com.spov.hellodocent.tools;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class HttpCommunicator {
	
	
	
	private RestTemplate template;
	private HttpEntity<MultiValueMap<String, String>> request;
	private ResponseEntity<String> response;
	
	public HttpCommunicator() {

		template =  new RestTemplate();
		
	}




	public String request_get(String url, MultiValueMap<String,String> param, HttpHeaders header) {
		
		request = new HttpEntity<MultiValueMap<String, String>>(param, header);
		response = template.exchange(url, HttpMethod.GET ,request, String.class);

		
		
		return response.getBody();
	}
	
	
	

	public String request_post(String url, MultiValueMap<String,String> param, HttpHeaders header) {
		
		
		request = new HttpEntity<MultiValueMap<String, String>>(param, header);
		response = template.exchange(url, HttpMethod.POST ,request, String.class);
		
		return response.getBody();
	}
	
	
	
	
}
