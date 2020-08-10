package com.orderservice.service;


import java.util.List;
import java.util.Optional;

import com.orderservice.model.OrderItem;

public interface OrderService {

	public OrderItem newOrder(OrderItem order);
	public List<OrderItem> findOrders();
	public Optional<OrderItem> findOrderById(long id);
	
}	