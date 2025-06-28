package com.BlogSphere.Spring_boot_project.service;

import com.BlogSphere.Spring_boot_project.exception.InvalidInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlogSphere.Spring_boot_project.dao.UserDao;
import com.BlogSphere.Spring_boot_project.dto.UserDTO;
import com.BlogSphere.Spring_boot_project.entity.Users;
import com.BlogSphere.Spring_boot_project.utils.DataBinder;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UserDao userDao;
	
	@Autowired
	DataBinder dataBinder;



	public UserDTO saveUserDao(UserDTO userDTO) {
		log.info("user registration >>");
		validateInput(userDTO);

		Users users = dataBinder.convertToEntity(userDTO);
		users = userDao.saveUserDao(users);
		return dataBinder.convertToDTO(users);
		
	}
	
	public Users getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	private void validateInput(UserDTO user){
		if(user.getEmail().equals("")){
			throw new InvalidInputException("Email Id cant be empty");
		}

	}

}
