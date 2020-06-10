package com.jsf.search.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsf.common.param.SearchMentorParam;
import com.jsf.common.resp.JSFResponse;
import com.jsf.search.resp.UserException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user")
public class UserSearchController {

	@ApiOperation(value = "user search mentor", notes = "user search mentor")
	@RequestMapping(value = "/mentor", method = { RequestMethod.POST })
	public JSFResponse identifier(@RequestBody SearchMentorParam param) throws UserException {
		JSFResponse cr = new JSFResponse();
		 
		return cr;
	}
}
