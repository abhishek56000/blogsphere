package com.BlogSphere.Spring_boot_project.repository;

import com.BlogSphere.Spring_boot_project.entity.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio,Integer> {

}
