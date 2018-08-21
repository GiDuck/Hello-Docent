package com.spov.hellodocent.domain;

import java.util.Date;

public class ResourceDTO {
	
	private String res_ref;
	private String res_type;
	private String res_url;
	private Date res_date;


	
	public String getRes_ref() {
		return res_ref;
	}

	public void setRes_ref(String res_ref) {
		this.res_ref = res_ref;
	}

	public String getRes_type() {
		return res_type;
	}

	public void setRes_type(String res_type) {
		this.res_type = res_type;
	}


	public String getRes_url() {
		return res_url;
	}

	public void setRes_url(String res_url) {
		this.res_url = res_url;
	}
	

	public Date getRes_date() {
		return res_date;
	}

	public void setRes_date(Date res_date) {
		this.res_date = res_date;
	}

	@Override
	public String toString() {
		
		String str = "RESOURCE DTO --> " + res_ref + " " + res_type + " " + res_url;
		return str;
	}
	

}
