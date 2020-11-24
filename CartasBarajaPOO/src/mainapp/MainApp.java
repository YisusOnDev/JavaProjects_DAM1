package mainapp;

import java.util.Scanner;

import controllers.Controller;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué quieres hacer? \n1.- Juego Individual (7 y medio) \n2.- \"Juego Completo\"");
		int seleccion = 0;
		boolean isValidNumber = false;
		while (!isValidNumber) {
			try {
				seleccion = Integer.parseInt(sc.nextLine());
				while (seleccion < 1 || seleccion > 2) {
					System.out.println("ERROR: Por favor, elige una opción entre " + 1 + " y " + 2);
					seleccion = Integer.parseInt(sc.nextLine());
				}
				isValidNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce números del " + 1 + " al " + 2);
			}
		}

		if (seleccion == 1) {
			new Controller().runSimple();
		} else {
			// TODO
		}

	}

}
