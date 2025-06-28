package com.BlogSphere.Spring_boot_project.utils;

import com.BlogSphere.Spring_boot_project.dto.PostDTO;
import org.springframework.stereotype.Component;

import com.BlogSphere.Spring_boot_project.dto.UserDTO;
import com.BlogSphere.Spring_boot_project.entity.Users;
import com.BlogSphere.Spring_boot_project.entity.Posts;

@Component
public class DataBinder {

	
	public UserDTO convertToDTO(Users entity) {
		UserDTO dto = new UserDTO();
		
		dto.setId(entity.getId());
		dto.setEmail(entity.getEmail());
		
		return dto;
	}
	
	public Users convertToEntity(UserDTO dto) {
		
		Users entity = new Users();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhoneNo(dto.getPhoneNo());
		
		return entity;
	}

	public PostDTO convertToDTo(Posts entity){
		PostDTO dto = new PostDTO();
		dto.setId(entity.getId());
		dto.setContent(entity.getContent());
		dto.setPostType(entity.getPostType());
		dto.setDate(entity.getDate());
		return dto;
	}

	public Posts convertToEntity(PostDTO dto){
		Posts post = new Posts();
		post.setId(dto.getId());
		post.setContent(dto.getContent());
		post.setPostType(dto.getPostType());
		post.setDate(dto.getDate());
		return post;
	}

}
