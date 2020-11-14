package t4_libro;

import java.util.Scanner;

public class ejer1 {

	public static void main(String[] args) {
//		Escribe un programa que pida por teclado un día de la semana y que diga qué
//		asignatura toca a primera hora ese día.
		
		Scanner sc = new Scanner(System.in);
		
		final String aLunes = "Bases de datos";
		final String aMartes = "Entornos de desarrollo";
		final String aMiercoles = "Entornos de desarrollo";
		final String aJueves = "FOL";
		final String aViernes = "Programación";
		
		System.out.println("Escribe el día de la semana que toca (Lunes, Martes, Miercoles, Jueves o Viernes");
		String selection = sc.nextLine();
		
		switch(selection) {
			case "Lunes":
				System.out.println("A primera hora tendrás: " + aLunes);
				break;
			case "Martes":
				System.out.println("A primera hora tendrás: " + aMartes);
				break;
			case "Miercoles":
				System.out.println("A primera hora tendrás: " + aMiercoles);
				break;
			case "Jueves":
				System.out.println("A primera hora tendrás: " + aJueves);
				break;
			case "Viernes":
				System.out.println("A primera hora tendrás: " + aViernes);
				break;
			default: 
				System.out.println("No has introducido un valor correcto");
		}
	}

}
