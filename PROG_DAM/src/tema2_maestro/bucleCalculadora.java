package tema2_maestro;

import java.util.Scanner;

public class bucleCalculadora {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean stillLooping = true;

		int selection;

		int n1;
		int n2;

		while (stillLooping) {
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("Bienvenido a la calculadora simple, por favor indica una acción:");
			System.out.println("1 --> Sumar\n2 --> Restar\n3 --> Multiplicar\n4 --> Dividir\n5 --> Salir");

			selection = Integer.parseInt(sc.nextLine());
			if (selection == 1 || selection == 2 || selection == 3 || selection == 4 || selection == 5) {
				int calculo;

				switch (selection) {
				case 1:
					System.out.println("Introduce el primer numero:");
					n1 = Integer.parseInt(sc.nextLine());
					System.out.println("Introduce el segundo numero:");
					n2 = Integer.parseInt(sc.nextLine());
					calculo = n1 + n2;
					System.out.println("La suma de " + n1 + " + " + n2 + " es: " + calculo);
					break;
				case 2:
					System.out.println("Introduce el primer numero:");
					n1 = Integer.parseInt(sc.nextLine());
					System.out.println("Introduce el segundo numero:");
					n2 = Integer.parseInt(sc.nextLine());
					calculo = n1 - n2;
					System.out.println("La resta de " + n1 + " + " + n2 + " es: " + calculo);
					break;
				case 3:
					System.out.println("Introduce el primer numero:");
					n1 = Integer.parseInt(sc.nextLine());
					System.out.println("Introduce el segundo numero:");
					n2 = Integer.parseInt(sc.nextLine());
					calculo = n1 * n2;
					System.out.println("La multiplicación de " + n1 + " + " + n2 + " es: " + calculo);
					break;
				case 4:
					System.out.println("Introduce el primer numero:");
					n1 = Integer.parseInt(sc.nextLine());
					System.out.println("Introduce el segundo numero:");
					n2 = Integer.parseInt(sc.nextLine());
					calculo = n1 / n2;
					System.out.println(
							"La división de " + n1 + " + " + n2 + " es: " + calculo + "\nY su resto es: " + n1 % n2);
					break;
				case 5:
					System.out.println("Bye bye...");
					stillLooping = false;
					break;
				}
			} else {
				System.out.println("no has introducido un valor correcto, inutil");
			}
		}
	}

}
