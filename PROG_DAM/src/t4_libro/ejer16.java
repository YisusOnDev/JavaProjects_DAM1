package t4_libro;

import java.util.Scanner;

public class ejer16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String respuesta;
		int puntuacion = 0;

		System.out.println("TEST DE CELOSOS");
		System.out.println("Este test te dirá si eres un celoso de mierda.\n");

		System.out.print(
				"1. Tu pareja parece estar más inquieta de lo normal sin ningún motivo aparente.\nverdadero o falso: ");
		respuesta = sc.nextLine();
		if (respuesta.equals("verdadero")) {
			puntuacion += 3;
		}

		System.out.print("2. Ha aumentado sus gastos de vestuario.\nverdadero o falso: ");
		respuesta = sc.nextLine();
		if (respuesta.equals("verdadero")) {
			puntuacion += 3;
		}

		System.out.print("3. Ha perdido el interés que mostraba anteriormente por ti.\nverdadero o falso: ");
		respuesta = sc.nextLine();
		if (respuesta.equals("verdadero")) {
			puntuacion += 3;
		}

		System.out.print(
				"4. Ahora se afeita y se asea con más frecuencia (si es hombre) o ahora se arregla el pelo y se asea con más frecuencia (si es mujer).\nverdadero o falso: ");
		respuesta = sc.nextLine();
		if (respuesta.equals("verdadero")) {
			puntuacion += 3;
		}

		System.out.print("5. No te deja que mires la agenda de su teléfono móvil.\nverdadero o falso: ");
		respuesta = sc.nextLine();
		if (respuesta.equals("verdadero")) {
			puntuacion += 3;
		}

		System.out.print(
				"6. A veces tiene llamadas que dice no querer contestar cuando estás tú delante.\n(v)erdadero o (f)also: ");
		respuesta = sc.nextLine();
		if (respuesta.equals("verdader")) {
			puntuacion += 3;
		}

		System.out.print(
				"7. Últimamente se preocupa más en cuidar la línea y/o estar bronceado/a.\n(v)erdadero o (f)also: ");
		respuesta = sc.nextLine();
		if (respuesta.equals("verdader")) {
			puntuacion += 3;
		}

		System.out.print(
				"8. Muchos días viene tarde después de trabajar porque dice tener mucho más trabajo.\n(v)erdadero o (f)also: ");
		respuesta = sc.nextLine();
		if (respuesta.equals("verdader")) {
			puntuacion += 3;
		}

		System.out.print("9. Has notado que últimamente se perfuma más.\n(v)erdadero o (f)also: ");
		respuesta = sc.nextLine();
		if (respuesta.equals("verdader")) {
			puntuacion += 3;
		}

		System.out.print(
				"10. Se confunde y te dice que ha estado en sitios donde no ha ido contigo.\n(v)erdadero o (f)also: ");
		respuesta = sc.nextLine();
		if (respuesta.equals("verdader")) {
			puntuacion += 3;
		}

		if (puntuacion <= 10) {
			System.out.print("¡Enhorabuena! tu pareja parece ser totalmente fiel.");
		}

		if ((puntuacion > 11) && (puntuacion <= 22)) {
			System.out.print(
					"Quizás exista el peligro de otra persona en su vida o en su mente, aunque seguramente será algo sin importancia. No bajes la guardia.");
		}

		if (puntuacion >= 22) {
			System.out.print(
					"Tu pareja tiene todos los ingredientes para estar viviendo un romance con otra persona. Te aconsejamos que indagues un poco más y averigües qué es lo que está pasando por su cabeza.");
		}
	}

}
