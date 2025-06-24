package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entities.Product;
import com.repositories.ProductRepository;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product save(Product p) {
		return productRepository.save(p);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(int productId) {
		return productRepository.findById(productId);
	}

	@Override
	public void deleteProductById(int productId) {
		if(productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
		}else {
			System.out.println("Product Not Exist with the Id "+productId);
		}
	}

}
