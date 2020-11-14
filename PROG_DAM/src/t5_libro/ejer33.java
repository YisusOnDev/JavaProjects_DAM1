package t5_libro;

import java.util.Scanner;

public class ejer33 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca la altura de la U: ");
		int altura = Integer.parseInt(sc.nextLine());

		for (int i = 1; i < altura; i++) {
			System.out.print("* ");
			for (int j = 2; j < altura; j++) {
				System.out.print("  ");
			}
			System.out.println("*");
		}

		System.out.print("  ");
		for (int i = 2; i < altura; i++) {
			System.out.print("* ");
		}

	}

}
