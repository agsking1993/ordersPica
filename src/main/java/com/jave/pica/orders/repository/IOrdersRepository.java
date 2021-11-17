package com.jave.pica.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jave.pica.orders.domain.Orders;



/**
 
 *
 */
public interface IOrdersRepository  extends  JpaRepository<Orders, Long>{
	
	 
}
