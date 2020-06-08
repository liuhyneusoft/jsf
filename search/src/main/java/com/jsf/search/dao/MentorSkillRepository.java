package com.jsf.search.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jsf.search.entity.MentorEntity;
import com.jsf.search.entity.MentorSkillsEntity;

@Repository
public interface MentorSkillRepository extends JpaRepository<MentorSkillsEntity, Long>, JpaSpecificationExecutor<MentorSkillsEntity> {
	List<MentorSkillsEntity> findAllBySkillNameIgnoreCase(String skillName);
	List<MentorSkillsEntity> findAllByMentor(MentorEntity mentor);
	MentorSkillsEntity findAllBySkillNameIgnoreCaseAndMentor(String skillName, MentorEntity mentor);
}
