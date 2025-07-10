package com.BlogSphere.Spring_boot_project.repository;

import com.BlogSphere.Spring_boot_project.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer> {
}
