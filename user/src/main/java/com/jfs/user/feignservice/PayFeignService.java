package com.jfs.user.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsf.common.resp.JSFResponse;

@FeignClient(value = "payment-service", path = "/payment")
public interface PayFeignService {
	@GetMapping("/test")
	public JSFResponse testPayment();
}
