package com.orderdetail.service;

import java.util.List;
import java.util.Optional;

import com.orderdetail.model.Order;

public interface OrderdetailService {
	
	public void createOrderdetail(Order order);
	
	public List<Order> findOrderdetails();
	
	public Optional<Order> findOrderdetailsById(long id);
}
