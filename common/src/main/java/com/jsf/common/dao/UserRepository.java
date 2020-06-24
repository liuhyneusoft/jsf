package com.jsf.common.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jsf.common.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
 
	UserEntity findByUserID(Long userID);
	
	UserEntity findByNameAndPass(String name, String pass);
	
	List<UserEntity> findAllByNameIgnoreCase(String name);
}
