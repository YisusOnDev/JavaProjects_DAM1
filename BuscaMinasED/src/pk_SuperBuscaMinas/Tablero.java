package pk_SuperBuscaMinas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Tablero {
	
	// Tablero de 9x9 10 minas
	public final int NUM_MINAS = 10;
	public final int MATRIZ_SIZE = 9;
	public final int CELDA_SIZE = 40;
	
	private BotonMina[][] matrizBotones;
	private PanelTiempo panelTiempo;
	private PanelContadorMinas panelContadorMinas;

	private int botonesNoMinaSinPulsar = 0;
	private boolean minaPulsada = false;
	
	private ArrayList<Coordenadas> listaPosicionMinas = new ArrayList<Coordenadas>();
	
	
	// Clase interna para almacenar pares de coordenadas
	private class Coordenadas {
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
	
	
	/**
	 * Método que crea un panel con una matriz de botones minas (BotonMina), un panel contador de minas, y un panel con el tiempo
	 * @return el panel con la matriz de minas
	 */
	public JPanel crearPanelBuscaMinas() {
		JPanel panelBuscaMinas = new JPanel();
		panelBuscaMinas.setLayout(null);
		
		// Creo matriz de botones
		inicializaMatrizBotones(MATRIZ_SIZE);
		
		//imprimeMatrizBotones(matrizBotones);
		
		// PanelBuscaMinas
		int coordX = 20;
		int coordY = 20;

		// Voy insertando botón a botón
		for (int fil = 0; fil < MATRIZ_SIZE; fil++) {
			for (int col = 0; col < MATRIZ_SIZE; col++) {
				
				// Le doy coordenadas y tamaño
				matrizBotones[fil][col].setBounds(coordX, coordY, CELDA_SIZE, CELDA_SIZE);

				// Añado el botón al panel
				panelBuscaMinas.add(matrizBotones[fil][col]);

				// Incremento coordenada X
				coordX = coordX + CELDA_SIZE - 1; // el -1 pixel es por un tema estético de los botones
			}

			// Reinicio coordenada X. Incremento coordenada Y
			coordX = 20;
			coordY = coordY + CELDA_SIZE - 1; // el -1 pixel es por un tema estético de los botones
		}
		
		// Panel Tiempo
		panelTiempo = new PanelTiempo();
		panelTiempo.setBounds(coordX, coordY + 10, panelTiempo.getWidth(), panelTiempo.getHeight());
		panelBuscaMinas.add(panelTiempo);
		
		// Panel Contador de minas (banderas)
		panelContadorMinas = new PanelContadorMinas(NUM_MINAS);
		panelContadorMinas.setBounds(coordX + (CELDA_SIZE * MATRIZ_SIZE) - panelContadorMinas.getWidth(), coordY + 10, panelContadorMinas.getWidth(), panelContadorMinas.getHeight());
		panelBuscaMinas.add(panelContadorMinas);
		panelBuscaMinas.setBounds(40, 10, CELDA_SIZE * MATRIZ_SIZE + 20, CELDA_SIZE * MATRIZ_SIZE + 100);
				
		return panelBuscaMinas;
	}
	
	
	/**
	 * Método que crea una matriz cuadrada (mismas filas que columnas) de BotonMina según los parámetros de entrada
	 * En este método se controla el listener de ratón en cada boton mina
	 * @param size tamaño de la matriz
	 */
	private void inicializaMatrizBotones(int size) {
		matrizBotones = new BotonMina[size][size];
		
		for (int fil=0; fil<matrizBotones.length; fil++) {
			for (int col=0; col<matrizBotones.length; col++) {
				matrizBotones[fil][col] = new BotonMina(fil, col);
				
				BotonMina celda = matrizBotones[fil][col];
				
				// Añado el listener de ratón
				celda.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						// Empieza el tiempo cuando haga click por primera vez
						if (!panelTiempo.isContadorIniciado()) {
							panelTiempo.contar();
						}
						
						// Boton Izquierdo
						if (e.getButton() == MouseEvent.BUTTON1) {				
							// Si es BOTON 
							if (celda.getEstado().equals(BotonMina.Estado.BOTON)) {
								// Si debajo hay una mina acaba
								if (celda.getValor().equals(BotonMina.Valor.MINA)) {
									celda.cambiarAspecto(BotonMina.Estado.MINA);
									minaPulsada = true;
									isJuegoFinalizado();
								}									
								// Si debajo no hay nada, limpio de forma recursiva
								else if (celda.getValor().equals(BotonMina.Valor.VACIO)) {
									celda.cambiarAspecto(BotonMina.Estado.PULSADO);

									recursivoDestapaCeldasAdyacentes(celda.getFil(), celda.getCol());
									isJuegoFinalizado();	
								}
								// Si hay número (indicando las minas adyacentes), lo muestro
								else if (celda.getValor().equals(BotonMina.Valor.NUMERO)) {
									celda.cambiarAspecto(BotonMina.Estado.NUMERO);
									botonesNoMinaSinPulsar--;
									isJuegoFinalizado();
								}									
							}
						}
						
						// Boton Derecho
						if (e.getButton() == MouseEvent.BUTTON3) {
							// Si es bandera quito bandera (dejo botón)
							if (celda.getEstado().equals(BotonMina.Estado.BANDERA) ) {
								celda.cambiarAspecto(BotonMina.Estado.BOTON);
								panelContadorMinas.incrementaNumMinas();
							}
							// Si es botón, pongo bandera
							else if(celda.getEstado().equals(BotonMina.Estado.BOTON) && panelContadorMinas.getNumMinas() > 0){
								celda.cambiarAspecto(BotonMina.Estado.BANDERA);
								panelContadorMinas.decrementaNumMinas();
							}
						}						
					}
					@Override
					public void mousePressed(MouseEvent e) {}
					@Override
					public void mouseExited(MouseEvent e) {}
					@Override
					public void mouseEntered(MouseEvent e) {}
					@Override
					public void mouseClicked(MouseEvent e) {}
				});				
			}
		}
		
		// ----------------- CREACION DE MINAS -----------------
		// Genero aleatoriamente numMinas minas
		int contador_minas = NUM_MINAS;
		int filaMina;
		int columnaMina;
		
		while (contador_minas > 0) {
			filaMina = (int)(Math.random() * matrizBotones.length);
			columnaMina = (int)(Math.random() * matrizBotones.length);
			
			if (!matrizBotones[filaMina][columnaMina].getValor().equals(BotonMina.Valor.MINA)) {
				matrizBotones[filaMina][columnaMina].setValor(BotonMina.Valor.MINA);
				contador_minas--;
				
				// Guardo las coordenadas de todas las minas
				listaPosicionMinas.add(new Coordenadas(filaMina, columnaMina));
			}
		}
				
		// Ahora recorro la matriz y actualizo el número de minas adyacentes a cada celda
		for (int i=0; i<matrizBotones.length; i++) {
			for (int j=0; j<matrizBotones.length; j++) {
				if (!matrizBotones[i][j].getValor().equals(BotonMina.Valor.MINA)) {
					int numMinasAdy = numeroMinasAdyacentes(i, j);
					
					// Necesario que la celda sepa el número de minas adyacentes
					matrizBotones[i][j].setNumMinasAdyacentes(numMinasAdy);
					
					if (numMinasAdy == 0) {
						matrizBotones[i][j].setValor(BotonMina.Valor.VACIO);
					}
					else {
						matrizBotones[i][j].setValor(BotonMina.Valor.NUMERO);
					}	
					botonesNoMinaSinPulsar++;
				}
			}
		}		
		// ----------------- CREACION DE MINAS -----------------
	}		
	
	
	// Método que nos indica si el juego ha finalizado, y si el jugador gana o no
	private void isJuegoFinalizado() {
		if (minaPulsada) {	// FIN DEL JUEGO: HA PERDIDO
			ejecutar_sonido("res/Explosion.wav");
			muestraMinas();
			
			panelTiempo.detener();
			
			JOptionPane.showMessageDialog(null, "La mina explotó!!", "Fin del juego", JOptionPane.DEFAULT_OPTION);
			System.exit(0);
		}
		else if (botonesNoMinaSinPulsar <= 0) {	// FIN DEL JUEGO: HA GANADO
			ejecutar_sonido("res/aplausos.wav");
			
			panelTiempo.detener();
			
			JOptionPane.showMessageDialog(null, "Ganó la partida!!\nHa tardado: " + panelTiempo.getSegundos() + " segundos", "Fin del juego", JOptionPane.DEFAULT_OPTION);
			System.exit(0);
		}
	}	
	
	
	/**
	 * @param path_sonido TODO
	 * 
	 */
	private void ejecutar_sonido(String path_sonido) {
		try {
			Clip sonido = AudioSystem.getClip();
			
			File a = new File(path_sonido);
			sonido.open(AudioSystem.getAudioInputStream(a));
			sonido.start();
		} catch (Exception e) {
			System.out.println("" + e);
		}
	}	

	// Método que muestra todas las minas. Se llama cuando se ha pulsado una mina y explota
	private void muestraMinas() {
		for (Coordenadas coordenadas: listaPosicionMinas) {
			matrizBotones[coordenadas.getFila()][coordenadas.getColumna()].cambiarAspecto(BotonMina.Estado.MINA);
		}		
	}
	
	
	// Método que destapa las celdas adyacentes a la celda indicada.
	// Siempre que esas celdas adyacentes no tengan minas de forma recursiva.
	private void recursivoDestapaCeldasAdyacentes(int fil, int col) {
		botonesNoMinaSinPulsar--;
		
		// Celda Superior izq
		if ((fil>0 && col>0) && matrizBotones[fil-1][col-1].getEstado().equals(BotonMina.Estado.BOTON)) {
			// Si es valor NUMERO cambia aspecto a NUMERO
			if (matrizBotones[fil-1][col-1].getValor().equals(BotonMina.Valor.NUMERO)) {
				matrizBotones[fil-1][col-1].cambiarAspecto(BotonMina.Estado.NUMERO);
				botonesNoMinaSinPulsar--;
			}
			// Si es valor VACIO cambia aspecto a PULSADO
			if (matrizBotones[fil-1][col-1].getValor().equals(BotonMina.Valor.VACIO)) {
				matrizBotones[fil-1][col-1].cambiarAspecto(BotonMina.Estado.PULSADO);
				recursivoDestapaCeldasAdyacentes(fil-1, col-1);
			}
		}
		
		// Celda Superior
		if ((fil>0)	&& matrizBotones[fil-1][col].getEstado().equals(BotonMina.Estado.BOTON)) {
			// Si es valor NUMERO cambia aspecto a NUMERO
			if (matrizBotones[fil-1][col].getValor().equals(BotonMina.Valor.NUMERO)) {
				matrizBotones[fil-1][col].cambiarAspecto(BotonMina.Estado.NUMERO);
				botonesNoMinaSinPulsar--;
			}
			// Si es valor VACIO cambia aspecto a PULSADO
			if (matrizBotones[fil-1][col].getValor().equals(BotonMina.Valor.VACIO)) {
				matrizBotones[fil-1][col].cambiarAspecto(BotonMina.Estado.PULSADO);
				recursivoDestapaCeldasAdyacentes(fil-1, col);
			}
		}		
		
		// Celda Superior der
		if ((fil>0 && col<matrizBotones.length-1) && matrizBotones[fil-1][col+1].getEstado().equals(BotonMina.Estado.BOTON)) {
			// Si es valor NUMERO cambia aspecto a NUMERO
			if (matrizBotones[fil-1][col+1].getValor().equals(BotonMina.Valor.NUMERO)) {
				matrizBotones[fil-1][col+1].cambiarAspecto(BotonMina.Estado.NUMERO);
				botonesNoMinaSinPulsar--;
			}
			// Si es valor VACIO cambia aspecto a PULSADO
			if (matrizBotones[fil-1][col+1].getValor().equals(BotonMina.Valor.VACIO)) {
				matrizBotones[fil-1][col+1].cambiarAspecto(BotonMina.Estado.PULSADO);
				recursivoDestapaCeldasAdyacentes(fil-1, col+1);
			}
		}	
		
		// Celda Izq
		if ((col>0)	&& matrizBotones[fil][col-1].getEstado().equals(BotonMina.Estado.BOTON)) {
			// Si es valor NUMERO cambia aspecto a NUMERO
			if (matrizBotones[fil][col-1].getValor().equals(BotonMina.Valor.NUMERO)) {
				matrizBotones[fil][col-1].cambiarAspecto(BotonMina.Estado.NUMERO);
				botonesNoMinaSinPulsar--;
			}
			// Si es valor VACIO cambia aspecto a PULSADO
			if (matrizBotones[fil][col-1].getValor().equals(BotonMina.Valor.VACIO)) {
				matrizBotones[fil][col-1].cambiarAspecto(BotonMina.Estado.PULSADO);
				recursivoDestapaCeldasAdyacentes(fil, col-1);
			}
		}
		
		// Celda Der
		if ((col<matrizBotones.length-1) && matrizBotones[fil][col+1].getEstado().equals(BotonMina.Estado.BOTON)) {
			// Si es valor NUMERO cambia aspecto a NUMERO
			if (matrizBotones[fil][col+1].getValor().equals(BotonMina.Valor.NUMERO)) {
				matrizBotones[fil][col+1].cambiarAspecto(BotonMina.Estado.NUMERO);
				botonesNoMinaSinPulsar--;
			}
			// Si es valor VACIO cambia aspecto a PULSADO
			if (matrizBotones[fil][col+1].getValor().equals(BotonMina.Valor.VACIO)) {
				matrizBotones[fil][col+1].cambiarAspecto(BotonMina.Estado.PULSADO);
				recursivoDestapaCeldasAdyacentes(fil, col+1);
			}
		}	
		
		// Celda Inferior der
		if ((fil<matrizBotones.length-1 && col<matrizBotones.length-1) && matrizBotones[fil+1][col+1].getEstado().equals(BotonMina.Estado.BOTON)) {
			// Si es valor NUMERO cambia aspecto a NUMERO
			if (matrizBotones[fil+1][col+1].getValor().equals(BotonMina.Valor.NUMERO)) {
				matrizBotones[fil+1][col+1].cambiarAspecto(BotonMina.Estado.NUMERO);
				botonesNoMinaSinPulsar--;
			}
			// Si es valor VACIO cambia aspecto a PULSADO
			if (matrizBotones[fil+1][col+1].getValor().equals(BotonMina.Valor.VACIO)) {
				matrizBotones[fil+1][col+1].cambiarAspecto(BotonMina.Estado.PULSADO);
				recursivoDestapaCeldasAdyacentes(fil+1, col+1);
			}
		}	
		
		// Celda Inferior
		if ((fil<matrizBotones.length-1) && matrizBotones[fil+1][col].getEstado().equals(BotonMina.Estado.BOTON)) {
			// Si es valor NUMERO cambia aspecto a NUMERO
			if (matrizBotones[fil+1][col].getValor().equals(BotonMina.Valor.NUMERO)) {
				matrizBotones[fil+1][col].cambiarAspecto(BotonMina.Estado.NUMERO);
				botonesNoMinaSinPulsar--;
			}
			// Si es valor VACIO cambia aspecto a PULSADO
			if (matrizBotones[fil+1][col].getValor().equals(BotonMina.Valor.VACIO)) {
				matrizBotones[fil+1][col].cambiarAspecto(BotonMina.Estado.PULSADO);
				recursivoDestapaCeldasAdyacentes(fil+1, col);
			}
		}	
		
		// Celda Inferior izq
		if ((fil<matrizBotones.length-1 && col>0) && matrizBotones[fil+1][col-1].getEstado().equals(BotonMina.Estado.BOTON)) {
			// Si es valor NUMERO cambia aspecto a NUMERO
			if (matrizBotones[fil+1][col-1].getValor().equals(BotonMina.Valor.NUMERO)) {
				matrizBotones[fil+1][col-1].cambiarAspecto(BotonMina.Estado.NUMERO);
				botonesNoMinaSinPulsar--;
			}
			// Si es valor VACIO cambia aspecto a PULSADO
			if (matrizBotones[fil+1][col-1].getValor().equals(BotonMina.Valor.VACIO)) {
				matrizBotones[fil+1][col-1].cambiarAspecto(BotonMina.Estado.PULSADO);
				recursivoDestapaCeldasAdyacentes(fil+1, col-1);
			}
		}
	}

	
	/**
	 * Método que indica el número de minas que existen en las posiciones adyacentes de la celda una matriz
	 * @param fil fila de la celda
	 * @param col columna de la celda
	 * @return el número de minas que se encuentran en las posiciones adyacentes a la celda indicada
	 */
	private int numeroMinasAdyacentes(int fil, int col) {
		int numMinas = 0;
		
		// Celda Superior izq
		if ((fil>0 && col>0) && matrizBotones[fil-1][col-1].getValor().equals(BotonMina.Valor.MINA)) {
			numMinas++;
		}
		
		// Celda Superior
		if ((fil>0)	&& matrizBotones[fil-1][col].getValor().equals(BotonMina.Valor.MINA)) {
			numMinas++;
		}		
		
		// Celda Superior der
		if ((fil>0 && col<matrizBotones.length-1) && matrizBotones[fil-1][col+1].getValor().equals(BotonMina.Valor.MINA)) {
			numMinas++;
		}	
		
		// Celda Izq
		if ((col>0)	&& matrizBotones[fil][col-1].getValor().equals(BotonMina.Valor.MINA)) {
			numMinas++;
		}	
		
		// Celda Der
		if ((col<matrizBotones.length-1) && matrizBotones[fil][col+1].getValor().equals(BotonMina.Valor.MINA)) {
			numMinas++;
		}	
		
		// Celda Inferior der
		if ((fil<matrizBotones.length-1 && col<matrizBotones.length-1) && matrizBotones[fil+1][col+1].getValor().equals(BotonMina.Valor.MINA)) {
			numMinas++;
		}	
		
		// Celda Inferior
		if ((fil<matrizBotones.length-1) && matrizBotones[fil+1][col].getValor().equals(BotonMina.Valor.MINA)) {
			numMinas++;
		}	
		
		// Celda Inferior izq
		if ((fil<matrizBotones.length-1 && col>0) && matrizBotones[fil+1][col-1].getValor().equals(BotonMina.Valor.MINA)) {
			numMinas++;
		}
				
		return numMinas;
	}

	/**
	 * Método que imprime una matriz por pantalla
	 */
	public static void imprimeMatrizBotones(BotonMina[][] matrizBotones) {
// TODO
	}		
}
