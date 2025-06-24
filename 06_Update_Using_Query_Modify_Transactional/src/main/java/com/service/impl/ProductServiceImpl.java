package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repositories.ProductRepository;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void updatePrice(int productId, double newPrice) {
		productRepository.updatePrice(productId, newPrice);
	}

	@Override
	public void deleteById(int productId) {
		if (productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
			System.out.println("Product Deleted successfully...");
		} else {
			System.out.println("No Product with the Id: " + productId);
		}
	}

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public void deleteById(List<Integer> productIds) {
		for (Integer productId : productIds) {
			if (productRepository.existsById(productId)) {
				productRepository.deleteById(productId);
				System.out.println("Product Deleted successfully...");
			} else {
				System.out.println("No Product with the Id: " + productId);
			}
		}
	}

}
