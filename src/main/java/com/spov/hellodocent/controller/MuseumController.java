package com.spov.hellodocent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spov.hellodocent.domain.MuseumEventDTO;
import com.spov.hellodocent.services.MuseumService;

@Controller
@RequestMapping("/museum")
public class MuseumController {

	private static final Logger logger = LoggerFactory.getLogger(MuseumController.class);

	@Inject
	private MuseumService museumService;
	
	
	@RequestMapping(value="/findEvent")
	public String findEvent(HttpServletRequest request, Model model) {

		
		List<MuseumEventDTO> container = new ArrayList<>();
		container = museumService.getLimitMuseumEvent();
		System.out.println("container size.. : " + container.size());
		model.addAttribute("events", container);
		
		
		return "museum/findEvent";
	}
	
	
	@RequestMapping(value="/getLocalList", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<String> findLocalList() {
		
		List<String> container = new ArrayList<>();
		container = museumService.getLocalList();
		
		
		return container;
	
		
	}
	
	
	@RequestMapping(value="/getPlaceList", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<String> findPlaceList(@RequestParam("name") String name, HttpServletRequest request) {
		
		System.out.println("name..." + name);
		List<String> container = new ArrayList<>();
		container = museumService.getPlaceList(name);
		
		
		return container;
	
		
	}
	
	
	@RequestMapping(value="/getPlaceFullList", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Map<String, String>> findPlaceFullList(@RequestParam("keyword") String keyword,@RequestParam("token") String token, 
			HttpServletRequest request) {
		
		System.out.println("getPlaceFull...");
		Map<String, String> container = new HashMap<>();
		container.put("token",token);
		container.put("keyword", keyword);
		System.out.println(container.get("token") + " " + container.get("keyword"));
		List<Map<String,String>> result = new ArrayList<>();
		
		result = museumService.getMuseumPlaceFullList(container);
		
		return result;
	
		
	}
	
	
	
	@RequestMapping(value="/getPlaceFullListByIds", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Map<String, String>> findPlaceFullListByIds(@RequestParam("keyword") String keyword, 
			HttpServletRequest request) {
		
		System.out.println("getPlaceFullByIds...");		
		List<Map<String,String>> result = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();
		List<String> container = new ArrayList<>();
		try {
			container = mapper.readValue(keyword, List.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(container);		

		result = museumService.getMuseumPlaceFullListByIds(container);
		System.out.println("return list size... " + result.size());
		
		return result;
	
		
	}
	
	
	
	@RequestMapping(value="/getMuseumListForQuery", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<MuseumEventDTO> getMuseumListForQuery(@RequestParam("type") String type,
			@RequestParam("placeName") String placeName, @RequestParam("keyword") String keyword,
			@RequestParam("date") String date, HttpServletRequest request) {
		
		System.out.println("getMuseumListForQuery...");
		System.out.println("query.. " + type + placeName + date);
		System.out.println(keyword);
		Map<String, String> param = new HashMap<>();
		param.put("type", type);
		param.put("placeName", placeName);
		param.put("keyword", keyword);
		param.put("date", date);


		List<MuseumEventDTO> container = new ArrayList<>();
		container = museumService.getMuseumEventsQuery(param);
		System.out.println("찾아온 데이터 수.. " + container.size());
		return container;
	
		
	}
	
	
	
	@RequestMapping("/findMuseumDetailView")
	public String findMuseumDetailView(@RequestParam("id") String id, Model model) {
		
		System.out.println("recived id... " + id);
		Map<String, String> container = new HashMap<>();
		container = museumService.getMuseumDetailInfo(id);
		model.addAttribute("container", container);
		

		return "museum/findPlaceDetail";
	}
	
	
	@RequestMapping("/findPlace")
	public String findMuseumPlace() {
		

		return "museum/findPlace";
	}
	

	
	@RequestMapping(value="/getGeoLocation", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Map<String, String>> getGeoLocation(@RequestParam("keyword") String keyword,
			@RequestParam("token") String token) {
		
		System.out.println("getGeoLocation....");
		List<Map<String, String>>container = new ArrayList<>();
		Map <String, String> param = new HashMap<>();
		param.put("keyword", keyword);
		param.put("token", token);

		container = museumService.getGeoLocation(param);
		
		
		
		
		return container;
	}
	
	
	
	
	
	
	
	
	
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @RequestMapping(value = "/setMuseum", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String setMuseum() {
	 * 
	 * HttpCommunicator hc = new HttpCommunicator(); HttpHeaders header = new
	 * HttpHeaders(); header.set("Content-Type", "charset=utf-8");
	 * header.set("Accept", "application/json");
	 * 
	 * 
	 * String url =
	 * "http://api.data.go.kr/openapi/museum-artgr-info-std?serviceKey=LRfAv2S42k+QXh7V7nYx28VbrpCEbf6rCX4GU5OBi1k/HUGXcsXy80ONnVUi/fJ64Xd0IT2ouRvlCUwDj1xXlw==&type=json&s_list=1000";
	 * String getData = hc.request_get(url, null, header); JsonParser jsonParser =
	 * JsonParser.newInstance(); Gson gson = new Gson().newBuilder().create();
	 * List<Object> container = new ArrayList<Object>();
	 * 
	 * 
	 * try { TypeToken<List<MuseumSetDTO>> typeToken = new
	 * TypeToken<List<MuseumSetDTO>>() { }; Type type = typeToken.getType();
	 * 
	 * List<MuseumSetDTO> temp = (List<MuseumSetDTO>)
	 * jsonParser.jsonToObject(getData, type);
	 * 
	 * System.out.println("List size..." + temp.size());
	 * System.out.println("-----List Printing Start...------");
	 * 
	 * for (int j = 0; j < temp.size(); ++j) {
	 * System.out.println(temp.get(j).get_id()); }
	 * 
	 * MuseumDivider md = new MuseumDivider(); container =
	 * md.MuseumDivideFactory(temp);
	 * 
	 * System.out.println("container size"); System.out.println(container.size());
	 * 
	 * 
	 * List<MuseumDTO> museum = (ArrayList<MuseumDTO>) container.get(0);
	 * List<MuseumLocationDTO> museumLocation = (ArrayList<MuseumLocationDTO>)
	 * container.get(1); List<MuseumCostDTO> museumCost = (ArrayList<MuseumCostDTO>)
	 * container.get(2);
	 * 
	 * 
	 * System.out.println((ArrayList<MuseumDTO>) container.get(0));
	 * System.out.println((ArrayList<MuseumDTO>) container.get(1));
	 * System.out.println((ArrayList<MuseumDTO>) container.get(2));
	 * 
	 * 
	 * 
	 * 
	 * 
	 * museumService.putMuseum(museum); museumService.putMuseumCost(museumCost);
	 * museumService.putMuseumLocation(museumLocation);
	 * 
	 * 
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return "redirect:/join"; }
	 * 
	 * 
	 */
	
	


/*	@RequestMapping(value = "/setMuseumEvents", method = { RequestMethod.GET, RequestMethod.POST })
	public String setMuseumEvents() throws Exception {

		String filepath = "C:\\Users\\gdtbg\\git\\Hello-Docent\\HelloDocent\\src\\main\\resources\\xmlfile\\displaySchedule.xml";
		List<Object> container = new ArrayList<Object>();
		container = (List<Object>) new XmlParser().setParserByFile(filepath, "item",
				new ScheduleInfoFormat(museumService));
		List<MuseumEventDTO> events = new ArrayList<MuseumEventDTO>();

		for (int i = 0; i < container.size(); ++i) {

			System.out.println(i + " 번째 변환중.....");
			events.add((MuseumEventDTO) container.get(i));

		}

		museumService.putMuseumEvent(events);

		return "redirect:/";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/setMuseumSchedule", method = { RequestMethod.GET, RequestMethod.POST })
	public String setMuseum() throws Exception {

		// XmlParser xml = (XmlParser) new
		// XmlParser("C:\\Users\\gdtbg\\git\\Hello-Docent\\HelloDocent\\src\\main\\resources\\xmlfile\\displaySchedule.xml",
		// museumService);
		String request_url = "http://www.emuseum.go.kr/openapi/code?serviceKey=LRfAv2S42k+QXh7V7nYx28VbrpCEbf6rCX4GU5OBi1k/HUGXcsXy80ONnVUi/fJ64Xd0IT2ouRvlCUwDj1xXlw=="
				+ "&numOfRows=100&parentCode=PS01009";

		HttpCommunicator httpRequest = new HttpCommunicator();
		
		 * MultiValueMap<String, String> param = new LinkedMultiValueMap<String,
		 * String>(); param.add("serviceKey",
		 * "LRfAv2S42k+QXh7V7nYx28VbrpCEbf6rCX4GU5OBi1k/HUGXcsXy80ONnVUi/fJ64Xd0IT2ouRvlCUwDj1xXlw=="
		 * ); param.add("numOfRows", "100"); param.add("parentCode", "PS01");
		 
		String response_str = httpRequest.request_get(request_url, null, null);
		System.out.println("응답 본문 : " + response_str);
		Gson gson = new Gson();

		MuseumCodeDTO codeDTO;
		String ref;

		@SuppressWarnings("unchecked")
		Map<String, Map> getParam = gson.fromJson(response_str, Map.class);

		List<Map<String, String>> temp = (List<Map<String, String>>) getParam.get("list");
		Map<String, String> nowMap;
		List<MuseumCodeDTO> container = new ArrayList<MuseumCodeDTO>();
		for (int i = 0; i < temp.size(); ++i) {
			nowMap = temp.get(i);
			ref = museumService.findMuseumKey(nowMap.get("name"));
			if (ref != null) {

				codeDTO = new MuseumCodeDTO();
				codeDTO.setMc_code(nowMap.get("code"));
				codeDTO.setMc_parentCode(nowMap.get("parentCode"));
				codeDTO.setMc_name(nowMap.get("name"));
				codeDTO.setMc_ref(ref);

				container.add(codeDTO);

				System.out.println(codeDTO.getMc_name());
				System.out.println(codeDTO.getMc_code());
				System.out.println(codeDTO.getMc_parentCode());
				System.out.println(codeDTO.getMc_ref());
				System.out.println(i + "번째------------------------------------------");

			}

		}

		System.out.println("코드 리스트 사이즈 : " + container.size());
		museumService.putMuseumCode(container);

		return "redirect:member/join";

	}

	@RequestMapping("/bigData")
	public String InsertBigData() throws Exception {
		long start = System.currentTimeMillis();
		long end;
		System.out.println("시작시간 : " + start);

		// String filepath=
		// "C:\\Users\\gdtbg\\git\\Hello-Docent\\HelloDocent\\src\\main\\resources\\xmlfile\\displayout.xml";
		// List<Object> container = new ArrayList<Object>();
		// container = (List<Object>)new XmlParser().setParserByFile(filepath, "item",
		// new DisplayParseFormat());

		String filePath = "C:\\Users\\gdtbg\\Downloads\\openapi2.xlsx";

		List<DisplayDTO> displays = new ArrayList<DisplayDTO>();
		List<DisplayInfoDTO> infos = new ArrayList<DisplayInfoDTO>();
		
		SAXExcelParser parser = new SAXExcelParser(museumService);
		parser.processFirstSheet(filePath);
		
		end = System.currentTimeMillis();
		System.out.println("종료 시간 : " + end);
		System.out.println("시간 차 : " + (end-start) + " m/s");


		// new ExcelParser().xlsxReader(filePath, displays, infos);

		
		 * ExcelParser2 parser = new ExcelParser2(); parser.inputBulkExcel(filePath);
		 

		FromHowTo how = new FromHowTo();
		how.processFirstSheet(filePath);

		return "redirect:/";

	}*/

}
