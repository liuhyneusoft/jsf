package com.jfs.user.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Collections2;
import com.jfs.user.exception.UserException;
import com.jsf.common.dao.ACustomRepo;
import com.jsf.common.dao.MentorRepository;
import com.jsf.common.dao.UserRepository;
import com.jsf.common.entity.MentorEntity;
import com.jsf.common.entity.UserEntity;
import com.jsf.common.enums.UserTypeEnum;
import com.jsf.common.param.LoginParam;
import com.jsf.common.param.RegParam;

@Service
public class LoginService {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MentorRepository mentorRepo;
	
	public UserEntity login(LoginParam param) {
		UserEntity user = userRepo.findByNameAndPass(param.getName(), param.getPassword());
		if(user ==  null) {
			throw new UserException("500", "please check username and password");
		}
		return user;
	}
	
	
	public Long reg(RegParam param) {
		checkName(param.getName());
		UserEntity user = new UserEntity();
		user.setName(param.getName());
		user.setPass(param.getPassword());
		user.setActive(true);
		userRepo.save(user);
		if(UserTypeEnum.mentor.equals(param.getType())) {
			MentorEntity mentor = new MentorEntity();
			mentor.setMentorID(user.getUserID());
			mentor.setActive(true);
			String[] names = user.getName().split("@");
			mentor.setName(names[0]);
			mentor.setRegCode(user.getName());//mail
			mentor.setRegDate(new Date());
			mentorRepo.save(mentor);
		} 
		return user.getUserID();
	}
	
	private void checkName(String name) {
		List<UserEntity> users = userRepo.findAllByNameIgnoreCase(name);
		if(users != null && users.size() > 0) {
			throw new UserException("500","user name already exists");
		}
	}
}
