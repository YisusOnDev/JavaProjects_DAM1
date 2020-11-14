package t2yt3_libro;

import java.util.Scanner;

public class ejer7 {
	// Ejercicio 4 del punto 3.4 del Libro.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(
					"Bienvenido a la \"calculadora\" \nPor favor, Introduce el primer número");
			double primerNumero = Double.parseDouble(sc.nextLine());
			System.out.println(
					"Bienvenido a la \"calculadora\" \nPor favor, Introduce el segundo número");
			double segundoNumero = Double.parseDouble(sc.nextLine());
			System.out.println(
					"Por favor, Indica si quieres sumar, restar, multiplicar o dividir estos números");
			String seleccion = sc.nextLine();
			
			if (seleccion.equals("sumar")) {
				double suma = primerNumero + segundoNumero;
				String sumaStr = "La suma de " + primerNumero + " y " + segundoNumero + " es: " + suma;
				System.out.println(sumaStr);
				
			} else if (seleccion.equals("restar")) {
				double resta = primerNumero - segundoNumero;
				String restaStr = "La resta de " + primerNumero + " y " + segundoNumero + " es: " + resta;
				System.out.println(restaStr);
				
			} else if (seleccion.equals("multiplicar")) {
				double multiplicar = primerNumero * segundoNumero;
				String multiplicarStr = "La multiplicación de " + primerNumero + " y " + segundoNumero + " es: " + multiplicar;
				System.out.println(multiplicarStr);
				
			} else if (seleccion.equals("dividir")) {
				double dividir = primerNumero / segundoNumero;
				double resto = primerNumero % segundoNumero;
				String divisionStr = "La división de " + primerNumero + " y " + segundoNumero + " es: " + dividir + "\nY su resto es: " + resto;
				System.out.println(divisionStr);
				
			}else {
				System.out.println("ERROR: Vuelve a intentarlo.");
				
			}
		}
	}
}
