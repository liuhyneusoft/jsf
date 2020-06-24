package com.jfs.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.common.dao.MentorRepository;
import com.jsf.common.dao.UserRepository;
import com.jsf.common.entity.MentorEntity;
import com.jsf.common.entity.UserEntity;
import com.jsf.common.param.UserRegParam;
import com.jsf.common.vo.MentoVo;

 
@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MentorRepository mentorRepo;
	
	
	public List<MentoVo> getMentors() {
		List<MentorEntity> mentorEntities = mentorRepo.findAll();
		return mentorEntities.stream().map(v ->mentoToVo(v)).collect(Collectors.toList());
	}
	
	public List<MentoVo> getMentorsParam(String name, String skill) {
		List<MentorEntity> mentorEntities = mentorRepo.findAllByNameLike("%"+name+"%");
		return mentorEntities.stream().map(v ->mentoToVo(v)).collect(Collectors.toList());
	}
	
	private MentoVo mentoToVo(MentorEntity m) {
		MentoVo vo = new MentoVo();
		vo.setName(m.getName());
		vo.setMail(m.getRegCode());
		vo.setExp("10");
		return vo;
	}
	
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
		//UserEntity user = userRepo.findById(userID).get();
		 
	}
}
