package com.BlogSphere.Spring_boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BlogSphere.Spring_boot_project.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}

