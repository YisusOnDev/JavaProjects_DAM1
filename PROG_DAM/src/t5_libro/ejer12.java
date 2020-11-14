package t5_libro;

import java.util.Scanner;

public class ejer12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int first = 0;
		int second = 1;
		int result;
		System.out.print("Introduce un número: ");
		int nSelec = Integer.parseInt(sc.nextLine());

		if (nSelec > 2) {
			while (nSelec > 2) {
				result = first;
				first = second;
				second = result + second;
				System.out.print(" " + second);
				nSelec--;
			}

		} else {
			System.out.println("Por favor, introduce un número mayor que 2");
		}

	}
}
