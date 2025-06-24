package com.demo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dto.ProductDTO;
import com.entities.Product;
import com.service.ProductService;
import com.util.InputUtil;
import com.util.ProductMapper;

@SpringBootApplication(scanBasePackages = { "com.demo", "com.util", "com.service" })
@EntityScan(basePackages = { "com.entities" })
@EnableJpaRepositories(basePackages = { "com.repositories" })
public class Application implements CommandLineRunner {

	private final ProductService productService;
	private final ProductMapper productMapper;

	public Application(ProductService productService, ProductMapper productMapper) {
		this.productService = productService;
		this.productMapper = productMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("***	Welcome	***");
		Scanner sc = new Scanner(System.in);
		do {
			int choice = InputUtil.menuOptions(sc);
			switch (choice) {
			case 1:
				ProductDTO productDTO = InputUtil.productDetailsToSave(sc);
				Product entity = productMapper.toEntity(productDTO);
				System.out.println(entity);
				productService.save(entity);
				break;

			case 2:
				List<Product> allProducts = productService.getAllProducts();
				allProducts.stream().forEach(System.out::println);
				break;

			case 3:
				int productId = InputUtil.getProductId(sc);
				Optional<Product> product = productService.getProductById(productId);
				if (product.isPresent()) {
					System.out.println(product.get());
				} else {
					System.out.println("No Product with the Id: " + productId);
				}
				break;

			case 4:
				int productIdToUpdate = InputUtil.getProductId(sc);
				Optional<Product> productToUpdate = productService.getProductById(productIdToUpdate);

				if (productToUpdate.isPresent()) {
					Product product2 = productToUpdate.get();

					int whatToUpdate = InputUtil.whatToUpdate(sc);
					switch (whatToUpdate) {
					case 1:
						String nameToUpdate = InputUtil.takeNameToUpdate(sc);
						product2.setName(nameToUpdate);
						break;
					case 2:
						String brandToUpdate = InputUtil.takeBrandToUpdate(sc);
						product2.setBrand(brandToUpdate);
						break;
					case 3:
						double priceToUpdate = InputUtil.takePriceToUpdate(sc);
						product2.setPrice(priceToUpdate);
						break;
					case 4:
						boolean availabilityToUpdate = InputUtil.takeAvailabilityToUpdate(sc);
						product2.setInStock(availabilityToUpdate);
						break;
					}
					productService.save(product2);
					break;
				}

			case 5:
				int productIdToDelete = InputUtil.getProductId(sc);
				productService.deleteProductById(productIdToDelete);
				break;
			}
		} while (InputUtil.wantToContinue(sc));
	}

}
