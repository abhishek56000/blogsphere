package com.BlogSphere.Spring_boot_project.dao;

import com.BlogSphere.Spring_boot_project.entity.Post;
import com.BlogSphere.Spring_boot_project.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao {
    @Autowired
    PostRepository postrepository;

    public Post createPost(Post post){
        return postrepository.save(post);
    }
    public Post getPostById(int id){
        return postrepository.findById(id).orElse(null);

    }
    public List<Post> getAllPost(){
        return postrepository.findAll();
    }
public void deletePostData(int id){
        postrepository.deleteById(id);
}
}
