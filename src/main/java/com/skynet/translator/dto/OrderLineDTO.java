package com.skynet.translator.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDTO {

	private Long id;

	private ProductDTO product;

	private Double price;
	
	private Double quantity;
	
	private Double total;

	
}
