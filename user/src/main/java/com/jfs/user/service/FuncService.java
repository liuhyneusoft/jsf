package com.jfs.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.common.dao.SkillRepository;
import com.jsf.common.entity.SkillEntity;
@Service
public class FuncService {

	@Autowired
	private SkillRepository skillRepo;
	
	public List<SkillEntity> getSkills() {
		List<SkillEntity> skills = skillRepo.findAllByOrderByName();
		return skills;
	}
	
	public void addSkill(String skill, Long skillID) {
		if(skillID == null) {
			SkillEntity skillEntity = new SkillEntity();
			skillEntity.setName(skill);
			 skillRepo.save(skillEntity);
		 
		} else {
			SkillEntity s =  skillRepo.findById(skillID).get();
			s.setName(skill);
			 skillRepo.save(s);
		}
	}
	
	public List<SkillEntity> delSkill(Long id) {
		SkillEntity skillEntity = skillRepo.findById(id).get();
		skillRepo.delete(skillEntity);
		List<SkillEntity> skills = skillRepo.findAllByOrderByName();
		return skills;
	}
}
