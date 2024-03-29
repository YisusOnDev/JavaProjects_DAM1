package yArrays;

import java.util.Random;
import java.util.Scanner;

public class yArrays {
	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int fil = 1 + rnd.nextInt(14); // Genera random filas para la matriz
		int col = 1 + rnd.nextInt(14); // Genera random columnas para la matriz
		int fil2 = 10; // Genera random filas para la matriz2
		int col2 = 10; // Genera random columnas para la matriz2
		int aLength = 1 + rnd.nextInt(14); // Genera random la longitud del array de ejemplo
		int nFilExtraer; // Indice de la fila, para extraer posteriormente de una matriz
		int nColExtraer; // Indice de la columna, para extraer posteriormente de una matriz
		int[][] matriz = new int[fil][col]; // Matriz principal
		int[][] matriz2 = new int[fil2][col2]; // Matriz de prueba para la multiplicaci�n
		int[] array = new int[aLength]; // Array para pruebas
		int[] numerosFilasElegidas = { 1, 2, 3 }; // Array de pruebas para generar la submatriz
		int[] numerosColumnasElegidas = { 1, 2, 3 }; // Array de pruebas para generar la submatriz

		generarMatriz(matriz);
		mostrarMatriz(matriz);

		System.out.println();
		System.out.println("A continuaci�n vamos a mostrar la diagonal (izquierda) de la matriz superior: ");

		calcularDiagonal(matriz, false);

		System.out.println();
		System.out.println("A continuaci�n vamos a mostrar la diagonal (derecha) de la matriz superior: ");

		calcularDiagonal(matriz, true);

		System.out.println();
		System.out.println(
				"Vamos a extraer las estad�sictas de la matriz \n[ m�nimo, m�ximo, media, desviacionTipica, varianza ]: ");
		mostrarArray(extraerEstadisticas(matriz));

		System.out.println();
		System.out.println();
		System.out.println("Ahora vamos a generar un array de ejemplo: ");
		generarArray(array);
		mostrarArray(array);

		System.out.println();
		System.out.println();
		System.out.println("\nVamos a invertir el array generado: ");
		invertir(array);
		mostrarArray(array);

		System.out.println();
		System.out.println();
		System.out.println("Vamos a extraer una fila de la matriz");
		System.out.print("Introduce el n� de la fila que quieres extraer: ");
		nFilExtraer = Integer.parseInt(sc.nextLine());
		getFila(matriz, nFilExtraer);

		System.out.println();
		System.out.println();
		System.out.println("Vamos a extraer una columna de la matriz");
		System.out.print("Introduce el n� de la columna que quieres extraer: ");
		nColExtraer = Integer.parseInt(sc.nextLine());
		getColumna(matriz, nColExtraer);

		System.out.println();
		System.out.println();
		System.out.println("Ahora vamos a generar una submatriz. ");
		submatriz(matriz, numerosFilasElegidas, numerosColumnasElegidas);

		System.out.println();
		System.out.println();
		System.out.println("Ahora vamos a generar multiplicar 2 matrices: ");
		generarMatriz(matriz2);
		multiplica(matriz, matriz2); // Cambiar matriz2 por matriz para que no de error probar.

	}

	/**
	 * Genera una matriz
	 * 
	 * @param m la matriz a generar
	 * @return devuelve la matriz generada
	 */
	public static int[][] generarMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = 1 + rnd.nextInt(24);
			}
		}
		return m;
	}

	/**
	 * Muestra por pantalla la matriz recibida.
	 * 
	 * @param m la matriz que queremos mostrar
	 */
	public static void mostrarMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print("[" + m[i][j] + "] ");
			}
			System.out.println();
		}
	}

	/**
	 * Muestra un vector con los n�meros de la diagonal (izquierda o derecha) de la
	 * matriz por pantalla.
	 * 
	 * @param m         es la matriz que recibe.
	 * @param invertida si es true, devolver� la diagonal empezando desde la
	 *                  derecha, si no desde la izquierda.
	 * @return devuelve el vector con los numeros que forman la diagonal (sea o no
	 *         cuadrada).
	 */
	public static int[] calcularDiagonal(int[][] m, boolean invertida) {
		int[] Array = new int[m.length];

		if (m.length == m[0].length) {
			if (!invertida) {
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m[i].length; j++) {
						if (i == j) {
							Array[i] = m[i][j];
						}
					}
				}
				mostrarArray(Array);
			} else if (invertida) {
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m[i].length; j++) {
						if ((i + j) == (m.length - 1)) {
							Array[i] = m[i][j];
						}
					}
				}
				mostrarArray(Array);
			}
		} else {
			System.out.println("la matriz introducida no es una matriz cuadrada");
		}

		return Array;
	}

	/**
	 * Muestra por pantalla el array recibido.
	 * 
	 * @param m el array que queremos mostrar
	 */
	public static void mostrarArray(int[] a) {
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]");
	}

	/**
	 * Devuelve un array con la siguiente informaci�n: [m�nimo, m�ximo, media,
	 * desviacionTipica, varianza] de una matriz
	 * 
	 * @param m la matriz
	 * @return array con la siguiente informaci�n: [m�nimo, m�ximo, media,
	 *         desviacionTipica, varianza]
	 */
	public static int[] extraerEstadisticas(int[][] m) {
		int[] Array = new int[5];
		int maximo = Integer.MIN_VALUE;
		int minimo = Integer.MAX_VALUE;
		int total = 0;
		int totalFilas = m.length;
		int totalColumnas = m[0].length;
		int media;
		double varianza = 0;
		double desviacionTipica;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {

				// Total necesario para realizar la media
				total += m[i][j];

				// Calculo m�ximo y m�nimo
				if (m[i][j] < minimo) {
					minimo = m[i][j];
				} else if (m[i][j] > maximo) {
					maximo = m[i][j];
				}

			}
		}

		// Generamos la media y la guardamos en su respectiva variable.
		media = (total / (totalFilas * totalColumnas));

		// Calculo desviaci�n t�pica
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				varianza += ((m[i][j] - media) * (m[i][j] - media)) / (totalFilas * totalColumnas);
			}
		}

		desviacionTipica = Math.sqrt(varianza);

		// Establecemos el minimo y m�ximo en su posici�n del Array.
		Array[0] = minimo;
		Array[1] = maximo;

		// Establecemos la media en su posici�n del Array.
		Array[2] = media;

		// Establecemos la desviaci�n t�pica en su posici�n del Array.
		Array[3] = (int) desviacionTipica;

		// Establecemos la varianzxa en su posici�n del Array.
		Array[4] = (int) varianza;

		return Array;
	}

	/**
	 * Devuelve le valor maximo de una matriz.
	 * 
	 * @param m la matriz
	 * @return el valor m�ximo de la matriz.
	 */
	public static int maximoValor(int[][] m) {
		int maximo = Integer.MIN_VALUE;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] > maximo) {
					maximo = m[i][j];
				}
			}
		}

		return maximo;
	}

	/**
	 * Devuelve le valor m�nimo de una matriz.
	 * 
	 * @param m la matriz
	 * @return el valor m�nimo de la matriz.
	 */
	public static int minimoValor(int[][] m) {
		int minimo = Integer.MAX_VALUE;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] < minimo) {
					minimo = m[i][j];
				}
			}
		}

		return minimo;
	}

	/**
	 * Cacula la media de una matriz.
	 * 
	 * @param m la matriz de la cual sacar la media
	 * @return la media de la matriz
	 */
	public static int media(int[][] m) {
		int total = 0;
		int totalFilas = m.length;
		int totalColumnas = m[0].length;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				total += m[i][j];
			}
		}

		return (total / (totalFilas * totalColumnas));
	}

	/**
	 * Cacula la desviaci�n t�pica de una matriz.
	 * 
	 * @param m la matriz de la cual sacar la desvicaci�n t�pica.
	 * @return la desviaci�n t�pica de la matriz.
	 */
	public static double desviacionTipica(int[][] m) {
		int total = 0;
		int totalFilas = m.length;
		int totalColumnas = m[0].length;
		int media;
		double varianza = 0;
		double desviacionTipica;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				total += m[i][j];
			}
		}

		media = (total / (totalFilas * totalColumnas));

		// Calculo desviaci�n t�pica
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				varianza += ((m[i][j] - media) * (m[i][j] - media)) / (totalFilas * totalColumnas);
			}
		}

		desviacionTipica = Math.sqrt(varianza);

		return desviacionTipica;
	}

	/**
	 * Cacula la varianza de una matriz.
	 * 
	 * @param m la matriz de la cual sacar la varianza.
	 * @return la varianza de la matriz.
	 */
	public static double varianza(int[][] m) {
		int total = 0;
		int totalFilas = m.length;
		int totalColumnas = m[0].length;
		int media;
		double varianza = 0;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				total += m[i][j];
			}
		}

		media = (total / (totalFilas * totalColumnas));

		// Calculo desviaci�n t�pica
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				varianza += ((m[i][j] - media) * (m[i][j] - media)) / (totalFilas * totalColumnas);
			}
		}

		return varianza;
	}

	/**
	 * Invierte completamente el array recibido
	 * 
	 * @param array a invertir
	 * @return array invertido
	 */

	public static int[] invertir(int[] array) {
		int aux;

		for (int i = 0; i < array.length / 2; i++) {
			aux = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = aux;
		}

		return array;
	}

	/**
	 * Devuelve un array con los valores de la fila recibida
	 * 
	 * @param m      la matriz donde buscar los valores
	 * @param indice la fila de la cual extraeremos los valores
	 * @return el array con los valores de la fila
	 */
	public static int[] getFila(int[][] m, int indice) {
		int[] fila = new int[m[0].length];

		if (indice >= 0 && indice <= m.length) {
			for (int i = 0; i < fila.length; i++) {
				fila[i] = m[indice - 1][i];
			}
			return fila;
		} else {
			System.out.println("El �ndice introducido se sale de los limites de la matriz.");
		}

		return null;
	}

	/**
	 * Devuelve un array con los valores de la fila recibida
	 * 
	 * @param m      la matriz donde buscar los valores
	 * @param indice la fila de la cual extraeremos los valores
	 * @return el array con los valores de la fila
	 */
	public static int[] getColumna(int[][] m, int indice) {
		int[] columna = new int[m.length];
		if (indice >= 0 && indice <= m[0].length) {
			for (int i = 0; i < columna.length; i++) {
				columna[i] = m[i][indice];
			}
			return columna;
		} else {
			System.out.println("El �ndice introducido se sale de los limites de la matriz.");
		}
		return null;
	}

	/**
	 * Genera un array
	 * 
	 * @param m el array a generar
	 * @return devuelve el array generado
	 */
	public static int[] generarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = 1 + rnd.nextInt(99);
		}
		return array;
	}

	/**
	 * De una matriz, se genera una submatriz con los valores de las filas y
	 * columnas elegidos.
	 * 
	 * @param m                       matriz de d�nde extraer los valores
	 * @param numerosFilasElegidas    es un array con las filas de las cuales se
	 *                                extraer�n los valores.
	 * @param numerosColumnasElegidas es un array con las columnas de las cuales se
	 *                                extraer�n los valores.
	 * @return una matriz con los valores extra�dos y del tama�o de las
	 *         filas*columnas elegidas.
	 */
	public static int[][] submatriz(int[][] m, int[] numerosFilasElegidas, int[] numerosColumnasElegidas) {
		boolean outOfIndex = false;
		int[][] submatriz = new int[numerosFilasElegidas.length][numerosColumnasElegidas.length];

		for (int i = 0; i < numerosFilasElegidas.length; i++) {
			if (numerosFilasElegidas.length >= m.length) {
				outOfIndex = true;
			}
		}

		for (int i = 0; i < numerosColumnasElegidas.length; i++) {
			if (numerosColumnasElegidas.length >= m.length) {
				outOfIndex = true;
			}
		}

		if (!outOfIndex) {
			for (int i = 0; i < numerosFilasElegidas.length; i++) {
				for (int j = 0; j < numerosColumnasElegidas.length; j++) {
					submatriz[i][j] = m[numerosFilasElegidas[i]][numerosColumnasElegidas[j]];

				}
			}

			mostrarMatriz(submatriz);

		} else if (outOfIndex) {
			System.out.println("Sobrepasas los limites de la matriz.");
		}

		return submatriz;
	}

	/**
	 * Si es posible, multiplica 2 matrices y te devuelve una matriz con el
	 * resultado de la multiplicaci�n de las anteriores.
	 * 
	 * @param m1 la matriz a multiplicar
	 * @param m2 la segunda matriz a multiplicar
	 * @return la matriz con el resultado de la multiplicacion
	 */
	public static int[][] multiplica(int[][] m1, int[][] m2) {
		int mMultiplicada[][] = new int[m1.length][m2[0].length];

		if (m1[0].length == m2.length) {

			for (int i = 0; i < m1.length; i++) {
				for (int j = 0; j < m2[0].length; j++) {
					mMultiplicada[i][j] = 0;
					for (int k = 0; k < m1[0].length; k++) {
						mMultiplicada[i][j] += m1[i][k] * m2[k][j];
					}
				}
			}
			mostrarMatriz(mMultiplicada);
		} else {
			System.out.println("Las dos matrices no se pueden multiplicar entre s�.");
		}

		return mMultiplicada;
	}

	/// EXTRAS

	/**
	 * Voltea horizontalmente una Matriz.
	 * 
	 * @param m1 la matriz a voltear
	 * @return la matriz volteada
	 */
	public static int[][] voltearHorizontal(int[][] m1) {
		int aux;
		for (int i = 0; i < m1.length / 2; i++) {
			for (int j = 0; j < m1[i].length; j++) {
				aux = m1[i][j];
				m1[i][j] = m1[m1.length - 1 - i][j];
				m1[m1.length - 1 - i][j] = aux;
			}
		}

		return m1;
	}

	/**
	 * Voltea verticalmente una Matriz.
	 * 
	 * @param m1 la matriz a voltear
	 * @return la matriz volteada
	 */
	public static int[][] voltearVertical(int[][] m1) {
		int aux;
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[i].length / 2; j++) {
				aux = m1[i][j];
				m1[i][j] = m1[i][m1.length - 1 - j];
				m1[i][m1.length - 1 - j] = aux;
			}
		}
		return m1;
	}

	/**
	 * Reemplaza los valores de una fila de la matriz por los valores de un array de
	 * la misma longitud.
	 * 
	 * @param m      la matriz
	 * @param a      el array
	 * @param indice �l indice de la fila a reemplazar
	 */
	public static void reemplazarFilaConArray(int m[][], int[] a, int indice) {
		if (indice >= 0 && indice <= m.length) {
			for (int i = 0; i < a.length; i++) {
				m[indice][i] = a[i];
			}
		} else {
			System.out.println("El tama�o del array es mayor a la fila de la matriz.");
		}
	}

	/**
	 * Reemplaza los valores de una columna de la matriz por los valores de un array
	 * de la misma longitud.
	 * 
	 * @param m      la matriz
	 * @param a      el array
	 * @param indice �l indice de la columna a reemplazar
	 */
	public static void reemplazarColumnaConArray(int m[][], int[] a, int indice) {
		if (indice >= 0 && indice <= m[0].length) {
			for (int i = 0; i < m[0].length; i++) {
				m[i][indice] = a[i];
			}
		} else {
			System.out.println("El �ndice introducido se sale de los limites de la matriz.");
		}
	}

	public static void rotarMatriz90grados(int m[][]) {
		int row = m.length;
		
		for (int i = 0; i < row; i++) {
			for (int j = i; j < row; j++) {
				int temp = m[i][j];
				m[i][j] = m[j][i];
				m[j][i] = temp;
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row / 2; j++) {
				int temp = m[i][j];
				m[i][j] = m[i][row - 1 - j];
				m[i][row - 1 - j] = temp;
			}
		}
	}

}
