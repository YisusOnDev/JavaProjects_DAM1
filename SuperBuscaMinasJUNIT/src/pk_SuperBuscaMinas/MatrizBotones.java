package pk_SuperBuscaMinas;

import java.util.ArrayList;

import pk_SuperBuscaMinas.BotonMina.Estado;
import pk_SuperBuscaMinas.BotonMina.Valor;
import pk_SuperBuscaMinas.Util.Posicion;

/**
 * Clase que gestiona una matriz de botones BotonMina
 *
 */
public class MatrizBotones {
	
	private BotonMina[][] matrizBotones;
	private int botonesNoMinaSinPulsar = 0;
	private ArrayList<Coordenadas> listaPosicionMinas = new ArrayList<Coordenadas>();
	
	
	public MatrizBotones(int filas, int columnas) {
		matrizBotones = new BotonMina[filas][columnas];
		
		for (int fil=0; fil<getSize(); fil++) {
			for (int col=0; col<getSize(); col++) {			
				BotonMina boton = new BotonMina(fil, col);
				matrizBotones[fil][col] = boton;
			}
		}
	}
	
	public MatrizBotones(int filas, int columnas, int numMinas) {
		this(filas, columnas);
		
		plantaMinas(numMinas);
	}
	
	/**
	 * Método que devuelve el botón que se encuentra en la posición informada
	 * @param fila
	 * @param columna
	 * @return
	 */
	public BotonMina getBoton(int fila, int columna) {
		return matrizBotones[fila][columna];
	}
	
	/**
	 * Método que devuelve el botón que se encuentra en la coordenada informada
	 * @param coord
	 * @return
	 */
	public BotonMina getBoton(Coordenadas coord) {
		return matrizBotones[coord.getFila()][coord.getColumna()];
	}

	/**
	 * Método que devuelve el tamaño de una matriz de botones
	 * @return
	 */
	public int getSize() {
		return matrizBotones.length;
	}
	
	/**
	 * Método que devuelve una lista con la posición de cada una de las minas
	 * @return the listaPosicionMinas
	 */
	public ArrayList<Coordenadas> getListaPosicionMinas() {
		return listaPosicionMinas;
	}

	/**
	 * Método que decrementa el numero de botones que no son minas y que aún no se han pulsado
	 */
	public void decrementaBotonesNoMinasSinPulsar() {
		botonesNoMinaSinPulsar--;
	}
	
	/**
	 * Método que devuelve el número de botones que no son minas y que aún no se han pulsado
	 * @return
	 */
	public int getBotonesNoMinaSinPulsar() {
		return botonesNoMinaSinPulsar;
	}
	
	/**
	 * Método que indica si existe un botón en una posición concreta
	 * @param boton Botón origen
	 * @param posicion Posición respecto al botón origen
	 * @return Si existe botón en esa posición
	 */
	public boolean hayBoton(BotonMina boton, Posicion posicion) {
		int fila = boton.getFil();
		int columna = boton.getCol();
		
		switch (posicion) {
			case SUP_IZQ:
				if (fila>0 && columna>0) return true;
				break;
			case SUP:
				if (fila>0) return true;
				break;
			case SUP_DER:
				if (fila>0 && columna<matrizBotones.length-1) return true;
				break;
			case DER:
				if (columna<matrizBotones.length-1) return true;
				break;
			case INF_DER:
				if (fila<matrizBotones.length-1 && columna<matrizBotones.length-1) return true;
				break;
			case INF:
				if (fila<matrizBotones.length-1) return true;
				break;
			case INF_IZQ:
				if (fila<matrizBotones.length-1 && columna>0) return true;
				break;
			case IZQ:
				if (columna>0) return true;
				break;
			default:
				break;
		}
		
		return false;
	}
	
	/**
	 * Método que devuelve el botón relativo a un botón origen
	 * @param boton Botón origen
	 * @param posicion Posición del botón a devolver
	 * @return El botón de la posición
	 */
	public BotonMina getBotonAdyacente(BotonMina boton, Posicion posicion) {
		int fila = boton.getFil();
		int columna = boton.getCol();
		
		if (!hayBoton(boton, posicion)) return null;
		
		switch (posicion) {
			case SUP_IZQ:	return getBoton(fila-1, columna-1);
			case SUP:		return getBoton(fila-1, columna);
			case SUP_DER:	return getBoton(fila-1, columna+1);
			case DER:		return getBoton(fila, columna+1);
			case INF_DER:	return getBoton(fila+1, columna+1);
			case INF:		return getBoton(fila+1, columna);
			case INF_IZQ:	return getBoton(fila+1, columna-1);
			case IZQ:		return getBoton(fila, columna-1);
		}
		
		return(null);
	}
	
	/**
	 * Método que genera minas en la matriz de botones
	 * @param numMinas número de minas a generar
	 */
	private void plantaMinas(int numMinas) {
		// Genero aleatoriamente numMinas minas
		int contador_minas = numMinas;
		int filaMina;
		int columnaMina;
		
		while (contador_minas > 0) {
			filaMina = (int)(Math.random() * this.getSize());
			columnaMina = (int)(Math.random() * this.getSize());
			
			if (!this.getBoton(filaMina, columnaMina).getValor().equals(Valor.MINA)) {
				this.getBoton(filaMina, columnaMina).setValor(Valor.MINA);
				contador_minas--;
				
				// Guardo las coordenadas de todas las minas
				listaPosicionMinas.add(new Coordenadas(filaMina, columnaMina));
			}
		}
		
		actualizaNumMinasAdyacentes();
	}
	
	/**
	 * Método que recorre toda la matriz calculando el número de minas adyacentes a cada celda botón
	 */
	public void actualizaNumMinasAdyacentes() {
		// Ahora recorro la matriz y actualizo el número de minas adyacentes a cada botón
		for (int i=0; i<this.getSize(); i++) {
			for (int j=0; j<this.getSize(); j++) {
				BotonMina boton = this.getBoton(i, j);
				if (!boton.getValor().equals(Valor.MINA)) {
					int numMinasAdy = numeroMinasAdyacentes(boton);
					
					// Necesario que el botón sepa el número de minas adyacentes
					boton.setNumMinasAdyacentes(numMinasAdy);
					
					if (numMinasAdy == 0) {
						boton.setValor(Valor.VACIO);
					}
					else {
						boton.setValor(Valor.NUMERO);
					}	
					botonesNoMinaSinPulsar++;
				}
			}
		}	
	}	
	
	/**
	 * Método que muestra todas las minas. Se llama cuando se ha pulsado una mina y explota
	 */
	public void muestraMinas() {
		for (Coordenadas coord: listaPosicionMinas) {
			BotonMina boton = this.getBoton(coord);
			boton.cambiarAspecto(Estado.MINA);
		}		
	}	
	
	/**
	 * Método que destapa el botón indicado. Si es un botón VACIO intentará hacer lo mismo con los adyacentes de forma recursiva 
	 * @param boton
	 * @param posicion
	 */
	private void destapaBoton(BotonMina boton, Posicion posicion) {
		if (this.hayBoton(boton, posicion)) {
			BotonMina boton_a_destapar = this.getBotonAdyacente(boton, posicion);

			if (boton_a_destapar.getEstado().equals(Estado.BOTON)) {		
				// Si es valor NUMERO cambia aspecto a NUMERO
				if (boton_a_destapar.getValor().equals(Valor.NUMERO)) {
					boton_a_destapar.cambiarAspecto(Estado.NUMERO);
					botonesNoMinaSinPulsar--;
				}  
				// Si es valor VACIO cambia aspecto a PULSADO
				else if (boton_a_destapar.getValor().equals(Valor.VACIO)) {
					boton_a_destapar.cambiarAspecto(Estado.PULSADO);
					recursivoDestapaBotonesAdyacentes(boton_a_destapar);
				}
			}
		}
	}
	
	/**
	 * Método que destapa los botones adyacentes al botón indicado.
	 * @param boton
	 */
	public void recursivoDestapaBotonesAdyacentes(BotonMina boton) {
		botonesNoMinaSinPulsar--;
				
		for(Posicion posicion: Posicion.values()) {
			destapaBoton(boton, posicion);
		}
		
		// Igual que el "for each" anterior
/*		destapaBoton(boton, Posicion.SUP_IZQ);
		destapaBoton(boton, Posicion.SUP);
		destapaBoton(boton, Posicion.SUP_DER);
		destapaBoton(boton, Posicion.DER);
		destapaBoton(boton, Posicion.INF_DER);
		destapaBoton(boton, Posicion.INF);
		destapaBoton(boton, Posicion.INF_IZQ);
		destapaBoton(boton, Posicion.IZQ);
*/
	}
	
	/**
	 * Método que indica el número de minas que existen en las posiciones adyacentes del botón una matriz
	 * @param boton
	 * @return el número de minas que se encuentran en las posiciones adyacentes al botón indicado
	 */
	private int numeroMinasAdyacentes(BotonMina boton) {
		int numMinas = 0;
		
		for(Posicion posicion: Posicion.values()) {
			numMinas = numMinas + getNumMinasAdyacentes(boton, posicion);
		}
		
		// Igual que el "for each" anterior		
/*		numMinas = numMinas + getNumMinasAdyacentes(boton, Posicion.SUP_IZQ);
		numMinas = numMinas + getNumMinasAdyacentes(boton, Posicion.SUP);
		numMinas = numMinas + getNumMinasAdyacentes(boton, Posicion.SUP_DER);
		numMinas = numMinas + getNumMinasAdyacentes(boton, Posicion.DER);
		numMinas = numMinas + getNumMinasAdyacentes(boton, Posicion.INF_DER);
		numMinas = numMinas + getNumMinasAdyacentes(boton, Posicion.INF);
		numMinas = numMinas + getNumMinasAdyacentes(boton, Posicion.INF_IZQ);
		numMinas = numMinas + getNumMinasAdyacentes(boton, Posicion.IZQ);
*/				
		return numMinas;
	}
	
	/**
	 * Método que indica el número de minas que existen en la posición adyacente a un botón 
	 * @param boton Botón origen
	 * @param posicion La posición del nuevo botón con respecto al botón que se informa como parámetro
	 * @return
	 */
	private int getNumMinasAdyacentes(BotonMina boton, Posicion posicion) {
		if (hayBoton(boton, posicion)) {
			if (getBotonAdyacente(boton, posicion).getValor().equals(Valor.MINA)) {
				return 1;
			}
			else return 0;
		}
		else return 0;
	}	
	
	/**
	 * Método que imprime una matriz por pantalla
	 */
	public void imprimir() {
		for (int i=0; i<matrizBotones.length; i++) {
			for (int j=0; j<matrizBotones.length; j++) {
				System.out.print(matrizBotones[i][j] + "\t");
			}
			
			System.out.println();
		}		
		
		System.out.println();
	}	
}
