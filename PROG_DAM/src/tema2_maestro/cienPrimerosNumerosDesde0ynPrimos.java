package tema2_maestro;

import static java.lang.Math.sqrt;

public class cienPrimerosNumerosDesde0ynPrimos {

	public static void main(String[] args) {
		for(int i = 0; i < 100; i++) {
			System.out.println(i);
		}
		
		int i = 0, v = 0, div = 0, raiz = 0;
		for (i = 1; i <= 100; i++) {
			div = 0;
			raiz = (int) sqrt(i);
			for (v = 1; v <= raiz; v++) { 
				if (i % v == 0)
					div++;
			}
			if (div <= 1)
				System.out.println(i + " es numero primo");

		}
		
	}

}
