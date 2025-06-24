package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Transactional
	@Query("UPDATE Product p SET p.price=:newPrice where p.productId=:productId")
	void updatePrice(int productId, double newPrice);

	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Transactional
	@Query("DELETE FROM Product p WHERE p.productId=:productId")
	void deleteById(int productId);

}
