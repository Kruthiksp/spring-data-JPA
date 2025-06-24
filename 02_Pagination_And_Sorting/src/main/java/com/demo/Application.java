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

@SpringBootApplication(scanBasePackages = { "com.demo", "com.util", "com.service" })
@EntityScan(basePackages = { "com.entities" })
@EnableJpaRepositories(basePackages = { "com.repositories" })
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
				List<Product> allProducts = productService.getAllProducts();
				allProducts.stream().forEach(System.out::println);
				break;
			case 2:
				String sortingParameter = InputUtil.takeSortingParameter(sc);
				boolean descendingOrder = InputUtil.descendingOrder(sc);
				List<Product> allProductsBySorting = productService.getAllProductsBySorting(sortingParameter,
						descendingOrder);
				allProductsBySorting.stream().forEach(System.out::println);
				break;
			case 3:
				int pageSize = InputUtil.takePageSize(sc);
				int pageNumber = InputUtil.takePageNumber(sc);
				List<Product> allProductsByPaging = productService.getAllProductsByPaging(pageNumber - 1, pageSize);
				allProductsByPaging.stream().forEach(System.out::println);
				break;
			case 4:
				String sortingParameter2 = InputUtil.takeSortingParameter(sc);
				boolean descendingOrder2 = InputUtil.descendingOrder(sc);
				int pageSize2 = InputUtil.takePageSize(sc);
				int pageNumber2 = InputUtil.takePageNumber(sc);
				List<Product> allProductsBySortingAndPaging = productService.getAllProductsBySortingAndPaging(
						sortingParameter2, descendingOrder2, pageNumber2 - 1, pageSize2);
				allProductsBySortingAndPaging.forEach(System.out::println);
				break;
			}
		} while (InputUtil.wantToContinue(sc));
	}

}
