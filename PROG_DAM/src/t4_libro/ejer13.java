package t4_libro;

import java.util.Scanner;

public class ejer13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int util;
		while (true) {
			System.out.println("Introduce 3 numeros, yo los ordenaré.");
			int a = Integer.parseInt(sc.nextLine());
			int b = Integer.parseInt(sc.nextLine());
			int c = Integer.parseInt(sc.nextLine());
	
			if (a > b) {
				util = a;
				a = b;
				b = util;
			}
	
			if (b > c) {
				util = b;
				b = c;
				c = util;
			}
	
			if (a > b) {
				util = a;
				a = b;
				b = util;
			}
	
			System.out.println("Los numeros (ordenador de mayor a menor): " + a + ", " + b + " y " + c + ".");
		}
	}
}
