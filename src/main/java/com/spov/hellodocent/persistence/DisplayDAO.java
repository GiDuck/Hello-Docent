package com.spov.hellodocent.persistence;

import java.util.List;
import java.util.Map;

public interface DisplayDAO {
	
	public List<Map<String, String>> getDisplayInfo(Map<String, String> params);
	public List<Map<String, String>> getDisplayInfoDefault(Map<String, String> params);

	public List<Map<String, String>> getMuseumInfo();
	public List<Map<String, String>> getMuseumInfoDefault();
	
	public Map<String, String> getDisplayInfoSimple(String keyword);
	public List<Map<String, String>> getDisplayInfoSimpleCard(String keyword);
}
