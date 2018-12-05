package com.haooon.servicetest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceTestApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/test")
	public String home(@RequestParam(value = "name", defaultValue = "haooon") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}
}
