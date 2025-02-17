package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.BookingRequestDTO;
import com.sunbeam.dto.BookingResponseDTO;
import com.sunbeam.dto.UserBookingDTO;

public interface BookingService {
	String addBookingDetails(BookingRequestDTO dto);
	
	UserBookingDTO getUserAllBookingDetails(String email);
	
	List<BookingResponseDTO> getAllBookings();
	
	String deleteBooking(String bookingNo);
}
