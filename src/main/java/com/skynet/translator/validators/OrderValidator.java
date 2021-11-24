package com.skynet.translator.validators;

import com.skynet.translator.entity.Order;
import com.skynet.translator.entity.OrderLine;
import com.skynet.translator.exceptions.ValidateServiceException;

public class OrderValidator {
	
	public static void save(Order order) {
	
		if(order.getLines() == null || order.getLines().isEmpty()) {
			throw new ValidateServiceException("Las Lineas son requeridas");
		}
		
		for(OrderLine line: order.getLines()) {
			
			if(line.getProduct() == null || line.getProduct().getId() == null) {
				throw new ValidateServiceException("El producto es requerido");
			}
			
			if(line.getQuantity() == null) {
				throw new ValidateServiceException("La cantidad es requerida");
			}
			
			if(line.getQuantity() < 0) {
				throw new ValidateServiceException("La cantidad es incorrecto");
			}
		}
	}

}
