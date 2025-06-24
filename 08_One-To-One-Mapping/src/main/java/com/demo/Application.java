package com.demo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dto.OwnerDTO;
import com.dto.ProductDTO;
import com.entities.Owner;
import com.entities.Product;
import com.service.OwnerService;
import com.service.ProductService;
import com.util.InputUtil;
import com.util.OwnerMapper;
import com.util.ProductMapper;

@SpringBootApplication(scanBasePackages = { "com.demo", "com.util", "com.service" })
@EntityScan(basePackages = { "com.entities" })
@EnableJpaRepositories(basePackages = { "com.repositories" })
public class Application implements CommandLineRunner {

	private final ProductService productService;
	private final ProductMapper productMapper;
	private final OwnerService ownerService;
	private final OwnerMapper ownerMapper;

	public Application(ProductService productService, ProductMapper productMapper, OwnerMapper ownerMapper,
			OwnerService ownerService) {
		this.productService = productService;
		this.productMapper = productMapper;
		this.ownerMapper = ownerMapper;
		this.ownerService = ownerService;
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
				OwnerDTO ownerDTO = InputUtil.ownerDetailsToSave(sc);
				Owner ownerEntity = ownerMapper.toEntity(ownerDTO);
				ownerService.save(ownerEntity);
				break;

			case 2:
				List<Owner> allOwners = ownerService.getAllOwners();
				allOwners.stream().forEach(System.out::println);
				break;

			case 3:
//				int ownerId = InputUtil.getOwnerId(sc);
				break;

			case 4:
				ProductDTO productDTO = InputUtil.productDetailsToSave(sc);
				Product productEntity = productMapper.toEntity(productDTO);
				System.out.println(productEntity);
				productService.save(productEntity);
				break;

			case 5:
				List<Product> allProducts = productService.getAllProducts();
				allProducts.stream().forEach(System.out::println);
				break;

			case 6:
				int productId = InputUtil.getProductId(sc);
				Optional<Product> product = productService.getProductById(productId);
				if (product.isPresent()) {
					System.out.println(product.get());
				} else {
					System.out.println("No Product with the Id: " + productId);
				}
				break;

			case 7:
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

			case 8:
				int productIdToDelete = InputUtil.getProductId(sc);
				productService.deleteProductById(productIdToDelete);
				break;
			}
		} while (InputUtil.wantToContinue(sc));
	}

}
