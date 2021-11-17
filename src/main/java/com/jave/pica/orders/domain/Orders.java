package com.jave.pica.orders.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long orderId;
 
    private Long clientId;

    private Long eventId;
	
    private Long flightId;
	
    private Long hotelId;
	
	private Long price;
	
    private String comments;
    
    private String status;
  
    

	
}