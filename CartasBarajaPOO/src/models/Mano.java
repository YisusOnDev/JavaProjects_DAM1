package models;

import java.util.Scanner;

import utils.ConsoleHelper;

public class Mano extends Baraja {
	
	protected void listarCartas() {
		int idAsignada = 0;
		for (Carta carta : listaCartas) {
			System.out.print(idAsignada++);
			System.out.print(carta + "\n");
		}
	}
	
	protected Carta elegirCarta() {
		Scanner sc = new Scanner(System.in);
		listarCartas();
		System.out.println("Selecciona el número de la carta a elegir: ");
		int indCarta = ConsoleHelper.elegirOpcion(1, listaCartas.size());
		Carta cartaElegida = listaCartas.get(indCarta);
		// Hay que borrar la carta?
		sc.close();
		return cartaElegida;
		
	}
}
