package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.dto.CityDTO;
import com.sunbeam.entities.City;

public interface CityDao extends JpaRepository<City, Long>{
	@Query("SELECT new com.sunbeam.dto.CityDTO(c.id, c.name, c.cityDetails, c.cityImage, c.duration, c.price) " +
	           "FROM City c WHERE c.packageEntity.id = :packageId")
	List<CityDTO> findByPackageId(Long packageId);
	
	 @Query("SELECT c FROM City c LEFT JOIN FETCH c.images WHERE c.id = :cityId")
	    City findCityWithImagesById(Long cityId);
}
