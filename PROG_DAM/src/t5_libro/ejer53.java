package t5_libro;

import java.util.Scanner;

public class ejer53 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca la altura de la figura: ");
		int altura = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < altura - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
