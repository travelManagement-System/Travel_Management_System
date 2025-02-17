package com.sunbeam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Package;

public interface PackageDao extends JpaRepository<Package, Long>{
	 @Query("SELECT p FROM Package p WHERE p.packageName = :packageName")
	    Package findByName(@Param("packageName") String packageName);
}
