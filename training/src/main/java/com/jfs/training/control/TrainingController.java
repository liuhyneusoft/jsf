package com.jfs.training.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.training.feign.FeignSerice;
import com.jsf.common.entity.UserEntity;
import com.jsf.common.resp.JSFResponse;

 
@RestController
@RequestMapping("/train")
public class TrainingController {

	@Autowired
	private FeignSerice feignSrice;
//	@RequestMapping(value = "/user/{userID}", method = { RequestMethod.GET })
//    public UserEntity list(@PathVariable Long userID){
//		UserEntity user = feignSrice.getUser(userID);
//        return user;
//    }
	@RequestMapping(value = "/{trainID}", method = { RequestMethod.GET })
	 public JSFResponse list(@PathVariable Long trainID){
		JSFResponse response = new JSFResponse();
		response.setValue("result", "hahahah");
		return response;
	}
	
	
	
}
