package com.jsf.technology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

 
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.jfs"})
@EntityScan("com.jsf.common.entity")
@EnableJpaRepositories("com.jsf.common.dao")
@EnableFeignClients
public class TechnologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnologyApplication.class, args);
	}

}
