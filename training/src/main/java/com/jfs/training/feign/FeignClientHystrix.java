package com.jfs.training.feign;

import org.springframework.stereotype.Component;

import com.jsf.common.entity.UserEntity;

@Component
public class FeignClientHystrix implements FeignSerice {

	@Override
	public UserEntity getUser(Long userID) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName("no user");
		return userEntity;
	}

}
