package t2yt3_libro;

import java.util.Scanner;

public class ejer5 {
	// Ejercicio 1 del punto 3.4 del Libro.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al \"multiplicador\" \nPor favor, Introduce el primer número");
		double primerNumero = Double.parseDouble(sc.nextLine());
		System.out.println("El número introducido es: " + primerNumero);
		System.out.println("Por favor, Introduce el segundo número");
		double segundoNumero = Double.parseDouble(sc.nextLine());
		System.out.println("El número introducido es: " + segundoNumero);
		double resultadoMultiplicacion = primerNumero * segundoNumero;
		System.out.println("La multiplicación de: " + primerNumero + " + " + segundoNumero + " es: " + resultadoMultiplicacion);
	}

}
