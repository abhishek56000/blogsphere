package com.BlogSphere.Spring_boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BlogSphere.Spring_boot_project.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);
	
	
}

