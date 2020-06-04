package com.jfs.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jfs.user.entity.SkillEntity;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long>, JpaSpecificationExecutor<SkillEntity> {
 
 

}
