package com.BlogSphere.Spring_boot_project.service;

import com.BlogSphere.Spring_boot_project.dao.PostDao;
import com.BlogSphere.Spring_boot_project.dao.UserDao;
import com.BlogSphere.Spring_boot_project.dto.PostDTO;
import com.BlogSphere.Spring_boot_project.entity.Posts;
import com.BlogSphere.Spring_boot_project.utils.DataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostDao postDao;
    @Autowired
    DataBinder dataBinder;

    public PostDTO savePostDao(PostDTO dto){
        Posts post = dataBinder.convertToEntity(dto);
        post=postDao.savePostDao(post);
        return dataBinder.convertToDTo(post);
    }
}
