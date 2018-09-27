package com.spov.hellodocent.services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spov.hellodocent.domain.MuseumEventDTO;
import com.spov.hellodocent.persistence.MuseumDAO;

/*박물관,미술관 DB 데이터 처리를 위한 서비스*/

@Service
public class MuseumServiceImpl implements MuseumService {

	@Inject
	private MuseumDAO museumDAO;



	@Override
	public String findMuseumKey(String name) {
		return museumDAO.findMuseumKey(name);

	}

	@Override
	public List<MuseumEventDTO> getMuseumEvents() {

		return museumDAO.getMuseumEvents();
	}

	@Override
	public String getMuseumType(String id) {
		return museumDAO.getMuseumType(id);
	}

	

	@Override
	public List<MuseumEventDTO> getLimitMuseumEvent() {
		return museumDAO.getLimitMuseumEvent();
	}

	@Override
	public List<String> getLocalList() {
		return museumDAO.getLocalList();
	}

	@Override
	public List<String> getPlaceList(String name) {
		
		return museumDAO.getPlaceList(name);
	}

	@Override
	public List<MuseumEventDTO> getMuseumEventsQuery(Map<String, Object> container) {
		
	
		String[] wordList = ((String)container.get("keyword")).split(" ");
		container.put("wordList", wordList);
		
		System.out.println("wordList : ...");
		System.out.println(Arrays.deepToString(wordList));
		System.out.println("Params... " + container);
		
		return museumDAO.getMuseumEventForQuery(container);
	}

	@Override
	public List<Map<String, String>> getMuseumPlaceFullList(Map<String, String> container) {
		return museumDAO.getMuseumPlaceFullList(container);
	}

	@Override
	public List<Map<String, String>> getGeoLocation(Map<String, String> container) {
		return museumDAO.getGeoLocation(container);
	}

	@Override
	public Map<String, String> getMuseumDetailInfo(String id) {
		return museumDAO.getMuseumDetailInfo(id);	
		
	}

	@Override
	public List<Map<String, String>> getMuseumPlaceFullListByIds(List<String> container) {
		return museumDAO.getMuseumPlaceFullListByIds(container);	
	}
	
	
	
	
	
	
	
	
	

}
