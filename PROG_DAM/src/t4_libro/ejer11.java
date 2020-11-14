package t4_libro;

import java.util.Scanner;

public class ejer11 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la hora que es");
		
		int hora = Integer.parseInt(sc.nextLine());
		
		System.out.println("Introduce los minutos de la hora introducida");

		int minuto = Integer.parseInt(sc.nextLine());

		int segundosPasados = (hora * 3600) + (minuto * 60);
		int segundosMedianoche = (24 * 3600) - segundosPasados;

		 System.out.println("Son las " + hora + ":" + minuto + " faltan " + segundosMedianoche 
				 + " segundos para medianoche");
	
	}
}
