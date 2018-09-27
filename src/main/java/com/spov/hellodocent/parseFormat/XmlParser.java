package com.spov.hellodocent.parseFormat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.spov.hellodocent.services.MuseumService;

public class XmlParser {


	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;
	private NodeList nodeList;
	private Node node;
	private Element element;

	private String xmlFilePath;
	private File xmlFile;

	private List<Object> parsedList;
	
	private MuseumService service;
	

	public XmlParser()
			throws ParserConfigurationException, SAXException, IOException {

		
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		parsedList = new ArrayList<Object>();



	}

	
	
	public  List<Object> setParserByFile(String filePath, String splitToken, ParseFormat format) throws Exception {
		
		xmlFile = new File(filePath);
		doc = builder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		nodeList = doc.getElementsByTagName(splitToken);
		List<Object>list = (List<Object>)format.xmlParseFormat(nodeList);
		return list;	
		
	}

	
	public  List<Object> setParserByString(String rawStr, String splitToken, ParseFormat format) throws Exception{
		
		
		
		doc = builder.parse(rawStr);
		doc.getDocumentElement().normalize();
		nodeList = doc.getElementsByTagName(splitToken);
		List<Object>list = (List<Object>)format.xmlParseFormat(nodeList);
		return list;
		
		
		
		
		
	}
	
	
	

	
	
	
	
}
