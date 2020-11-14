package t7_libro;

import java.util.Scanner;

public class ejer5 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] numero = new int[10];
		int maximo = Integer.MIN_VALUE;
		int minimo = Integer.MAX_VALUE;
		int i;

		for (i = 0; i < 10; i++) {
			System.out.println("Introduce un número:");
			numero[i] = Integer.parseInt(sc.nextLine());

			if (numero[i] < minimo) {
				minimo = numero[i];
			}

			if (numero[i] > maximo) {
				maximo = numero[i];
			}
		}

		System.out.println();

		for (i = 0; i < 10; i++) {
			System.out.print(numero[i]);
			if (numero[i] == maximo) {
				System.out.print(" es el máximo");
			}

			if (numero[i] == minimo) {
				System.out.print(" es el mínimo");
			}
			System.out.println();
		}

	}
}
