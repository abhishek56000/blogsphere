package com.BlogSphere.Spring_boot_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlogSphere.Spring_boot_project.dao.UserDao;
import com.BlogSphere.Spring_boot_project.dto.UserDTO;
import com.BlogSphere.Spring_boot_project.entity.Users;
import com.BlogSphere.Spring_boot_project.utils.DataBinder;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	DataBinder dataBinder;

	public UserDTO saveUserDao(UserDTO userDTO) {
		
		Users users = dataBinder.convertToEntity(userDTO);
		
		
		users = userDao.saveUserDao(users);	
		
		
		return dataBinder.convertToDTO(users);
		
	}
	
	public Users getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
	

}
