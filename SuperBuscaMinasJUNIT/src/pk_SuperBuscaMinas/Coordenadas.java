package pk_SuperBuscaMinas;

/**
 * Clase para almacenar pares de coordenadas
 *
 */
public class Coordenadas {
	private int fila;
	private int columna;

	public Coordenadas(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}
	
	public int getColumna() {
		return columna;
	}
	
	public void setColumna(int columna) {
		this.columna = columna;
	}

}
