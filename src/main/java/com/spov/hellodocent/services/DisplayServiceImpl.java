package com.spov.hellodocent.services;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
	public List<Map<String, String>> getDisplayInfoDefault(Map<String, String> params) {
		return displayDAO.getDisplayInfoDefault(params);
	}

	@Override
	public List<Map<String, String>> getDisplayInfoSimpleCard(String keyword) {
		return displayDAO.getDisplayInfoSimpleCard(keyword);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
