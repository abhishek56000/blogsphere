package com.BlogSphere.Spring_boot_project.dao;

import com.BlogSphere.Spring_boot_project.entity.Posts;
import com.BlogSphere.Spring_boot_project.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {
    @Autowired
    PostRepository postrepository;

    public Posts savePostDao(Posts post){
        return postrepository.save(post);
    }
}
