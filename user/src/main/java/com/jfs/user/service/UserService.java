package com.jfs.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfs.user.param.UserRegParam;
import com.jsf.common.dao.UserRepository;
import com.jsf.common.entity.UserEntity;

 
@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public UserEntity addUser(UserRegParam param) {
		UserEntity user = new UserEntity();
		user.setName(param.getName());
		user.setContact(param.getContract());
		user.setFirstName(param.getFirstName());
		user.setLastName(param.getLastName());
		user.setPass(param.getPassword());
		userRepo.save(user);
		return user;
	}
	
	public UserEntity getUser(Long userID) {
		UserEntity user = userRepo.findById(userID).get();
		return user;
	}
	
	public void sendMsg(Long userID, Long mentorID) {
		UserEntity user = userRepo.findById(userID).get();
		 
	}
}
