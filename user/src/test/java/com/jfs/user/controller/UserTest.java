package com.jfs.user.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jfs.user.feignservice.TrainFeignService;
import com.jfs.user.service.LoginService;
import com.jsf.common.dao.ACustomRepo;
import com.jsf.common.entity.UserEntity;
import com.jsf.common.param.LoginParam;
import com.jsf.common.resp.JSFResponse;

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
		UserEntity userId = loginService.login(param);
		logger.info("*************** user login ********** " + userId.getUserID());
	}
	
	@Autowired
	private ACustomRepo queryRepo;
	
	@Test
	public void getUser() throws Exception {
		UserEntity user = queryRepo.getUser(1L);
		logger.info("*************** get user ********** " + user.getName());
	}
	
	
	@Autowired
	private TrainFeignService trainService;
	
	@Test
	public void getTrains() throws Exception {
		JSFResponse response = trainService.trainList(100L);
		logger.info("*************** get train list ********** " + response);
	}
	
	@Test
	public void acceptTrains() throws Exception {
		JSFResponse response = trainService.accept(1L);
		logger.info("*************** accept train ********** " + response);
	}
	
	@Test
	public void rejectTrains() throws Exception {
		JSFResponse response = trainService.reject(1L);
		logger.info("*************** reject train ********** " + response);
	}
	
}
