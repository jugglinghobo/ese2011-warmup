package source;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	private static Scanner scan = new Scanner(System.in);
	
	
	public static String promptStringInput(String output) {
		System.out.println(output);
		return scan.nextLine();
	}
	
	public static int promptIntInput(String output) {
		System.out.println(output);
		int input = 0;
		boolean hasEnteredNumber = false;
		while (!hasEnteredNumber) {
			try {
				input = scan.nextInt();
				// this catches the unused newLinestring after the int input
				@SuppressWarnings("unused")
				String notused = scan.nextLine();
				hasEnteredNumber = true;
			} catch (InputMismatchException e) {
				System.out.println(scan.next() + " is not a valid number.");
			}
		}
		return input;
	}

	public static Date promptDate(String output) {
		System.out.println(output);
		return new Date();
	}

	public static boolean promptBoolean(String output) {
		System.out.println(output);
		if (scan.nextLine().equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
}
