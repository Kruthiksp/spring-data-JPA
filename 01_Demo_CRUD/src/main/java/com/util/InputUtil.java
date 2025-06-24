package com.util;

import java.util.Scanner;

import com.dto.ProductDTO;

public class InputUtil {
	public static int menuOptions(Scanner sc) {
		System.out.println("1. Add Product");
		System.out.println("2. View All Products");
		System.out.println("3. View Products By Id");
		System.out.println("4. Update Product");
		System.out.println("5. Delete Product");

		int choice = sc.nextInt();

		if (choice >= 1 && choice <= 5) {
			return choice;
		} else {
			System.out.println("--- Invalid Choice ---");
			System.out.println("Try Again...");
			return menuOptions(sc);
		}
	}

	public static ProductDTO productDetailsToSave(Scanner sc) {
		System.out.println("Enter Product Name");
		String name = sc.next();
		System.out.println("Enter Product Brand");
		String brand = sc.next();
		System.out.println("Enter Product Price");
		double price = sc.nextDouble();
		System.out.println("Is Product Available?\nPress Y if Available\nPress N if Not Available.");
		char available = sc.next().toUpperCase().charAt(0);

		boolean isAvailable = available == 'Y' ? true : false;

		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(name);
		productDTO.setBrand(brand);
		productDTO.setPrice(price);
		productDTO.setInStock(isAvailable);

		return productDTO;
	}

	public static int getProductId(Scanner sc) {
		System.out.println("Enter the Product id");
		int id = sc.nextInt();
		return id;
	}

	public static int whatToUpdate(Scanner sc) {
		System.out.println("What you want to Update?");
		System.out.println("1. update Name");
		System.out.println("2. update Brand");
		System.out.println("3. update Price");
		System.out.println("4. update Availability");
		int choice = sc.nextInt();
		if (choice >= 1 && choice <= 4) {
			return choice;
		} else {
			System.out.println("Invalid Choice");
			return whatToUpdate(sc);
		}
	}

	public static String takeNameToUpdate(Scanner sc) {
		System.out.println("Enter Product Name");
		String name = sc.next();
		return name;
	}

	public static String takeBrandToUpdate(Scanner sc) {
		System.out.println("Enter Product brand");
		String brand = sc.next();
		return brand;
	}

	public static double takePriceToUpdate(Scanner sc) {
		System.out.println("Enter Product Price");
		double price = sc.nextDouble();
		return price;
	}

	public static boolean takeAvailabilityToUpdate(Scanner sc) {
		System.out.println("Is Product Available?\nPress Y if Available\nPress N if Not Available.");
		char available = sc.next().toUpperCase().charAt(0);

		boolean isAvailable = available == 'Y' ? true : false;

		return isAvailable;
	}

	public static boolean wantToContinue(Scanner sc) {
		System.out.println("Press Y to Continue N to Exit");
		char choice = sc.next().toUpperCase().charAt(0);
		return (choice == 'Y') ? true : false;
	}
}
