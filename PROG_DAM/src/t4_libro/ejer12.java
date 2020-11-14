package t4_libro;

import java.util.Scanner;

public class ejer12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int puntos = 0;
		String respuesta;

		System.out.println("BIENVENIDO AL PoG Cuestionario - musha suerte");

		System.out.println("¿Cúal de estos no es un lenguaje de programación?");
		System.out.println("a) HTML\nb) JAVASCRIPT\nc) PHP");
		respuesta = sc.nextLine();
		if (respuesta.equals("a")) {
			puntos++;
		}

		System.out.println("¿Cuales de estos SI es un lenguaje de bases de datos");
		System.out.println("a) MongoDB\nb) pDB\nc) SQL");
		respuesta = sc.nextLine();
		if (respuesta.equals("c")) {
			puntos++;
		}

		System.out.println("¿Es html un lenguaje de marcas o un lenguaje de programación?");
		System.out.println("a) Marcas\nb) Programación\nc) De que me hablas");
		respuesta = sc.nextLine();
		if (respuesta.equals("a")) {
			puntos++;
		}

		System.out.println("¿Cuales de los siguientes no es un componente del ordenador");
		System.out.println("a) CPU\nb) Mouse\nc) SSD");
		respuesta = sc.nextLine();
		if (respuesta.equals("b")) {
			puntos++;
		}

		System.out.println("¿Cuál de las siguientes memorias NO es volátil?");
		System.out.println("a) RAM\nb) BSOD\nc) HDD");
		respuesta = sc.nextLine();
		if (respuesta.equals("c")) {
			puntos++;
		}

		System.out.println("Tu puntuación ha sido de " + puntos + " puntos.");
	}

}
