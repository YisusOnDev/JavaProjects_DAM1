package models;

public class Mano extends Baraja {
	
	protected void listarCartas() {
		int idAsignada = 0;
		for (Carta carta : listaCartas) {
			System.out.print(idAsignada++);
			System.out.print(carta + "\n");
		}
	}
	
	protected Carta elegirCarta() {
		// TODO
		return null;
		
	}
}
