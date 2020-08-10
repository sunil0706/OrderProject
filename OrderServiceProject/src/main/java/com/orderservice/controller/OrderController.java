package com.orderservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.model.OrderItem;
import com.orderservice.service.OrderServiceImpl;

@RestController
@RequestMapping("/service")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@PostMapping("/order")
	public ResponseEntity<Void> createOrder(@Valid @RequestBody OrderItem order){
		logger.info("Inside Ordercontroller createOrder method...");
		orderService.newOrder(order);
		logger.info("Order placed successfully...");
		logger.info("Outside Ordercontroller createOrder method...");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
	public List<OrderItem> findOrders(){
		logger.info("Inside Ordercontroller findOrders method...");
		List<OrderItem> orderList = orderService.findOrders();
		orderList.forEach(System.out::println);
		logger.info("Outside Ordercontroller findOrders method...");
		return orderList;
	}
	
	@GetMapping("/order/{id}")
	public Optional<OrderItem> findOrderById(@PathVariable long id){
		logger.info("Inside Ordercontroller findOrderById method...");
		Optional<OrderItem> order = orderService.findOrderById(id);
		logger.info("Outside Ordercontroller findOrderById method...");
		return order;
	}

}
