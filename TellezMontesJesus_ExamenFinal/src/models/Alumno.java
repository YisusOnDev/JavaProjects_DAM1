package models;

public class Alumno {
	private int numero;
	private String nombre;
	private double nota;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Alumno(int numero, String nombre, double nota) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.nota = nota;
	}
	
	
}
