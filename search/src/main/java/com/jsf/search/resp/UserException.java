package com.jsf.search.resp;

public class UserException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String code ;
	public String msg ;
	
	public UserException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
