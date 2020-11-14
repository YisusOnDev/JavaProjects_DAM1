package mainApp;

import models.Alumno;

public class MainApp {

	public static void main(String[] args) {
		Alumno pepe = new Alumno("77957522S", "Jesus", "Tellez", 1.75, 19, 'm');
		
		pepe.setEstatura(1.80);
		System.out.println(pepe.getEstatura());
	}

}
