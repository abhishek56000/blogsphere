package com.BlogSphere.Spring_boot_project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/update/{id}")
    public ResponseDTO<UserDTO>update(@PathVariable int id,@RequestBody UserDTO dto){
        UserDTO userDTO=userService.update(id,dto);
        return new ResponseDTO<>(true,"User update",userDTO);
    }
    @GetMapping("/get/{id}")
    public ResponseDTO<UserDTO>get(@PathVariable int id){
        UserDTO userDTO=userService.getUser(id);
        return new ResponseDTO<>(true,"get user",userDTO);
    }
    public ResponseDTO<UserDTO>delete(@PathVariable int id){
        userService.delete(id);
        return new ResponseDTO<>(true,"delete");
    }
}
