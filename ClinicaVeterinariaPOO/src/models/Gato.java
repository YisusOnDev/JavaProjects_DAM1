package models;

import java.time.LocalDate;

public class Gato extends Animal {

	public enum RazaGato {
		Comun, Siames, Persa, Angora, ScottishFold
	}

	public static RazaGato getRazaValue(String typed) {
		typed = typed.toUpperCase();

		if (typed.equals("COMUN")) {
			return RazaGato.Comun;
		} else if (typed.equals("SIAMES")) {
			return RazaGato.Siames;
		} else if (typed.equals("PERSA")) {
			return RazaGato.Persa;
		} else if (typed.equals("ANGORA")) {
			return RazaGato.Angora;
		} else if (typed.equals("SCOTTISHFOLD")) {
			return RazaGato.ScottishFold;
		}

		return null;
	}

	private RazaGato raza;
	private String microChip;

	public Gato(String nombre, RazaGato raza, LocalDate fechaNacimiento, double peso, String microchip) {
		super(nombre, fechaNacimiento, peso, null);
		this.microChip = microchip;
		this.raza = raza;
	}

	@Override
	public String toString() {

		return "\nFicha Gato \nNombre: " + nombre + "\nRaza: " + raza + "\nFecha de nacimiento: " + fechaNacimiento
				+ "\nPeso: " + peso + "\nMicrochip: " + microChip + "\nComentarios: " + comentarios;

	}

}