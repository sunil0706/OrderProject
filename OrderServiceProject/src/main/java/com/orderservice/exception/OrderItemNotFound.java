package com.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderItemNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public OrderItemNotFound() {
		
	}
	public OrderItemNotFound(String message) {
		super(message);
	}

}
