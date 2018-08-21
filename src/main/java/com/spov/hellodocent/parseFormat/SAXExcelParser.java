package com.spov.hellodocent.parseFormat;

import java.io.InputStream;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.spov.hellodocent.services.MuseumService;


public class SAXExcelParser {
	
	MuseumService service;
	
	
	   public SAXExcelParser(MuseumService service) {
		super();
		this.service = service;
	}

	public void processFirstSheet(String filename) throws Exception {
	        try (OPCPackage pkg = OPCPackage.open(filename, PackageAccess.READ)) {
	            XSSFReader r = new XSSFReader(pkg);
	            SharedStringsTable sst = r.getSharedStringsTable();

	            XMLReader parser = fetchSheetParser(sst);

	            // process the first sheet
	            try (InputStream sheet = r.getSheetsData().next()) {
					InputSource sheetSource = new InputSource(sheet);
					parser.parse(sheetSource);
				}
	        }
	    }

	    public void processAllSheets(String filename) throws Exception {
	        try (OPCPackage pkg = OPCPackage.open(filename, PackageAccess.READ)) {
	            XSSFReader r = new XSSFReader(pkg);
	            SharedStringsTable sst = r.getSharedStringsTable();

	            XMLReader parser = fetchSheetParser(sst);

	            Iterator<InputStream> sheets = r.getSheetsData();
	            while (sheets.hasNext()) {
	                System.out.println("Processing new sheet:\n");
	                try (InputStream sheet = sheets.next()) {
						InputSource sheetSource = new InputSource(sheet);
						parser.parse(sheetSource);
					}
	                System.out.println("");
	            }
	        }
	    }

	    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException, ParserConfigurationException {
	        XMLReader parser = SAXHelper.newXMLReader();
	        ContentHandler handler = new CustomSheetHandler(sst, service);
	        parser.setContentHandler(handler);
	        return parser;
	    }


}
