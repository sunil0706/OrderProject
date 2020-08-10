package com.orderdetail.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderdetail.model.Order;
import com.orderdetail.repository.OrderdetailRepository;

@Service
public class OrderdetailServiceImpl implements OrderdetailService{

	private static final Logger logger = LoggerFactory.getLogger(OrderdetailServiceImpl.class);

	@Autowired
	private OrderdetailRepository orderdetailRepository;
	
	@Override
	public void createOrderdetail(Order order) {
		logger.info("Inside OrderdetailServiceImpl createOrderdetail...");
		orderdetailRepository.save(order);
		logger.info("Outside OrderdetailServiceImpl createOrderdetail...");
	}
	
	@Override
	public List<Order> findOrderdetails() {
		logger.info("Inside OrderdetailServiceImpl findOrderdetails...");
		List<Order> orderDetails = orderdetailRepository.findAll();
		logger.info("Outside OrderdetailServiceImpl findOrderdetails...");
		return orderDetails;
	}

	@Override
	public Optional<Order> findOrderdetailsById(long id) {
		logger.info("Inside OrderdetailServiceImpl findOrderdetailsById...");
		Optional<Order> orderDetails = orderdetailRepository.findById(id);
		logger.info("Outside OrderdetailServiceImpl findOrderdetailsById...");
		return orderDetails;
	}
}
