package tema2_maestro;

import java.util.Scanner;

public class notasAlumnosBucle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int alumnosInsertados = 0;
		double totalNotas = 0;

		double nota1, nota2, nota3, nota4, nota5, nota6, nota7, nota8, nota9, nota10;
		String nombreAlumno1, nombreAlumno2, nombreAlumno3, nombreAlumno4, nombreAlumno5, nombreAlumno6, nombreAlumno7,
				nombreAlumno8, nombreAlumno9, nombreAlumno10;

		double notaAlta = Double.MIN_VALUE;
		String aA = "a";
		String aB = "b";
		double notaBaja = Double.MAX_VALUE;

		while (alumnosInsertados < 10) {
			System.out.print("Inserta el nombre del alumno: ");
			nombreAlumno1 = sc.nextLine();
			System.out.print("Introduce su nota:");
			nota1 = Double.parseDouble(sc.nextLine());
			if (nota1 <= 10 && nota1 >= 0) {
				alumnosInsertados = alumnosInsertados + 1;
			} else {
				System.out.println("La nota no puede ser menor que 0 ni mayor a 10.");
				return;
			}

			if (nota1 > notaAlta) {
				notaAlta = nota1;
				aA = nombreAlumno1;
			}
			if (nota1 < notaBaja) {
				notaBaja = nota1;
				aB = nombreAlumno1;
			}

			System.out.print("Inserta el nombre del alumno: ");
			nombreAlumno2 = sc.nextLine();
			System.out.print("Introduce su nota:");
			nota2 = Double.parseDouble(sc.nextLine());
			if (nota2 <= 10 && nota2 >= 0) {
				alumnosInsertados = alumnosInsertados + 1;
			} else {
				System.out.println("La nota no puede ser menor que 0 ni mayor a 10.");
				return;
			}

			if (nota2 > notaAlta) {
				notaAlta = nota2;
				aA = nombreAlumno2;
			}
			if (nota2 < notaBaja) {
				notaBaja = nota2;
				aB = nombreAlumno2;
			}

			System.out.print("Inserta el nombre del alumno: ");
			nombreAlumno3 = sc.nextLine();
			System.out.print("Introduce su nota:");
			nota3 = Double.parseDouble(sc.nextLine());
			if (nota3 <= 10 && nota3 >= 0) {
				alumnosInsertados = alumnosInsertados + 1;
			} else {
				System.out.println("La nota no puede ser menor que 0 ni mayor a 10.");
				return;
			}

			if (nota3 > notaAlta) {
				notaAlta = nota3;
				aA = nombreAlumno3;
			}
			if (nota3 < notaBaja) {
				notaBaja = nota3;
				aB = nombreAlumno3;
			}

			System.out.print("Inserta el nombre del alumno: ");
			nombreAlumno4 = sc.nextLine();
			System.out.print("Introduce su nota:");
			nota4 = Double.parseDouble(sc.nextLine());
			if (nota4 <= 10 && nota4 >= 0) {
				alumnosInsertados = alumnosInsertados + 1;
			} else {
				System.out.println("La nota no puede ser menor que 0 ni mayor a 10.");
				return;
			}

			if (nota4 > notaAlta) {
				notaAlta = nota4;
				aA = nombreAlumno4;
			}
			if (nota4 < notaBaja) {
				notaBaja = nota4;
				aB = nombreAlumno4;
			}

			System.out.print("Inserta el nombre del alumno: ");
			nombreAlumno5 = sc.nextLine();
			System.out.print("Introduce su nota:");
			nota5 = Double.parseDouble(sc.nextLine());
			if (nota5 <= 10 && nota5 >= 0) {
				alumnosInsertados = alumnosInsertados + 1;
			} else {
				System.out.println("La nota no puede ser menor que 0 ni mayor a 10.");
				return;
			}

			if (nota5 > notaAlta) {
				notaAlta = nota5;
				aA = nombreAlumno5;
			}
			if (nota5 < notaBaja) {
				notaBaja = nota5;
				aB = nombreAlumno5;
			}

			System.out.print("Inserta el nombre del alumno: ");
			nombreAlumno6 = sc.nextLine();
			System.out.print("Introduce su nota:");
			nota6 = Double.parseDouble(sc.nextLine());
			if (nota6 <= 10 && nota6 >= 0) {
				alumnosInsertados = alumnosInsertados + 1;
			} else {
				System.out.println("La nota no puede ser menor que 0 ni mayor a 10.");
				return;
			}

			if (nota6 > notaAlta) {
				notaAlta = nota6;
				aA = nombreAlumno6;
			}
			if (nota6 < notaBaja) {
				notaBaja = nota6;
				aB = nombreAlumno6;
			}

			System.out.print("Inserta el nombre del alumno: ");
			nombreAlumno7 = sc.nextLine();
			System.out.print("Introduce su nota:");
			nota7 = Double.parseDouble(sc.nextLine());
			if (nota7 <= 10 && nota7 >= 0) {
				alumnosInsertados = alumnosInsertados + 1;
			} else {
				System.out.println("La nota no puede ser menor que 0 ni mayor a 10.");
				return;
			}

			if (nota7 > notaAlta) {
				notaAlta = nota7;
				aA = nombreAlumno7;
			}
			if (nota7 < notaBaja) {
				notaBaja = nota7;
				aB = nombreAlumno7;
			}

			System.out.print("Inserta el nombre del alumno: ");
			nombreAlumno8 = sc.nextLine();
			System.out.print("Introduce su nota:");
			nota8 = Double.parseDouble(sc.nextLine());
			if (nota8 <= 10 && nota8 >= 0) {
				alumnosInsertados = alumnosInsertados + 1;
			} else {
				System.out.println("La nota no puede ser menor que 0 ni mayor a 10.");
				return;
			}

			if (nota8 > notaAlta) {
				notaAlta = nota8;
				aA = nombreAlumno8;
			}
			if (nota8 < notaBaja) {
				notaBaja = nota8;
				aB = nombreAlumno8;
			}

			System.out.print("Inserta el nombre del alumno: ");
			nombreAlumno9 = sc.nextLine();
			System.out.print("Introduce su nota:");
			nota9 = Double.parseDouble(sc.nextLine());
			if (nota9 <= 10 && nota9 >= 0) {
				alumnosInsertados = alumnosInsertados + 1;
			} else {
				System.out.println("La nota no puede ser menor que 0 ni mayor a 10.");
				return;
			}

			if (nota9 > notaAlta) {
				notaAlta = nota9;
				aA = nombreAlumno9;
			}
			if (nota9 < notaBaja) {
				notaBaja = nota9;
				aB = nombreAlumno8;
			}

			System.out.print("Inserta el nombre del alumno: ");
			nombreAlumno10 = sc.nextLine();
			System.out.print("Introduce su nota:");
			nota10 = Double.parseDouble(sc.nextLine());
			if (nota10 <= 10 && nota10 >= 0) {
				alumnosInsertados = alumnosInsertados + 1;
			} else {
				System.out.println("La nota no puede ser menor que 0 ni mayor a 10.");
				return;
			}

			if (nota10 > notaAlta) {
				notaAlta = nota10;
				aA = nombreAlumno10;
			}

			if (nota10 < notaBaja) {
				notaBaja = nota10;
				aB = nombreAlumno10;
			}

			totalNotas = nota1 + nota2 + nota3 + nota4 + nota5 + nota6 + nota7 + nota8 + nota9 + nota10;
			System.out.println("La media de las notas es:" + totalNotas / alumnosInsertados);
			System.out.println("La nota más alta es " + notaAlta + " Y la tiene: " + aA);

			System.out.println("La nota más baja es " + notaBaja + " Y la tiene: " + aB);

			return;
		}

	}

}
