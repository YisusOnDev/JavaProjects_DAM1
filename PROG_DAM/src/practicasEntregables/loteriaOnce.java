package practicasEntregables;

import java.util.Random;
import java.util.Scanner;

public class loteriaOnce {

	/*
	 * Programa "Simulador de Loteria"
	 * 
	 * @author: Jesús Téllez
	 * 
	 * Este programa te permite comprobar un boleto de 5 cifras con un boleto
	 * "ganador" que se genera. Dependiendo de si tu boleto coincide entero o "x"
	 * cifras con el ganador se te da "y" premio.
	 * 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random(); // Creamos un método para generar aleatorio. Posteriormente se usará para
									// generar un número aleatorio que será el boleto ganador.

		// Variables
		final int primerPremio = 35000; // Cantidad que ganas si te toca el primer premio.
		final int segundoPremio = 200; // Cantidad que ganas si te toca el segundo premio.
		final int tercerPremio = 20; // Cantidad que ganas si te toca el tercer premio.
		final int cuartoPremio = 6; // Cantidad que ganas si te toca el cuarto premio.
		final float quintoPremio = 1.5f; // Cantidad que ganas si te toca el reintegro.
		boolean stillPlay = true; // Loop del juego, siempre true para que no finalice, false para que pare el
									// juego.
		int scPrincipal = 0; // Opción del primer menú.
		int boletoSc = 0; // Guardamos el boleto introducido por el usuario en formato Int.
		String boletoString = null; // Guardamos el boleto introducido por el usuario en formato String (es el que
		// usamos para comparar las cifras con el ganador).
		int boletoPremiado; // Guardamos el boleto ganador generado en Int.
		String boletoPremiadoString; // Guardamos el boleto ganador en String (es con el que comparamos con el
										// introducido).

		// Loop principal del programa.
		while (stillPlay == true) {

			boletoPremiado = 00001 + rnd.nextInt(99999); // Generamos el boleto premiado.
			boletoPremiadoString = Integer.toString(boletoPremiado);

			while (boletoPremiadoString.length() < 5) {
				boletoPremiadoString = "0" + boletoPremiadoString;
			}

			System.out.println("Bienvenido al sistema de comprobación de la ONCE.\n");

			boolean esValido = false;

			// Gestión de errores.
			while (!esValido) {
				try {
					System.out.println(
							"¿Que deseas hacer?\n1 --> Revisar mi boleto\n2 --> Ver boleto premiado\n3 --> Salir");
					scPrincipal = Integer.parseInt(sc.nextLine()); // Selección principal
					if (scPrincipal == 1 || scPrincipal == 2 || scPrincipal == 3) {
						esValido = true;
					} else {
						esValido = false;
					}
				} catch (Exception e) {
					System.out.println("Por favor, introduce números enteros. \n");
					esValido = false;
				}
			}

			// Generamos el boleto premiado y comprobamos todo tipo de premio y/o reintegro.
			if (scPrincipal == 1) {
				boolean tieneFormatoBoleto = false;

				// Gestión de errores
				while (!tieneFormatoBoleto) {
					try {
						System.out.print("Introduce tu boleto: ");
						boletoSc = Integer.parseInt(sc.nextLine()); // Pedimos su número de boleto.
						boletoString = Integer.toString(boletoSc);
						if (boletoString.length() <= 5) {
							tieneFormatoBoleto = true;
						} else {
							System.out.println(
									"Por favor, introduce el boleto en formato correcto (5 números enteros). \n");
							tieneFormatoBoleto = false;
						}
					} catch (Exception e) {
						System.out.println("Por favor, introduce números enteros y solo 5 cifras. \n");
						tieneFormatoBoleto = false;
					}
				}

				// En caso de que no haya incluído ceros a la izquierda o Java no los incluya,
				// los añadimos.
				while (boletoString.length() < 5) {
					boletoString = "0" + boletoString;
				}

				// Simulamos una barra de carga.
				System.out.println("Comprobando: %----");
				System.out.println("Comprobando: %%---");
				System.out.println("Comprobando: %%%--");
				System.out.println("Comprobando: %%%%-");
				System.out.println("Comprobando: %%%%%\n");

				// Todas las cifras coinciden, primer premio.
				if (boletoPremiadoString.equals(boletoString)) {
					System.out.println("El boleto premiado es: " + boletoPremiadoString + "\nTu boleto es: "
							+ boletoString + " ¡HAS GANADO: " + primerPremio + "€ ENHORABUENA!");

					// 4 útlimas cifras coinciden, segundo premio.
				} else if (boletoPremiadoString.charAt(4) == boletoString.charAt(4)
						&& boletoPremiadoString.charAt(3) == boletoString.charAt(3)
						&& boletoPremiadoString.charAt(2) == boletoString.charAt(2)
						&& boletoPremiadoString.charAt(1) == boletoString.charAt(1)) {
					System.out.println("El boleto premiado es: " + boletoPremiadoString + "\nTu boleto es: "
							+ boletoString + " ¡HAS GANADO: " + segundoPremio + "€ ENHORABUENA!");

					// 3 Últimas cifras coinciden, tercer premio.
				} else if (boletoPremiadoString.charAt(4) == boletoString.charAt(4)
						&& boletoPremiadoString.charAt(3) == boletoString.charAt(3)
						&& boletoPremiadoString.charAt(2) == boletoString.charAt(2)) {
					System.out.println("El boleto premiado es: " + boletoPremiadoString + "\nTu boleto es: "
							+ boletoString + " ¡HAS GANADO: " + tercerPremio + "€ ENHORABUENA!");

					// 2 Últimas cifras coinciden, cuarto premio.
				} else if (boletoPremiadoString.charAt(4) == boletoString.charAt(4)
						&& boletoPremiadoString.charAt(3) == boletoString.charAt(3)) {
					System.out.println("El boleto premiado es: " + boletoPremiadoString + "\nTu boleto es: "
							+ boletoString + " ¡HAS GANADO: " + cuartoPremio + "€ ENHORABUENA!");

					// Reintegro, "quinto premio" + opción de comprar otro para volver a jugar
				} else if (boletoPremiadoString.charAt(0) == boletoString.charAt(0)
						|| boletoPremiadoString.charAt(4) == boletoString.charAt(4)) {
					System.out.println("El boleto premiado es: " + boletoPremiadoString + "\nTu boleto es: "
							+ boletoString + " Has obtenido el reintegro: " + quintoPremio + "€.");

					// En caso del reintegro le damos la opción de comprar otro boleto, seguir
					// jugando o salir.
					boolean tempEsValido = false;

					// Gestión de errores.
					while (!tempEsValido) {
						try {
							// Como le ha tocado el reintegro, le preguntamos si desea comprar otro,
							// comprobar otro o salir.
							System.out.println(
									"\n¿Qué deseas hacer? \n1 --> Comprar otro boleto (generado aleatoriamente) \n2 --> Comprobar otro número \n3 --> Salir");
							int tempSc = Integer.parseInt(sc.nextLine());
							// Se genera otro boleto aleatorio para el usuario.
							if (tempSc == 1) {
								int nuevoBoleto = 00001 + rnd.nextInt(99999); // Generamos el nuevo boleto del usuario
																				// con
																				// método Random.
								String nuevoBoletoString = Integer.toString(nuevoBoleto);
								System.out.println(
										"Tu boleto para el proximo sorteo de la ONCE es: " + nuevoBoletoString);
								System.out.println("Muchas gracias por jugar, ¡esperamos verte pronto!");
								stillPlay = false;
								tempEsValido = true;
								// Continuamos el juego.
							} else if (tempSc == 2) {
								tempEsValido = true;
								stillPlay = true;

								// Paramos el juego.
							} else if (tempSc == 3) {
								System.out.println("Muchas gracias por jugar, ¡esperamos verte pronto!");
								tempEsValido = true;
								stillPlay = false;

								// Ha puesto lo que le da la gana, se lo decimos.
							} else {
								System.out.println("Introduce un valor válido (1, 2 o 3)");
								tempEsValido = false;
							}
						} catch (Exception e) {
							System.out.println("Por favor, introduce números enteros. \n");
							esValido = false;
						}
					}

					// No le ha tocado nada. Volvemos al inicio.
				} else {
					System.out.println("El boleto premiado es: " + boletoPremiadoString + "\nTu boleto es: "
							+ boletoString + " No has obtenido ningún premio, ¡la proxima vez será!");
				}

				// Solo mostramos el número que ha sido premiado y se lo mostramos.
			} else if (scPrincipal == 2) {
				System.out.println("El boleto premiado ha sido: " + boletoPremiadoString + "\n");

				// Paramos el programa.
			} else if (scPrincipal == 3) {
				System.out.println("Muchas gracias por jugar, ¡esperamos verte pronto!");
				stillPlay = false;
			}
		}
	}
}
