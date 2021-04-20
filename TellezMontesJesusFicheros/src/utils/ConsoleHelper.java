package utils;

import java.io.File;
import java.util.Scanner;

public class ConsoleHelper {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Method that prints the main menu
	 */
	public static void printMainMenu() {
		System.out.println("OPTIONS:");
		System.out.println("1. Load file\n" + "2. Create file\n" + "3. Exit\n");
		System.out.println("Choose an option: ");
	}

	/**
	 * Method that read the options number
	 * 
	 * @param minValue max int allowed
	 * @param maxValue minimum int allowed
	 * @return the option
	 */
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

	/**
	 * Method that shows a simple yes/no option menu prompt
	 * 
	 * @param what the message
	 * @return the option
	 */
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

	/**
	 * Method that gets the absolute path that the user typed
	 * 
	 * @param method read/write
	 * @return absolute path if path is ok, null if path does not exist or file is
	 *         incorrect
	 */
	public static String getPathandFileMenu(String method) {
		String path = readString("Please insert the file path");
		String filename = readString("Please insert the filename (WITH EXTENSION!!)");

		if (!path.endsWith("/")) {
			path += "/";
		}

		String absolutePath = path + filename;
		if (!absolutePath.endsWith(".csv")) {
			System.out.println("File must have a name and the extension must be CSV.");
			getPathandFileMenu("read");
		} else {
			File f = new File(absolutePath);
			if (method.equals("read") && f.exists() && !f.isDirectory()) {
				return absolutePath;
			} else if (method.equals("read") && !f.exists()) {
				System.out.println("File does not exist...");
				printMainMenu();
			} else {
				return absolutePath;
			}
		}

		return null;

	}

	/**
	 * Method to read a simple string
	 * 
	 * @param what the message to show
	 * @return the string
	 */
	public static String readString(String what) {
		System.out.println(what);
		return sc.nextLine();
	}

	/**
	 * Method to read correctly a double
	 * 
	 * @param what the message
	 * @return the double write by the user
	 */
	public static double readDouble(String what) {
		double num = 0;
		System.out.println(what);
		boolean isNumber = false;

		while (!isNumber) {
			try {
				num = Double.parseDouble(sc.nextLine());
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Type a real number.");
				System.out.print(what + ": ");
			}
		}
		return num;
	}

	/**
	 * Method to chet if a string is a correct double
	 * 
	 * @param what the number as string
	 * @return if its a correct double or not (true / false )
	 */
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
