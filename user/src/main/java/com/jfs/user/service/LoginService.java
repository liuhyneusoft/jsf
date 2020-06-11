package com.jfs.user.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Long login(LoginParam param) {
		UserEntity user = userRepo.findByNameAndPass(param.getName(), param.getPassword());
		return user.getUserID();
	}
	
	
	public Long reg(RegParam param) {
		
		UserEntity user = new UserEntity();
		user.setName(param.getName());
		user.setPass(param.getPassword());
		user.setActive(true);
		userRepo.save(user);
		if(UserTypeEnum.mentor.equals(param.getType())) {
			MentorEntity mentor = new MentorEntity();
			mentor.setMentorID(user.getUserID());
			mentor.setActive(true);
			mentor.setName(user.getName());
			mentor.setRegDate(new Date());
			mentorRepo.save(mentor);
		} 
		return user.getUserID();
	}
}
