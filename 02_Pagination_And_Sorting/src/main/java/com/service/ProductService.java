package com.service;

import java.util.List;
import java.util.Optional;

import com.entities.Product;

public interface ProductService {
	List<Product> getAllProducts();

	List<Product> getAllProductsBySorting(String sortingparameter, boolean isDescending);

	List<Product> getAllProductsByPaging(int pageNumber, int pageSize);

	List<Product> getAllProductsBySortingAndPaging(String sortingparameter, boolean isDescending, int pageNumber,
			int pageSize);
}
