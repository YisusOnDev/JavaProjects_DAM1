package mainapp;

import java.util.ArrayList;

import models.CuentaCorriente;
import models.Persona;
import utils.Utils;

public class MainApp {
	// Divertido
	public static void main(String[] args) {
		Utils.mainMenu();
	}
	
	
// No divertido...
//	public static void main(String[] args) {
//		CuentaCorriente cuentaPaco = new CuentaCorriente(00001, 5014.90, null);
//		CuentaCorriente cuentaPepe = new CuentaCorriente(00002, 9523.55, null);
//		CuentaCorriente cuentaRatata = new CuentaCorriente(00003, 3541.10, null);
//		Persona Paco = new Persona("Paco", "Puas, Rodriguez", "55695412L", 1065.50, cuentaPaco);
//		Persona Pepe = new Persona("Pepe", "Ramirez, Fernandez", "44569825D", 965.75, cuentaPepe);
//		Persona Ratata = new Persona("Rata", "Dominguez Pavon", "55632568M", 1500.25, cuentaRatata);
//		
//		System.out.println(Paco);
//		System.out.println(Pepe);
//		System.out.println(Ratata);
//		
//		Pepe.setSueldo(999.99);
//		System.out.println("El sueldo de Pepe es: " + Pepe.getSueldo());
//		
//		cuentaPaco.setTitular(Paco);
//		cuentaPepe.setTitular(Pepe);
//		cuentaRatata.setTitular(Ratata);
//		
//		System.out.println(cuentaPaco);
//		System.out.println(cuentaPepe);
//		System.out.println(cuentaRatata);
//		
//		cuentaPaco.sumarCantidad(55);
//		cuentaPepe.restarCantidad(523.55);
//		cuentaRatata.restarCantidad(3541.11);
//		
//		Paco.cobrarSueldo();
//		Pepe.sacarPasta(0.55);
//		Ratata.subirSueldo(3600);
//		
//		System.out.println(Paco + "\n");
//		System.out.println(Pepe + "\n");
//		System.out.println(Ratata + "\n");
//		
//		System.out.println(cuentaPaco + "\n");
//		System.out.println(cuentaPepe + "\n");
//		System.out.println(cuentaRatata);
//		
//	}

}
