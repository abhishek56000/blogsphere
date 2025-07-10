package com.BlogSphere.Spring_boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BlogSphere.Spring_boot_project.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
