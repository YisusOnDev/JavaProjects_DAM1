package t7_libro;

import java.util.Scanner;

public class ejer3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double[] numeros = new double[10];
		
			numeros[0] = Integer.parseInt(sc.nextLine());
			numeros[1] = Integer.parseInt(sc.nextLine());
			numeros[2] = Integer.parseInt(sc.nextLine());
			numeros[3] = Integer.parseInt(sc.nextLine());
			numeros[4] = Integer.parseInt(sc.nextLine());
			numeros[5] = Integer.parseInt(sc.nextLine());
			numeros[6] = Integer.parseInt(sc.nextLine());
			numeros[7] = Integer.parseInt(sc.nextLine());
			numeros[8] = Integer.parseInt(sc.nextLine());
			numeros[9] = Integer.parseInt(sc.nextLine());
		
		for (int i = 10; i < numeros.length && i >= 0; i--) {
			System.out.println(numeros[i]);
		}

	}

}
