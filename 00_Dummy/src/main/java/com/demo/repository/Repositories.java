package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Product;

public interface Repositories extends JpaRepository<Product, Integer>{
	
}
