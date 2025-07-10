package com.BlogSphere.Spring_boot_project.service;

import com.BlogSphere.Spring_boot_project.dao.AudioDao;
import com.BlogSphere.Spring_boot_project.dto.AudioDto;
import com.BlogSphere.Spring_boot_project.entity.Audio;
import com.BlogSphere.Spring_boot_project.utils.DataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudioService {

    @Autowired
    DataBinder dataBinder;
       @Autowired
      AudioDao audioDao;
    public AudioDto save(AudioDto audioDto){
        Audio audio=dataBinder.convertToEntity(audioDto);
        audio=audioDao.save(audio);
        return dataBinder.convertToDTO(audio);

    }
}
