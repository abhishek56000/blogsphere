package com.BlogSphere.Spring_boot_project.dao;

import com.BlogSphere.Spring_boot_project.entity.Post;
import com.BlogSphere.Spring_boot_project.entity.Video;
import com.BlogSphere.Spring_boot_project.repository.PostRepository;
import com.BlogSphere.Spring_boot_project.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VideoDao {

    @Autowired
    VideoRepository videoRepository;

    public Video save(Video video) {
        return videoRepository.save(video);
    }

}
