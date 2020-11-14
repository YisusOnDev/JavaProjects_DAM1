package tema2_maestro;

import java.util.Scanner;

public class notas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println(
					"Calculadora de notas de Alumnos");
			System.out.println("------------------------------");
			System.out.println("Introduce el nombre del profesor");
			String nombreProfesor = sc.nextLine();
			System.out.println("------------------------------");
			System.out.println("Escribe la asignatura de la cual se va a calcular la nota");
			String asignatura = sc.nextLine();
			System.out.println("------------------------------");
			System.out.println("Introduce el nombre del alumno");
			String nombreAlumno = sc.nextLine();
			System.out.println("------------------------------");
			System.out.println("Introduce el apellido del alumno");
			String apellidoAlumno = sc.nextLine();
			System.out.println("------------------------------");
			System.out.println("Introduce la nota númerica que tiene el alumno en la asignatura");
			Double nota = sc.nextDouble();
			System.out.println("------------------------------");

			String notaTxt = "ERROR";
			
			if (nota >= 0 && nota <= 2.99) {
				notaTxt = "Muy deficiente";
			} else if (nota >= 3 && nota <= 4.99) {
				notaTxt = "Insuficiente";
			}else if (nota >= 5 && nota <= 5.99 ) {
				notaTxt = "Suficiente";
			}else if (nota >= 6 && nota <= 7.49) {
				notaTxt = "Bien";
			}else if (nota >= 7.5 && nota <= 8.99) {
				notaTxt = "Notable";
			}else if (nota >= 9 && nota <= 9.99) {
				notaTxt = "Sobresaliente";
			}else if (nota == 10) {
				notaTxt = "Matrícula de honor";
			}else {
				System.out.println("ERROR: Vuelve a intentarlo.");
			}
			
			System.out.println("El nombre del profesor es: " + nombreProfesor + "\nLa asignatura que imparte es: " + asignatura + "\nEl alumno es: "
					+ nombreAlumno + " " + apellidoAlumno + "\nLa nota cuantitativa es: " + nota + "\nLa nota cualitativa es: " + notaTxt); 
		}
	}
}
