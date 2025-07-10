package com.BlogSphere.Spring_boot_project.dao;

import com.BlogSphere.Spring_boot_project.entity.Audio;
import com.BlogSphere.Spring_boot_project.repository.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AudioDao {

    @Autowired
    AudioRepository AudioRepository;

    public Audio save(Audio audio){
        return AudioRepository.save(audio);
    }
    public  Audio getById(int id){

        return AudioRepository.findById(id).orElse(null);
    }

}
