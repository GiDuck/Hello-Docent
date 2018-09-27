package com.spov.hellodocent.domain;

import java.sql.Date;

public class MuseumEventDTO {

	private String de_ref;
	private String de_uci;
	private String de_title;
	private String de_image;
	private String de_person;
	private String de_subCategory;
	private String de_url;
	private String de_venue;
	private String de_category;
	private Date de_startDate;
	private Date de_endDate;
	private String de_refName;
		
	
	public MuseumEventDTO() {
		super();
	}
	
	public String getDe_ref() {
		return de_ref;
	}
	public void setDe_ref(String de_ref) {
		this.de_ref = de_ref;
	}
	public String getDe_uci() {
		return de_uci;
	}
	public void setDe_uci(String de_uci) {
		this.de_uci = de_uci;
	}
	public String getDe_title() {
		return de_title;
	}
	public void setDe_title(String de_title) {
		this.de_title = de_title;
	}
	public String getDe_image() {
		return de_image;
	}
	public void setDe_image(String de_image) {
		this.de_image = de_image;
	}
	public String getDe_person() {
		return de_person;
	}
	public void setDe_person(String de_person) {
		this.de_person = de_person;
	}
	public String getDe_subCategory() {
		return de_subCategory;
	}
	public void setDe_subCategory(String de_subCategory) {
		this.de_subCategory = de_subCategory;
	}
	public String getDe_url() {
		return de_url;
	}
	public void setDe_url(String de_url) {
		this.de_url = de_url;
	}

	public String getDe_venue() {
		return de_venue;
	}
	public void setDe_venue(String de_venue) {
		this.de_venue = de_venue;
	}
	public String getDe_category() {
		return de_category;
	}
	public void setDe_category(String de_category) {
		this.de_category = de_category;
	}

	public Date getDe_startDate() {
		return de_startDate;
	}

	public void setDe_startDate(Date de_startDate) {
		this.de_startDate = de_startDate;
	}

	public Date getDe_endDate() {
		return de_endDate;
	}

	public void setDe_endDate(Date de_endDate) {
		this.de_endDate = de_endDate;
	}

	public String getDe_refName() {
		return de_refName;
	}

	public void setDe_refName(String de_refName) {
		this.de_refName = de_refName;
	}

	
	
	
	
	
	
	
	
}
