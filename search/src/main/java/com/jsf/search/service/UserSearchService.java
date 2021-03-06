package com.jsf.search.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.common.dao.MentorCaleRepository;
import com.jsf.common.dao.MentorSkillRepository;
import com.jsf.common.entity.MentorCalenEntity;
import com.jsf.common.entity.MentorEntity;
import com.jsf.common.entity.MentorSkillsEntity;
import com.jsf.common.param.SearchMentorParam;
import com.jsf.search.MentorVO;
 
@Service
public class UserSearchService {

	@Autowired
	private MentorSkillRepository mentSkillRepo;
	@Autowired
	private MentorCaleRepository mentCaleRepo;
	
	public List<MentorVO> searchMontor(SearchMentorParam param) {
		
		String skill = param.getSkill();
		String startDate = param.getStartDate();
		String ednDate = param.getEndDate();
		List<MentorSkillsEntity> sills = mentSkillRepo.findAllBySkillNameIgnoreCase(skill);
		if(Strings.isNotEmpty(startDate) && Strings.isNotEmpty(ednDate)) {
			sills = sills.stream().filter(v -> timeActive(v, startDate, ednDate)).collect(Collectors.toList());
		}
		List<MentorEntity> mentors = sills.stream().map(v -> v.getMentor()).distinct().collect(Collectors.toList());
		List<MentorVO> vos = mentors.stream().map(v -> mentorToVO(v, skill)).collect(Collectors.toList());
		return vos;
	}
	
	private MentorVO mentorToVO(MentorEntity ment, String skill) {
		MentorVO vo = new MentorVO();
		vo.setExp(ment.getExperience());
		MentorSkillsEntity mentorSkillsEntity = mentSkillRepo.findAllBySkillNameIgnoreCaseAndMentor(skill, ment);
		vo.setExpense(mentorSkillsEntity.getRate());
		vo.setName(ment.getName());
		List<MentorSkillsEntity>  mentorSkills = mentSkillRepo.findAllByMentor(ment);
		String skills = mentorSkills.stream().map(v -> v.getSkillName()).collect(Collectors.joining(","));
		vo.setSkills(skills);
		return vo;
	}
	
	private boolean timeActive(MentorSkillsEntity ms, String startDate, String endDate) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		boolean b = false;
		try {
			Date start = sf.parse(startDate);
			Date end = sf.parse(endDate);
			MentorEntity mentor = ms.getMentor();
			MentorCalenEntity calenEntity = mentCaleRepo.findByMentor(mentor);
			Date menStart = calenEntity.getStartDate();
			Date menEnd = calenEntity.getEndDate();
			
			if(menStart.before(start) && menEnd.after(end)) {
				b = true;
			} else {
				b = false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return b;
	}
}
