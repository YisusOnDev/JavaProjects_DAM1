package models;

import java.time.LocalDate;

public class Reptil extends Animal {

	public enum EspecieReptil {
		Tortuga, Iguana, DragonDeComodo
	}

	public static EspecieReptil getRazaValue(String typed) {
		typed = typed.toUpperCase();

		if (typed.equals("TORTUGA")) {
			return EspecieReptil.Tortuga;
		} else if (typed.equals("IGUANA")) {
			return EspecieReptil.Iguana;
		} else if (typed.equals("DRAGONDECOMODO")) {
			return EspecieReptil.DragonDeComodo;
		}

		return null;
	}

	private EspecieReptil especie;
	private String microChip;
	private boolean esVenenoso;

	public Reptil(String nombre, EspecieReptil especie, LocalDate fechaNacimiento, double peso, String microchip,
			boolean tieneVeneno) {
		super(nombre, fechaNacimiento, peso, null);
		this.microChip = microchip;
		this.especie = especie;
		this.esVenenoso = tieneVeneno;
	}

	@Override
	public String toString() {
		String esVenenoso;
		if (this.esVenenoso) {
			esVenenoso = "Sí";
		} else {
			esVenenoso = "No";
		}
		return "\nFicha Reptil \nNombre: " + nombre + "\nRaza: " + especie + "\nFecha de nacimiento: " + fechaNacimiento
				+ "\nPeso: " + peso + "\nMicrochip: " + microChip + "\nEs venenoso" + esVenenoso + "\nComentarios: "
				+ comentarios;

	}

}