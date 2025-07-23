package com.BlogSphere.Spring_boot_project.utils;

import com.BlogSphere.Spring_boot_project.dto.*;
import com.BlogSphere.Spring_boot_project.entity.*;
import com.BlogSphere.Spring_boot_project.enums.PostType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DataBinder {


    public UserDTO convertToDTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setUsername(entity.getUsername());
        dto.setAbout(entity.getAbout());
        dto.setPwd(entity.getPwd());
        dto.setPhoto(entity.getPhoto());
        dto.setPhoneNo(entity.getPhoneNo());

        return dto;
    }

    public User convertToEntity(UserDTO dto) {

        User entity = new User();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNo(dto.getPhoneNo());
        entity.setUsername(dto.getUsername());
        entity.setAbout(dto.getAbout());
        entity.setPwd(dto.getPwd());
        entity.setPhoto(dto.getPhoto());

        return entity;
    }

    public PostDTO convertToDTo(Post entity) {
        PostDTO dto = new PostDTO();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        dto.setPostType(entity.getPostType());
        dto.setDate(entity.getCreatedDate());
        dto.setUserId(entity.getUser().getId());
        return dto;
    }

    public Post convertToEntity(PostDTO dto) {
        Post post = new Post();

        post.setId(dto.getId());
        post.setContent(dto.getContent());
        post.setPostType(dto.getPostType());
        post.setCreatedDate(new Date());
        return post;
    }


    public Video convertToEntity(VideoDTO videoDTO) {
        Video video = new Video();
        video.setUrl(videoDTO.getUrl());
        video.setThumbnail(videoDTO.getThumbnail());
        return video;
    }
    public Text convertToEntity(TextDto textDto){
        Text text=new Text();
        text.setBackground(textDto.getBackground());
        text.setBody(textDto.getBody());
        return text;
    }
    public Image convertToEntity(ImageDto imageDto){
        Image image=new Image();
        image.setUrl(imageDto.getUrl());
        return image;
    }

    public Audio convertToEntity(AudioDto audioDto){
      Audio audio=new Audio();
        audio.setUrl(audioDto.getUrl());
        return audio;
    }

    public AudioDto convertToDTO(Audio audio){
        AudioDto audioDto=new AudioDto();
        audioDto.setUrl(audio.getUrl());
        return audioDto;
    }
    public TagDto convertToDto(Tag tag){
        TagDto tagDto=new TagDto();
        tagDto.setName(tag.getName());
        return tagDto;
    }
    public Tag convertToEntity(TagDto tagDto){
        Tag tag=new Tag();
        tag.setName(tagDto.getName());
        return tag;
    }
//  public Likes convertToEntity(LikesDTO likesDTO){
//        Likes likes=new Likes();
//        likes.
//  }

}
