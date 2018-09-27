package com.spov.hellodocent.persistence;

import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.MuseumEventDTO;

public interface MuseumDAO {
	
	public String findMuseumKey(String name);
	public List<MuseumEventDTO> getMuseumEvents();
	public String getMuseumType(String id);
	public List<MuseumEventDTO> getLimitMuseumEvent();
	public List<String> getLocalList();
	public List<String> getPlaceList(String keyword);
	public List<MuseumEventDTO> getMuseumEventForQuery(Map<String, Object> container);
	public List<Map<String, String>> getMuseumPlaceFullList (Map<String, String> container);
	public List<Map<String, String>> getGeoLocation(Map<String, String> container);
	public Map<String, String> getMuseumDetailInfo(String id);
	public List<Map<String, String>> getMuseumPlaceFullListByIds(List<String> container);
	

}
