package com.sunbeam.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Image;
import com.sunbeam.entities.Package;

public interface ImageHandlingService {
	Package uploadImage(Package packageDetails, MultipartFile image) throws IOException;
	byte[] serveImage(String packageName) throws IOException;
	List<Image> uploadImage(Long id, MultipartFile[] images) throws IOException;
}
