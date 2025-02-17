package com.sunbeam.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.custom_exception.ApiException;
import com.sunbeam.dto.CityDTO;
import com.sunbeam.dto.PackageDTO;
import com.sunbeam.dto.PackageResponseDTO;
import com.sunbeam.dto.UpdatePackageDTO;
import com.sunbeam.entities.Package;
import com.sunbeam.service.CityServiceImpl;
import com.sunbeam.service.PackageService;
import com.sunbeam.service.PackageServiceImpl;

@RestController
@RequestMapping("/packages")
@CrossOrigin(origins = "http://localhost:3000")
public class PackageController {
	@Autowired
	private PackageServiceImpl packageServiceImpl;
	@Autowired
	private CityServiceImpl cityService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPackage(@ModelAttribute PackageDTO dto){
		packageServiceImpl.addPackage(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Package added successfully");
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePackage(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(packageServiceImpl.deletePackage(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllCities(@PathVariable String id){
		List<CityDTO> cities = cityService.getAllCityDetails(id);
		System.out.println(cities);
		return ResponseEntity.status(HttpStatus.OK).body(cities);
	}
	
//	@PutMapping("/update/{packageId}")
//	public ResponseEntity<?> updatePackage(@PathVariable Long packageId, @RequestBody PackageDTO dto){
//		
//		Package p = packageServiceImpl.updatePackage(dto);
//		
//		return null;
//	}
	
	@PutMapping("/update/{packageId}")
	public ResponseEntity<?> updatePackage(@PathVariable Long packageId, @RequestBody UpdatePackageDTO dto){
		//Object obj = packageServiceImpl.updatePackage(packageId, dto);
		return ResponseEntity.status(HttpStatus.OK).body(packageServiceImpl.updatePackage(packageId, dto));
	}
	
	
} 
