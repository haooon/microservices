package com.haooon.consulclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient

@RestController
public class ConsulClientApplication {
    @RequestMapping("/hi")
    public String home() {
        return "hi ,i'm miya";
    }

	public static void main(String[] args) {
		SpringApplication.run(ConsulClientApplication.class, args);
	}

}

