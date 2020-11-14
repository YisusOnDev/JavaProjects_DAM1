package t4_libro;

import java.util.Scanner;

public class ejer6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		final double g = 9.81;
		while (true) {
			System.out.println("Cálculo del tiempo de caída de un objeto.");
			System.out.println("Por favor, introduce la altura (en metros) desde la que cae el objeto: ");
			Double h = Double.parseDouble(sc.nextLine());

			double s = Math.sqrt(2 * h / g);

			System.out.println("El objeto tarda \"" + s + "\" segundos en caer.\n");
		}
		
	}
	
}
