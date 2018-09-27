package com.spov.hellodocent.domain;

import java.util.List;

public class SearchDTO {

	private String keyword;
	private List<String> museums;
	private List<String> wordList;
	private String prefix;
	private String suffix;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<String> getMuseums() {
		return museums;
	}

	public void setMuseums(List<String> museums) {
		this.museums = museums;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public List<String> getWordList() {
		return wordList;
	}

	public void setWordList(List<String> wordList) {
		this.wordList = wordList;
	}

}
