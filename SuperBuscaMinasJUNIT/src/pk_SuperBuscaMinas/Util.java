package pk_SuperBuscaMinas;

public class Util {
	/**
	 * Posibles posiciones con respecto a un botón central 
	 * <ul>
	 * <li>SUP_IZQ: Superior izquierdo</li>
	 * <li>SUP: Superior</li>
	 * <li>SUP_DER: Superior derecho</li>
	 * <li>DER: Derecho</li>
	 * <li>INF_DER: Inferior derecho</li>
	 * <li>INF: Inferior</li>
	 * <li>INF_IZQ: Inferior izquierdo</li>
	 * <li>IZQ: Izquierdo</li>
	 * </ul>
	 */
	public static enum Posicion {
		SUP_IZQ, SUP, SUP_DER, DER, INF_DER, INF, INF_IZQ, IZQ
	}
	
	/**
	 * Método que imprime una matriz por pantalla
	 */
	public static void imprimeMatrizBotones(BotonMina[][] matrizBotones) {
		for (int i=0; i<matrizBotones.length; i++) {
			for (int j=0; j<matrizBotones.length; j++) {
				System.out.print("\t" + matrizBotones[i][j] + " ");
			}
			
			System.out.println();
		}		
		
		System.out.println();
	}
	
	/**
	 * Método que acorta una cadena a una longitud especificada, o añade espacios hasta llegar a la longitud especificada
	 * @param s
	 * @param size
	 * @return
	 */
	public static String ajustar_length(String s, int size) {
		if (s.length()>size) return s.substring(0, size);
		else {
			int espacios = size - s.length();
			
			for (int i=0;i<espacios;i++) s = s + " ";
			
			return s;
		}
	}
}
