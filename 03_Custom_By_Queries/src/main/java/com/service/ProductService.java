package com.service;

import java.util.List;

import com.entities.Product;

public interface ProductService {
	List<Product> findByBrand(String brand);

	List<Product> findByPriceBetween(double start, double end);

	List<Product> findByInStockTrue();
}
