package t5_libro;

import java.util.Scanner;

public class ejer24 {

	public static void main(String[] args) {
		// Escribe un programa que lea un número n e imprima una pirámide de números
		// con n filas como en la siguiente figura:

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce el número de filas que quieres que tenga la piramide: ");
		int scFilas = Integer.parseInt(sc.nextLine());
		int altura = 1;
		int espacios = scFilas - 1;
		int i;

		while (altura < scFilas) {

			for (i = 1; i <= espacios; i++) {
				System.out.print(" ");
			}
			for (i = 1; i < altura; i++) {
				System.out.print(i);
			}

			for (i = altura; i > 0; i--) {
				System.out.print(i);
			}

			System.out.println();

			altura++;
			espacios--;

		}

	}

}
