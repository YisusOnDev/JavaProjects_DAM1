package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Baraja {

	private ArrayList<Carta> listaCartas;
	private final int MAXCartas = 40;
	private final int MINCartas = 1;

	public Baraja() {
		listaCartas = new ArrayList<Carta>();
	}

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

	public void InsertaCartaFinal(int idCarta) {
		listaCartas.add(new Carta(idCarta));
	}

	public void InsertaCartaPrincipio(int idCarta) {
		listaCartas.add(0, new Carta(idCarta));
	}

	public void InsertaCartaFinal(Carta c) {
		listaCartas.add(c);
	}

	public int getNumeroCartas() {
		return listaCartas.size();
	}

	public boolean isVacia() {
		return listaCartas.isEmpty();
	}
	
}
