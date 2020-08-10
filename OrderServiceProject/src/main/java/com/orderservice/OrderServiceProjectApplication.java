package com.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan("com.orderservice.model")
@EnableEurekaClient
public class OrderServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceProjectApplication.class, args);
	}

}
