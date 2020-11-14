package t5_libro;

import java.util.Scanner;

public class ejer4y5y6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int i = 320;
		// números del 320 al 160, contando de 20 en 20
		System.out.println(
				"Selecciona la manera de ver los números del 320 al 160, contando de 20 en 20 hacía atrás: \n1 --> con bucle for\n2 --> con bucle while\n3 --> con bucle do while");
		int selection = Integer.parseInt(sc.nextLine());

		switch (selection) {
		case 1:
			for (i = 320; i >= 160; i-=20) {
				System.out.println(i);
			}
			break;
		case 2:
			while (i > 160) {
				i -= 20;
				System.out.println(i);
			}
			break;
		case 3:
			do {
				i = i - 20;
				System.out.println(i);
			} while (i > 160);
			break;
		default:
			System.out.println("Error...");
		}

	}
}
