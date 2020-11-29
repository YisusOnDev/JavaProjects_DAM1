package models;

public class Carta {

	private int numeroCarta;
	private int paloCarta;
	private int idCarta;

	/**
	 * Constructor de carta indicando el numero de carta y el palo de la carta.
	 * 
	 * @param numeroCarta Numero de la carta
	 * @param paloCarta   Palo de la carta
	 */
	public Carta(int numeroCarta, int paloCarta) {
		super();
		this.numeroCarta = numeroCarta;
		this.paloCarta = paloCarta;
		this.idCarta = (paloCarta * 10 + numeroCarta);
	}

	/**
	 * Constructor de carta indicando el id correspondiente a la carta
	 * 
	 * @param id Id correspondiente de la carta
	 */
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

	/**
	 * Consigue el número de una carta
	 * 
	 * @return El numero de la carta
	 */
	public int getNumeroCarta() {
		return numeroCarta;
	}

	/**
	 * Consigue el palo de una carta
	 * 
	 * @return El palo de la carta
	 */
	public int getPaloCarta() {
		return paloCarta;
	}

	/**
	 * COnsigue el id de una carta
	 * 
	 * @return El id de la carta
	 */
	public int getIdCarta() {
		return idCarta;
	}

	/**
	 * Conseguir el nombre correspondiente al numero de la carta.
	 * 
	 * @return El nombre de la carta en si.
	 */
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

	/**
	 * Devuelve el nombre del palo al que pertenece una carta
	 * 
	 * @return El palo al que pertenece la carta
	 */
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

	/**
	 * Devuelve el nombre completo de la carta
	 * 
	 * @return Nombre de la carta + Palo al que pertenece
	 */
	public String getNombreCarta() {
		return getNombreNumero() + " de " + getNombrePalo();
	}

	/**
	 * Con el numero de carta, consigue el valor de la misma en el Tute
	 * 
	 * @return Valor de la carta en el juego del tute
	 */
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

	/**
	 * Con el numero de carta, consigue el valor de la misma en el Mus
	 * 
	 * @return Valor de la carta en el juego del mus
	 */
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

	/**
	 * Con el numero de carta, consigue el valor de la misma en el "7 y media"
	 * 
	 * @return Valor de la carta en el juego de la "7 y media"
	 */
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