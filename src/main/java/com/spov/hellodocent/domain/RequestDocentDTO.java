package com.spov.hellodocent.domain;

import java.util.Date;

public class RequestDocentDTO {
	
	private String req_id;
	private String req_name;
	private String req_telnum;
	private String req_email;
	private String req_professional;
	private String req_introduce;
	private Date req_date;
	
	public String getReq_id() {
		return req_id;
	}
	public void setReq_id(String req_id) {
		this.req_id = req_id;
	}
	public String getReq_name() {
		return req_name;
	}
	public void setReq_name(String req_name) {
		this.req_name = req_name;
	}
	public String getReq_telnum() {
		return req_telnum;
	}
	public void setReq_telnum(String req_telnum) {
		this.req_telnum = req_telnum;
	}
	public String getReq_email() {
		return req_email;
	}
	public void setReq_email(String req_email) {
		this.req_email = req_email;
	}
	public String getReq_professional() {
		return req_professional;
	}
	public void setReq_professional(String req_professional) {
		this.req_professional = req_professional;
	}
	public String getReq_introduce() {
		return req_introduce;
	}
	public void setReq_introduce(String req_introduce) {
		this.req_introduce = req_introduce;
	}
	public Date getReq_date() {
		return req_date;
	}
	public void setReq_date(Date req_date) {
		this.req_date = req_date;
	}
	@Override
	public String toString() {
		return "RequestDocentDTO [req_id=" + req_id + ", req_name=" + req_name + ", req_telnum=" + req_telnum
				+ ", req_email=" + req_email + ", req_professional=" + req_professional + ", req_introduce="
				+ req_introduce + ", req_date=" + req_date + "]";
	}

	
	
	

}
