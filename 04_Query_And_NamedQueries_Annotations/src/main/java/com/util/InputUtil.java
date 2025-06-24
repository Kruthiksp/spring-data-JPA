package com.util;

import java.util.Scanner;

public class InputUtil {
	public static int menuOptions(Scanner sc) {
		System.out.println("1. @Query(HQL) to Find the Average price of all the products");
		System.out.println("2. @Query(SQL) to Fetch the products of perticular brand with perticular price range.");
		System.out.println("3. @NamedQuery to Fetch All products");
		System.out.println("4. @NamedNativeQuery to Fetch the products of perticular brand with perticular price range");

		int choice = sc.nextInt();

		if (choice >= 1 && choice <= 4) {
			return choice;
		} else {
			System.out.println("--- Invalid Choice ---");
			System.out.println("Try Again...");
			return menuOptions(sc);
		}
	}

	public static String acceptBrandName(Scanner sc) {
		System.out.println("Enter the Brand Name whose avg price you want.");
		return sc.next();
	}

	public static int acceptStartPrice(Scanner sc) {
		System.out.println("Enter the Starting Price.");
		return sc.nextInt();
	}

	public static int acceptEndPrice(Scanner sc) {
		System.out.println("Enter the Starting Price.");
		return sc.nextInt();
	}

	public static boolean wantToContinue(Scanner sc) {
		System.out.println("Press Y to Continue N to Exit");
		char choice = sc.next().toUpperCase().charAt(0);
		return (choice == 'Y') ? true : false;
	}
}
