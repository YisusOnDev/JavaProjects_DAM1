package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Baraja {

	protected ArrayList<Carta> listaCartas;
	private final int MAXCartas = 40;
	private final int MINCartas = 1;

	/**
	 * Crea una baraja vacia
	 */
	public Baraja() {
		listaCartas = new ArrayList<Carta>();
	}

	/**
	 * Crea una baraja de "X" tipo
	 * 
	 * @param tipoBraja el tipo de baraja que queremos (1. 40 cartas o 2. 80 cartas)
	 */
	public Baraja(int tipoBraja) {
		listaCartas = new ArrayList<Carta>();
		switch (tipoBraja) {
		case 1:
			for (int i = MINCartas; i < MAXCartas; i++) {
				Carta carta = new Carta(i);
				listaCartas.add(carta);
			}
			return;
		case 2:
			for (int i = MINCartas; i < MAXCartas; i++) {
				Carta carta = new Carta(i);
				listaCartas.add(carta);
				listaCartas.add(carta); // Sucio...
			}
			return;

		}
	}

	/**
	 * Crea una baraja de "X" tipo y además puedes barajar la misma al momento
	 * 
	 * @param tipoBraja 1 o 2 (1. 40 cartas 2. 80 cartas)
	 * @param barajar   true baraja, false no baraja
	 */
	public Baraja(int tipoBraja, boolean barajar) {
		listaCartas = new ArrayList<Carta>();

		switch (tipoBraja) {
		case 1:
			for (int i = 1; i < 40; i++) {
				Carta carta = new Carta(i);
				listaCartas.add(carta);
			}
			return;
		case 2:
			for (int i = 1; i < 40; i++) {
				Carta carta = new Carta(i);
				listaCartas.add(carta);
				listaCartas.add(carta); // Sucio...
			}
			return;

		}

		if (barajar)
			barajar();
	}

	/**
	 * Baraja la baraja de cartas
	 */
	public void barajar() {
		Collections.shuffle(listaCartas, new Random());
	}

	/**
	 * Corta la baraja en X posicion.
	 * 
	 * @param posicion la posicion donde quieres cortar la baraja
	 */
	public void cortar(int posicion) {
		if (posicion > listaCartas.size() || posicion <= 0) {
			System.out.println(
					"No se puede cortar la baraja debido a que la posición no existe o es mayor al número de cartas.");
		} else {
			for (int i = 0; i < posicion; i++) {
				listaCartas.add(listaCartas.get(0));
				listaCartas.remove(0);
			}
		}
	}

	/**
	 * Roba una carta de la baraja
	 * 
	 * @return la carta robada
	 */
	public Carta robar() {
		if (isVacia()) {
			return null;
		} else {
			Carta cartaRobada = listaCartas.get(0);
			listaCartas.remove(0);
			return cartaRobada;
		}
	}

	/**
	 * Inserta una carta al final de la baraja
	 * 
	 * @param idCarta la id de la carta a introducir
	 */
	public void InsertaCartaFinal(int idCarta) {
		listaCartas.add(new Carta(idCarta));
	}

	/**
	 * Inserta una carta al principio de la baraja
	 * 
	 * @param idCarta la id de la carta a introducir
	 */
	public void InsertaCartaPrincipio(int idCarta) {
		listaCartas.add(0, new Carta(idCarta));
	}

	/**
	 * Inserta una carta al final de la baraja
	 * 
	 * @param c la CARTA a introducir
	 */
	public void InsertaCartaFinal(Carta c) {
		listaCartas.add(c);
	}

	/**
	 * Consigue la cantidad de cartas que hay en la baraja
	 * 
	 * @return la cantidad de cartas que hay en la baraja
	 */
	public int getNumeroCartas() {
		return listaCartas.size();
	}

	/**
	 * Chequea si la baraja esta vacia o no
	 * 
	 * @return true si esta vacia, false si no esta vacia
	 */
	public boolean isVacia() {
		return listaCartas.isEmpty();
	}

}
