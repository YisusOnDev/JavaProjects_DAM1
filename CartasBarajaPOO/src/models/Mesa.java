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
		for (int i = n; i > 0; i--) {
			
		}
		return null;
		
	}
	
	protected void addCartaABaraja() {
		baraja.InsertaCartaFinal(1);
	}
	
}
