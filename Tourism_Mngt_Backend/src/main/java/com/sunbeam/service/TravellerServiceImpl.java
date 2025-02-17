package com.sunbeam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.custom_exception.ResourceNotFoundException;
import com.sunbeam.dao.BookingDao;
import com.sunbeam.dao.TravellerDao;
import com.sunbeam.dto.TravellerDTO;
import com.sunbeam.entities.Booking;
import com.sunbeam.entities.Traveller;

@Service
@Transactional
public class TravellerServiceImpl implements TravellerService {
	@Autowired
	private TravellerDao travellerDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BookingDao bookingDao;
	
	
	
	public String addTravellers(List<TravellerDTO> travellers, String bookingNo) {
		Booking booking = bookingDao.findByBookingNo(bookingNo);
		if(booking==null)
			throw new ResourceNotFoundException("Invalid Booking No!!");
			
		for (TravellerDTO traveller : travellers) {
			Traveller travellerEntity = mapper.map(traveller, Traveller.class);
			travellerEntity.setBookingNo(booking);
			travellerDao.save(travellerEntity);
		}

		return "Traveller details added successfully";
	}
}
