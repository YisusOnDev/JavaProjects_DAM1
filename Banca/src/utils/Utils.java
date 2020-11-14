package utils;

import java.util.ArrayList;
import java.util.Scanner;

import models.CuentaCorriente;
import models.Persona;

public class Utils {
	static Scanner sc = new Scanner(System.in);
	static int nCuentasCreadas;
	static ArrayList<Persona> personas = new ArrayList<Persona>();

	public static void mainMenu() {
		char selection;
		System.out.println(
				"Escoge una opción: \na --> Añadir persona \nb --> Elegir persona \nc --> Borrar persona \nd --> Salir \n\nTu selección: ");
		selection = Character.toUpperCase(sc.next().charAt(0));
		switch (selection) {
		case 'A':
			anyadirPersona();
			return;
		case 'B':
			seleccionarPersona();
			return;
		case 'C':
			borrarPersona();
			return;
		case 'D':
			System.out.println("Gracias por usar Banca ¡Hasta la próxima!");
			return;
		default:
			System.out.println("Por favor escoge una opción correcta.");
			mainMenu();
		}

	}

	public static void anyadirPersona() {
		String nombre;
		String primerApellido;
		String segundoApellido;
		String dni;
		double sueldo;
		nCuentasCreadas += 1;
		CuentaCorriente nuevaCuenta = new CuentaCorriente(nCuentasCreadas, 0, null);
		
		System.out.print("Introduce el nombre de la persona: ");
		nombre = sc.nextLine();
		System.out.println();

		System.out.print("Introduce el primer apellido de la persona: ");
		primerApellido = sc.nextLine();
		System.out.println();

		System.out.print("Introduce el segundo apellido de la persona: ");
		segundoApellido = sc.nextLine();
		System.out.println();

		System.out.print("Introduce el DNI de la persona: ");
		dni = sc.nextLine();
		System.out.println();

		System.out.print("Introduce el sueldo de la persona (2 decimales): ");
		sueldo = Double.parseDouble(sc.nextLine());
		Persona nuevaPersona = new Persona(nombre, (primerApellido + ", " + segundoApellido), dni, sueldo, nuevaCuenta);

		personas.add(nuevaPersona);
		mainMenu();

	}

	public static void seleccionarPersona() {
		if (!personas.isEmpty()) {
			for (Persona a : personas) {
				System.out.println(a);
			}

//			int selection;
//			System.out.println(
//					"Escoge una opción: \n1 --> Cobrar sueldo \n2 --> Sacar pasta \n3 --> Subir sueldo \n4 --> Mostrar detalles \n\nTu selección: ");
//			selection = Integer.parseInt(sc.nextLine());
		} else {
			System.out.println("No hay ninguna persona en nuestra db.");
		}

	}

	public static void borrarPersona() {

	}

}
