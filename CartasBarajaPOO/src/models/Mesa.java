package models;

import java.util.List;

public class Mesa {
	protected Baraja baraja;

	protected Mesa(Baraja baraja) {
		super();
		this.baraja = baraja;
	}
	
	protected Carta robarCartaDeBaraja() {
		return this.baraja.robar();
	}
	
	protected List<Carta> robarVariasCartas(int n) {
		//TODO
		return null;
		
	}
	
}
