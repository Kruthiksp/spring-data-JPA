package com.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dto.ProductDTO;
import com.entities.Product;
import com.repositories.ProductRepository;
import com.service.ProductService;
import com.util.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@Override
	public Product save(Product p) {
		return productRepository.save(p);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> all = productRepository.findAll();
		List<ProductDTO> collect = all.stream().map(entity -> productMapper.toDTO(entity)).collect(Collectors.toList());
		return collect;
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
