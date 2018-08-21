package com.spov.hellodocent.services;


import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.DisplayDTO;
import com.spov.hellodocent.domain.DisplayInfoDTO;
import com.spov.hellodocent.domain.MuseumCodeDTO;
import com.spov.hellodocent.domain.MuseumCostDTO;
import com.spov.hellodocent.domain.MuseumDTO;
import com.spov.hellodocent.domain.MuseumEventDTO;
import com.spov.hellodocent.domain.MuseumLocationDTO;


/*박물관,미술관 DB 데이터 처리를 위한 서비스*/


public interface MuseumService {
	
	public void putMuseum(List<MuseumDTO> museumList);
	public void putMuseumCost(List<MuseumCostDTO> museumCostList);
	public void putMuseumLocation(List<MuseumLocationDTO> museumLocationList);
	public void putMuseumEvent(List<MuseumEventDTO> museumEventDTO);
	public void putMuseumCode(List<MuseumCodeDTO> museumCodeDTO);
	public void putDisplayInfo(List<DisplayDTO> displays, List<DisplayInfoDTO> infos);
	public String findMuseumKey(String name);
	public String getMuseumType(String id);
	/*서비스 비즈니스 로직*/
	
	public List<MuseumEventDTO> getMuseumEvents();
	public List<MuseumEventDTO> getLimitMuseumEvent();
	public List<String> getLocalList();
	public List<String> getPlaceList(String name);
	
	public List<MuseumEventDTO> getMuseumEventsQuery(Map<String, String> container);
	public List<Map<String, String>> getMuseumPlaceFullList(Map<String, String> container);
	public List<Map<String, String>> getGeoLocation(Map<String, String> container);
	
	public Map<String, String> getMuseumDetailInfo(String id);
	public List<Map<String, String>> getMuseumPlaceFullListByIds(List<String> container);

}
