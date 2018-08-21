package com.spov.hellodocent.domain;

import java.util.Date;

public class CommentaryReplyDTO {
	private String CMTR_ID;
	private String CMTR_REF;
	private String CMTR_REPREF;
	private String CMTR_WRITERUID;
	private String CMTR_CONTENT;
	private Date CMTR_DATE;

	public String getCMTR_ID() {
		return CMTR_ID;
	}
	public void setCMTR_ID(String cMTR_ID) {
		CMTR_ID = cMTR_ID;
	}
	public String getCMTR_REF() {
		return CMTR_REF;
	}
	public void setCMTR_REF(String cMTR_REF) {
		CMTR_REF = cMTR_REF;
	}
	public String getCMTR_REPREF() {
		return CMTR_REPREF;
	}
	public void setCMTR_REPREF(String cMTR_REPREF) {
		CMTR_REPREF = cMTR_REPREF;
	}
	public String getCMTR_WRITERUID() {
		return CMTR_WRITERUID;
	}
	public void setCMTR_WRITERUID(String cMTR_WRITERUID) {
		CMTR_WRITERUID = cMTR_WRITERUID;
	}
	public String getCMTR_CONTENT() {
		return CMTR_CONTENT;
	}
	public void setCMTR_CONTENT(String cMTR_CONTENT) {
		CMTR_CONTENT = cMTR_CONTENT;
	}
	public Date getCMTR_DATE() {
		return CMTR_DATE;
	}
	public void setCMTR_DATE(Date cMTR_DATE) {
		CMTR_DATE = cMTR_DATE;
	}
	
	@Override
	public String toString() {
		
	
		System.out.println(CMTR_ID + " " + CMTR_REF + " " + CMTR_REPREF + " " + CMTR_WRITERUID + " " + CMTR_CONTENT + " " + CMTR_DATE);
		
		return super.toString();
	}

	
	
	
	
	
	
}
