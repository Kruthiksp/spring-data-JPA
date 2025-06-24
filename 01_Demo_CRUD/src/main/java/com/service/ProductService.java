package com.service;

import java.util.List;
import java.util.Optional;

import com.entities.Product;

public interface ProductService {
	Product save(Product p);

	List<Product> getAllProducts();

	Optional<Product> getProductById(int productId);
	
	void deleteProductById(int productId);
}
