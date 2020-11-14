package t4_libro;

import java.util.Scanner;

public class ejer3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final String lunes1 = "Lunes";
		final String martes2 = "Martes";
		final String miercoles3 = "Miercoles";
		final String jueves4 = "Jueves";
		final String viernes5 = "Viernes";
		final String sabado6 = "Sabado";
		final String domingo7 = "Domingo";
		
		while(true) {
			System.out.println("Introduce un número del 1 al 7 y te diré que día de la semana es");
			int selection = Integer.parseInt(sc.nextLine());
			
			switch(selection) {
				case 1:
					System.out.println(lunes1);
					break;
				case 2:
					System.out.println(martes2);
					break;
				case 3:
					System.out.println(miercoles3);
					break;
				case 4:
					System.out.println(jueves4);
					break;
				case 5:
					System.out.println(viernes5);
					break;
				case 6:
					System.out.println(sabado6);
					break;
				case 7:
					System.out.println(domingo7);
					break;
				default: 
					System.out.println("No has introducido un número correcto");
			}
		}
	}
}
