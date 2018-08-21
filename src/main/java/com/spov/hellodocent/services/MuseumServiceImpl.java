package com.spov.hellodocent.services;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spov.hellodocent.domain.DisplayDTO;
import com.spov.hellodocent.domain.DisplayInfoDTO;
import com.spov.hellodocent.domain.MuseumCodeDTO;
import com.spov.hellodocent.domain.MuseumCostDTO;
import com.spov.hellodocent.domain.MuseumDTO;
import com.spov.hellodocent.domain.MuseumEventDTO;
import com.spov.hellodocent.domain.MuseumLocationDTO;
import com.spov.hellodocent.persistence.MuseumDAO;

/*박물관,미술관 DB 데이터 처리를 위한 서비스*/

@Service
public class MuseumServiceImpl implements MuseumService {

	@Inject
	private MuseumDAO museumDAO;

	@Override
	public void putMuseum(List<MuseumDTO> museumList) {

		System.out.println(museumList.size());

		for (MuseumDTO museumDTO : museumList) {
			try {
				museumDAO.putMuseum(museumDTO);

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

	}

	@Override
	public void putMuseumCost(List<MuseumCostDTO> museumCostList) {

		for (MuseumCostDTO museumCostDTO : museumCostList) {

			try {

				museumDAO.putMuseumCost(museumCostDTO);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	public void putMuseumLocation(List<MuseumLocationDTO> museumLocationList) {

		for (MuseumLocationDTO museumLocationDTO : museumLocationList) {

			try {

				museumDAO.putMuseumLocation(museumLocationDTO);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void putMuseumEvent(List<MuseumEventDTO> museumEventDTO) {

		for (MuseumEventDTO eventDto : museumEventDTO) {

			try {

				museumDAO.putMuseumEvent(eventDto);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void putMuseumCode(List<MuseumCodeDTO> museumCodeDTO) {
		for (MuseumCodeDTO codeDto : museumCodeDTO) {

			try {

				museumDAO.putMuseumCode(codeDto);
				

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public String findMuseumKey(String name) {
		System.out.println("input into dao : " + name);
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
	public void putDisplayInfo(List<DisplayDTO> displays, List<DisplayInfoDTO> infos) {

		
			try {

				museumDAO.putDisplayInfo(displays, infos);

			} catch (Exception e) {
				e.printStackTrace();
			}

		

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
	public List<MuseumEventDTO> getMuseumEventsQuery(Map<String, String> container) {
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
