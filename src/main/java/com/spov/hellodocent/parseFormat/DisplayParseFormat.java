package com.spov.hellodocent.parseFormat;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.spov.hellodocent.domain.DisplayDTO;
import com.spov.hellodocent.domain.DisplayInfoDTO;

public class DisplayParseFormat implements ParseFormat {

	private Element element;
	
	@Override
	public Object xmlParseFormat(NodeList nodeList) {

		
		System.out.println("Parsing Data Size : " + nodeList.getLength());
		
		List<DisplayDTO> display_container = new ArrayList<DisplayDTO>();
		List<DisplayInfoDTO> info_container = new ArrayList<DisplayInfoDTO>();
		
		DisplayDTO display;
		DisplayInfoDTO displayInfo;
		
		
		String tempStr;
		String id;
		String temp[];
		NodeList nodes;
		ArrayList<String> tagsName = new ArrayList<String>();
		String tagName = null;
		
		for(int i = 0 ; i<nodeList.getLength(); ++i) {
			
			
			try {
				System.out.println(i+"번째 파싱중입니다.......");
				System.out.println("-------------------print elements name --------------------");
				element = (Element) nodeList.item(i);
				nodes = (NodeList) nodeList.item(i);
				
				display = new DisplayDTO();
				displayInfo = new DisplayInfoDTO();

				
				for(int index=0; index<nodes.getLength(); ++index) {
						
				tagName = nodes.item(index).getNodeName();
					
				if(tagName.equals("#text"))
					continue;
			
				//initSetters(tagName, element, display, displayInfo);
				
				}
				

				
				System.out.println("이름:" + display.getDp_name());
				System.out.println("id값 : " + display.getDp_id());
				
				display_container.add(display);
				info_container.add(displayInfo);
				
				
				
				
			}catch(Exception e) {
				
				
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
		
		System.out.println("display array size .... : " + display_container.size());
		System.out.println("displaInfoy array size .... : " + info_container.size());
		System.out.println("종료시각 : " + System.currentTimeMillis());

		

		
		
		return null;
	}
	
	
/*	private void initSetters(String token, Element element, DisplayDTO display, DisplayInfoDTO displayInfo) {
		
		if(token.equals("UCI")) {
			String tempStr;
			String temp[];
			tempStr = element.getElementsByTagName("UCI").item(0).getTextContent();
			System.out.println("들어있는 UCI은? ---> " + tempStr);
			temp = tempStr.split("\\.");
			display.setDp_id(temp[2]);
			displayInfo.setDpl_id(temp[2]);}
		else if(token.equals("CREATOR"))
		{display.setDp_exp(element.getElementsByTagName("CREATOR").item(0).getTextContent())}
		else if(token.equals("DISPLAY")){display.setDp_type(element.getElementsByTagName("TYPE").item(0).getTextContent())}
		else if(token.equals("TITLE")){display.setDp_name(element.getElementsByTagName("TITLE").item(0).getTextContent())}
		else if(token.equals("ALTERNATIVE_TITLE")){displayInfo.setDpl_alternativeTitle(element.getElementsByTagName("ALTERNATIVE_TITLE").item(0).getTextContent());}
		else if(token.equals("EXTENT")){displayInfo.setDpl_extent(element.getElementsByTagName("EXTENT").item(0).getTextContent());}
		else if(token.equals("REFERENCE_IDENTIFIER")){displayInfo.setDpl_imageUrl(element.getElementsByTagName("REFERENCE_IDENTIFIER").item(0).getTextContent());}
		else if(token.equals("PUBLISHER")){displayInfo.setDpl_rights(element.getElementsByTagName("PUBLISHER").item(0).getTextContent());}  
		else if(token.equals("TEMPORAL")){displayInfo.setDpl_temporal(element.getElementsByTagName("TEMPORAL").item(0).getTextContent());}
		else if(token.equals("URL")){displayInfo.setDpl_url(element.getElementsByTagName("URL").item(0).getTextContent());}
	

		}*/
		
		
		
	}
	
	

