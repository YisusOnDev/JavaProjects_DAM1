package t4_libro;

import java.util.Scanner;

public class ejer14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Introduce un número, te diré si es par o divisible entre 5");
			double number = Double.parseDouble(sc.nextLine());
			
			if((number % 2) == 0 && (number % 5) == 0) {
				// Par
				System.out.println("El número introducido es: " + number + "\nEs par y divisible entre 5");
			}else if(number % 2 == 0) {
				System.out.println("El número introducido es: " + number + "\nEs par pero no divisible entre 5");
			}else if(number % 5 == 0) {
				System.out.println("El número introducido es: " + number + "\nNo es par pero si divisible entre 5");
			}else {
				System.out.println("Error, vuelve a intentarlo");
			}
		}	
	}
}
