package models;

import interfaces.IPlayable;

abstract class InstrumentoMusical implements IPlayable {
	double precio;
	String marca;
	String modelo;

	protected InstrumentoMusical(double precio, String marca, String modelo) {
		super();
		this.precio = precio;
		this.marca = marca;
		this.modelo = modelo;
	}

	/**
	 * Método para conseguir el precio de un instrumento
	 * 
	 * @return el precio del instrumento
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Método para poner el precio de un instrumento
	 * 
	 * @param precio el precio deseado
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Método para conseguir la marca de un instrumento
	 * 
	 * @return la marca del instrumento
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Método para poner la marca a un instrumento
	 * 
	 * @param marca la marca deseada
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Método para conseguir el modelo de un instrumento
	 * 
	 * @return el modelo del instrumento
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Método para poner el modelo de un instrumento
	 * 
	 * @param modelo el modelo del instrumento
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
