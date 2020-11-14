package t7_libro;

import java.util.Scanner;

public class ejer9 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    int[] numero = new int[8];
	    int i;

	    for (i = 0; i < 8; i++) {
		   System.out.println("Introduce un número:");
	      numero[i] = Integer.parseInt(sc.nextLine());
	    }

	    for (i = 0; i < 8; i++) {
	      if (numero[i] % 2 == 0) {
	        System.out.println(numero[i] + " par");
	      } else {
	        System.out.println(numero[i] + " impar");
	      }
	    }
	  }

}
