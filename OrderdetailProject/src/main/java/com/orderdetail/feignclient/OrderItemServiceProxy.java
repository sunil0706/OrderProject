package com.orderdetail.feignclient;



import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.orderdetail.model.OrderItem;

/*
 * Calling findOrderItem of OrderService using feign client
 */
@FeignClient(name="OrderService")
public interface OrderItemServiceProxy {
	
	@GetMapping("/service/orders")
	public List<OrderItem> findOrderItem();

}
