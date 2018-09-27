package com.spov.hellodocent.parseFormat;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.spov.hellodocent.domain.MuseumEventDTO;
import com.spov.hellodocent.services.MuseumService;

public class ScheduleInfoFormat implements ParseFormat {

	MuseumService service;

	Element element;

	public ScheduleInfoFormat(MuseumService service) {
		super();
		this.service = service;

	}

	@Override
	public Object xmlParseFormat(NodeList nodeList) {

		System.out.println(nodeList.getLength());
		List<MuseumEventDTO> container = new ArrayList<MuseumEventDTO>();

		/*
		 * int counter = 0;
		 * 
		 * String flag; MuseumEventDTO dto; String checkArr[]; String tempStr;
		 * 
		 * Date today = new Date(); Date compareDate = new Date(); int checkSum = 0;
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 * 
		 * 
		 * 
		 * for (int i = 0; i < nodeList.getLength(); ++i) {
		 * 
		 * try { element = (Element) nodeList.item(i); flag =
		 * element.getElementsByTagName("period").item(0).getTextContent(); //
		 * System.out.println(flag);
		 * 
		 * if (flag != null && flag.contains("2018")) {
		 * 
		 * checkArr = flag.split("~"); String temp = checkArr[1].replaceAll("\\s", "");
		 * compareDate = sdf.parse(temp); checkSum = today.compareTo(compareDate);
		 * 
		 * if (checkSum < 0 || checkSum == 0) {
		 * 
		 * tempStr =
		 * (element.getElementsByTagName("collectionDb").item(0).getTextContent())
		 * .replace("DB", "").replaceAll("\\s", ""); dto = new MuseumEventDTO(); String
		 * uid = service.findMuseumKey(tempStr); dto.setDe_ref(uid);
		 * dto.setDe_category(service.getMuseumType(uid));
		 * dto.setDe_uci(element.getElementsByTagName("uci").item(0).getTextContent());
		 * dto.setDe_image(element.getElementsByTagName("referenceIdentifier").item(0).
		 * getTextContent());
		 * dto.setDe_person(element.getElementsByTagName("person").item(0).
		 * getTextContent());
		 * dto.setDe_url(element.getElementsByTagName("url").item(0).getTextContent());
		 * dto.setDe_title(element.getElementsByTagName("title").item(0).getTextContent(
		 * ));
		 * dto.setDe_venue(element.getElementsByTagName("venue").item(0).getTextContent(
		 * ));
		 * dto.setDe_subCategory(element.getElementsByTagName("subjectCategory").item(0)
		 * .getTextContent()); dto.setDe_startDate(new java.sql.Date
		 * (sdf.parse(checkArr[0]).getTime())); dto.setDe_endDate(new java.sql.Date
		 * (sdf.parse(checkArr[1]).getTime())); //
		 * System.out.println(element.getElementsByTagName("affiliation").item(0).
		 * getTextContent());
		 * 
		 * container.add(dto); ++counter;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); System.out.println("error : " + e.getMessage()); }
		 * 
		 * }
		 * 
		 * System.out.println("2018년에 있는 총 행사 개수는? " + counter);
		 * System.out.println(container.size());
		 * 
		 * for (int j = 0; j < container.size(); ++j) {
		 * 
		 * MuseumEventDTO dtoo = container.get(j);
		 * 
		 * try {
		 * 
		 * System.out.println(j + "번째---------------------------------------------");
		 * 
		 * System.out.println(dtoo.getDe_ref() + "  " + dtoo.getDe_image() + "  " +
		 * dtoo.getDe_person() + "  " + dtoo.getDe_subCategory() + "  " +
		 * dtoo.getDe_title() + "  " + dtoo.getDe_uci() + "  " + dtoo.getDe_url() + "  "
		 * + dtoo.getDe_venue());
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); } }
		 */

		return container;
	}

}
