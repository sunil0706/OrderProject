package com.orderservice.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.model.OrderItem;
import com.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public OrderItem newOrder(OrderItem order) {
		logger.info("Inside OrderServiceImpl newOrder method...");
		OrderItem placedOrder = orderRepository.save(order);
		logger.info("Outside OrderServiceImpl newOrder method...");
		return placedOrder;
	}

	@Override
	public List<OrderItem> findOrders() {
		logger.info("Inside OrderServiceImpl findOrders method...");
		List<OrderItem> orders = orderRepository.findAll();
		orders.stream().forEach(order->System.out.println(order.getId()+", Product Name : "+order.getPname()+", Product Id : "+order.getPcode()+", Quantity : "+order.getQuantity()));
		logger.info("Outside OrderServiceImpl findOrders method...");
		return orders;
	}
	
	@Override
	public Optional<OrderItem> findOrderById(long id) {
		logger.info("Inside OrderServiceImpl findOrderById method...");
		Optional<OrderItem> order = orderRepository.findById(id);
		logger.info("Outside OrderServiceImpl findOrderById method...");
		return order;
	}

}
