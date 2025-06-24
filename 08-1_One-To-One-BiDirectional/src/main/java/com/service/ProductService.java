package com.service;

import java.util.List;
import java.util.Optional;

import com.dto.ProductDTO;
import com.entities.Product;

public interface ProductService {
	Product save(Product p);

	List<ProductDTO> getAllProducts();

	Optional<Product> getProductById(int productId);
	
	void deleteProductById(int productId);
}
