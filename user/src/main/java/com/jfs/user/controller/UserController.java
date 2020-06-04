package com.jfs.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.user.entity.UserEntity;
import com.jfs.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/add", method = { RequestMethod.GET })
    public UserEntity list(@RequestParam String name){
		UserEntity user = userService.addUser(name);
        return user;
    }
	
	@RequestMapping(value = "/{userID}", method = { RequestMethod.GET })
    public UserEntity getUser(@PathVariable Long userID){
		UserEntity user = userService.getUser(userID);
        return user;
    }
}
