package models;

import java.util.ArrayList;

public abstract class AbstractPlayer {
	protected String nombre;
	protected int puntos;
	protected Mano mano;
	protected Mesa mesa;
	
	protected AbstractPlayer(String nombre, int puntos, Mano mano, Mesa mesa) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
		this.mano = mano;
		this.mesa = mesa;
	}
	
	protected abstract void jugarTurno();
	
	

}
