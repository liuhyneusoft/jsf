package com.jfs.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.user.service.LoginService;
import com.jsf.common.param.RegParam;
import com.jsf.common.resp.JSFResponse;

@RestController
@RequestMapping("/reg")
public class RegController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/", method = { RequestMethod.POST })
    public JSFResponse getUser(@RequestBody RegParam param){
		JSFResponse cr = new JSFResponse();
		Long userId = loginService.reg(param);
		cr.setValue("userId", userId);
        return cr;
    }
}
