package com.BlogSphere.Spring_boot_project.dao;

import java.util.List;

import com.BlogSphere.Spring_boot_project.entity.User;
import com.BlogSphere.Spring_boot_project.exception.InvalidInputException;
import com.BlogSphere.Spring_boot_project.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BlogSphere.Spring_boot_project.repository.CommentRepository;
import com.BlogSphere.Spring_boot_project.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	CommentRepository commonRepository;
	

	public User saveUserDao(User user) {
		
		return userRepository.save(user);
	}

	public User getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public User getUserById(int id) {
		User user= userRepository.findById(id).orElseThrow(null);
		if(user==null) {
			throw new InvalidInputException("user id is not found");
		}
		return user;
	}
	public void deleteUserById(int id) {

		userRepository.deleteById(id);
	}
	public User updateUserById(	 User user) {

		return userRepository.save(user);
	}

}
