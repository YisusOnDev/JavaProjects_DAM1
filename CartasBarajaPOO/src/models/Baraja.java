package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Baraja {

	private ArrayList<Carta> listaCartas = new ArrayList<Carta>();

	public Baraja() {
		listaCartas.clear();
	}

	public Baraja(int tipoBraja) {
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
	}

	public Baraja(int tipoBraja, boolean barajar) {
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

		if (barajar) {
			Collections.shuffle(listaCartas, new Random());
		}
	}

	public void barajar() {
		Collections.shuffle(listaCartas, new Random());
	}

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

	public Carta robar() {
		if (isVacia()) {
			return null;
		} else {
			Carta cartaRobada = listaCartas.get(0);
			listaCartas.remove(0);
			return cartaRobada;
		}

	}

	public boolean isVacia() {
		return listaCartas.isEmpty();
	}

}
