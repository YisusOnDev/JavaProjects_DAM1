package models;

import java.time.LocalDate;

public class Perro extends Animal {

	public enum RazaPerro {
		PastorAleman, Husky, FoxTerrier, Dalmata, SanBernardo
	}

	public static RazaPerro getRazaValue(String typed) {
		typed = typed.toUpperCase();

		if (typed.equals("PASTORALEMAN")) {
			return RazaPerro.PastorAleman;
		} else if (typed.equals("HUSKY")) {
			return RazaPerro.Husky;
		} else if (typed.equals("FOXTERRIER")) {
			return RazaPerro.FoxTerrier;
		} else if (typed.equals("DALMATA")) {
			return RazaPerro.Dalmata;
		} else if (typed.equals("SANBERNARDO")) {
			return RazaPerro.SanBernardo;
		}

		return null;
	}

	private RazaPerro raza;
	private String microChip;

	public Perro(String nombre, RazaPerro raza, LocalDate fechaNacimiento, double peso, String microchip) {
		super(nombre, fechaNacimiento, peso, null);
		this.microChip = microchip;
		this.raza = raza;
	}

	@Override
	public String toString() {

		return "\nFicha Perro \nNombre: " + nombre + "\nRaza: " + raza + "\nFecha de nacimiento: " + fechaNacimiento
				+ "\nPeso: " + peso + "\nMicrochip: " + microChip + "\nComentarios: " + comentarios;

	}

}