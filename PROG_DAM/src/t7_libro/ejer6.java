package t7_libro;

import java.util.Scanner;

public class ejer6 {
//	Escribe un programa que lea 15 números por teclado y que los almacene en un
//	array. Rota los elementos de ese array, es decir, el elemento de la posición 0
//	debe pasar a la posición 1, el de la 1 a la 2, etc. El número que se encuentra en
//	la última posición debe pasar a la posición 0. Finalmente, muestra el contenido
//	del array.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[15];

		for (int i = 0; i < 15; i++) {
			System.out.print("introduce un número: ");
			numeros[i] = Integer.parseInt(sc.nextLine());
		}

		// Array original
		for (int i = 0; i < 15; i++) {
			System.out.print(numeros[i] + " ");
		}

		System.out.println("");

		// Array movido
		int aux = numeros[14];
		for (int i = 14; i > 0; i--) {
			numeros[i] = numeros[i - 1];
		}
		numeros[0] = aux;
		for (int i = 0; i < 15; i++) {
			System.out.print(numeros[i] + " ");
		}
	}
}
