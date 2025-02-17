package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.TravellerDTO;
import com.sunbeam.dto.TravellerRequestDTO;
import com.sunbeam.service.TravellerServiceImpl;

@RestController
@RequestMapping("/traveller")
public class TravellerController {
	@Autowired
	private TravellerServiceImpl travellerService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addTravellers(@RequestBody TravellerRequestDTO dto){
		List<TravellerDTO> travellers = dto.getTravellers();
        String bookingNo = dto.getBookingNo();
        System.out.println(bookingNo);
		return ResponseEntity.ok(travellerService.addTravellers(travellers, bookingNo));
	}
}
