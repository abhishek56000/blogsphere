package com.BlogSphere.Spring_boot_project.dao;

import com.BlogSphere.Spring_boot_project.dto.TagDto;
import com.BlogSphere.Spring_boot_project.entity.Tag;
import com.BlogSphere.Spring_boot_project.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TagDao {

    @Autowired
    TagRepository tagRepository;

    public Tag save(Tag tag){
        return tagRepository.save(tag);
    }

    public Tag getTagByName(String name){
       return tagRepository.findByName(name);
    }


}
