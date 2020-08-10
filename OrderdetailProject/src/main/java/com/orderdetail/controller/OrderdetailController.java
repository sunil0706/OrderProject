package com.orderdetail.controller;

import java.util.List;
import java.util.Optional;

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

import com.orderdetail.exception.OrderNotFoundException;
import com.orderdetail.feignclient.OrderItemServiceProxy;
import com.orderdetail.model.Order;
import com.orderdetail.model.OrderItem;
import com.orderdetail.service.OrderdetailServiceImpl;

@RestController
@RequestMapping("/service")
public class OrderdetailController {

	private static Logger logger = LoggerFactory.getLogger(OrderdetailController.class);
	
	@Autowired
	private OrderdetailServiceImpl orderdetail;
	
	@Autowired
	private OrderItemServiceProxy orderdetailService;
	
	@PostMapping("/orderdetail")
	public ResponseEntity<Void> createOrder(@RequestBody Order order){
		logger.info("Inside OrderdetailController createOrder method...");
		List<OrderItem> list = orderdetailService.findOrderItem();
		list.stream().forEach(orderDetails->System.out.println("Product Code : "+orderDetails.getPcode()+", Product Name : "+orderDetails.getPname()+", Quantity : "+orderDetails.getQuantity()));
		if(list.size()==0) {
			throw new OrderNotFoundException();
		}
		order.setOrderItem(list);
		orderdetail.createOrderdetail(order);
		logger.info("Outside OrderdetailController createOrder method...");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/orderdetail")
	public List<Order> findOrderdetails() throws OrderNotFoundException{
		logger.info("Inside OrderdetailController findOrderdetails method...");
		List<Order> orderdetailList = orderdetail.findOrderdetails();
		logger.info("Outside OrderdetailController findOrderdetails method...");
		return orderdetailList;
	}
	
	@GetMapping("/orderdetail/{id}")
	public Optional<Order> findOrderdetailsById(@PathVariable long id) throws OrderNotFoundException{
		logger.info("Inside OrderdetailController findOrderdetailsById method...");
		Optional<Order> order = orderdetail.findOrderdetailsById(id);
		logger.info("Outside OrderdetailController findOrderdetailsById method...");
		return order;
	}
}