package com.jave.pica.orders.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jave.pica.orders.domain.Orders;
import com.jave.pica.orders.domain.Response;
import com.jave.pica.orders.dto.ResponseDTO;
import com.jave.pica.orders.utils.Constant;
import com.pica.jave.orders.service.IOrders;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

	@Autowired
	private IOrders orderService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createOrder(@RequestBody Orders order) {

		String jsonResponse = "";
		Long idOrder = 0L;

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		ResponseDTO response = new ResponseDTO();
		response.setInfoOrder(new Response());

		try {
			Orders responseTotalInfo = orderService.save(order);
			idOrder = responseTotalInfo.getOrderId();

			if (idOrder > 0) {
				response.getInfoOrder().setOrderId(idOrder);
				response.setStatusCode(Constant.CODE_RESPONSE_200);
				response.setMensaje(Constant.DESCRIPTION_RESPONSE_200);
				logger.info("Orden creada: " + idOrder);
			} else {
				response.setStatusCode(Constant.CODE_RESPONSE_404);
				response.setMensaje(Constant.DESCRIPTION_RESPONSE_404);
			}

			jsonResponse = objectMapper.writeValueAsString(response);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			jsonResponse = Constant.ERROR_CONVERT;
		}

		return jsonResponse;
	}

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public String cancelOrder(@RequestBody Orders order){
    	ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		String jsonResponse = "";
		
		ResponseDTO response = new ResponseDTO();

		Orders orderExist = orderService.findById(order.getOrderId());

		if(orderExist != null)
			orderExist.setStatus(order.getStatus());
		
		    orderService.save(orderExist);
			response.setStatusCode(Constant.CODE_RESPONSE_200);
			response.setMensaje(Constant.DESCRIPTION_RESPONSE_200);
		
		try {
			jsonResponse = objectMapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			jsonResponse = Constant.ERROR_CONVERT;
		}
		
        return jsonResponse;
    }

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public String findOrder(@PathVariable(value = "id") Long idOrder) {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		
		String jsonResponse = "";

		Orders order = orderService.findById(idOrder);

		try {
			jsonResponse = objectMapper.writeValueAsString(order);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			jsonResponse = Constant.ERROR_CONVERT;
		}

		return jsonResponse;
	}

}