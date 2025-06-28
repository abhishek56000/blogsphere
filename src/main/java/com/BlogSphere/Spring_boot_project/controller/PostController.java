package com.BlogSphere.Spring_boot_project.controller;

import java.util.List;

import com.BlogSphere.Spring_boot_project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.BlogSphere.Spring_boot_project.dao.UserDao;
import com.BlogSphere.Spring_boot_project.dto.ResponseDTO;
import com.BlogSphere.Spring_boot_project.dto.UserDTO;
import com.BlogSphere.Spring_boot_project.entity.Users;


public class PostController {

    @Autowired
    UserService userService;

    Logger LOG = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "/user/save")
    public ResponseDTO<UserDTO> saveUserController(@RequestBody UserDTO user) {

        LOG.info("Hello");
        UserDTO users = userService.saveUserDao(user);
        return new ResponseDTO<UserDTO>(true, "User saved", users);


    }


}
