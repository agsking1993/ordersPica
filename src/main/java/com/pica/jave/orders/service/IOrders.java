package com.pica.jave.orders.service;
 

import java.util.List;

import com.jave.pica.orders.domain.Orders;

 
public interface IOrders {

    Orders save(Orders order);
    List<Orders> findAll();
    Orders findById(Long id);
}