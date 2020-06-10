package com.jsf.security.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsf.common.param.LoginParam;
import com.jsf.common.resp.JSFResponse;

@RestController
@RequestMapping("/mval")
public class LoginController {
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	 public JSFResponse login(@RequestBody LoginParam param){
		JSFResponse response = new JSFResponse();
		response.setValue("result", "login");
		return response;
	}
	
	
	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	 public JSFResponse test(){
		JSFResponse response = new JSFResponse();
		response.setValue("result", "aaaaaaaaaaaaaaaa");
		return response;
	}
	
	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	 public JSFResponse register(@RequestBody LoginParam param){
		JSFResponse response = new JSFResponse();
		response.setValue("result", "register");
		return response;
	}
}
