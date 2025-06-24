package com.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entities.Product;
import com.service.ProductService;
import com.util.InputUtil;

@SpringBootApplication(scanBasePackages = { "com.service" })
@EntityScan(basePackages = "com.entities")
@EnableJpaRepositories(basePackages = "com.repositories")
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
				String brand = InputUtil.acceptBrandToFilter(sc);
				List<Product> byBrand = productService.findByBrand(brand);
				System.out.println("\n" + byBrand.size() + " Products Found");
				byBrand.stream().forEach(System.out::println);
				break;
			case 2:
				double[] acceptPriceToFilter = InputUtil.acceptPriceToFilter(sc);
				List<Product> byPriceBetween = productService.findByPriceBetween(acceptPriceToFilter[0],
						acceptPriceToFilter[1]);
				System.out.println("\n" + byPriceBetween.size() + " Products Found");
				byPriceBetween.stream().forEach(System.out::println);
				break;
			case 3:
				List<Product> byInStockTrue = productService.findByInStockTrue();
				System.out.println("\n" + byInStockTrue.size() + " Products Found");
				byInStockTrue.stream().forEach(System.out::println);
				break;
			}

		} while (InputUtil.wantToContinue(sc));
	}

}
