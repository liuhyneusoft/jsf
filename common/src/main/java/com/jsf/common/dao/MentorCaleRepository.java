package com.jsf.common.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jsf.common.entity.MentorCalenEntity;
import com.jsf.common.entity.MentorEntity;
 

public interface MentorCaleRepository extends JpaRepository<MentorCalenEntity, Long>, JpaSpecificationExecutor<MentorCalenEntity> {
	 
	MentorCalenEntity findByMentor(MentorEntity mentor);
}
