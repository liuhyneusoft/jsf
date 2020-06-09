package com.jfs.user.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jsf.common.resp.JSFResponse;

@FeignClient(value = "training-service", path = "/train")
public interface TrainFeignService {
	@GetMapping("/{trainID}")
	public JSFResponse getTrain(@PathVariable("trainID") Long trainID);
}
