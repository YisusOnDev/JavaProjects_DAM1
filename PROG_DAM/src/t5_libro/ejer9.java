package t5_libro;

import java.util.Scanner;

public class ejer9 {

	public static void main(String[] args) {
		// Muestra la tabla de multiplicar de un número introducido por teclado.

		Scanner sc = new Scanner(System.in);

		long n;

		System.out.print("Introduce un número, te diré su número de digitos:");
		n = Long.parseLong(sc.nextLine());
		int l;
		for (l=0;n>0;++l) {
			 n/=10;
		}
		 System.out.println(l + 1);
	    
		
	}

}
