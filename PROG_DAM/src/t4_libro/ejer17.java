package t4_libro;

import java.util.Scanner;

public class ejer17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor, introduce un número ENTERO:");
		int numero = Integer.parseInt(sc.nextLine());
		int result = numero % 10;
		
		System.out.println("El número introducido es: " + numero + " y la última cifra es: " + result);

	}

}
