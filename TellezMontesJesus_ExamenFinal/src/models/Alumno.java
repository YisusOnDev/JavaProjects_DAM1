package models;

public class Alumno {
	private int numero;
	private String nombre;
	private double nota;

	/**
	 * Constructor for Alumno
	 * 
	 * @param numero Alumno numero (id)
	 * @param nombre Alumno nombre (name)
	 * @param nota   Alumno nota (float calif)
	 */
	public Alumno(int numero, String nombre, double nota) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.nota = nota;
	}

	/**
	 * Method that get the Alumno number
	 * 
	 * @return Alumno numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Method that set the Alumno numero
	 * 
	 * @param numero wanted numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Method that get the Alumno nombre
	 * 
	 * @return Alumno nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Method that set the Alumno nombre
	 * 
	 * @param numero wanted nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Method that get the Alumno nota
	 * 
	 * @return Alumno nota
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * Method that set the Alumno nota
	 * 
	 * @param numero wanted nota
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}
}
