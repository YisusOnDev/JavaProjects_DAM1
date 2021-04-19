package utils;

import java.util.Scanner;

public class ConsoleHelper {
private static Scanner sc = new Scanner(System.in);
	
	public static void imprimirMenu() {
		System.out.println("OPCIONES:");
		System.out.println("1. Leer archivo\n" + "2. Guardar archivo\n" + "3. Añadir alumno\n");
		System.out.println("Elige una opci�n: ");
	}

	public static int chooseOptionMenu(int minValue, int maxValue) {
		boolean isNumber = false;
		int opc = 0;
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < minValue || opc > maxValue) {
					System.out.println("ERROR: Por favor, elige una opcion entre "+ minValue +" y "+ maxValue);
					imprimirMenu();
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce numeros del "+ minValue +" al "+ maxValue);
				imprimirMenu();
			}
		}
		return opc;
	}
	
	public static int chooseOption(int min, int max) {
		boolean isNumber = false;
		int opc = 0;
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < min || opc > max) {
					System.out.println("ERROR: Por favor, elige una opcion entre "+ min +" y "+ max);
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce numeros del "+min+ " al " + max);
			}
		}
		return opc;
	}
	
	public static String readString(String what) {
		System.out.println(what);
		return sc.nextLine();
	}
	
	public static double readDouble(String what) {
		double num = 0;
		System.out.println(what);
		boolean isNumber = false;

		while (!isNumber) {
			try {
				num = Double.parseDouble(sc.nextLine());
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce un n�mero real.");
				System.out.print("Introduce " + what + ": ");
			}
		}
		return num;
	}
	
	public static boolean readYesNo(String what) {
		boolean isNumber = false;
		int opc = 0;
		System.out.println(what);
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < 0 || opc > 1) {
					System.out.println("ERROR: Por favor, elige una opci�n entre "+ 0 +" (no) y "+ 1 + "(s�)");
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce n�meros del "+ 0 +" (no) y "+ 1 + "(s�)");
			}
		}
		return opc == 1;
	}
}
