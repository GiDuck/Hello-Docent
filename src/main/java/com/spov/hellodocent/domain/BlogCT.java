package com.spov.hellodocent.domain;

import java.util.List;

public class BlogCT {

	private String col_id;
	private String col_writeruid;
	private String col_title;
	private String col_introduce;
	private String col_date;
	private String col_type;
	private String col_content;
	private List<String> images;
	private List<String> tags;

	
	public String getCol_id() {
		return col_id;
	}
	public void setCol_id(String col_id) {
		this.col_id = col_id;
	}
	public String getCol_writeruid() {
		return col_writeruid;
	}
	public void setCol_writeruid(String col_writeruid) {
		this.col_writeruid = col_writeruid;
	}
	public String getCol_title() {
		return col_title;
	}
	public void setCol_title(String col_title) {
		this.col_title = col_title;
	}
	public String getCol_introduce() {
		return col_introduce;
	}
	public void setCol_introduce(String col_introduce) {
		this.col_introduce = col_introduce;
	}
	
	public String getCol_date() {
		return col_date;
	}
	public void setCol_date(String col_date) {
		this.col_date = col_date;
	}
	public String getCol_type() {
		return col_type;
	}
	public void setCol_type(String col_type) {
		this.col_type = col_type;
	}
	public String getCol_content() {
		return col_content;
	}
	public void setCol_content(String col_content) {
		this.col_content = col_content;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "BlogCT [col_id=" + col_id + ", col_writeruid=" + col_writeruid + ", col_title=" + col_title
				+ ", col_introduce=" + col_introduce + ", col_date=" + col_date + ", col_type=" + col_type
				+ ", col_content=" + col_content + ", images=" + images + ", tags=" + tags + "]";
	}
	
	
	
	
	
}
