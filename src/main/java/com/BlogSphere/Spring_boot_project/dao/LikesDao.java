package com.BlogSphere.Spring_boot_project.dao;

import com.BlogSphere.Spring_boot_project.entity.Likes;
import com.BlogSphere.Spring_boot_project.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LikesDao {

    @Autowired
    LikesRepository likesRepository;


    public Likes save(Likes likes){

        return likesRepository.save(likes);
    }
}
