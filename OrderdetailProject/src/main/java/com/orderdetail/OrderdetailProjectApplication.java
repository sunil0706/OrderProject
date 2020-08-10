package com.orderdetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan("com.orderdetail.model")
@EnableFeignClients
@EnableDiscoveryClient
public class OrderdetailProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderdetailProjectApplication.class, args);
	}

}
