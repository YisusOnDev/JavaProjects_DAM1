package t4_libro;

import java.util.Scanner;

public class ejer4 {
	
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		final int less40multiplier = 12;
		final int more40multiplier = 16;
		int totalGenerado = 0;
		
		while(true) {
			System.out.println("Introduce el nº de horas trabajadas durante la semana:");
			int selection = Integer.parseInt(sc.nextLine());
			
			if(selection <= 40){
				totalGenerado = selection * less40multiplier;
			}else if(selection >= 41){
				System.out.println("Current selection equals: "+selection);
				System.out.println("Current totalGenerado equals: "+totalGenerado);
				int firstCalc = 40;
				int restCalc = selection - firstCalc;
				totalGenerado = (firstCalc * less40multiplier) + (restCalc * more40multiplier);
			}else {
				System.out.println("Por favor introduce un valor correcto");
			}
			
			System.out.println("Tu sueldo semanal será o es de: " + totalGenerado + "€");
			
		}
	}
}
