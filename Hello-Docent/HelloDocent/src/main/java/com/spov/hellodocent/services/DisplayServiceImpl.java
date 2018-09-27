package com.spov.hellodocent.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spov.hellodocent.domain.SearchDTO;
import com.spov.hellodocent.persistence.DisplayDAO;

@Service
public class DisplayServiceImpl implements DisplayService{

	@Inject
	DisplayDAO displayDAO;

	@Override
	public List<Map<String, String>> getMuseumInfo() {
		
		return displayDAO.getMuseumInfo();
	}

	@Override
	public List<Map<String, String>> getDisplayInfo(Map<String, String> params) {
		return displayDAO.getDisplayInfo(params);
	}

	@Override
	public Map<String, String> getDisplayInfoSimple(String keyword) {
		return displayDAO.getDisplayInfoSimple(keyword);
	}

	@Override
	public List<Map<String, String>> getMuseumInfoDefault() {
		
		return displayDAO.getMuseumInfoDefault();
	}

	@Override
	public List<Map<String, String>> getDisplayInfoDefault(SearchDTO param) {
		
		String[] words = param.getKeyword().split(" ");
		List<String> wordList = new ArrayList<>();
		
		for(String str : words) {
			
		wordList.add(str);
			
		}
		
		param.setWordList(wordList);
		displayDAO.getDisplayInfoDefault(param);
		
		return displayDAO.getDisplayInfoDefault(param);
	}

	@Override
	public List<Map<String, String>> getDisplayInfoSimpleCard(String keyword) {
		return displayDAO.getDisplayInfoSimpleCard(keyword);
	}

	@Override
	public List<Map<String, String>> getDisplayInfoByKeyword(String keyword, List<String> museums, String prefix, String suffix) {

		
		String[] strArr = keyword.split(" ");
		List<String> wordList = new ArrayList<String>();
		
		for(String str : strArr) {
			
			if(str!=null && str.trim().length()>0) {
				
				wordList.add(str);
				
				
			}
			
			
		}
		
		System.out.println("word list : ");
		System.out.println(wordList);
		

		
		SearchDTO param = new SearchDTO();
		param.setKeyword(keyword);
		param.setPrefix(prefix);
		param.setSuffix(suffix);
		param.setWordList(wordList);
		
		
		return displayDAO.getDisplayInfoByKeyword(param);
	}

	@Override
	public List<Map<String, String>> getMuseumInfoByKeyword(String keyword) {
		
		
		String[] strArr = keyword.split(" ");
		List<String> wordList = new ArrayList<String>();
		
		for(String str : strArr) {
			
			if(str!=null && str.trim().length()>0) {
				
				wordList.add(str);
	
			}
		
	}
	

		return displayDAO.getMuseumInfoByKeyword(wordList);

	
	}
	
}
	
	
	
	
	
	
