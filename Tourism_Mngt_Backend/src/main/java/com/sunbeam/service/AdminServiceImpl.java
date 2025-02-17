 package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exception.ApiException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.AdminDTO;
import com.sunbeam.entities.User;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public String addNewAdmin(AdminDTO dto) {
		if (dto.getPassword().equals(dto.getConfirmPassword())) {
			User userEntity = mapper.map(dto, User.class);
			userDao.save(userEntity);
			return "Admin registered successfully";
		}
		throw new ApiException("Password doesn't match! Try again");
	}

}
