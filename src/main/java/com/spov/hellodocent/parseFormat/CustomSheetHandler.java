package com.spov.hellodocent.parseFormat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.spov.hellodocent.domain.DisplayDTO;
import com.spov.hellodocent.domain.DisplayInfoDTO;
import com.spov.hellodocent.services.MuseumService;

public class CustomSheetHandler extends DefaultHandler {

	private final SharedStringsTable sst;
	private String lastContents;
	private boolean nextIsString;
	private boolean inlineStr;
	private final LruCache<Integer, String> lruCache = new LruCache<>(50);

	private List<DisplayDTO> displays;
	private List<DisplayInfoDTO> infos;
	private DisplayDTO display;
	private DisplayInfoDTO info;
	private String Token;
	private int rowCount;
	private String sequence;
	
	private MuseumService service;

	public CustomSheetHandler(SharedStringsTable sst, MuseumService service) {
		super();
		this.sst = sst;
		this.service = service;
		displays = new ArrayList<>();
		infos = new ArrayList<>();
		rowCount = -1;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		super.startElement(uri, localName, qName, attributes);

		// c => cell
				if (qName.equals("c")) {
					// Print the cell reference
		
		System.out.println(attributes.getValue("r"));
		System.out.println(qName);

		String temp = attributes.getValue("r");
		sequence = temp.substring(0, 1).toUpperCase();
		int counter = Integer.valueOf(temp.substring(1, temp.length()));
		
		
		if (counter != rowCount) { // a, b, c..... o, p 까지 순서가 다 돌고 이제 다른 행으로 넘어간 상태. vo를 초기화 시켜준다.


			if(rowCount != -1) {
				
				displays.add(display);
				infos.add(info);
				//service.putDisplayInfo(display, info);
							
				
			}
			
			display = new DisplayDTO();
			info = new DisplayInfoDTO();
			rowCount = counter;
			
			System.out.println("now data size.... " + displays.size() + "  /  " + infos.size());

		}

		

			System.out.print(attributes.getValue("r") + " - ");
			// Figure out if the value is an index in the SST
			String cellType = attributes.getValue("t");
			nextIsString = cellType != null && cellType.equals("s");
			inlineStr = cellType != null && cellType.equals("inlineStr");
		}
		// Clear contents cache
		lastContents = "";

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);

		// Process the last contents as required.
		// Do now, as characters() may be called more than once
		if (nextIsString) {
			Integer idx = Integer.valueOf(lastContents);

			lastContents = lruCache.get(idx);
			if (lastContents == null && !lruCache.containsKey(idx)) {
				lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
				lruCache.put(idx, lastContents);
			}
			nextIsString = false;
		}

		// v => contents of a cell
		// Output after we've seen the string contents
		if (qName.equals("v") || (inlineStr && qName.equals("c"))) {
			
			pushData(lastContents,sequence);
			System.out.println(lastContents);
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		lastContents += new String(ch, start, length);

	}

	private static class LruCache<A, B> extends LinkedHashMap<A, B> {
		private final int maxEntries;

		public LruCache(final int maxEntries) {
			super(maxEntries + 1, 1.0f, true);
			this.maxEntries = maxEntries;
		}

		@Override
		protected boolean removeEldestEntry(final Map.Entry<A, B> eldest) {
			return super.size() > maxEntries;
		}
	}

	public void pushData(String content, String sequence) {

		System.out.println("들어온 content... " + content);
		
		switch (sequence) {

		// 부제목
		case "B": {

			info.setDpl_alternativeTitle(content);

		}
			break;

		// CREATOR
		case "D": {

			display.setDp_exp(content);

		}
			break;

		// EXTENT
		case "E": {

			info.setDpl_extent(content);

		}
			break;

		// PUBLISHER
		case "I": {

			info.setDpl_publisher(content);

		}
			break;

		// 썸네일 이미지
		case "J": {

			info.setDpl_imageUrl(content);

		}
			break;

		// 시대정보
		case "L": {
			info.setDpl_temporal(content);
		}
			break;
		// 제목
		case "M": {

			display.setDp_name(content);
			System.out.println("현재 제목 .. --> " + content);
		}
			break;

		// 타입
		case "N": {

			display.setDp_type(content);
		}
			break;
		// UCI 정보
		case "O": {

			
			display.setDp_uci(content);
			String temp[] = content.split("\\.");
			System.out.println("temp size.... " + temp.length);
			display.setDp_id(temp[2]);
			info.setDpl_id(temp[2]);
			System.out.println("현재 ID .. --> " + temp[2]);


		}break;
		
		//url
		case "P": {

			info.setDpl_url(content);
		}break;
		
		
		default : System.out.println("Content parsing error"); break;

		}

	}


	@Override
	public void endDocument() throws SAXException {

		
		service.putDisplayInfo(displays, infos);
		
		
		super.endDocument();
	}
	
	
	

}
