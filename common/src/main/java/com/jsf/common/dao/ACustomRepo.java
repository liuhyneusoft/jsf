package com.jsf.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsf.common.entity.UserEntity;

@Repository
public interface ACustomRepo extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
	 @Query(value= "select * from t_user t where t.id = ?1", nativeQuery = true)
	 UserEntity getUser(Long userId);
}
