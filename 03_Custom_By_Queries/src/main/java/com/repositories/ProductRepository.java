package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByBrand(String brand);

	List<Product> findByBrandOrderByPriceDesc(String brand);

	List<Product> findByPriceBetween(double start, double end);

	List<Product> findByInStockTrue();
}
