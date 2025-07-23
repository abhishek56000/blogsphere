package com.BlogSphere.Spring_boot_project.service;

import com.BlogSphere.Spring_boot_project.entity.User;
import com.BlogSphere.Spring_boot_project.exception.InvalidInputException;
import com.BlogSphere.Spring_boot_project.utils.AESUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlogSphere.Spring_boot_project.dao.UserDao;
import com.BlogSphere.Spring_boot_project.dto.UserDTO;
import com.BlogSphere.Spring_boot_project.utils.DataBinder;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UserDao userDao;
	
	@Autowired
	DataBinder dataBinder;

	@Autowired
	EmailService emailService;

	public UserDTO saveUserDao(UserDTO userDTO) {
		log.info("user registration >>");
		validateInput(userDTO);

		User user = dataBinder.convertToEntity(userDTO);
		String pass = user.getPwd();
		String encpass;
        try {
          encpass = AESUtils.encrypt(pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		user.setPwd(encpass);
        user = userDao.saveUserDao(user);
		emailService.sendRegistrationMail(user.getEmail(), user.getName());
		return dataBinder.convertToDTO(user);
		
	}
	public UserDTO update(int id, UserDTO dto){
		User user=userDao.getUserById(id);
		if(dto.getName()!=null){
			user.setName(dto.getName());
		}
		if(dto.getEmail()!=null){
			user.setEmail(dto.getEmail());
		}
		if(dto.getPhoneNo()!=null){
			user.setPhoto(dto.getPhoneNo());
		}
		if(dto.getPwd()!=null){
			user.setPwd(dto.getPwd());
		}
		if(dto.getUsername()!=null){
			user.setUsername(dto.getUsername());
		}
		if(dto.getAbout()!=null){
			user.setAbout(dto.getAbout());
		}
     	 User user1=userDao.saveUserDao(user);
			return dataBinder.convertToDTO(user1);
    }
		public UserDTO getUser(int id ){
		User user=userDao.getUserById(id);
		String encpass = user.getPwd();
			String decpass;
            try {
                 decpass = AESUtils.decrypt(encpass);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            user.setPwd(decpass);
			return dataBinder.convertToDTO(user);
}

	public User getUserByEmail(String email) {

		return userDao.getUserByEmail(email);
	}
	public void delete(int id){
		userDao.deleteUserById(id);
	}

	private void validateInput(UserDTO user){
		if(user.getEmail().equals("")){
			throw new InvalidInputException("Email Id cant be empty");
		}

	}



}
