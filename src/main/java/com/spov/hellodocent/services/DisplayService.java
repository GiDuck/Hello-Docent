package com.spov.hellodocent.services;

import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.SearchDTO;

public interface DisplayService {

	public List<Map<String, String>> getMuseumInfo();
	public List<Map<String, String>> getMuseumInfoDefault();
	public List<Map<String, String>> getDisplayInfo(Map<String, String> params);
	public List<Map<String, String>> getDisplayInfoDefault(SearchDTO param);
	public Map<String, String> getDisplayInfoSimple(String keyword);
	public List<Map<String, String>> getDisplayInfoSimpleCard(String keyword);
	public List<Map<String, String>> getDisplayInfoByKeyword(String keyword, List<String> museums, String prefix, String suffix);
	public List<Map<String, String>> getMuseumInfoByKeyword(String keyword);
}
