package com.jfs.training.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.common.dao.MentorRepository;
import com.jsf.common.dao.SkillRepository;
import com.jsf.common.dao.TrainRepository;
import com.jsf.common.dao.UserRepository;
import com.jsf.common.entity.TrainEntity;
import com.jsf.common.entity.UserEntity;
import com.jsf.common.enums.TrainStatusEnum;
import com.jsf.common.param.TrainParam;
import com.jsf.common.vo.TrainVo;

@Service
public class TrainService {

	@Autowired
	private SkillRepository skillRepo;
	@Autowired
	private TrainRepository trainRepo;
	@Autowired
	private MentorRepository mentorRepo;
	@Autowired
	private UserRepository userRepo;

	public List<TrainVo> trains(Long userID) {
		UserEntity user = userRepo.findByUserID(userID);
		List<TrainEntity> trains = trainRepo.findALlByUser(user);
		List<TrainVo> vos = trains.stream().map(v -> trainToVo(v)).collect(Collectors.toList());
		return vos;
	}

	private TrainVo trainToVo(TrainEntity train) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		TrainVo vo = new TrainVo();
		vo.setSkill(train.getSkill().getName());
		vo.setStatus(train.getStatus().toString());
		vo.setApplyDate(sFormat.format(train.getStartDate()));
		vo.setId(train.getTrainID()+"");
		vo.setMentorName(train.getMentor().getName());
		vo.setUserName(train.getUser().getName());
		return vo;
	}

	public void accept(Long trainID) {
		TrainEntity train = trainRepo.findById(trainID).get();
		train.setStatus(TrainStatusEnum.accept);
		trainRepo.save(train);
	}

	public void reject(Long trainID) {
		TrainEntity train = trainRepo.findById(trainID).get();
		train.setStatus(TrainStatusEnum.reject);
		trainRepo.save(train);
	}

	public void saveTrain(TrainParam param) {
		try {
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
			TrainEntity train = new TrainEntity();
			train.setStatus(TrainStatusEnum.apply);
			train.setStartDate(sFormat.parse(param.getStartDate()));
			train.setEndDate(sFormat.parse(param.getEndDate()));
			train.setSkill(skillRepo.findByNameIgnoreCase(param.getSkill()));
			train.setUser(userRepo.findByUserID(param.getUserID()));
			train.setMentor(mentorRepo.findByMentorID(param.getMentorID()));
			trainRepo.save(train);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
