package pk_SuperBuscaMinas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pk_SuperBuscaMinas.BotonMina.Estado;
import pk_SuperBuscaMinas.BotonMina.Valor;

/**
 * Clase que controla la disposición de paneles y botones, así como los eventos del juego.
 *
 */
public class Tablero {
	
	// Tablero de 9x9 10 minas
	public final int NUM_MINAS = 10;
	public final int MATRIZ_SIZE = 9;
	public final int WINDOW_HORIZONTAL_SIZE = 500;
	public final int WINDOW_VERTICAL_SIZE = 500;
	public final int CELDA_SIZE = 40;
	
	private MatrizBotones matrizBotones;
	private PanelTiempo panelTiempo;
	private PanelContadorMinas panelContadorMinas;

	private boolean minaPulsada = false;
	
	
	/**
	 * Método que crea un panel con una matriz de botones minas (BotonMina), un panel contador de minas, y un panel con el tiempo
	 * @return Un JPanel que contiene una Matriz de botones, un panel contador de minas (banderas) y un panel contador de tiempo
	 */
	public JPanel crearPanelBuscaMinas() {
		JPanel panelBuscaMinas = new JPanel();
		panelBuscaMinas.setLayout(null);
		
		// Creo matriz de botones
		matrizBotones = new MatrizBotones(MATRIZ_SIZE, MATRIZ_SIZE, NUM_MINAS);
		generarEventosBotones();
		
		// PanelBuscaMinas
		int coordX = 20;
		int coordY = 20;

		// Voy insertando botón a botón
		for (int fil = 0; fil < MATRIZ_SIZE; fil++) {
			for (int col = 0; col < MATRIZ_SIZE; col++) {
				
				// Le doy coordenadas y tamaño
				matrizBotones.getBoton(fil, col).setBounds(coordX, coordY, CELDA_SIZE, CELDA_SIZE);

				// Añado el botón al panel
				panelBuscaMinas.add(matrizBotones.getBoton(fil, col));

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
	 * Método que genera los eventos de los botones de una matriz de BotonMina.
	 * En este método se controla el listener de ratón en cada boton mina
	 */
	private void generarEventosBotones() {
		for (int fil=0; fil<matrizBotones.getSize(); fil++) {
			for (int col=0; col<matrizBotones.getSize(); col++) {
				BotonMina boton = matrizBotones.getBoton(fil, col);
				
				// Añado el listener de ratón
				boton.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						// Empieza el tiempo cuando haga click por primera vez
						if (!panelTiempo.isContadorIniciado()) {
							panelTiempo.contar();
						}
						
						// Boton Izquierdo
						if (e.getButton() == MouseEvent.BUTTON1) {				
							// Si es BOTON 
							if (boton.getEstado().equals(Estado.BOTON)) {
								// Si debajo hay una mina acaba
								if (boton.getValor().equals(Valor.MINA)) {
									boton.cambiarAspecto(Estado.MINA);
									minaPulsada = true;
									isJuegoFinalizado();
								}									
								// Si debajo no hay nada, limpio de forma recursiva
								else if (boton.getValor().equals(Valor.VACIO)) {
									boton.cambiarAspecto(Estado.PULSADO);

									matrizBotones.recursivoDestapaBotonesAdyacentes(boton);
									isJuegoFinalizado();	
								}
								// Si hay número (indicando las minas adyacentes), lo muestro
								else if (boton.getValor().equals(Valor.NUMERO)) {
									boton.cambiarAspecto(Estado.NUMERO);
									matrizBotones.decrementaBotonesNoMinasSinPulsar();
									isJuegoFinalizado();
								}									
							}
						}
						
						// Boton Derecho
						if (e.getButton() == MouseEvent.BUTTON3) {
							// Si es bandera quito bandera (dejo botón)
							if (boton.getEstado().equals(Estado.BANDERA) ) {
								boton.cambiarAspecto(Estado.BOTON);
								panelContadorMinas.incrementaNumMinas();
							}
							// Si es botón, pongo bandera
							else if(boton.getEstado().equals(Estado.BOTON) && panelContadorMinas.getNumMinas() > 0){
								boton.cambiarAspecto(Estado.BANDERA);
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
	}
	
	
	/**
	 * Método que nos indica si el juego ha finalizado, y si el jugador gana o no
	 */
	private void isJuegoFinalizado() {
		if (minaPulsada) {	// FIN DEL JUEGO: HA PERDIDO
			ejecutar_sonido("res/Explosion.wav");
			matrizBotones.muestraMinas();
			mensajeFinJuego("La mina explotó!!");
		}
		else if (matrizBotones.getBotonesNoMinaSinPulsar() <= 0) {	// FIN DEL JUEGO: HA GANADO
			ejecutar_sonido("res/aplausos.wav");	
			mensajeFinJuego("Ganó la partida!!\nHa tardado: " + panelTiempo.getSegundos() + " segundos");	
		}
	}


	/**
	 * Método que ejecuta un sonido
	 * @param path_sonido ruta al archivo de sonido
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
	
	
	/**
	 * Método que muestra el mensaje de Fin de juego y termina la aplicación
	 * @param mensaje Mensaje a mostrar
	 */
	private void mensajeFinJuego(String mensaje) {
		panelTiempo.detener();
		
		JOptionPane.showMessageDialog(null, mensaje, "Fin del juego", JOptionPane.DEFAULT_OPTION);
		System.exit(0);
	}	

}
