package utils;

import java.util.ArrayList;
import java.util.Scanner;

import models.CuentaCorriente;
import models.Persona;

public class Utils {
	static int nCuentasCreadas;
	static ArrayList<Persona> personas = new ArrayList<Persona>();
	static boolean personasDeRelleno = false;

	public static void mainMenu() {
		Scanner sc = new Scanner(System.in);
		// Cuentas y personas de ejemplo (relleno)
		if (!personasDeRelleno)
			personasDeRelleno();
		personasDeRelleno = true;

		char mainSelection;
		System.out.println(
				"Escoge una opción: \na --> Añadir persona \nb --> Elegir persona \nc --> Borrar persona \nd --> Salir \n\nTu selección: ");
		mainSelection = Character.toUpperCase(sc.next().charAt(0));
		switch (mainSelection) {
		case 'A':
			anyadirPersona();
			sc.close();
			return;
		case 'B':
			seleccionarPersona();
			sc.close();
			return;
		case 'C':
			borrarPersona();
			sc.close();
			return;
		case 'D':
			System.out.println("Gracias por usar Banca ¡Hasta la próxima!");
			sc.close();
			return;
		default:
			System.out.println("Por favor escoge una opción correcta.");
			mainMenu();
		}
		sc.close();
	}

	public static void anyadirPersona() {
		Scanner sc = new Scanner(System.in);
		nCuentasCreadas += 1;
		CuentaCorriente nuevaCuenta = new CuentaCorriente(nCuentasCreadas, 0, null);

		String nombre;
		String primerApellido;
		String segundoApellido;
		String dni;
		double sueldo;

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
		sc.close();

	}

	public static void seleccionarPersona() {
		Scanner sc = new Scanner(System.in);
		int selection;
		if (!personas.isEmpty()) {
			System.out.println("Listado de clientes:");
			for (Persona a : personas) {
				System.out.println(
						(personas.indexOf(a) + 1) + " " + a.getDni() + " " + a.getApellidos() + ", " + a.getNombre());
			}

			System.out.print("\nPor favor pon el número de cliente para seleccionar uno: ");
			selection = Integer.parseInt(sc.nextLine());
			selection -= 1;
			if (selection >= 0 && selection <= (personas.size() - 1)) {
				Persona pSeleccionada = personas.get(selection);
				System.out.println(
						"Has seleccionado a: " + pSeleccionada.getApellidos() + ", " + pSeleccionada.getNombre());
				System.out.println("");
				int selection2;
				System.out.println(
						"Escoge una opción: \n1 --> Cobrar sueldo \n2 --> Sacar pasta \n3 --> Subir sueldo \n4 --> Mostrar detalles \n\nTu selección: ");
				selection2 = Integer.parseInt(sc.nextLine());
				if (selection2 > 0 && selection2 <= 4) {
					switch (selection2) {
					case 1:
						pSeleccionada.cobrarSueldo();
						System.out.println(pSeleccionada.getNombre() + " ha cobrado su sueldo.");
						mainMenu();
						sc.close();
						return;
					case 2:
						double cantidad;
						System.out.print("Escribe la cantidad a sacar: ");
						cantidad = Double.parseDouble(sc.nextLine());
						if (cantidad <= pSeleccionada.getCuenta().getSaldo()) {
							pSeleccionada.sacarPasta(cantidad);
							System.out.println("Has sacado: " + cantidad + " dineros.");
							mainMenu();
						} else {
							System.out.println("No puedes sacar más dinero del que tienes.");
							seleccionarPersona();
						}

						sc.close();
						return;
					case 3:
						double nuevoSueldo;
						System.out.print("Escribe la cantidad a ESTABLECER (no suma establece una nueva cantidad): ");
						nuevoSueldo = Double.parseDouble(sc.nextLine());
						if (nuevoSueldo > 0) {
							pSeleccionada.subirSueldo(nuevoSueldo);
							System.out
									.println("El nuevo sueldo de " + pSeleccionada.getNombre() + " es: " + nuevoSueldo);
							mainMenu();
						} else {
							System.out.println("El nuevo sueldo no puede ser negativo.");
						}

						sc.close();
						return;
					case 4:
						System.out.println("Los detalles de " + pSeleccionada.getApellidos() + ", "
								+ pSeleccionada.getNombre() + " son: ");
						System.out.println(pSeleccionada);
						mainMenu();
						sc.close();
						return;
					default:
						System.out.println("Por favor escoge una opción correcta.");
						seleccionarPersona();
					}
				}
			} else {
				System.out.println("No has selecciona un número de cliente correcto.");
				mainMenu();
			}
		} else {
			System.out.println("No hay ninguna persona en nuestra db.");
		}
		sc.close();
	}

	public static void borrarPersona() {
		Scanner sc = new Scanner(System.in);
		int selection;
		if (!personas.isEmpty()) {
			System.out.println("Listado de clientes:");
			for (Persona a : personas) {
				System.out.println(
						(personas.indexOf(a) + 1) + " " + a.getDni() + " " + a.getApellidos() + ", " + a.getNombre());
			}

			System.out.print("\nPor favor pon el número de cliente para borrarlo: ");
			selection = Integer.parseInt(sc.nextLine());
			selection -= 1;

			if (selection >= 0 && selection <= (personas.size() - 1)) {
				Persona pSeleccionada = personas.get(selection);
				System.out.println();
				System.out.println(
						"Has seleccionado a: " + pSeleccionada.getApellidos() + ", " + pSeleccionada.getNombre());
				System.out.println("\n ¿Estás seguro que quieres borrarla? \n1 --> Sí \n2 -- No");
				int selection2;
				selection2 = Integer.parseInt(sc.nextLine());
				if (selection2 == 1 || selection2 == 2) {
					personas.remove(pSeleccionada);
					System.out.println("La persona ha sido removida con éxito.");
					mainMenu();
				} else {
					mainMenu();
				}

			}
		} else {
			System.out.println("No hay ninguna persona en nuestra db.");
			mainMenu();
		}
		sc.close();
	}

	public static void personasDeRelleno() {
		CuentaCorriente cuentaPaco = new CuentaCorriente(00001, 5014.90, null);
		CuentaCorriente cuentaPepe = new CuentaCorriente(00002, 9523.55, null);
		CuentaCorriente cuentaRatata = new CuentaCorriente(00003, 3541.10, null);
		Persona Paco = new Persona("Paco", "Puas, Rodriguez", "55695412L", 1065.50, cuentaPaco);
		Persona Pepe = new Persona("Pepe", "Ramirez, Fernandez", "44569825D", 965.75, cuentaPepe);
		Persona Ratata = new Persona("Rata", "Dominguez Pavon", "55632568M", 1500.25, cuentaRatata);
		personas.add(Paco);
		personas.add(Pepe);
		personas.add(Ratata);
	}

}