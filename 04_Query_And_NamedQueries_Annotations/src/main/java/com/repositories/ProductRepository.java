package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dto.ProductPartialDTO;
import com.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT AVG(p.price) FROM Product p WHERE p.brand = :brand")
	double averagePriceOfAllProducts(@Param("brand") String brand);
	// here we mat use @Param or may not use it
	// Its optional

	@Query(value = "SELECT * FROM product WHERE BRAND = :brand AND PRICE BETWEEN :startPrice AND :endPrice", nativeQuery = true)
	List<Product> productsInRangeOfABrand(String brand, int startPrice, int endPrice);

	@Query(name = "Product.allProducts")
	List<Product> AllProducts();

	@Query(name = "Product.productsInRangeOfBrand", nativeQuery = true)
	List<ProductPartialDTO> productsInRangeOfBrand(String brand, int startPrice, int endPrice);
}
