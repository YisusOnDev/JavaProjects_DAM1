import java.util.Arrays;
import java.util.Random;

public class TellezMontesJesus_Examen1 {
	static Random rnd = new Random();

	/**
	 * Busca si un string existe en un array.
	 * 
	 * @param lista   El array de String.
	 * @param palabra El String a buscar si existe en el Array.
	 * @return true si existe dentro del Array, false si no.
	 */
	public static boolean buscarPalabraEnArray(String[] lista, String palabra) {
		// Recorremos el array
		for (int i = 0; i < lista.length; i++) {
			// Si encontramos el String deseado devolvemos true.
			if (lista[i].equals(palabra)) {
				return true;
			}
		}
		// Si no encontramos el String deseado devolvemos false.
		return false;
	}

	public static int[][] voltearMatrizSentidoHorario(int[][] matriz) {
		// TODO
		return null;
	}

	/**
	 * Dada una matriz, extrae los valores de su zona exterior y devuelve los
	 * valores extraidos en forma de Array.
	 * 
	 * @param la matriz a extraer sus valores exteriores.
	 * @return un array con los valores exteriores extraídos de la matriz.
	 */
	public static int[] capaExteriorMatriz(int[][] matriz) {
		int[] arrayExterior = new int[(matriz.length * matriz.length)];
		int indice = 0;
		if (matriz.length == matriz[0].length) {
			for (int i = 0; i < matriz.length; i++) {
				arrayExterior[i] = matriz[i][0];
				indice++;
			}

			for (int i = 0; i < matriz[0].length; i++) {
				if (i != 0 && i != (matriz.length - 1)) {
					arrayExterior[indice] = matriz[matriz.length - 1][i];
					indice++;
				}
			}

			int[] auxArray = yArrays.invertir(yArrays.getColumna(matriz, matriz.length - 1));
			for (int i = 0; i < auxArray.length; i++) {
				arrayExterior[indice] = auxArray[i];
				indice++;
			}

			for (int i = matriz[0].length - 1; i > 0; i--) {
				if (i != 0 && i != matriz[0].length - 1) {
					arrayExterior[indice] = matriz[0][i];
					indice++;
				}
			}

			return Arrays.copyOf(arrayExterior, indice);

		} else {
			System.out.println("La matriz introducida no es cuadrada.");
		}
		return null;
	}

	public static void main(String[] args) {
		// Pruebas buscarPalabraEnArray
		String[] arrayString = { "a", "b", "c" }; // Array de String con propósito de pruebas.

		System.out.println(buscarPalabraEnArray(arrayString, "e")); // Test "buscarPalabraEnArray" (a, b o c para que
																	// devuelva true.)

		// Pruebas Capa Exterior Matriz
		int[][] matriz = new int[8][8]; // Matriz a generar

		yArrays.generarMatriz(matriz); // Genera matriz
		yArrays.mostrarMatriz(matriz); // Muestra la matriz

		yArrays.mostrarArray(capaExteriorMatriz(matriz)); // si no falla... muestra el array con los valores de la capa
															// exterior devueltos.
	}

}
