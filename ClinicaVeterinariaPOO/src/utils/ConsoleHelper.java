package utils;

import java.util.Scanner;

public class ConsoleHelper {

	private static Scanner sc = new Scanner(System.in);
	
	public static void imprimirMenu() {
		System.out.println("OPCIONES:");
		System.out.println("1. Añadir animal\n" + "2. Modificar comentario\n" + "3. Mostrar animales\n");
		System.out.println("Elige una opción: ");
	}

	public static int elegirOpcionMenu(int minValue, int maxValue) {
		boolean isNumber = false;
		int opc = 0;
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < minValue || opc > maxValue) {
					System.out.println("ERROR: Por favor, elige una opción entre "+ minValue +" y "+ maxValue);
					imprimirMenu();
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce números del "+ minValue +" al "+ maxValue);
				imprimirMenu();
			}
		}
		return opc;
	}
	
	public static int elegirOpcion(int min, int max) {
		boolean isNumber = false;
		int opc = 0;
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < min || opc > max) {
					System.out.println("ERROR: Por favor, elige una opción entre "+ min +" y "+ max);
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce números del "+min+ " al " + max);
			}
		}
		return opc;
	}
	
	public static String leerString(String what) {
		System.out.println(what);
		return sc.nextLine();
	}
	
	public static double leerDouble(String what) {
		double num = 0;
		System.out.println(what);
		boolean isNumber = false;

		while (!isNumber) {
			try {
				num = Double.parseDouble(sc.nextLine());
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce un número real.");
				System.out.print("Introduce " + what + ": ");
			}
		}
		return num;
	}
	
	public static boolean leerSiNo(String what) {
		boolean isNumber = false;
		int opc = 0;
		System.out.println(what);
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < 0 || opc > 1) {
					System.out.println("ERROR: Por favor, elige una opción entre "+ 0 +" (no) y "+ 1 + "(sí)");
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce números del "+ 0 +" (no) y "+ 1 + "(sí)");
			}
		}
		return opc == 1;
	}

	public static String definirAnimalMenu() {
		String tipoAnimal;
		tipoAnimal = leerString("Introduce el tipo de animal (Perro, Gato, Pajaro o Reptil): ");
		
		switch (tipoAnimal.toUpperCase()) {
		case "PERRO":
			return "PERRO";
		case "GATO":
			return "GATO";
		case "PAJARO":
			return "PAJARO";
		case "REPTIL":
			return "REPTIL";
		default:
			System.out.println("Por favor introduce un tipo de animal correcto.");
			definirAnimalMenu();
			break;
		}
		
		return null;
	}
}