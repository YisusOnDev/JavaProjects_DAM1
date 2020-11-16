package models;

public class Persona {

	private String nombre;
	private String apellidos;
	private String dni;
	private double sueldo;
	private CuentaCorriente cuenta;

	public Persona(String nombre, String apellidos, String dni, double sueldo, CuentaCorriente cuenta) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sueldo = sueldo;
		this.cuenta = cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public CuentaCorriente getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}

	public void cobrarSueldo() {
		this.cuenta.sumarCantidad(this.sueldo);
	}

	public void sacarPasta(double cantidad) {
		// restará de la cuenta esta cantidad. Ojo, no podrás sacar más de lo que
		// tienes… Si se intentará se lanzará un error y no restará nada.

		if (cantidad > (double) this.cuenta.getSaldo()) {
			System.out.println("Eres muy listo no? Más quisieras sacar más de lo que tienes... ¡Mago!");
		} else {
			try {
				this.cuenta.restarCantidad(cantidad);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void subirSueldo(double nuevoSueldo) {
		this.setSueldo(nuevoSueldo);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", sueldo=" + sueldo
				+ ", saldo=" + this.cuenta.getSaldo() + "]";
	}

}
