package com.jfs.user.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfs.user.feignservice.TrainFeignService;
import com.jsf.common.dao.MentorRepository;
import com.jsf.common.dao.UserRepository;
import com.jsf.common.entity.MentorEntity;
import com.jsf.common.entity.UserEntity;
import com.jsf.common.param.TrainParam;
import com.jsf.common.param.UserRegParam;
import com.jsf.common.resp.JSFResponse;
import com.jsf.common.vo.MentoVo;

 
@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MentorRepository mentorRepo;
	@Autowired
	private TrainFeignService trainService;
	
	public void reject(String trainID) {
		trainService.reject(Long.parseLong(trainID));
	}
	
	public void confirm(String trainID) {
		trainService.accept(Long.parseLong(trainID));
	}
	
	public JSFResponse trains(String userID) {
		return trainService.trainList(Long.parseLong(userID));
	}
	
	
	public void apply(String userID, String mail) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		MentorEntity mentor = mentorRepo.findByRegCode(mail);
		TrainParam param = new TrainParam();
		param.setEndDate("2020-12-31");
		param.setMentorID(mentor.getMentorID());
		param.setSkill("java");
		param.setStartDate(sFormat.format(new Date()));	
		param.setUserID(Long.parseLong(userID));
		trainService.add(param);
	}
	
	
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
