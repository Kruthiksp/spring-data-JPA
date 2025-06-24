package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private Integer productId;
	private String name;
	private String brand;
	private double price;
	private boolean inStock;
	private OwnerDTO ownerDTO;
}
