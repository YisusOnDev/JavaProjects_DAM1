package t4_libro;

import java.util.Scanner;

public class ejer28 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\nBienvenido al juego de piedra, papel o tijera INFINITO. Por favor no hacer trampas.\n");
			System.out.print("Jugador 1 (piedra, papel o tijera): ");
			String seleccionP1 = sc.nextLine();
			System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");
			System.out.print("Jugador 2 (introduzca piedra, papel o tijera): ");
			String seleccionP2 = sc.nextLine();

			if (seleccionP1.equals(seleccionP2)) {
				System.out.println("Empate");
			} else {
				String ganador = "Jugador 2";
				switch (seleccionP1) {
				case "piedra":
					if (seleccionP2.equals("tijera")) {
						ganador = "Jugador 1";
					}
					break;
				case "papel":
					if (seleccionP2.equals("piedra")) {
						ganador = "Jugador 1";
					}
					break;
				case "tijera":
					if (seleccionP2.equals("papel")) {
						ganador = "Jugador 1";
					}
					break;
				default:
					System.out.println("Fatal error.");
				}
				System.out.println("Ha ganado: " + ganador);
			}
		}

	}
}
