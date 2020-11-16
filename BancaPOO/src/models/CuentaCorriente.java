package models;

public class CuentaCorriente {

	private int numeroCuenta;
	private double saldo;

	/**
	 * Constructor CuentaCorriente
	 * 
	 * @param numeroCuenta
	 * @param saldo
	 * @param titular
	 */
	public CuentaCorriente(int numeroCuenta, double saldo  ) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
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
	
	public void sumarCantidad(double cantidad) {
		this.saldo += cantidad;
	}
	
	public void restarCantidad(double cantidad) throws Exception {
		if (cantidad > this.saldo) {
			throw new Exception("Eres muy listo no? Más quisieras sacar más de lo que tienes... ¡Mago!");
		} else {
			this.saldo -= cantidad;
		}
	}

	@Override
	public String toString() {
		return "CuentaCorriente [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}

}
