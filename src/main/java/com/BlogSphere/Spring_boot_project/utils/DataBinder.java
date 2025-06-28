package com.BlogSphere.Spring_boot_project.utils;

import org.springframework.stereotype.Component;

import com.BlogSphere.Spring_boot_project.dto.UserDTO;
import com.BlogSphere.Spring_boot_project.entity.Users;

@Component
public class DataBinder {

	
	public UserDTO convertToDTO(Users entity) {
		UserDTO dto = new UserDTO();
		
		dto.setId(entity.getId());
		
		return dto;
	}
	
	public Users convertToEntity(UserDTO dto) {
		
		Users entity = new Users();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhoneNo(dto.getPhoneNo());
		
		return entity;
	}
}
