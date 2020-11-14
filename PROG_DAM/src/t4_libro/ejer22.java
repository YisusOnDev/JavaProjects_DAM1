package t4_libro;

import java.util.Scanner;

public class ejer22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Por favor, introduzca un día de la semana (de lunes a viernes): ");
		String dia = sc.nextLine();

		int numeroDia = 0;

		switch (dia) {
		case "lunes":
			numeroDia = 0;
			break;
		case "martes":
			numeroDia = 1;
			break;
		case "miercoles":
			numeroDia = 2;
			break;
		case "jueves":
			numeroDia = 3;
			break;
		case "viernes":
			numeroDia = 4;
			break;
		default:
			System.out.print("El día introducido no es correcto.");
		}

		System.out.println("A continuación introduzca la hora (hora y minutos)");

		System.out.print("Hora: ");
		int horas = Integer.parseInt(sc.nextLine());

		System.out.print("Minutos: ");
		int minutos = Integer.parseInt(sc.nextLine());

		int minsTotales = (4 * 24 * 60) + (15 * 60);
		int minsActuales = (numeroDia * 24 * 60) + (horas * 60) + minutos;
		int finalTotal = minsTotales - minsActuales;

		System.out.print("Faltan " + finalTotal + " minutos para llegar al fin de semana.");

	}

}
