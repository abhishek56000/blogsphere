package com.BlogSphere.Spring_boot_project.repository;

import com.BlogSphere.Spring_boot_project.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Integer> {

    Tag findByName(String name);
}

