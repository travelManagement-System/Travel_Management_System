package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Image;

public interface ImageDao extends JpaRepository<Image, Long>{

}
