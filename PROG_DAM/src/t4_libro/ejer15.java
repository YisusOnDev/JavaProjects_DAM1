package t4_libro;

import java.util.Scanner;

public class ejer15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("--------------------------------------------------- \n");
			System.out.println("Introduce el carácter con el que quieres hacer la piramide");
			String simbol = sc.nextLine();

			System.out.println("Escribe la posición del vertice (arriba, abajo, izquierda o derecha)");
			String selection = sc.nextLine();
			System.out.println("\n");

			switch (selection) {
			case "arriba":
				System.out.println("  " + simbol);
				System.out.println(" " + simbol + simbol + simbol);
				System.out.println(simbol + simbol + simbol + simbol + simbol);
				System.out.println("\n");
				break;
			case "abajo":
				System.out.println(simbol + simbol + simbol + simbol + simbol);
				System.out.println(" " + simbol + simbol + simbol);
				System.out.println("  " + simbol);
				System.out.println("\n");
				break;
			case "izquierda":
				System.out.println("    " + simbol);
				System.out.println("  " + simbol + " " + simbol);
				System.out.println(simbol + " " + simbol + " " + simbol);
				System.out.println("  " + simbol + " " + simbol);
				System.out.println("    " + simbol);
				System.out.println("\n");
				break;
			case "derecha":
				System.out.println(simbol);
				System.out.println(simbol + " " + simbol);
				System.out.println(simbol + " " + simbol + " " + simbol);
				System.out.println(simbol + " " + simbol);
				System.out.println(simbol);
				System.out.println("\n");
				break;
			default:
				System.out.println("Por favor indica correctamente la posición del vertice.");
			}
		}

	}

}
