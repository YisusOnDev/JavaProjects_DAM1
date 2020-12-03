package models;

import java.util.ArrayList;

public abstract class AbstractGame {
	protected boolean finished;

	protected enum modoJuego {
		Solitario, UnovsCPU, PvP, Multiplayer
	}

	protected ArrayList<AbstractPlayer> jugadores;
	protected Mesa mesa;
	int ronda;

	protected AbstractGame(boolean finished, ArrayList<AbstractPlayer> jugadores, Mesa mesa) {
		super();
		this.finished = finished;
		this.jugadores = jugadores;
		this.mesa = mesa;
	}

	protected abstract void bienvenida();

	protected abstract void menuPrincipal();

	protected abstract AbstractPlayer nextTurno();

	protected abstract void start();

	protected void barajar() {
		// Barajar TODO
	}

	protected void finish() {
		// recoge todas las cartas en la mano de los jugadores.
		// TODO
	}

}