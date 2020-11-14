package t4_libro;

import java.util.Scanner;

public class ejer2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int horaEscrita;
		while(true) {
			System.out.println("¿Que hora es? (sin los minutos ni segundos)");
			horaEscrita = Integer.parseInt(sc.nextLine());
			if(horaEscrita >= 6 && horaEscrita <= 12) {
				System.out.println("Buenos días");
			} else if(horaEscrita >= 13 && horaEscrita <= 20) {
				System.out.println("Buenas tardes");
			} else if(horaEscrita >= 21 || horaEscrita <= 5) {
				System.out.println("Buenas noches");
			} else {
				System.out.println("La hora introducida no es correcta");
			}
		}
	}
}
