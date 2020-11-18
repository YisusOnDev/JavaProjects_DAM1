package models;

import java.time.LocalDate;

public abstract class Animal {

	protected String nombre;
	protected LocalDate fechaNacimiento;
	protected double peso;
	protected String comentarios;

	public Animal(String nombre, LocalDate fechaNacimiento, double peso, String comentarios) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.peso = peso;

		if (comentarios != null)
			this.comentarios = comentarios;
		else
			this.comentarios = "No hay comentarios registrados.";
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}