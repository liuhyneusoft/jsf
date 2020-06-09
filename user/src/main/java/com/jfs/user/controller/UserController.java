package com.jfs.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.user.feignservice.TrainFeignService;
import com.jfs.user.param.UserRegParam;
import com.jfs.user.service.UserService;
import com.jsf.common.entity.UserEntity;
import com.jsf.common.resp.JSFResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/reg", method = { RequestMethod.POST })
    public JSFResponse list(@RequestBody UserRegParam userParam){
		UserEntity user = userService.addUser(userParam);
		JSFResponse cr = new JSFResponse();
		cr.setValue("result", user);
		return cr;
    }
	
	@RequestMapping(value = "/{userID}", method = { RequestMethod.GET })
    public JSFResponse getUser(@PathVariable Long userID){
		JSFResponse cr = new JSFResponse();
		UserEntity user = userService.getUser(userID);
		cr.setValue("result", user);
        return cr;
    }
	
	@RequestMapping(value = "/message/{userID}/{mentorID}", method = { RequestMethod.GET })
    public JSFResponse sendMsg(@PathVariable Long userID, @PathVariable Long mentorID){
		JSFResponse cr = new JSFResponse();
		userService.sendMsg(userID, mentorID);
        return cr;
    }
	
	@Autowired
	private TrainFeignService trainService;
	@RequestMapping(value = "/train/{trainID}", method = { RequestMethod.GET })
    public JSFResponse xx(@PathVariable Long trainID){
		return trainService.getTrain(trainID);
    }
	
	
}
