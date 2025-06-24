package com.entities;

import com.dto.ProductPartialDTO;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Product.allProducts", query = "SELECT p FROM Product p")
@NamedNativeQuery(name = "Product.productsInRangeOfBrand", query = "SELECT product_id,name,price FROM product WHERE BRAND = :brand AND PRICE BETWEEN :startPrice AND :endPrice", resultSetMapping = "ProductPartialMapping")
@SqlResultSetMapping(name = "ProductPartialMapping", classes = @ConstructorResult(targetClass = ProductPartialDTO.class, columns = {
		@ColumnResult(name = "product_id", type = Integer.class),
		@ColumnResult(name = "name", type = String.class),
		@ColumnResult(name = "price", type = Double.class) }))

public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String name;
	private String brand;
	private double price;
	private boolean inStock;
}