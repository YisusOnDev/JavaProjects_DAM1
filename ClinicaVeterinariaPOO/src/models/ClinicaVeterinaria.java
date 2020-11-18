package models;

import java.util.ArrayList;

public class ClinicaVeterinaria {

	private ArrayList<Animal> animales;

	public ClinicaVeterinaria(ArrayList<Animal> animales) {
		super();
		this.animales = animales;
	}

	public ClinicaVeterinaria() {
		super();
		this.animales = new ArrayList<Animal>();
	}

	public void InsertarAnimal(Animal animal) {
		this.animales.add(animal);
	}

	public Animal BuscarAnimal(String nombreAnimal) {
		for (Animal a : this.animales) {
			if (a.getNombre().equals(nombreAnimal))
				return a;
		}

		return null;
	}

	public void ModificarComentarioAnimal(String nombreAnimal, String nuevoComentario) {
		for (Animal a : this.animales) {
			if (a.getNombre().equals(nombreAnimal)) {
				a.setComentarios(nuevoComentario);
			}
		}
	}

	@Override
	public String toString() {
		String toPrint = "\n ";
		for (Animal a : this.animales) {
			if (a instanceof Perro) {
				toPrint += "\n" + (Perro) a;
			} else if (a instanceof Gato) {
				toPrint += "\n" + (Gato) a;
			} else if (a instanceof Pajaro) {
				toPrint += "\n" + (Pajaro) a;
			} else if (a instanceof Reptil) {
				toPrint += "\n" + (Reptil) a;
			}
		}

		return toPrint;
	}

}