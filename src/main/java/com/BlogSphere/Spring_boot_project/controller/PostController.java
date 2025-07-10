package com.BlogSphere.Spring_boot_project.controller;

import com.BlogSphere.Spring_boot_project.dto.PostDTO;
import com.BlogSphere.Spring_boot_project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import com.BlogSphere.Spring_boot_project.dto.ResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/create")
    public ResponseDTO<PostDTO> create(@RequestBody PostDTO dto) {

        PostDTO post = postService.createPost(dto);

        return new ResponseDTO<PostDTO>(true, "post saved", post);
    }

    @GetMapping("/{id}")
    public ResponseDTO<PostDTO> getPostController(@PathVariable int id) {
        PostDTO dto = postService.serviceGetPostById(id);
        return new ResponseDTO<PostDTO>(true, "post saved", dto);

    }

    @GetMapping("/getAllPost")
    public ResponseDTO<List<PostDTO>> getAllPostController() {

        List<PostDTO> dto = postService.serviceGetPostAll();

        return new ResponseDTO<>(true, "post saved", dto);
    }
    @PutMapping ("/updatePost/{id}")
    public ResponseDTO<PostDTO> updatePostController(@PathVariable int id ,@RequestBody PostDTO dto) {
        PostDTO post = postService.serviceUpdatePostDao(id,dto);

        return new ResponseDTO<PostDTO>(true, "post saved", post);
    }

@DeleteMapping("/deletePost/{id}")
    public ResponseDTO<String>deletePostController(@PathVariable int id){
        postService.serviceDeletePostDao(id);

        return new ResponseDTO<String>(true,"Data is deleted");
    }
}


