package com.spov.hellodocent.museum;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.spov.hellodocent.domain.MuseumCostDTO;
import com.spov.hellodocent.domain.MuseumDTO;
import com.spov.hellodocent.domain.MuseumLocationDTO;
import com.spov.hellodocent.domain.MuseumSetDTO;

public class MuseumDivider {
	
	private SecureRandom random;
	private String id;
	private List<MuseumDTO> museumDTOList;
	private List<MuseumLocationDTO> museumLocationList;
	private List<MuseumCostDTO> museumCostList;
	
	
	
	public MuseumDivider() {
		super();
		random = new SecureRandom();
	}
	
	public List<Object> MuseumDivideFactory(List<MuseumSetDTO> container) {
		
		try {
		List<Object> list = new ArrayList<Object>();
		museumDTOList = new ArrayList<MuseumDTO>();
		museumLocationList = new ArrayList<MuseumLocationDTO>();
		museumCostList = new ArrayList<MuseumCostDTO>();
		
		for(int i=0; i<container.size(); ++i) {
			
			
			makeId();
			museumDTOList.add(convertMuseumDTO(container.get(i)));
			museumLocationList.add(convertMuseumLocationDTO(container.get(i)));
			museumCostList.add(convertMuseumCostDTO(container.get(i)));
			System.out.println(id + " : ------------------" + i + "--------------------생성중");
			
			
		}
		
		list.add(museumDTOList);
		list.add(museumLocationList);
		list.add(museumCostList);
		
		System.out.println(list);
		
		return list;
		
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("divide process fail...");
			System.out.println(e.getMessage());
			return null;
		}finally {
			
			//clear();
			
		}
		
		
		
		
		
	}
	
	
	private void clear() {
		
		museumDTOList.clear();
		museumLocationList.clear();
		museumCostList.clear();
		id = null;
		
		
	}

	private void makeId() {
		
		
		id = String.valueOf(new BigInteger(130, random).toString());
		
	}
	
	private MuseumDTO convertMuseumDTO(MuseumSetDTO set) {
		
		
		MuseumDTO museum = new MuseumDTO();
		museum.setEp_id(id);
		museum.setEp_closeInfo(set.get휴관정보());
		museum.setEp_facilities(set.get편의시설정보());
		museum.setEp_name(set.get시설명());
		museum.setEp_introduce(set.get박물관미술관소개());
		museum.setEp_facilities(set.get편의시설정보());
		museum.setEp_traffic(set.get교통안내정보());
		museum.setEp_url(set.get운영홈페이지());
		museum.setEp_phone(set.get관리기관전화번호());
		museum.setEp_type(set.get박물관미술관구분());
		museum.setEp_operTimeStart(set.get평일관람시작시각());
		museum.setEp_operTimeEnd(set.get평일관람종료시각());
		museum.setEp_operTimeWKStart(set.get공휴일관람시작시각());
		museum.setEp_operTimeWKEnd(set.get공휴일관람종료시각());
		
		if(set.get시설명().contains("박물관")) {
			
			museum.setEp_subType("박물관");
			
		}else if(set.get시설명().contains("미술관")) {
			
			museum.setEp_subType("미술관");

		}else {
						
			museum.setEp_subType("기타");
			
		}
		
	
		
		return museum;
		
		
	}

	private MuseumCostDTO convertMuseumCostDTO(MuseumSetDTO set) {

		MuseumCostDTO museumCost = new MuseumCostDTO();
		museumCost.setEpc_adult(set.get어른관람료());
		museumCost.setEpc_child(set.get어린이관람료());
		museumCost.setEpc_teenager(set.get청소년관람료());
		museumCost.setEpc_etc(set.get관람료기타정보());
		museumCost.setEpc_id(id);
		
		return museumCost;
		
		

	}

	private MuseumLocationDTO convertMuseumLocationDTO(MuseumSetDTO set) throws Exception {

		
		MuseumLocationDTO museumLocation = new MuseumLocationDTO();
		museumLocation.setEpl_id(id);
		museumLocation.setEpl_address(set.get소재지지번주소());	
		museumLocation.setEpl_addressRoad(set.get소재지도로명주소());
		museumLocation.setEpl_locationX(set.get위도());
		museumLocation.setEpl_locationY(set.get경도());
		
		String[] temp = set.get소재지도로명주소().split(" ");
		museumLocation.setEpl_token(temp[0]);

		return museumLocation;
	}



	

}
