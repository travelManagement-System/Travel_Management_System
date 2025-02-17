package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.CityDTO;

public interface CityService {
	List<CityDTO> getAllCityDetails(String packageId);
}
