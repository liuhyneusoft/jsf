package com.jsf.common.param;

import com.jsf.common.enums.UserTypeEnum;

import lombok.Data;

@Data
public class RegParam {
	private String name;
	private String password;
	private UserTypeEnum type;
}
