package com.service.impl;

import java.util.List;

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
	public List<Product> findByBrand(String brand) {
//		List<Product> byBrand = productRepository.findByBrand(brand);
		List<Product> byBrand = productRepository.findByBrandOrderByPriceDesc(brand);
		return byBrand;
	}

	@Override
	public List<Product> findByPriceBetween(double start, double end) {
		List<Product> byPriceBetween = productRepository.findByPriceBetween(start, end);
		return byPriceBetween;
	}

	@Override
	public List<Product> findByInStockTrue() {
		List<Product> byInStockTrue = productRepository.findByInStockTrue();
		return byInStockTrue;
	}

}
