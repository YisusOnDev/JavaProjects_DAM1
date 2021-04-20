package utils;

import java.util.Scanner;

public class ConsoleHelper {

	private static Scanner sc = new Scanner(System.in);

	public static void printMainMenu() {
		System.out.println("OPTIONS:");
		System.out.println("1. Load file\n" + "2. Create file\n" + "3. Exit\n");
		System.out.println("Choose an option: ");
	}

	public static int chooseOptionMenu(int minValue, int maxValue) {
		boolean isNumber = false;
		int opc = 0;
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < minValue || opc > maxValue) {
					System.out
							.println("ERROR: Please choose an option (numer) between " + minValue + " and " + maxValue);
					printMainMenu();
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Please choose an option (numer) between " + minValue + " and " + maxValue);
				printMainMenu();
			}
		}
		return opc;
	}

	public static boolean yesNo(String what) {
		boolean isNumber = false;
		int opc = 0;
		System.out.println(what);
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < 0 || opc > 1) {
					System.out.println("ERROR: Please choose a number between " + 0 + " (no) y " + 1 + "(yes)");
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Please choose a number between " + 0 + " (no) y " + 1 + "(yes)");
			}
		}
		return opc == 1;
	}

	public static boolean checkIsDouble(String what) {
		boolean isNumber = false;

		while (!isNumber) {
			try {
				Double.parseDouble(what);
				isNumber = true;
			} catch (NumberFormatException e) {
				isNumber = false;
			}
		}
		return isNumber;
	}
}
