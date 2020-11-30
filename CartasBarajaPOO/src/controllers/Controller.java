package controllers;

import models.Baraja;
import models.Mano;
import models.Carta;
import utils.ConsoleHelper;

public class Controller {
	/**
	 * Carga el juego del 7 y medio versión 1 jugador.
	 * 
	 */
	public void runSimple() {
		jugar7ymedioSimple();
	}

	/**
	 * Ejecución del juego 7 y medio de 1 jugador. Va pidiendo cartas y da la opción
	 * a plantarse (en caso de que no haya perdido ni ganado) y siempre volver a
	 * jugar o salir.
	 */
	public void jugar7ymedioSimple() {
		boolean quiereContinuar = true;
		Baraja baraja = new Baraja(1, true);
		Carta currentCard;
		double contador = 0;

		System.out.println("Bienvenido al juego del 7 y medio, crack");
		while (quiereContinuar == true) {
			baraja.barajar();
			currentCard = baraja.robar();
			System.out.println("La carta que te ha tocado es el " + currentCard.getNombreNumero() + " de "
					+ currentCard.getNombrePalo());
			contador = currentCard.getValor7ymedia() + contador;
			if (contador == 7.50) {
				System.out.println("FELICIDADES, HAS GANADO.");
				quiereContinuar = false;
				boolean opcion = ConsoleHelper.leerSiNo("0.- Nueva partida \n1.- Salir");
				if (opcion) {
					quiereContinuar = false;
				} else {
					quiereContinuar = false;
					new Controller().runSimple();
				}
			} else if (contador < 7.50) {
				System.out.println("Tu total actual es: " + contador + "\n1.- Pedir otra. \n2.- Plantarse.");
				int opcion = ConsoleHelper.elegirOpcion(1, 2);
				switch (opcion) {
				case 1:
					quiereContinuar = true;
					break;
				case 2:
					quiereContinuar = false;
					boolean opcion2 = ConsoleHelper.leerSiNo("0.- Nueva partida \n1.- Salir");
					if (opcion2) {
						quiereContinuar = false;
					} else {
						quiereContinuar = false;
						new Controller().runSimple();
					}
					break;
				}
			} else if (contador > 7.50) {
				System.out.println("OHHH; TE HAS PASADO CAMPEÓN.");
				quiereContinuar = false;

				boolean opcion = ConsoleHelper.leerSiNo("0.- Nueva partida \n1.- Salir");
				if (opcion) {
					quiereContinuar = false;
				} else {
					quiereContinuar = false;
					new Controller().runSimple();
				}
			}

		}
	}

}
