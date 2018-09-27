package com.spov.hellodocent.domain;

import java.util.Date;

public class CommentaryDTO {
	
	private String CMT_ID;
	private String CMT_REF;
	private String CMT_WRITERUID;
	private String CMT_TITLE;
	private String CMT_INTRODUCE;
	private String CMT_ISFREE;
	private String CMT_CONTENTTYPE;
	private Date CMT_DATE;
	private String CMT_CONTENT;
	
	public String getCMT_ID() {
		return CMT_ID;
	}
	public void setCMT_ID(String cMT_ID) {
		CMT_ID = cMT_ID;
	}
	public String getCMT_REF() {
		return CMT_REF;
	}
	public void setCMT_REF(String cMT_REF) {
		CMT_REF = cMT_REF;
	}
	public String getCMT_WRITERUID() {
		return CMT_WRITERUID;
	}
	public void setCMT_WRITERUID(String cMT_WRITERUID) {
		CMT_WRITERUID = cMT_WRITERUID;
	}
	public String getCMT_TITLE() {
		return CMT_TITLE;
	}
	public void setCMT_TITLE(String cMT_TITLE) {
		CMT_TITLE = cMT_TITLE;
	}
	public String getCMT_INTRODUCE() {
		return CMT_INTRODUCE;
	}
	public void setCMT_INTRODUCE(String cMT_INTRODUCE) {
		CMT_INTRODUCE = cMT_INTRODUCE;
	}
	public String getCMT_ISFREE() {
		return CMT_ISFREE;
	}
	public void setCMT_ISFREE(String cMT_ISFREE) {
		CMT_ISFREE = cMT_ISFREE;
	}
	public String getCMT_CONTENTTYPE() {
		return CMT_CONTENTTYPE;
	}
	public void setCMT_CONTENTTYPE(String cMT_CONTENTTYPE) {
		CMT_CONTENTTYPE = cMT_CONTENTTYPE;
	}
	
	public Date getCMT_DATE() {
		return CMT_DATE;
	}
	public void setCMT_DATE(Date cMT_DATE) {
		CMT_DATE = cMT_DATE;
	}
	public String getCMT_CONTENT() {
		return CMT_CONTENT;
	}
	public void setCMT_CONTENT(String cMT_CONTENT) {
		CMT_CONTENT = cMT_CONTENT;
	}
	
	@Override
	public String toString() {
		return "CommentaryDTO [CMT_ID=" + CMT_ID + ", CMT_REF=" + CMT_REF + ", CMT_WRITERUID=" + CMT_WRITERUID
				+ ", CMT_TITLE=" + CMT_TITLE + ", CMT_INTRODUCE=" + CMT_INTRODUCE + ", CMT_ISFREE=" + CMT_ISFREE
				+ ", CMT_CONTENTTYPE=" + CMT_CONTENTTYPE + ", CMT_DATE=" + CMT_DATE + ", CMT_CONTENT=" + CMT_CONTENT
				+ "]";
	}
	
	
	
	

}
