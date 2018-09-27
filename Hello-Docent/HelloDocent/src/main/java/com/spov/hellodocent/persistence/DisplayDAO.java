package com.spov.hellodocent.persistence;

import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.SearchDTO;

public interface DisplayDAO {
	
	public List<Map<String, String>> getDisplayInfo(Map<String, String> params);
	public List<Map<String, String>> getDisplayInfoDefault(SearchDTO param);

	public List<Map<String, String>> getMuseumInfo();
	public List<Map<String, String>> getMuseumInfoDefault();
	public List<Map<String, String>> getMuseumInfoByKeyword(List<String> wordList);
	
	public Map<String, String> getDisplayInfoSimple(String keyword);
	public List<Map<String, String>> getDisplayInfoSimpleCard(String keyword);

	public List<Map<String, String>> getDisplayInfoByKeyword (SearchDTO param);

}
