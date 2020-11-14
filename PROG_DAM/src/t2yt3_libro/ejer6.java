package t2yt3_libro;

import java.util.Scanner;

public class ejer6 {
	// Ejercicio 2 y 3 del punto 3.4 del Libro.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final double multiplicadorPesetas = 166.386; // valor de 1 euro en pesetas.
		final double multiplicadorEuros = 0.0060; // Equivalente de 1 peseta en euros
		
		while(true) {
			System.out.println(
					"Bienvenido al \"conversor\" \nPor favor, Introduce si quieres convertir de euros a pesetas o de pesetas a euros");
			String aConvertir = sc.nextLine();
			
			if (aConvertir.equals("euros a pesetas")) {
				System.out.println("Vas a convertir de " + aConvertir + "\nPor favor, introduce la cantidad a convertir:");
				double cantidad = Double.parseDouble(sc.nextLine());
				double totalConversion = cantidad * multiplicadorEuros;
				System.out.println("La cantidad que has introducido es: " + cantidad + ". \n" + cantidad + " pesetas son: "
						+ totalConversion + " euros");
				
			} else if (aConvertir.equals("pesetas a euros")) {
				System.out.println("Vas a convertir de " + aConvertir + "\nPor favor, introduce la cantidad a convertir:");
				double cantidad = Double.parseDouble(sc.nextLine());
				double totalConversion = cantidad * multiplicadorPesetas;
				System.out.println("La cantidad que has introducido es: " + cantidad + ". \n" + cantidad + " euros son: "
						+ totalConversion + " pesetas");
				
			} else {
				System.out.println("ERROR: Vuelve a intentarlo");
				
			}
		}
	}
}
