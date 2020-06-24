package com.jfs.user.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsf.common.resp.JSFResponse;
@ControllerAdvice
@ResponseBody
public class UserExceptionHandler {
	@ExceptionHandler(Exception.class)
	public JSFResponse handleException(Exception e) {
		e.printStackTrace();
		return respond("500", "system error");
	}

	@ExceptionHandler(UserException.class)
	public JSFResponse handleException(UserException e) {
		 e.printStackTrace();
		return respond(e.getCode(), e.getMsg());
	}
	
	private JSFResponse respond(String errorCode, String msg) {
		JSFResponse response = new JSFResponse();
		response.setCode(errorCode);
		response.setMsg(msg);
		return response;
	}
}
