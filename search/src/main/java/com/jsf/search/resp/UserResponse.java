package com.jsf.search.resp;

import java.util.HashMap;
import java.util.Map;

public class UserResponse {
	private String code = "00000";
	private String msg = "success";
	private Map<String, Object> responseBody = new HashMap<String, Object>();
	
	public void setValue(String key, Object value) {
		this.responseBody.put(key, value);
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
