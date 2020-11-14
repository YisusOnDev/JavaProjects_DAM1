package t4_libro;

import java.util.Scanner;

public class ejer21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("------------------- \n");
			System.out.println("Calculadora de medias... \n");
			System.out.print("Nota del primer control: ");
			double nota1 = Double.parseDouble(sc.nextLine());

			System.out.print("Nota del segundo control: ");
			double nota2 = Double.parseDouble(sc.nextLine());

			double media = (nota1 + nota2) / 2;
			if (media > 10) {
				System.out.println("La nota es en base a 10 no 100 o superior, prueba de nuevo");
				return;
			}else {
				if (media < 5) {
					System.out.print("¿Cuál ha sido el resultado de la recuperación? (apto/no apto): ");
					String recuperacion = sc.nextLine().toLowerCase();
					if (recuperacion.equals("apto")) {
						media = 5;
					}
				}
			}

			System.out.println("Tu nota de Programación es " + media);
		}

	}
}
