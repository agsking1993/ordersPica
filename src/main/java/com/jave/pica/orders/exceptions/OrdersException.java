package com.jave.pica.orders.exceptions;

public class OrdersException  extends Exception {
	
	private static final long serialVersionUID = 4627743181268973121L;

	public OrdersException(String errorMessage) {
        super(errorMessage);
    }
}
