package com.BlogSphere.Spring_boot_project.controller;

import com.BlogSphere.Spring_boot_project.dto.PostDTO;
import com.BlogSphere.Spring_boot_project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import com.BlogSphere.Spring_boot_project.dto.ResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/savePost")
    public ResponseDTO<PostDTO> savePostController(@RequestBody PostDTO dto){
        PostDTO post = postService.savePostDao(dto);

        return new ResponseDTO<PostDTO>(true,"post saved",post);
    }

}
