package t5_libro;

import java.util.Scanner;

public class ejer1y2y3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = 5;
		
		System.out.println("Selecciona la manera de ver los multiplos: \n1 --> con bucle for\n2 --> con bucle while\n3 --> con bucle do while");
		int selection = Integer.parseInt(sc.nextLine());
		
		
		switch(selection) {
		case 1:
			//Multiplos de 5 hasta 100 con bucle for
			for (i = 5; i <= 100; i+=5) {
				System.out.println(i);
			}
			break;
		case 2:
			//Multiplos de 5 hasta 100 con bucle while
			while(i < 100) {
				i+=5;
				System.out.println(i);
			}
			break;
		case 3:
			//Multiplos de 5 hasta 100 con bucle do while
			do {
				i = i + 5;
				System.out.println(i);
			}while(i < 100);
			break;
		default:
			System.out.println("Error...");
		}
		
	}

}
