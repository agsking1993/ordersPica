package com.jave.pica.orders.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jave.pica.orders.domain.Orders;
import com.jave.pica.orders.repository.IOrdersRepository;
import com.pica.jave.orders.service.IOrders;


@Service(value = "customerService")
public class OrdersImpl implements  IOrders {

	@Autowired
	private IOrdersRepository ordersRepository;

//	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//		User user = userDao.findByUsername(userId);
//		if (user == null) {
//			throw new CustomersException("Invalid username or password.");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				getAuthority());
//	}

 

	public List<Orders> findAll() {
		List<Orders> list = new ArrayList<>();
		ordersRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Orders findById(Long id) {
		return ordersRepository.getById(id);
	}
	
 

	@Override
	public Orders save(Orders user) {
		return ordersRepository.save(user);
	}
}