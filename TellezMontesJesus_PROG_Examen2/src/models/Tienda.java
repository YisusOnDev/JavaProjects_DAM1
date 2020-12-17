package models;

import java.util.ArrayList;

import utils.ConsoleHelper;

public class Tienda {
	protected ArrayList<InstrumentoMusical> instrumentosStock;
	double caja;

	/**
	 * Constructor vácio de la tienda. Inicializa y reserva la memoria del Array de
	 * todos los instrumentos
	 */
	public Tienda() {
		this.caja = 0;
		instrumentosStock = new ArrayList<InstrumentoMusical>();
	}

	/**
	 * Método para Conseguir el dinero que hay en la caja de la tienda
	 * 
	 * @return la cantidad de dinero que hay en la caja
	 */
	public double getCaja() {
		return caja;
	}

	/**
	 * Método para Pone el dinero (no lo suma) que hay en la caja
	 * 
	 * @param caja dinero que habrá en la caja.
	 */
	public void setCaja(double caja) {
		this.caja = caja;
	}

	/**
	 * Método para añadir dinero a la caja de la tienda
	 * 
	 * @param cantidad cantidad a añadir a la caja
	 */
	public void anyadirCaja(double cantidad) {
		this.caja += cantidad;
	}

	/**
	 * Método que añade un instrumento al ArrayList de instrumentos en stock.
	 */
	public void anyadirInstrumento() {
		System.out.println("¿Qué quieres añadir? \n1.- Bateria \n2.- Guitarra");
		int opcion;
		double precio;
		String marca;
		String modelo;

		opcion = ConsoleHelper.elegirOpcion(1, 2);

		switch (opcion) {
		case 1:
			precio = ConsoleHelper.leerDoublePositivo("Introduce el precio: ");
			marca = ConsoleHelper.leerString("Introduce la marca: ");
			modelo = ConsoleHelper.leerString("Introduce el modelo: ");

			Bateria bateria = new Bateria(precio, marca, modelo);
			instrumentosStock.add(bateria);
			System.out.println("Has añadido una bateria.");
			break;

		case 2:
			precio = ConsoleHelper.leerDoublePositivo("Introduce el precio: ");
			marca = ConsoleHelper.leerString("Introduce la marca: ");
			modelo = ConsoleHelper.leerString("Introduce el modelo: ");

			Guitarra guitarra = new Guitarra(precio, marca, modelo);
			instrumentosStock.add(guitarra);
			System.out.println("Has añadido una guitarra.");
			break;
		}

	}

	/**
	 * Método que lista cada instrumento que hay en el ArrayList de instrumentos en
	 * stock junto a una id "única"
	 */
	public void listarInstrumentos() {
		int id = 0;
		if (!instrumentosStock.isEmpty()) {
			for (InstrumentoMusical instrumentoMusical : instrumentosStock) {
				System.out.print(++id + " ");
				System.out.println(instrumentoMusical + "");
			}

			System.out.println();
		} else {
			System.out.println("No nos quedan más instrumentos para vender :(");
		}

	}

	/**
	 * Método para vender un instrumento. Lo quita de la lista, avisa al cliente y
	 * suma la venta a la caja.
	 */
	public void venderInstrumento() {
		int opc;
		InstrumentoMusical instrumentoEscogido;

		listarInstrumentos();

		if (!instrumentosStock.isEmpty()) {
			opc = ConsoleHelper.leerInt("¿Qué instrumento deseas?: ");

			instrumentoEscogido = instrumentosStock.get(opc - 1);

			if (instrumentoEscogido != null) {
				anyadirCaja(instrumentoEscogido.getPrecio());
				System.out.println("Te acabas de comprar una " + instrumentoEscogido + ", suena así: "
						+ instrumentoEscogido.tocarInstrumento() + " ¡Disfrutala!");

				instrumentosStock.remove(instrumentoEscogido);
			} else {
				System.out.println("No has seleccionado un instrumento válido.");
				venderInstrumento();
			}
		}
	}

	/**
	 * Método para mostrar el dinero que hay en la caja. (STRING)
	 */
	public void mostrarCaja() {
		System.out.println("En la caja hay de momento: " + getCaja() + "€");
	}

}
