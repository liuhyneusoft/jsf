package com.jsf.weur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WeurApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeurApplication.class, args);
    }

}
