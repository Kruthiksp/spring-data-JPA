package com.util;

import java.util.Scanner;

public class InputUtil {
	public static int menuOptions(Scanner sc) {
		System.out.println("1. Filter based on Brand");
		System.out.println("2. Filter based on Price");
		System.out.println("3. Filter Only inStock Products");
//		System.out.println("4. View All By Sorting and Pagination");

		int choice = sc.nextInt();

		if (choice >= 1 && choice <= 3) {
			return choice;
		} else {
			System.out.println("--- Invalid Choice ---");
			System.out.println("Try Again...");
			return menuOptions(sc);
		}
	}

	public static String acceptBrandToFilter(Scanner sc) {
		System.out.println("Enter the brand you want to search");
		return sc.next();
	}

	public static double[] acceptPriceToFilter(Scanner sc) {
		System.out.println("Enter the Starting Price to filter");
		double start = sc.nextDouble();
		System.out.println("Enter the Ending Price to filter");
		double end = sc.nextDouble();
		double[] prices = {start,end};
		return prices;
	}

	public static boolean wantToContinue(Scanner sc) {
		System.out.println("Press Y to Continue N to Exit");
		char choice = sc.next().toUpperCase().charAt(0);
		return (choice == 'Y') ? true : false;
	}
}
