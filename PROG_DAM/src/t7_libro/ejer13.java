package t7_libro;

import java.util.Scanner;

public class ejer13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] n = new int[100];
		int maximo = 0;
		int minimo = 100;

		for (int i = 0; i < 100; i++) {
			n[i] = (int) (Math.random() * 501);

			if (n[i] < minimo) {
				minimo = n[i];
			}

			if (n[i] > maximo) {
				maximo = n[i];
			}
		}

		for (int elemento : n) {
			System.out.print(elemento + " ");
		}

		System.out.print("\n\n¿Qué quiere destacar? (1 –-> el mínimo, 2 –-> el máximo): ");
		int opcion = Integer.parseInt(sc.nextLine());

		int toMark; // 

		if (opcion == 1) {
			toMark = minimo;
		} else {
			toMark = maximo;
		}

		System.out.println();

		for (int orig : n) {
			if (orig == toMark) {
				System.out.print(" ->" + orig + "<- ");
			} else {
				System.out.print(orig + " ");
			}
		}
	}

}
