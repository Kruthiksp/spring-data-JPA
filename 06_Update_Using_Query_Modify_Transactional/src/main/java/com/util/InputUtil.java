package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {
	public static int menuOptions(Scanner sc) {
		System.out.println("1. Update Price");
		System.out.println("2. Delete Product");
		System.out.println("3. Delete List Of Products");
//		System.out.println("4. @NamedNativeQuery to Fetch the products of perticular brand with perticular price range");

		int choice = sc.nextInt();

		if (choice >= 1 && choice <= 3) {
			return choice;
		} else {
			System.out.println("--- Invalid Choice ---");
			System.out.println("Try Again...");
			return menuOptions(sc);
		}
	}

	public static int acceptProductId(Scanner sc) {
		System.out.println("Enter Product ID:");
		return sc.nextInt();
	}

	public static List<Integer> acceptProductIds(Scanner sc) {
		List<Integer> ownerIds = new ArrayList<>();
		do {
			System.out.println("Enter Product ID:");
			ownerIds.add(sc.nextInt());
		} while (wantToContinue(sc));
		
		return ownerIds;
	}

	public static double acceptNewPrice(Scanner sc) {
		System.out.println("Enter the Updated Price:");
		return sc.nextDouble();
	}

	public static boolean wantToContinue(Scanner sc) {
		System.out.println("Press Y to Continue N to Exit");
		char choice = sc.next().toUpperCase().charAt(0);
		return (choice == 'Y') ? true : false;
	}
}
