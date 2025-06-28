package com.BlogSphere.Spring_boot_project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BlogSphere.Spring_boot_project.dao.UserDao;
import com.BlogSphere.Spring_boot_project.dto.ResponseDTO;
import com.BlogSphere.Spring_boot_project.dto.UserDTO;
import com.BlogSphere.Spring_boot_project.entity.Users;
import com.BlogSphere.Spring_boot_project.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao usersdao;

	Logger LOG = LoggerFactory.getLogger(UserController.class);

	@PostMapping(value = "/user/save")
	public ResponseDTO<UserDTO> saveUserController(@RequestBody UserDTO user) {
		
		LOG.info("Hello");
		UserDTO users = userService.saveUserDao(user);
		return new ResponseDTO<UserDTO>(true, "User saved", users);
		
		
		
	}
	@GetMapping(value = "/getAllUsers")
	public List<Users> getAllDataDao() {
		return usersdao.getAllUsers();
	}

	@GetMapping("/getUserById/{id}")
	public Users getUserById(@PathVariable int id) {
		return usersdao.getUserById(id);
	}
	@DeleteMapping("/deleteUserById/{id}")
		public void delete(@PathVariable int id) {
	  usersdao.deleteuserById(id);
	}
	@PostMapping("/updateuserById/{id}")
	public Users updateuserdta(@PathVariable int id, @RequestBody  Users user) {
		
		return usersdao.updateuserById(id, user);
	}
}
