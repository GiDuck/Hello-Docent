package com.spov.hellodocent.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DocentInfoDTO {

	
	private String di_iuid;
	private String di_carrer;
	private String di_introduce;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date di_vertifiedTime;
	
	private String di_certificationPath;
	
	public String getDi_iuid() {
		return di_iuid;
	}
	public void setDi_iuid(String di_iuid) {
		this.di_iuid = di_iuid;
	}
	public String getDi_carrer() {
		return di_carrer;
	}
	public void setDi_carrer(String di_carrer) {
		this.di_carrer = di_carrer;
	}
	public String getDi_introduce() {
		return di_introduce;
	}
	public void setDi_introduce(String di_introduce) {
		this.di_introduce = di_introduce;
	}

	public Date getDi_vertifiedTime() {
		return di_vertifiedTime;
	}
	public void setDi_vertifiedTime(Date di_vertifiedTime) {
		this.di_vertifiedTime = di_vertifiedTime;
	}
	public String getDi_certificationPath() {
		return di_certificationPath;
	}
	public void setDi_certificationPath(String di_certificationPath) {
		this.di_certificationPath = di_certificationPath;
	}

	
	
	
	
	
}
