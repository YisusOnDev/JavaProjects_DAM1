package t5_libro;

import java.util.Scanner;

public class ejer25 {

	public static void main(String[] args) {
		// Realiza un programa que pida un número por teclado y que luego muestre ese
		// número al revés.

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número (ENTERO), te lo devuelvo al revés ;) --> ");
		int n = Integer.parseInt(sc.nextLine());
		int invertido = 0;
		
		while (n > 0) {
			int resto = n % 10;
			invertido = invertido * 10 + resto;
			n /= 10;
		}

		System.out.println(invertido);

	}

}