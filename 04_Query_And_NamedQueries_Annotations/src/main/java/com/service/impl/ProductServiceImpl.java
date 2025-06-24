package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.ProductPartialDTO;
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
	public double averagePriceOfAllProducts(String brand) {

		return productRepository.averagePriceOfAllProducts(brand);
	}

	@Override
	public List<Product> productsInRangeOfABrand(String brand, int startPrice, int endPrice) {
		return productRepository.productsInRangeOfABrand(brand, startPrice, endPrice);
	}

	@Override
	public List<Product> AllProducts() {
		return productRepository.AllProducts();
	}

	@Override
	public List<ProductPartialDTO> productsInRangeOfBrand(String brand, int startPrice, int endPrice) {
		return productRepository.productsInRangeOfBrand(brand, startPrice, endPrice);
	}

}
