package com.BlogSphere.Spring_boot_project.repository;

import com.BlogSphere.Spring_boot_project.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text,Integer> {

}
