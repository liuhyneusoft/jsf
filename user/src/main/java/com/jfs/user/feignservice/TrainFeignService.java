package com.jfs.user.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsf.common.param.TrainParam;
import com.jsf.common.resp.JSFResponse;

@FeignClient(value = "training-service", path = "/train")
public interface TrainFeignService {
	@GetMapping("/{trainID}")
	public JSFResponse getTrain(@PathVariable("trainID") Long trainID);

	@PostMapping(value = "/add")
	public JSFResponse add(@RequestBody TrainParam param);

	@GetMapping(value = "/user/{userID}/list")
	public JSFResponse trainList(@PathVariable("userID") Long userID);

	@GetMapping(value = "/accept/{trainID}")
	public JSFResponse accept(@PathVariable("trainID") Long trainID);
	
	@GetMapping(value = "/reject/{trainID}")
	public JSFResponse reject(@PathVariable("trainID") Long trainID);
}
