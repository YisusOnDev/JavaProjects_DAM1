package t5_libro;

import java.util.Scanner;

public class ejer13 {

	public static void main(String[] args) {
		// Escribe un programa que lea una lista de diez números y determine cuántos
		// son positivos, y cuántos son negativos.
		Scanner sc = new Scanner(System.in);
		int nNumeros = 0;
		int negatives = 0;
		int positives = 0;
		
		while (nNumeros < 10) {
			System.out.print("Introduce un número: ");
			double n = Double.parseDouble(sc.nextLine());
			nNumeros++;
			
			if (n < 0) {
				System.out.println(n + " es negativo.");
				negatives++;
			}
			
			if (n > 0) {
				System.out.println(n + " es positivo.");
				positives++;
			}
		}
		
		System.out.println("Recuento:\n" + positives + " números son positivos.\n" + negatives + " números son negativos.");

	}

}
