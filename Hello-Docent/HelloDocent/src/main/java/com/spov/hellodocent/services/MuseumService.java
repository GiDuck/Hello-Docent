package com.spov.hellodocent.services;


import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.MuseumEventDTO;


/*박물관,미술관 DB 데이터 처리를 위한 서비스*/


public interface MuseumService {
	

	public String findMuseumKey(String name);
	public String getMuseumType(String id);
	/*서비스 비즈니스 로직*/
	
	public List<MuseumEventDTO> getMuseumEvents();
	public List<MuseumEventDTO> getLimitMuseumEvent();
	public List<String> getLocalList();
	public List<String> getPlaceList(String name);
	
	public List<MuseumEventDTO> getMuseumEventsQuery(Map<String, Object> container);
	public List<Map<String, String>> getMuseumPlaceFullList(Map<String, String> container);
	public List<Map<String, String>> getGeoLocation(Map<String, String> container);
	
	public Map<String, String> getMuseumDetailInfo(String id);
	public List<Map<String, String>> getMuseumPlaceFullListByIds(List<String> container);

}
