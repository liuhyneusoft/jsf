package com.jsf.search.resp;

public class UserException extends RuntimeException {
	public String code ;
	public String msg ;
	
	public UserException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
