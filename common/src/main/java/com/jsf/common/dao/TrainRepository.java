package com.jsf.common.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jsf.common.entity.TrainEntity;
import com.jsf.common.entity.UserEntity;

@Repository
public interface TrainRepository extends JpaRepository<TrainEntity, Long>, JpaSpecificationExecutor<TrainEntity> {

	List<TrainEntity> findALlByUser(UserEntity user);

}
