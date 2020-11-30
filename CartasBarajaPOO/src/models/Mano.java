package models;

public class Mano extends Baraja {
	
	public void listarCartas() {
		int idAsignada = 0;
		for (Carta carta : listaCartas) {
			System.out.print(idAsignada++);
			System.out.print(carta + "\n");
		}
	}
}
