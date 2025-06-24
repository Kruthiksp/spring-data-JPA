package com.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
				int productId = InputUtil.acceptProductId(sc);
				double newPrice = InputUtil.acceptNewPrice(sc);
				productService.updatePrice(productId, newPrice);
				System.out.println("price updated successfully...");
				break;
			case 2:
				int productId1 = InputUtil.acceptProductId(sc);
				productService.deleteById(productId1);
				break;
			case 3:
				List<Integer> productIds = InputUtil.acceptProductIds(sc);
				productService.deleteById(productIds);
				break;
			}
		} while (InputUtil.wantToContinue(sc));
	}

}
