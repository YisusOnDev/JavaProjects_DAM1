package models;

import java.time.LocalDate;

public class Pajaro extends Animal {

	public enum EspeciePajaro {
		Canario, Periquito, Agapornis
	}

	public static EspeciePajaro getRazaValue(String typed) {
		typed = typed.toUpperCase();

		if (typed.equals("CANARIO")) {
			return EspeciePajaro.Canario;
		} else if (typed.equals("PERIQUITO")) {
			return EspeciePajaro.Periquito;
		} else if (typed.equals("AGAPORNIS")) {
			return EspeciePajaro.Agapornis;
		}

		return null;
	}

	private EspeciePajaro especie;
	private String microChip;
	private boolean cantor;

	public Pajaro(String nombre, EspeciePajaro especie, LocalDate fechaNacimiento, double peso, String microchip,
			boolean esCantor) {
		super(nombre, fechaNacimiento, peso, null);
		this.microChip = microchip;
		this.especie = especie;
		this.cantor = esCantor;
	}

	@Override
	public String toString() {
		String esCantor;

		if (this.cantor) {
			esCantor = "Sí";
		} else {
			esCantor = "No";
		}

		return "\nFicha Pajaro \nNombre: " + nombre + "\nRaza: " + especie + "\nFecha de nacimiento: " + fechaNacimiento
				+ "\nPeso: " + peso + "\nMicrochip: " + microChip + "\nEs cantor: " + esCantor + "\nComentarios: "
				+ comentarios;

	}

}