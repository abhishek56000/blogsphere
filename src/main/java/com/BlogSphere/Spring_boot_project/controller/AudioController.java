package com.BlogSphere.Spring_boot_project.controller;

import com.BlogSphere.Spring_boot_project.dto.AudioDto;
import com.BlogSphere.Spring_boot_project.dto.ResponseDTO;
import com.BlogSphere.Spring_boot_project.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audio")
public class AudioController {

    @Autowired
    AudioService audioService;

    @PostMapping("/create")
    public ResponseDTO<AudioDto> create(@RequestBody AudioDto audioDto){
        AudioDto audioDto1 = audioService.save(audioDto);
        return new ResponseDTO<>(true,"audio saved",audioDto1);
    }
}
