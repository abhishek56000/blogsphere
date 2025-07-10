package com.BlogSphere.Spring_boot_project.repository;

import com.BlogSphere.Spring_boot_project.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Integer> {

}
