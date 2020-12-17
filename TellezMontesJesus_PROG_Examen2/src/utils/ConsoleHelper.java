package utils;

import java.util.Scanner;

public class ConsoleHelper {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Funcion que lee una opción de tipo int (con gestion de errores) que es
	 * introducida por el usuario. Esta es chequeada para que cumpla con el mínimo y
	 * máximo valor impuesto
	 * 
	 * @param minValue mínimo valor válido
	 * @param maxValue máximo valor válido
	 * @return devuelve la opción introducida por el usuario una vez comprobada.
	 */
	public static int elegirOpcion(int min, int max) {
		boolean isNumber = false;
		int opc = 0;
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < min || opc > max) {
					System.out.println("ERROR: Por favor, elige una opción entre " + min + " y " + max);
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce números del " + min + " al " + max);
			}
		}
		return opc;
	}

	/**
	 * Funcion que permite leer lo que escribe (string) el usuario
	 * 
	 * @param what el mensaje que se le muestra al usuario
	 * @return el mensaje que escribe el usuario
	 */
	public static String leerString(String what) {
		String userString;

		do {
			System.out.println(what);
			userString = sc.nextLine();
			if (userString.isBlank()) {
				System.out.println("[ERROR] Debes de instroducir algo (No sirven espacios vacios).");
			}

		} while (userString.isBlank());

		return userString;
	}

	/**
	 * Función para leer por teclado un double (con gestión de errores), pero este
	 * debe ser positivo si o sí.
	 * 
	 * @param what el mensaje que se le muestra al usuario.
	 * @return devuelve la opción introducida por el usuario una vez comprobada.
	 */
	public static double leerDoublePositivo(String what) {
		double num = 0;
		boolean isNumber = false;

		do {
			try {
				System.out.println(what);
				num = Double.parseDouble(sc.nextLine());
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce un número positivo.");
			}

		} while (!isNumber || num < 0);

		return num;

	}

	/**
	 * Función para leer por teclado un int (con gestión de errores), pero este debe
	 * ser positivo si o sí.
	 * 
	 * @param what el mensaje que se le muestra al usuario.
	 * @return devuelve la opción introducida por el usuario una vez comprobada.
	 */
	public static int leerInt(String what) {
		int num = 0;
		System.out.println(what);
		boolean isNumber = false;

		while (!isNumber) {
			try {
				num = Integer.parseInt(sc.nextLine());
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce un número entero.");
				System.out.print(what);
			}
		}
		return num;
	}

}
