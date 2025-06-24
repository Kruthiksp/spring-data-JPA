package com.service;

import java.util.List;

public interface ProductService {
	void updatePrice(int productId, double newPrice);

	void deleteById(int productId);
	
	void deleteById(List<Integer> productIds);
}