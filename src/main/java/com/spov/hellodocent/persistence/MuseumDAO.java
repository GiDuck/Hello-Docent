package com.spov.hellodocent.persistence;

import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.DisplayDTO;
import com.spov.hellodocent.domain.DisplayInfoDTO;
import com.spov.hellodocent.domain.MuseumCodeDTO;
import com.spov.hellodocent.domain.MuseumCostDTO;
import com.spov.hellodocent.domain.MuseumDTO;
import com.spov.hellodocent.domain.MuseumEventDTO;
import com.spov.hellodocent.domain.MuseumLocationDTO;

public interface MuseumDAO {
	
	public void putMuseum(MuseumDTO museumDTO);
	public void putMuseumCost(MuseumCostDTO museumCostDTO);
	public void putMuseumLocation(MuseumLocationDTO museumLocationDTO);
	public void putMuseumEvent(MuseumEventDTO museumEventDTO);
	public void putMuseumCode(MuseumCodeDTO museumCodeDTO);
	public void putDisplayInfo(List<DisplayDTO> displayDTO, List<DisplayInfoDTO> displayInfoDTO);
	public String findMuseumKey(String name);
	public List<MuseumEventDTO> getMuseumEvents();
	public String getMuseumType(String id);
	public List<MuseumEventDTO> getLimitMuseumEvent();
	public List<String> getLocalList();
	public List<String> getPlaceList(String name);
	public List<MuseumEventDTO> getMuseumEventForQuery(Map<String, String> container);
	public List<Map<String, String>> getMuseumPlaceFullList (Map<String, String> container);
	public List<Map<String, String>> getGeoLocation(Map<String, String> container);
	public Map<String, String> getMuseumDetailInfo(String id);
	public List<Map<String, String>> getMuseumPlaceFullListByIds(List<String> container);
	

}
