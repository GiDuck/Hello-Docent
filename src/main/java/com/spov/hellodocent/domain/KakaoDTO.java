package com.spov.hellodocent.domain;

import java.io.Serializable;
import java.util.Map;

public class KakaoDTO implements Serializable {

	private int id;
	private Map<String, String> properties;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<String, String> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	
	
	
	
	
	
	
	
}
