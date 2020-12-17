package models;

public class Guitarra extends InstrumentoMusical {

	/**
	 * Constructor para instrumento de tipo "Guitarra" se requerirá de su precio,
	 * marca y modelo.
	 * 
	 * @param precio el precio del instrumento
	 * @param marca  la marca del instrumento
	 * @param modelo el modelo del instrumento
	 */
	protected Guitarra(double precio, String marca, String modelo) {
		super(precio, marca, modelo);
	}

	@Override
	public String tocarInstrumento() {
		return "Triiing";
	}

	@Override
	public String toString() {
		return "Guitarra [Marca: " + marca + ", Modelo: " + modelo + ", Precio: " + precio + "€ ]";
	}

}
