package com.haooon.servicesys;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.haooon.servicesys.mapper")
public class ServiceSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSysApplication.class, args);
	}
}
