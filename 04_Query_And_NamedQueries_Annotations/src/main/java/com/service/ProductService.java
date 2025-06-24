package com.service;

import java.util.List;

import com.dto.ProductPartialDTO;
import com.entities.Product;

public interface ProductService {
	double averagePriceOfAllProducts(String brand);

	List<Product> productsInRangeOfABrand(String brand, int startPrice, int endPrice);

	List<Product> AllProducts();

	List<ProductPartialDTO> productsInRangeOfBrand(String brand, int startPrice, int endPrice);
}
