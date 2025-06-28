package com.BlogSphere.Spring_boot_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BlogSphere.Spring_boot_project.entity.Users;
import com.BlogSphere.Spring_boot_project.repository.CommentRepository;
import com.BlogSphere.Spring_boot_project.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	CommentRepository commonRepository;
	
	
	public Users saveUserDao(Users user) {
		
		return userRepository.save(user);
	}

	public Users getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	public Users getUserById(int id) {
		Users user= userRepository.findById(id).orElseThrow(null);
		if(user==null) {
		//	throw new  UserNotFoundException("user id="+id+"is not found");
		}
		return user;
	}
	public void deleteuserById(int id) {
		userRepository.deleteById(id);
	}
	public Users updateuserById(int id,Users user) {
		user.setId(id);
		return userRepository.save(user);
	}
}
