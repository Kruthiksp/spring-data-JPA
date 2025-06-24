package com.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getAllProductsBySorting(String sortingparameter, boolean isDescending) {
		Direction direction = isDescending ? Direction.DESC : Direction.ASC;
		Sort sort = Sort.by(direction, sortingparameter);
		return productRepository.findAll(sort);
	}

	@Override
	public List<Product> getAllProductsByPaging(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Product> productsByPaging = productRepository.findAll(pageable);
		return productsByPaging.stream().toList();
//		return (List<Product>) productsByPaging;		this will throw Exception
	}

	@Override
	public List<Product> getAllProductsBySortingAndPaging(String sortingparameter, boolean isDescending, int pageNumber,
			int pageSize) {
		Direction direction = isDescending ? Direction.DESC : Direction.ASC;
		Sort sort = Sort.by(direction, sortingparameter);
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Product> productsBySortingAndPaging = productRepository.findAll(pageable);

		return productsBySortingAndPaging.stream().toList();
	}
}
