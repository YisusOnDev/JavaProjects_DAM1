package t5_libro;

import java.util.Scanner;

public class ejer18 {

	public static void main(String[] args) {
		// Escribe un programa que obtenga los números enteros comprendidos entre dos
		// números introducidos por teclado y validados como distintos, el programa debe
		// empezar por el menor de los enteros introducidos e ir incrementando de 7 en
		// 7.
		
		Scanner sc = new Scanner(System.in);
		
		int a;
		int b;
		
		System.out.print("Introduce el menor número: ");
		a = Integer.parseInt(sc.nextLine());
		System.out.print("Introduce el mayor número: ");
		b = Integer.parseInt(sc.nextLine());
		
		if (b < a) {
			int mayor = a;
			int menor = b;
			a = menor;
			b = mayor;
		} else {
			System.out.println("EERROORR");
		}
		
		for (int i = 1; i < b; i+=7) {
			if (i > a && i < b) {
				System.out.println(i);
			}
		}
	}

}
