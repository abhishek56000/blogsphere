package com.BlogSphere.Spring_boot_project.controller;

import com.BlogSphere.Spring_boot_project.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {
    @Autowired
    TagService tagService;
    @PostMapping("/createTag")
    ResponseDTO<TagDto>create(TagDto tagDto){

        tagDto=tagService.save(tagDto);

        return new ResponseDTO<>(true,"tag save",tagDto);
    }

}
