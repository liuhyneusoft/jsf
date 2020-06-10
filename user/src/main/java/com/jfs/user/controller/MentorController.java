package com.jfs.user.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsf.common.param.UserRegParam;
import com.jsf.common.resp.JSFResponse;

@RestController
@RequestMapping("/mentor")
public class MentorController {

	@RequestMapping(value = "/reg", method = { RequestMethod.POST })
    public JSFResponse list(@RequestBody UserRegParam userParam){
		JSFResponse cr = new JSFResponse();
		return cr;
    }
	
	
	
}
