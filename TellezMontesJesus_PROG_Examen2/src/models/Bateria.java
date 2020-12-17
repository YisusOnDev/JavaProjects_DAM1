package models;

public class Bateria extends InstrumentoMusical {

	/**
	 * Constructor para instrumento de tipo "Bateria" se requerirá de su precio,
	 * marca y modelo.
	 * 
	 * @param precio el precio del instrumento
	 * @param marca  la marca del instrumento
	 * @param modelo el modelo del instrumento
	 */
	protected Bateria(double precio, String marca, String modelo) {
		super(precio, marca, modelo);
	}

	@Override
	public String tocarInstrumento() {
		return "Tumtumpá";

	}

	@Override
	public String toString() {
		return "Bateria [Marca: " + marca + ", Modelo: " + modelo + ", Precio: " + precio + "€ ]";
	}

}
