package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Long>{

}
