package com.jsf.search.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jsf.search.entity.TrainEntity;

@Repository
public interface TrainRepository extends JpaRepository<TrainEntity, Long>, JpaSpecificationExecutor<TrainEntity> {
 
 

}
