package com.jfs.training.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jfs.training.config.FeignConfiguration;
import com.jsf.common.entity.UserEntity;
 
@FeignClient(value = "user-service", path = "/user", configuration = FeignConfiguration.class,fallback = FeignClientHystrix.class)
public interface FeignSerice {

	 @GetMapping("/{userID}")
	 public UserEntity getUser(@PathVariable("userID")Long userID);
}
