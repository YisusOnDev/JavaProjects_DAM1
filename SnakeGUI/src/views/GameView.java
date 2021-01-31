package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.KeyboardController;
import models.Snake;

public class GameView extends JFrame {

	private static final long serialVersionUID = -6786273410349931728L;

	private Snake snake;
	private boolean jugando;
	private boolean pausado;
	private boolean showEndMessageal;
	private boolean mostrado;
	private BoardView board;

	private int timerCount;
	private JPanel mainPanel;
	private JPanel botonera;
	private JLabel puntos;
	private JLabel pointsLbl;
	private JButton start;
	private JButton pause;
	private KeyboardController miControlador;

	public GameView() {
		snake = new Snake();
		jugando = false;
		showEndMessageal = false;
		mostrado = false;
		pausado = false;

		initialize();
	}

	private void initialize() {
		setUIComponents();
		setUIListeners();
		startGame();
	}

	private void setUIComponents() {
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 3. Ahora creamos los componentes y los ponemos en la frame (ventana).

		// El panel de fondo. Rellena el frame, y sirve de contenedor del board y de
		// la botonera.
		mainPanel = new JPanel(new BorderLayout());

		// Create
		board = new BoardView();
		board.setBorder(BorderFactory.createLineBorder(Color.black));
		board.setBackground(new java.awt.Color(250, 240, 200));
		board.setSize(600, 400);
		board.setSnakeFrame(this);

		// Ahora el turno de la botonera. Tendrá los dos botones y las etiquetas de
		// texto
		botonera = new JPanel();
		botonera.setBorder(BorderFactory.createLineBorder(Color.black));
		botonera.setBackground(new java.awt.Color(150, 150, 150));

		// Ahora definimos las dos etiquetas para los puntos.
		puntos = new JLabel();
		puntos.setText("Puntos: ");
		puntos.setBackground(new java.awt.Color(190, 190, 190));

		pointsLbl = new JLabel();
		pointsLbl.setText("0");
		pointsLbl.setBackground(new java.awt.Color(190, 190, 190));

		// turno de los botones de empezar y pausar/continuar
		start = new JButton();
		start.setSize(50, 20);
		start.setText("Start");

		pause = new JButton();
		pause.setSize(50, 20);
		pause.setText("Pause");

		// Preparamos el control del teclado
		miControlador = new KeyboardController();
		miControlador.setSnakeFrame(this); // le damos al controlador de teclado un enlace el frame principal
		board.addKeyListener(miControlador); // le decimos al board que el teclado es cosa de nuestro controlador
		board.setFocusable(true); // permitimos que el board pueda coger el foco.

		// Añadimos los componentes uno a uno, cada uno en su contenedor, y al final el
		// panel principal
		// se añade al frame principal.
		botonera.add(start);
		botonera.add(pause);
		botonera.add(puntos);
		botonera.add(pointsLbl);

		mainPanel.add(botonera, BorderLayout.PAGE_END);
		mainPanel.add(board, BorderLayout.CENTER);
		this.add(mainPanel);

		this.setVisible(true); // activamos la ventana principal para que sea "pintable"

	}

	private void setUIListeners() {
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startGamePressed();
			}

		});

		pause.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pauseGamePressed();
			}

		});
	}

	public Snake getSerpiente() {
		return snake;
	}

	// nos han pulsado tecla, cambiamos de dirección.
	public void cambiaDireccion(int key) {
		snake.cambiaDireccion(key);
	}

	// tenemos que mostrar la ventanita de final de partida??? Sólo una vez...
	private boolean showEndMessage() {
		boolean resultado;

		resultado = false;
		if (showEndMessageal && !mostrado) { // estamos al final de una partida y no hemos mostrado nada
			resultado = true; // activamos el resultado para que se muestre la ventana
			mostrado = true; // ya no dejamos que se muestre más la próxima vez...
		}

		return resultado;
	}

	// toca crecer sólo si estamos en una partida activa y no estamos pausados...
	private void tocaCrecer() {
		if (jugando && !pausado)
			snake.crecer();
	}

	// toca moverse sólo si estamos en una partida activa y no estamos pausados...
	private void tocaMoverse() {
		if (jugando && !pausado)
			snake.moverse();
	}

	// han pulsado el botón de start, hay que ponerlo todo en orden.
	private void empezarDeNuevo() {
		snake = new Snake(); // nueva y flamante serpiente
		jugando = true; // estamos jugando a partir de ¡YA!
		showEndMessageal = false; // ni estamos al final ni mucho menos
		mostrado = false; // hemos mostrado el msg de final
		pausado = false; // Y todavía nadie ha pulsado el pause, todavía...
	}

	// Hay que ver si la serpiente sigue viva, pero sólo si estamos jugando y no en
	// modo pausa...
	private void checkStatus(int iAlto, int iAncho) {
		if (jugando && !pausado) {
			if (snake.estaMuerta(iAlto, iAncho)) {
				// acabamos de matarnos. Hay que mostrar msg al final y ya no jugamos...
				jugando = false;
				showEndMessageal = true;
				mostrado = false;
			}
		}
	}

	// sólo pausamos / continuamos si estamos jugando.
	private void pausaContinuaJuego() {
		if (jugando) {
			pausado = !pausado;
		}
	}

	private void startGamePressed() {
		this.empezarDeNuevo();
		board.requestFocus();
	}

	private void pauseGamePressed() {
		this.pausaContinuaJuego();
		board.requestFocus();
	}

	private void startGame() {
		timerCount = 0; // nuestro control de los pasos del tiempo. Cada vez que timerCount cuenta un
		// paso, pasan 10ms

		while (true) { // por siempre jamás (hasta que nos cierren la ventana) estamos controlando el
			// juego.

			// actualizamos el estado del juego
			if (timerCount % 20 == 0) {
				if (timerCount == 60) {
					timerCount = 0;
					this.tocaCrecer();

					// We grow up, update points
					pointsLbl.setText(Integer.toString(this.getSerpiente().getPuntos()));
				} else {
					timerCount++;
					this.tocaMoverse();
				}

				this.checkStatus(board.getHeight(), board.getWidth()); // Check if lost

			} else {
				timerCount++;
			}

			// If finished, show end message
			if (this.showEndMessage()) {
				JOptionPane.showMessageDialog(this,
						"Se acabo vaquero, has conseguido " + pointsLbl.getText() + " puntos");
			}

			// Repaint board
			board.repaint();

			// Let some time to repaint all
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
