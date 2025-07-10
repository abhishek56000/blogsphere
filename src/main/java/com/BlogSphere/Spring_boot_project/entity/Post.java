package com.BlogSphere.Spring_boot_project.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Posts{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    private Date date;

    private String postType;
    
    @ManyToMany
    private List<Users> uid;

    @ManyToMany
    private List<Audio> audios;
	
    @ManyToMany
    private List<Videos> videos;
    @OneToOne
    private Texts texts;
    @ManyToMany
    private List<Tag> tags;
    @ManyToMany
    private List<Photos> photo;
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
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public List<Users> getUid() {
		return uid;
	}
	public void setUid(List<Users> uid) {
		this.uid = uid;
	}
	public List<Audio> getAudios() {
		return audios;
	}
	public void setAudios(List<Audio> audios) {
		this.audios = audios;
	}
	public List<Videos> getVideos() {
		return videos;
	}
	public void setVideos(List<Videos> videos) {
		this.videos = videos;
	}
	public Texts getTexts() {
		return texts;
	}
	public void setTexts(Texts texts) {
		this.texts = texts;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<Photos> getPhoto() {
		return photo;
	}
	public void setPhoto(List<Photos> photo) {
		this.photo = photo;
	}

    
}

