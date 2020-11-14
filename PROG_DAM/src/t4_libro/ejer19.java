package t4_libro;

import java.util.Scanner;

public class ejer19 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		System.out.println("Introduce un número entero (máximo 5 digitos): ");
		int numero = Integer.parseInt(sc.nextLine());

		if (numero < 0) {
			numero = numero * -1;
		}

		while (numero != 0) {
			numero /= 10;
			++count;
		}

		System.out.println("El número tiene " + count + " digitos.");
	}
}