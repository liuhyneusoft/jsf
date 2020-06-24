package com.jfs.user.exception;

import lombok.Data;

@Data
public class UserException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String code = "00000";
	private String msg = "success";
	
	public UserException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
