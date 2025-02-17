package com.sunbeam.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravellerRequestDTO {
	private List<TravellerDTO> travellers;
	
	private String bookingNo;
}
