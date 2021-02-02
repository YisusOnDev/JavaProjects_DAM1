package ejercicios;

public class ejercicios {
	public static void main(String[] args) {
		System.out.println(fiboRecursive(4)); // 1. Calcular el valor de la posición fibonacci usando recursividad.
		
		System.out.println();
		
		System.out.println(reverseNumberRecursive(123456)); // 3. Invertir un numero de forma recursiva (no usar String)
		
		System.out.println();
		
		System.out.println(calculatePowRecursive(2, -2)); // 5. Calcula la potencia de un numero de forma recursiva,
															// tanto para exponentes negativos como positivos.
		
		System.out.println();
		
		System.out.println(sumIntRecursive(22)); // 7. Suma los digitos de un numero de forma recursiva.
		
		System.out.println();
		
		int[] searchArray = { 1, 2, 3 };
		int toSearch = 3;
		System.out.println(searchInArrayRecursive(searchArray, toSearch, 0)); // 9. Buscar un elemento de un array de forma
																			// recursiva.
		
		System.out.println();
		
		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10}};
		System.out.println(printMatrixRecursive(matrix, 0)); // 11. Recorrer una matriz de forma recursiva.
	}

	// 1
	public static int fiboRecursive(int i) {
		if (i == 1) {
			return 0;
		} else if (i == 2) {
			return 1;
		} else {
			return fiboRecursive(i - 2) + fiboRecursive(i - 1);
		}
	}

	// 3
	public static int reverseNumberRecursive(int i) {
		int nlenght = 0;
		int a = i;
		while (a > 0) {
			nlenght++;
			a = a / 10;
		}
		return computeReverse(i, nlenght);
	}

	public static int computeReverse(int a, int b) {
		if (b == 1) {
			return a;
		} else {
			int nc = a % 10;
			a = a / 10;
			return (int) (nc * Math.pow(10, b - 1)) + computeReverse(a, --b);
		}
	}

	// 5
	public static float calculatePowRecursive(int b, int e) {
		if (e == 1) {
			return (float) b;
		} else if (e > 1) {
			return b * calculatePowRecursive(b, --e);
		} else if (e == -1) {
			return 1 / b;
		} else {
			return 1 / calculatePowRecursive(b, e * -1);
		}

	}

	// 7
	public static int sumIntRecursive(int i) {
		if (i / 10 == 0) {
			return i;
		} else {
			return (i % 10 + sumIntRecursive(i / 10));
		}
	}

	// 9
	public static String searchInArrayRecursive(int arr[], int search, int ind) {
		if (ind < arr.length) {
			if (arr[ind] == search)
				return "Si, hemos encontrado " + search;
			else
				return searchInArrayRecursive(arr, search, ind + 1);
		}

		return "No hemos encontrado " + search;

	}

	// 11
	public static String printMatrixRecursive(int m[][], int ind) {
		if (ind < m.length) {
			if (ind == m.length - 1) {
				return printArrayForMatrix(m[ind], 0);
			} else {
				return printArrayForMatrix(m[ind], 0) + " \n" + printArrayForMatrix(m[ind+1], 0);
			}
		}
		
		return null;

	}

	public static String printArrayForMatrix(int[] arr, int ind) {
		if (ind < arr.length) {
			if (ind == arr.length - 1) {
				return String.valueOf(arr[ind]);
			} else {
				return String.valueOf(arr[ind]) + " " + printArrayForMatrix(arr, ind + 1);
			}
		}

		return null;
	}
}
