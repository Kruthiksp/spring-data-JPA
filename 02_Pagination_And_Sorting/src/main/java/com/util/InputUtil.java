package com.util;

import java.util.Scanner;

public class InputUtil {
	public static int menuOptions(Scanner sc) {
		System.out.println("1. View All Products");
		System.out.println("2. View All By Sorting");
		System.out.println("3. View All By Pagination");
		System.out.println("4. View All By Sorting and Pagination");

		int choice = sc.nextInt();

		if (choice >= 1 && choice <= 4) {
			return choice;
		} else {
			System.out.println("--- Invalid Choice ---");
			System.out.println("Try Again...");
			return menuOptions(sc);
		}
	}

	public static String takeSortingParameter(Scanner sc) {
		System.out.println("\nBased on what parameter you want to sort?");
		System.out.println("name");
		System.out.println("brand");
		System.out.println("price");
		System.out.println("inStock");

		return sc.next();
	}

	public static boolean descendingOrder(Scanner sc) {
		System.out.println("\nPress A for Ascending Order");
		System.out.println("Press D for Descending Order");

		char choice = sc.next().toUpperCase().charAt(0);

		return 'D' == choice;
	}

	public static int takePageSize(Scanner sc) {
		System.out.println("Enter the Page Size:");
		int pageSize = sc.nextInt();
		if (pageSize > 0) {
			return pageSize;
		} else {
			System.out.println("Page Size Must be Greater than 0");
			return takePageSize(sc);
		}
	}

	public static int takePageNumber(Scanner sc) {
		System.out.println("Enter the Page Number:");
		int pageNumber = sc.nextInt();
		if (pageNumber > 0) {
			return pageNumber;
		} else {
			System.out.println("Page Number Must be Greater than 0");
			return takePageNumber(sc);
		}
	}

	public static boolean wantToContinue(Scanner sc) {
		System.out.println("Press Y to Continue N to Exit");
		char choice = sc.next().toUpperCase().charAt(0);
		return (choice == 'Y') ? true : false;
	}
}
