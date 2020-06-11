package com.jfs.user.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jfs.user.service.LoginService;
import com.jsf.common.dao.ACustomRepo;
import com.jsf.common.entity.UserEntity;
import com.jsf.common.param.LoginParam;

@SpringBootTest
@RunWith(SpringRunner.class)

public class UserTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private LoginService loginService;
	
	@Test
	public void login() throws Exception {
		LoginParam param = new LoginParam();
		param.setName("lhy");
		param.setPassword("123456");
		Long userId = loginService.login(param);
		logger.info("*************** user login ********** " + userId);
	}
	
	@Autowired
	private ACustomRepo queryRepo;
	
	@Test
	public void getUser() throws Exception {
		UserEntity user = queryRepo.getUser(1L);
		logger.info("*************** get user ********** " + user.getName());
	}
}
