package com.sunbeam.dto;

import com.sunbeam.entities.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravellerDTO {

	private String name;

	private Long age;

	private Gender gender;

	private String email;

	private String aadhaarNo;
	
}
