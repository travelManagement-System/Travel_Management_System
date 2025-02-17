package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ForgetPasswordDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.dto.UserResponseDTO;

public interface UserService {
	String addNewUser(UserDTO dto);
	String setPassword(ForgetPasswordDTO dto);	
	String deleteUser(String email);
	List<UserResponseDTO> getAllUsers();
}
