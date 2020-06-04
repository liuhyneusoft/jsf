package com.jfs.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfs.user.dao.UserRepository;
import com.jfs.user.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public UserEntity addUser(String name) {
		UserEntity user = new UserEntity();
		user.setName(name);
		userRepo.save(user);
		return user;
	}
	
	public UserEntity getUser(Long userID) {
		UserEntity user = userRepo.findById(userID).get();
		return user;
	}
}
