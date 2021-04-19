package controllers;

public class Controller {

	public void run() {
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
					String nuevaDescripcionAnimal = ConsoleHelper.leerString("Introduce la nueva descripci�n del animal: ");
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
		} while (ConsoleHelper.leerSiNo("�Desea hacer algo m�s? S� (1) No (0)"));
	}
}
