package com.jsf.search.resp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class SearchExceptionHandle {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(Exception.class)
	public UserResponse handleException(Exception e) {
		e.printStackTrace();
		logger.error(e.toString());
		for(StackTraceElement element :e.getStackTrace()) {
			logger.error(element.toString());
		}
		return respond("500", "error");
	}
	
	private UserResponse respond(String errorCode, String msg) {
		UserResponse response = new UserResponse();
		response.setCode(errorCode);
		response.setMsg(msg);
		return response;
	}
}
