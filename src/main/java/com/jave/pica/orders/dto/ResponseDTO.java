package com.jave.pica.orders.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jave.pica.orders.domain.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO implements Serializable {

	private static final long serialVersionUID = -2647437081345894369L;

	@JsonProperty("statusCode")
	private int statusCode;

	@JsonProperty("mensaje")
	private String mensaje;
	
	@JsonProperty("data")
	private Response infoOrder;

}
