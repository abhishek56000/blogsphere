//package com.BlogSphere.Spring_boot_project.service;
//
//import com.BlogSphere.Spring_boot_project.dao.LikesDao;
//import com.BlogSphere.Spring_boot_project.dao.PostDao;
//import com.BlogSphere.Spring_boot_project.dao.UserDao;
//import com.BlogSphere.Spring_boot_project.dto.LikesDTO;
//import com.BlogSphere.Spring_boot_project.entity.Likes;
//import com.BlogSphere.Spring_boot_project.entity.Post;
//import com.BlogSphere.Spring_boot_project.entity.User;
//import com.BlogSphere.Spring_boot_project.utils.DataBinder;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//public class LikesService {
//    @Autowired
//    LikesDao likesDao;
//    @Autowired
//    UserDao userDao;
//    @Autowired
//    DataBinder dataBinder;
//
//  public LikesDTO save(LikesDTO likesDTO){
//
////      if(userDao.getUserById(likesDTO.getUserId())!=null){
//          likesDTO.setUserId(userDao.getUserById(likesDTO.getUserId()));
//      }
//  }
//
//
//
//
//}
