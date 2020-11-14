package models;

public class CuentaCorriente {

	private int numeroCuenta;
	private double saldo;
	private Persona titular;

	/**
	 * Constructor CuentaCorriente
	 * 
	 * @param numeroCuenta
	 * @param saldo
	 * @param titular
	 */
	public CuentaCorriente(int numeroCuenta, double saldo, Persona titular) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.titular = titular;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Persona getTitular() {
		return titular;
	}

	public void setTitular(Persona titular) {
		this.titular = titular;
	}
	
	public void sumarCantidad(double cantidad) {
		this.saldo += cantidad;
	}
	
	public void restarCantidad(double cantidad) {
		if (cantidad > this.saldo) {
			System.out.println("Eres muy listo no? Más quisieras sacar más de lo que tienes... ¡Mago!");
		} else {
			this.saldo -= cantidad;
		}
	}

	@Override
	public String toString() {
		return "CuentaCorriente [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", titular=" + titular + "]";
	}

}
