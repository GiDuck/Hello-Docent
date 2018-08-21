package com.spov.hellodocent.persistence;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spov.hellodocent.domain.DisplayDTO;
import com.spov.hellodocent.domain.DisplayInfoDTO;
import com.spov.hellodocent.domain.MuseumCodeDTO;
import com.spov.hellodocent.domain.MuseumCostDTO;
import com.spov.hellodocent.domain.MuseumDTO;
import com.spov.hellodocent.domain.MuseumEventDTO;
import com.spov.hellodocent.domain.MuseumLocationDTO;

@Repository
public class MuseumDAOImpl implements MuseumDAO {

	@Inject
	private SqlSession sqlSession;
	

	
/*	ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\gdtbg\\git\\Hello-Docent\\HelloDocent\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
*/
	//private SqlSession sqlSession = factory.openSession(ExecutorType.BATCH);
	
	private static final String namespace = "com.spov.hellodocent.mappers.museumMapper";

	
	
	@Override
	public void putMuseum(MuseumDTO museumDTO) {
		
		System.out.println(museumDTO);
		System.out.println(museumDTO.getEp_id());
		System.out.println(museumDTO.getEp_closeInfo());
		System.out.println(museumDTO.getEp_name());


		

		sqlSession.insert(namespace+".putMuseum", museumDTO);
		
		
	}

	@Override
	public void putMuseumCost(MuseumCostDTO museumCostDTO) {


		sqlSession.insert(namespace+".putMuseumCost", museumCostDTO);

	}

	@Override
	public void putMuseumLocation(MuseumLocationDTO museumLocationDTO) {


		sqlSession.insert(namespace+".putMuseumLocation", museumLocationDTO);

	}

	@Override
	public void putMuseumEvent(MuseumEventDTO museumEventDTO) {
		sqlSession.insert(namespace+".putMuseumEvent", museumEventDTO);
		
	}

	@Override
	public String findMuseumKey(String name) {
		return sqlSession.selectOne(namespace+".selectMuseumKey", name);

	}

	@Override
	public void putMuseumCode(MuseumCodeDTO museumCodeDTO) {
		sqlSession.insert(namespace+".putMuseumCode", museumCodeDTO);

	}

	@Override
	public List<MuseumEventDTO> getMuseumEvents() {

		return sqlSession.selectList(namespace+".getMuseumEvents");
	}

	@Override
	public String getMuseumType(String id) {

		
		return sqlSession.selectOne(namespace+".getMuseumType", id);
	}

	@Override
	public void putDisplayInfo(List<DisplayDTO> displayDTO, List<DisplayInfoDTO> displayInfoDTO) {

		for(DisplayDTO display : displayDTO) 
		sqlSession.insert(namespace+".setDisplay", display);	
		
		
		for(DisplayInfoDTO info : displayInfoDTO)
		sqlSession.insert(namespace+".setDisplayInfo", info);

		
		
	}
	
	
	
	/*@Override
	public void putDisplayInfo(List<DisplayDTO> displayDTO, List<DisplayInfoDTO> displayInfoDTO) {

		SqlSession session = factory.openSession(ExecutorType.BATCH);
		System.out.println("sql Type : " + session.getConfiguration().getDefaultExecutorType());
		
		final int term = 70;
		int start = 0;
		int end = term;
		int count = 0;
		int total = displayDTO.size();
		
		List<DisplayDTO>tempDisplay = new ArrayList<>();
		List<DisplayInfoDTO>tempInfo = new ArrayList<>();
		
		long startT = System.currentTimeMillis();
		long endT=0;
		System.out.println("insert start... " + startT);
		while(true) {
			
			if(count == total) {
				break;
			}
		
			System.out.println("start " + start);
			System.out.println("end " + end);

			// if real size = 3800 , end = 4000, 
				
			
			for(int i=start; i<end; ++i)
			{
				tempDisplay.add(displayDTO.get(i));
				tempInfo.add(displayInfoDTO.get(i));
				count++;

			}
			
			System.out.println("tempDisplay" + tempDisplay.size());
			System.out.println("tempInfo" + tempInfo.size());
			

			
			try {
			sqlSession.insert(namespace+".setDisplay", tempDisplay);	
			sqlSession.insert(namespace+".setDisplayInfo", tempInfo);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			start += term;
			end += term;
			

			
			tempDisplay.clear();
			tempInfo.clear();
			
			
		}
		
				endT = System.currentTimeMillis();
				System.out.println("insert end... " + endT);
				System.out.println("시간차... " + (endT-startT));
				System.out.println("-------------------------");

		
		
	}*/

	@Override
	public List<MuseumEventDTO> getLimitMuseumEvent() {

		return sqlSession.selectList(namespace+".getMuseumEventsLimit"); 
	}

	@Override
	public List<String> getLocalList() {
		
		return sqlSession.selectList(namespace+".getMuseumLocalList");
	}

	@Override
	public List<String> getPlaceList(String name) {
		return sqlSession.selectList(namespace+".getMuseumPlaceList", name);
	}

	@Override
	public List<MuseumEventDTO> getMuseumEventForQuery(Map<String, String> container) {
		return sqlSession.selectList(namespace+".getMuseumEventsQuery", container);
	}

	@Override
	public List<Map<String, String>> getMuseumPlaceFullList(Map<String, String> container) {
	
		return sqlSession.selectList(namespace+".getMuseumPlaceFullList", container);
	}
	
	@Override
	public List<Map<String, String>> getMuseumPlaceFullListByIds(List<String> container) {
	
		return sqlSession.selectList(namespace+".getMuseumPlaceFullListByIds", container);
	}
	

	@Override
	public List<Map<String, String>> getGeoLocation(Map<String, String> container) {
		return sqlSession.selectList(namespace+".selectGeoLocation", container);
	}

	@Override
	public Map<String, String> getMuseumDetailInfo(String id) {
		return sqlSession.selectOne(namespace+".getMuseumDetailInfo", id);
	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
