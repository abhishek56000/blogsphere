package com.BlogSphere.Spring_boot_project.service;

import com.BlogSphere.Spring_boot_project.dao.TagDao;
import com.BlogSphere.Spring_boot_project.entity.Tag;
import com.BlogSphere.Spring_boot_project.utils.DataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
     @Autowired
     DataBinder dataBinder;
     @Autowired
    TagDao tagDao;
    public TagDto save(TagDto tagDto){
        Tag tag=new Tag();
        tag=dataBinder.convertToEntity(tagDto);
        tag=tagDao.save(tag);
        return dataBinder.convertToDto(tag);
    }
    public TagDto getName(TagDto tagDto){
        Tag tag=new Tag();
        tag=dataBinder.convertToEntity(tagDto);
        tag=tagDao.getTagByName(tag.getName());
        if(tag==null){
            return null;
        }else {
            return dataBinder.convertToDto(tag);
        }

    }
}
