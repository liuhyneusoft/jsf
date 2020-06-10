package com.jfs.user.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsf.common.param.LoginParam;
import com.jsf.common.resp.JSFResponse;

@RestController
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
    public JSFResponse getUser(@RequestBody LoginParam param){
		JSFResponse cr = new JSFResponse();
		cr.setValue("userId", "1234");
        return cr;
    }
}
