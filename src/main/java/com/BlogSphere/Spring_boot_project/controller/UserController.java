package com.BlogSphere.Spring_boot_project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BlogSphere.Spring_boot_project.dto.ResponseDTO;
import com.BlogSphere.Spring_boot_project.dto.UserDTO;

import com.BlogSphere.Spring_boot_project.service.UserService;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;


    Logger LOG = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "/save")
    public ResponseDTO<UserDTO> saveUserController(@RequestBody UserDTO user) {

        LOG.info("Hello");
        UserDTO users = userService.saveUserDao(user);
        return new ResponseDTO<UserDTO>(true, "User saved", users);
    }



}
