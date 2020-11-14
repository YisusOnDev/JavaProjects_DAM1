package t4_libro;

import java.util.Scanner;

public class ejer5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double a = 0;
		double b = 0;
		double result = 0;
		
		while(true) {
			System.out.println("Vamos a calcular una ecuación de 1er grado (ax + b = 0)");
			System.out.println("Introduce el valor de a:");
			a = Double.parseDouble(sc.nextLine());
			System.out.println("Introduce el valor de b:");
			b = Double.parseDouble(sc.nextLine());
			
			if(a==0){
				System.out.println("Esa ecuación no tiene solución real");
				return;
			}else {
				result = -b/a;
			}
			
			System.out.println("En la ecuación " + a + "x + " + b + " = 0 \nX = " + result);
			
		}
	}
}
