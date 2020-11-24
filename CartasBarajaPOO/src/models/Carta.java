package models;

public class Carta {

	private int numeroCarta;
	private int paloCarta;
	private int idCarta;

	public Carta(int numeroCarta, int paloCarta) {
		super();
		this.numeroCarta = numeroCarta;
		this.paloCarta = paloCarta;
		this.idCarta = (paloCarta * 10 + numeroCarta);
	}

	public Carta(int id) {
		this.idCarta = id;
		if (id % 10 == 0) {
			paloCarta = id / 10 - 1;
			numeroCarta = 10;
		} else {
			paloCarta = id / 10;
			numeroCarta = id % 10;
		}
	}

	public int getNumeroCarta() {
		return numeroCarta;
	}

	public int getPaloCarta() {
		return paloCarta;
	}

	public int getIdCarta() {
		return idCarta;
	}

	public String getNombreNumero() {
		switch (numeroCarta) {
		case 1:
			return "AS";
		case 2:
			return "Dos";
		case 3:
			return "Tres";
		case 4:
			return "Cuatro";
		case 5:
			return "Cinco";
		case 6:
			return "Seis";
		case 7:
			return "Siete";
		case 8:
			return "Sota";
		case 9:
			return "Caballo";
		case 10:
			return "Rey";
		default:
			return null;
		}
	}

	public String getNombrePalo() {
		switch (paloCarta) {
		case 0:
			return "Oros";
		case 1:
			return "Copas";
		case 2:
			return "Espadas";
		case 3:
			return "Bastos";
		default:
			return null;
		}
	}

	public String getNombreCarta() {
		return getNombreNumero() + " de " + getNombrePalo();
	}

	public int getValorTute() {
		switch (numeroCarta) {
		case 1:
			return 11;
		case 3:
			return 10;
		case 8:
			return 2;
		case 9:
			return 3;
		case 10:
			return 4;
		}

		return 0;
	}

	public int getValorMus() {
		switch (numeroCarta) {
		case 1:
			return 1;
		case 2:
			return 1;
		case 3:
			return 2;
		case 8:
			return 10;
		case 9:
			return 10;
		case 10:
			return 10;
		default:
			return numeroCarta;
		}
	}

	public double getValor7ymedia() {
		switch (numeroCarta) {
		case 8:
			return 0.5;
		case 9:
			return 0.5;
		case 10:
			return 0.5;
		default:
			return numeroCarta;
		}
	}

	@Override
	public String toString() {
		return "Carta [numeroCarta=" + numeroCarta + ", paloCarta=" + paloCarta + ", idCarta=" + idCarta + "]";
	}

}