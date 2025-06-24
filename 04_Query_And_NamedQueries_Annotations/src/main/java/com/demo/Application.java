package com.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dto.ProductPartialDTO;
import com.entities.Product;
import com.service.ProductService;
import com.util.InputUtil;

@SpringBootApplication(scanBasePackages = { "com.service" })
@EnableJpaRepositories(basePackages = { "com.repositories" })
@EntityScan(basePackages = { "com.entities" })
public class Application implements CommandLineRunner {

	private final ProductService productService;

	public Application(ProductService productService) {
		this.productService = productService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		do {
			int menuOptions = InputUtil.menuOptions(sc);
			switch (menuOptions) {
			case 1:
				String brandName = InputUtil.acceptBrandName(sc);
				double averagePriceOfAllProducts = productService.averagePriceOfAllProducts(brandName);
				System.out.println(
						"\nAverage Price Of All Products form " + brandName + " is : " + averagePriceOfAllProducts);
				break;

			case 2:
				String brandName1 = InputUtil.acceptBrandName(sc);
				int startPrice = InputUtil.acceptStartPrice(sc);
				int endPrice = InputUtil.acceptEndPrice(sc);
				List<Product> productsInRangeOfABrand = productService.productsInRangeOfABrand(brandName1, startPrice,
						endPrice);
				productsInRangeOfABrand.stream().forEach(System.out::println);
				break;

			case 3:
				List<Product> allProducts = productService.AllProducts();
				allProducts.stream().forEach(System.out::println);
				break;
			case 4:
				String brandName2 = InputUtil.acceptBrandName(sc);
				int startPrice1 = InputUtil.acceptStartPrice(sc);
				int endPrice1 = InputUtil.acceptEndPrice(sc);
				List<ProductPartialDTO> productsInRangeOfBrand = productService.productsInRangeOfBrand(brandName2, startPrice1,
						endPrice1);
				productsInRangeOfBrand.stream().forEach(System.out::println);
				break;
			}
		} while (InputUtil.wantToContinue(sc));
	}

}
