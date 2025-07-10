package com.BlogSphere.Spring_boot_project.service;

import com.BlogSphere.Spring_boot_project.dao.*;
import com.BlogSphere.Spring_boot_project.dto.PostDTO;
import com.BlogSphere.Spring_boot_project.dto.TagDto;
import com.BlogSphere.Spring_boot_project.entity.*;
import com.BlogSphere.Spring_boot_project.enums.PostType;
import com.BlogSphere.Spring_boot_project.exception.InvalidInputException;
import com.BlogSphere.Spring_boot_project.utils.DataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostDao postDao;
    @Autowired
    DataBinder dataBinder;
    @Autowired
    UserDao userDao;
    @Autowired
    VideoDao videoDao;
    @Autowired
   TextDao textDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    AudioDao audioDao;
   @Autowired
   TagDao tagDao;
   @Autowired
   TagService tagService;



    public PostDTO createPost(PostDTO dto) {
        Post post = dataBinder.convertToEntity(dto);
        Audio audio=audioDao.getById(dto.getAudioId());
        User user = userDao.getUserById(dto.getUserId());

        post.setUser(user);
       post.setAudio(audio);

        List<TagDto>tags=dto.getTags();
        List<Tag>entityTags=new ArrayList<>();
        for (int i=0;i< tags.size();i++) {
            if (tagService.getName(tags.get(i))!=null) {
                Tag tag=dataBinder.convertToEntity(tagService.getName(tags.get(i)));
                entityTags.add(tag);

            } else {
                    Tag tag = dataBinder.convertToEntity(tags.get(i));
                    tag = tagDao.save(tag);
                    entityTags.add(tag);
                }

            }

         post.setTags(entityTags);

        if (PostType.VIDEO.equals(dto.getPostType())) {
            Video video = dataBinder.convertToEntity(dto.getVideo());
            video = videoDao.save(video);
            post.setVideo(video);
        }
        if (PostType.TEXT.equals(dto.getPostType())) {
            Text text = dataBinder.convertToEntity(dto.getText());
            text = textDao.save(text);
            post.setText(text);
        }
        if(PostType.IMAGE.equals(dto.getPostType())) {
          Image image = dataBinder.convertToEntity(dto.getImage());
          image=imageDao.save(image);
          post.setImage(image);
        }

            post = postDao.createPost(post);
            return dataBinder.convertToDTo(post);

    }


    public PostDTO serviceGetPostById(int id) {
        Post post = postDao.getPostById(id);
        if (post == null) {
            throw new InvalidInputException("id is not found");
        }
        return dataBinder.convertToDTo(post);
    }

    public List<PostDTO> serviceGetPostAll() {
        List<Post> post = postDao.getAllPost();
        if (post.isEmpty()) {
            throw new InvalidInputException("post is not found by this id");
        }
        List<PostDTO> dtoList = new ArrayList<>();

        for (int i = 0; i < post.size(); i++) {
            dtoList.add(dataBinder.convertToDTo(post.get(i)));
        }
        return dtoList;
    }

    public PostDTO serviceUpdatePostDao(int id, PostDTO dto) {
        Post post = postDao.getPostById(id);
        if (dto.getPostType() != null) {
            post.setPostType(dto.getPostType());
        }
        if (dto.getContent() != null) {
            post.setContent(dto.getContent());
        }
        if (dto.getDate() != null) {
            post.setCreatedDate(dto.getDate());
        }
        post = postDao.createPost(post);
        return dataBinder.convertToDTo(post);
    }

    public void serviceDeletePostDao(int id) {
        postDao.deletePostData(id);

    }


}

