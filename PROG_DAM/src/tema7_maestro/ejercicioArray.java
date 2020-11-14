package tema7_maestro;

import java.util.Arrays;
import java.util.Scanner;

public class ejercicioArray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		final int FIL = 6;
		final int COL = 5;

		boolean salir = false;

		String[] alumnos = { "JOSE MANUEL MEDINA VILLALOBOS", "GABRIEL CARRILLO BLASCO", "NATALIA MONTES MIGUELEZ",
				"MARIA ANTONIA DE PAZ CARRERO", "AITOR GONGORA VALCARCEL", "NICOLAS BAYON BAEZ",
				"ALBA VERDUGO JUSTICIA", "MONTSERRAT FABRA DIEGO", "IRENE CARA HOYOS", "AITOR ROSAS ESCALANTE",
				"ISMAEL LARIOS ROSADO", "MARGARITA DOS SANTOS JUAN", "JAIME CUENCA ANGEL",
				"MARIA CRISTINA BELMONTE ROVIRA", "RAFAEL LLUCH MATAMOROS", "PURIFICACION CAÑADA ROIG",
				"MARIO RAPOSO GALINDO", "DOLORES FONTAN ALFONSO", "AGUSTIN NAVARRO DONOSO", "XAVIER POMARES IRIGOYEN",
				"ANTONIO IBORRA CASTILLO", "LORENZO CANET PINTADO", "HUGO CAPITAN LOBO", "EDUARDO DE PABLO PINTOR",
				"DIEGO GRANERO CHINCHILLA", "ANGEL DALMAU MATIAS", "CARLOS RUEDA PALOMINO",
				"JOSE CARLOS SANCHIS VILCHES", "JOSE MANUEL RICO RUS", "MARIA MAR RECHE ARACIL" };

		String[][] puestos = new String[FIL][COL];

		ordenarArray(alumnos);

		System.out.print("¡Bienvenid@!. ");
		mostrarAlumnos(alumnos);

		while (!salir) {

			System.out.println();
			System.out.println(
					"¿Qué quieres hacer? \n1 --> Ver primer turno \n2 --> Ver segundo turno \n3 --> Mostrar lista de alumnos \n4 --> Intercambiar turno \n5 --> Salir");

			int seleccion = Integer.parseInt(sc.nextLine());

			if (seleccion == 1) {
				rellenarPuestos(puestos, alumnos);
				generarPuestos(puestos, alumnos, true);
				mostrarCompleto(puestos);
			} else if (seleccion == 2) {
				rellenarPuestos(puestos, alumnos);
				generarPuestos(puestos, alumnos, false);
				mostrarCompleto(puestos);
			} else if (seleccion == 3) {
				rellenarPuestos(puestos, alumnos);
				mostrarAlumnos(alumnos);
			} else if (seleccion == 4) {
				rellenarPuestos(puestos, alumnos);
				System.out.println();
				System.out.print("Introduce tu nombre completo: ");
				String alumno1 = sc.nextLine().toUpperCase();
				System.out.print("\nIntroduce el nombre del alumno el cual te deja cambiarte con él: ");
				String alumno2 = sc.nextLine().toUpperCase();
				if (intercambiarPuestos(puestos, alumnos, alumno1, alumno2)) {
					System.out.println("Los puestos han sido cambiados.");
				} else {
					System.out.println("Solo puedes cambiar los puestos con alguien del turno opuesto.");
				}

			} else if (seleccion == 5) {
				System.out.println("Gracias por usar el programita compa Sech!");
				salir = true;
			}

		}
		sc.close();
	}

	public static void generarPuestos(String[][] relleno, String[] contenido, boolean primeraQuincena) {
		
		int count = 0;
		
		if (primeraQuincena) {
			int iAlumno = 0;
			for (int i = 0; i < relleno.length; i++) {
				for (int j = 0; j < relleno[i].length; j++) {
					if (count % 2 == 0) {
						relleno[i][j] = contenido[iAlumno];
						iAlumno++;
						count++;
					} else if (count % 2 != 0) {
						relleno[i][j] = "VACIO";
						count++;
					}

				}
			}
		} else {
			int iAlumno = 15;
			for (int i = 0; i < relleno.length; i++) {
				for (int j = 0; j < relleno[i].length; j++) {
					if (count % 2 == 0) {
						relleno[i][j] = "VACIO";
						count++;
					} else if (count % 2 != 0) {
						relleno[i][j] = contenido[iAlumno];
						iAlumno++;
						count++;
					}
				}
			}
		}
	}

	public static void rellenarPuestos(String[][] relleno, String[] contenido) {
		int iAlumno = 0;
		for (int i = 0; i < relleno.length; i++) {
			for (int j = 0; j < relleno[i].length; j++) {
				relleno[i][j] = contenido[iAlumno];
				iAlumno++;
			}
		}
	}

	public static void ordenarArray(String[] aOrdenar) {
		Arrays.sort(aOrdenar);
	}

	public static void mostrarCompleto(String[][] aMostrar) {
		for (int i = 0; i < aMostrar.length; i++) {
			for (int j = 0; j < aMostrar[i].length; j++) {
				System.out.print("[" + aMostrar[i][j] + "] ");
			}
			System.out.println("");
		}
	}

	public static boolean esPar(int num) {
		if (num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean intercambiarPuestos(String[][] puestos, String[] alumnos, String alumnoSolicitante,
			String alumnoIntercambio) {
		int iAlumno = 0;
		int firstCheck = 1;
		int secondCheck = 1;
		for (int i = 0; i < puestos.length; i++) {
			for (int j = 0; j < puestos[i].length; j++) {

				puestos[i][j] = alumnos[iAlumno];

				if (puestos[i][j].equals(alumnoSolicitante)) {
					//System.out.println("FIRST CHECK OK");
					firstCheck = iAlumno;
					System.out.println(firstCheck);
				} else if (puestos[i][j].equals(alumnoIntercambio)) {

					//System.out.println("SECOND CHECK OK");
					secondCheck = iAlumno;

					System.out.println(secondCheck);
				}

				iAlumno++;
			}
		}

		if (firstCheck < 16 && secondCheck >= 15|| firstCheck >= 15 && secondCheck < 16) {
			 //System.out.println(alumnos[firstCheck]);
			alumnos[firstCheck] = alumnoIntercambio;
			 //System.out.println(alumnos[firstCheck]);
			 //System.out.println(alumnos[secondCheck]);
			alumnos[secondCheck] = alumnoSolicitante;
			 //System.out.println(alumnos[secondCheck]);
			 return true;
		} else {
			return false;
		}

	}

	public static void mostrarAlumnos(String[] alumnos) {
		System.out.println("Esta es la lista de clase: \n");
		for (int i = 0; i < alumnos.length; i++) {
			System.out.println(alumnos[i]);
		}
	}
}