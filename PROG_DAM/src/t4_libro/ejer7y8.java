package t4_libro;

import java.util.Scanner;

public class ejer7y8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("------------------------------------------- \n");
			System.out.println("Vamos a calcular la media de 3 notas:");
			System.out.println("Introduce la primera nota");
			double nota1 = Double.parseDouble(sc.nextLine());
			System.out.println("Introduce la segunda nota");
			double nota2 = Double.parseDouble(sc.nextLine());
			System.out.println("Introduce la tercera nota");
			double nota3 = Double.parseDouble(sc.nextLine());
			
			double notaMedia = (nota1 + nota2 + nota3) / 3;

			String notaTxt = "ERROR";

			if (notaMedia >= 0 && notaMedia <= 2.99) {
				notaTxt = "Muy deficiente";
			} else if (notaMedia >= 3 && notaMedia <= 4.99) {
				notaTxt = "Insuficiente";
			} else if (notaMedia >= 5 && notaMedia <= 5.99) {
				notaTxt = "Suficiente";
			} else if (notaMedia >= 6 && notaMedia <= 7.49) {
				notaTxt = "Bien";
			} else if (notaMedia >= 7.5 && notaMedia <= 8.99) {
				notaTxt = "Notable";
			} else if (notaMedia >= 9 && notaMedia <= 9.99) {
				notaTxt = "Sobresaliente";
			} else if (notaMedia == 10) {
				notaTxt = "Matrícula de honor";
			} else {
				System.out.println("ERROR: Vuelve a intentarlo.");
			}

			System.out.println("La media de las notas: " + nota1 + " " + nota2 + " " + nota3 + " es: " + notaMedia +
					"\nTienes un: " + notaTxt);
		}
	}
}
