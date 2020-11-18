package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import models.Animal;
import models.ClinicaVeterinaria;
import models.Gato;
import models.Gato.RazaGato;
import models.Pajaro;
import models.Pajaro.EspeciePajaro;
import models.Perro;
import models.Perro.RazaPerro;
import models.Reptil;
import models.Reptil.EspecieReptil;
import utils.ConsoleHelper;

public class Controller {
	static ClinicaVeterinaria Clinica = new ClinicaVeterinaria();

	public void run() {
		System.out.println("1");

		System.out.println("2");
		mainMenu();
	}

	private void mainMenu() {
		do {
			ConsoleHelper.imprimirMenu();
			int opc = ConsoleHelper.elegirOpcionMenu(1, 3);
			switch (opc) {
			case 1:
				crearAnimal(ConsoleHelper.definirAnimalMenu());
				break;
			case 2:
				String nombreAnimal = ConsoleHelper.leerString("Introduce el nombre del animal a modificar el comentario: ");
				if (Clinica.BuscarAnimal(nombreAnimal) != null) {
					String nuevaDescripcionAnimal = ConsoleHelper.leerString("Introduce la nueva descripción del animal: ");
					Clinica.ModificarComentarioAnimal(nombreAnimal, nuevaDescripcionAnimal);
				} else {
					System.out.println("No se ha encontrado ese animal en nuestra base de datos.");
					mainMenu();
				}
				break;
			case 3:
				System.out.println(Clinica);
				break;

			}
		} while (ConsoleHelper.leerSiNo("¿Desea hacer algo más? Sí (1) No (0)"));
	}

	public Animal crearAnimal(String tipo) {
		String nombre;
		LocalDate fechaNac;
		double peso;
		String chip;
		Animal animalCrear = null;

		nombre = ConsoleHelper.leerString("Introduce el nombre del animal: ");
		fechaNac = transformarAFechaValida();
		peso = ConsoleHelper.leerDouble("Introduce el peso del animal: ");
		chip = ConsoleHelper.leerString("Introduce el código del microchip del animal: ");

		switch (tipo.toUpperCase()) {
		case "PERRO":
			RazaPerro razaPerro = Perro.getRazaValue(ConsoleHelper.leerString(
					"Introduce la raza del perro (PastorAleman, Husky, FoxTerrier, Dalmata o SanBernardo): "));

			boolean razaPerroValida = false;
			while (!razaPerroValida) {
				while (razaPerro == null) {
					System.out.println("ERROR: Por favor, elige una opción correcta.");
					razaPerro = Perro.getRazaValue(ConsoleHelper.leerString(
							"Introduce la raza del perro (PastorAleman, Husky, FoxTerrier, Dalmata o SanBernardo): "));
				}
				razaPerroValida = true;
			}

			animalCrear = new Perro(nombre, razaPerro, fechaNac, peso, chip);
			break;
		case "GATO":
			RazaGato razaGato = Gato.getRazaValue(ConsoleHelper
					.leerString("Introduce la raza del gato (Comun, Siames, Persa, Angora o ScottishFold): "));

			boolean razaGatoValida = false;
			while (!razaGatoValida) {
				while (razaGato == null) {
					System.out.println("ERROR: Por favor, elige una opción correcta.");
					razaGato = Gato.getRazaValue(ConsoleHelper
							.leerString("Introduce la raza del gato (Comun, Siames, Persa, Angora o ScottishFold): "));
				}
				razaGatoValida = true;
			}

			animalCrear = new Gato(nombre, razaGato, fechaNac, peso, chip);
			break;
		case "PAJARO":
			EspeciePajaro razaPajaro = Pajaro.getRazaValue(
					ConsoleHelper.leerString("Introduce la especie del pajaro (Canario, Periquito o Agapornis): "));

			boolean razaPajaroValida = false;
			while (!razaPajaroValida) {
				while (razaPajaro == null) {
					System.out.println("ERROR: Por favor, elige una opción correcta.");
					razaPajaro = Pajaro.getRazaValue(ConsoleHelper
							.leerString("Introduce la especie del pajaro (Canario, Periquito o Agapornis): "));
				}
				razaPajaroValida = true;
			}

			boolean canta = ConsoleHelper.leerSiNo("¿El pajaro canta? - 0. No - 1. Si: ");

			animalCrear = new Pajaro(nombre, razaPajaro, fechaNac, peso, chip, canta);
			break;
		case "REPTIL":
			EspecieReptil razaReptil = Reptil.getRazaValue(
					ConsoleHelper.leerString("Introduce la especie del reptil (Tortuga, Iguana o DragonDeComodo): "));

			boolean razaReptilValida = false;
			while (!razaReptilValida) {
				while (razaReptil == null) {
					System.out.println("ERROR: Por favor, elige una opción correcta.");
					razaReptil = Reptil.getRazaValue(ConsoleHelper
							.leerString("Introduce la raza especie del reptil (Tortuga, Iguana o DragonDeComodo): "));
				}
				razaReptilValida = true;
			}

			boolean esVenenoso = ConsoleHelper.leerSiNo("¿El reptil es venenoso? - 0. No - 1. Si: ");

			animalCrear = new Reptil(nombre, razaReptil, fechaNac, peso, chip, esVenenoso);
			break;

		}

		Clinica.InsertarAnimal(animalCrear);

		boolean anyadirComentario = ConsoleHelper.leerSiNo("¿Quieres añadir comentarios al animal? - 0. No - 1. Si: ");

		if (anyadirComentario)
			animalCrear.setComentarios(
					ConsoleHelper.leerString("Introduce acontinuación los comentarios sobre el animal: "));

		return null;

	}

	private static LocalDate transformarAFechaValida() {
		String fecha;
		boolean validDate = false;
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("D/m/yyyy");
		LocalDate nuevaFecha = null;
		while (!validDate) {
			try {
				fecha = ConsoleHelper
						.leerString("Introduce la fecha de nacimiento del animal (Formato: Día/Mes/Año): ");
				nuevaFecha = LocalDate.parse(fecha, formatoFecha);
				validDate = true;
			} catch (DateTimeParseException e) {
				System.out.println("ERROR: Formato incorrecto");
			}
		}
		return nuevaFecha;
	}
}
