package com.jsf.common.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jsf.common.entity.MentorEntity;

@Repository
public interface MentorRepository extends JpaRepository<MentorEntity, Long>, JpaSpecificationExecutor<MentorEntity> {
 
	MentorEntity findByMentorID(Long mentorID);
	List<MentorEntity> findAllByNameLike(String name);
}
