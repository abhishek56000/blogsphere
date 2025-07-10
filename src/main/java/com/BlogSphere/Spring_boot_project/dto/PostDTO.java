package com.BlogSphere.Spring_boot_project.dto;

import com.BlogSphere.Spring_boot_project.entity.Tag;
import com.BlogSphere.Spring_boot_project.enums.PostType;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
    public class PostDTO {
    private int id;
    private String content;
    private Date date;
    private PostType postType;
    private int userId;
    private VideoDTO video;
    private TextDto text;
    private ImageDto image;
    private int audioId;
    private List<TagDto>tags;


    public List<TagDto> getTags() {
        return tags;
    }
    public void setTags(List<TagDto> tags) {
        this.tags = tags;
    }
    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public int  getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public VideoDTO getVideo() {
        return video;
    }

    public void setVideo(VideoDTO video) {
        this.video = video;
    }

    public int getAudioId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId = audioId;
    }

    public TextDto getText() {
        return text;
    }

    public void setText(TextDto text) {
        this.text = text;
    }
}
