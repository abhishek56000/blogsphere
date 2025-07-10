package com.BlogSphere.Spring_boot_project.dao;

import com.BlogSphere.Spring_boot_project.entity.Image;
import com.BlogSphere.Spring_boot_project.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDao {

    @Autowired
    ImageRepository imageRepository;

    public Image save(Image image){
        return imageRepository.save(image);
    }
}
