package com.jfs.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.user.service.LoginService;
import com.jsf.common.entity.UserEntity;
import com.jsf.common.param.LoginParam;
import com.jsf.common.resp.JSFResponse;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
    public JSFResponse getUser(@RequestBody LoginParam param){
		JSFResponse cr = new JSFResponse();
		UserEntity user = loginService.login(param);
		cr.setValue("userID", user.getUserID());
		cr.setValue("userName", user.getName());
        return cr;
    }
}
