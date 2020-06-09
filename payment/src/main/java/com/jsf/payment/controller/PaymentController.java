package com.jsf.payment.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsf.common.resp.JSFResponse;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	 public JSFResponse list(){
		JSFResponse response = new JSFResponse();
		response.setValue("result", "payment wuwuwuw");
		return response;
	}
}
