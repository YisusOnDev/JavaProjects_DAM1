package models;

public class Alumno {
	private int num;
	private String nombre;
	private String grupo;

	public Alumno(int num, String nombre, String grupo) {
		this.num = num;
		this.nombre = nombre;
		this.grupo = grupo;
	}

	public String getNum() {
		return Integer.toString(num);
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

}