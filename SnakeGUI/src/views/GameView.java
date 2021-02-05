package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
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
import models.Square;
import panels.BoardPanel;

public class GameView extends JFrame {

	private static final long serialVersionUID = -6786273410349931728L;

	private Snake snake;
	private Square apple;
	private boolean playing;
	private boolean inPauseMenu;
	private boolean showEndMessage;
	private boolean showing;
	private BoardPanel board;

	private int timerCount;
	private JPanel mainPanel;
	private JPanel buttons;
	private JLabel points;
	private JLabel pointsLbl;
	private JButton start;
	private JButton pause;
	private KeyboardController myController;

	private boolean hackEnabled = false; // enable or disable godmode (never RIP)

	private int mapHeight;
	private int mapWidth;

	final int easyGM = 1;
	final int normalGM = 2;
	final int hardGM = 4;
	final int hardcoreGM = 20;
	private int selectedGm;

	public GameView() {
		selectMapSize();
		snake = new Snake();
		apple = generateNewApple();
		playing = false;
		showEndMessage = false;
		showing = false;
		inPauseMenu = false;

		initialize();
	}

	private void initialize() {
		setUIComponents();
		setUIListeners();
		startGame();
	}

	private void setUIComponents() {
		this.setSize(mapHeight, mapWidth);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		mainPanel = new JPanel(new BorderLayout());

		board = new BoardPanel();
		board.setBorder(BorderFactory.createLineBorder(Color.black));
		board.setBackground(new java.awt.Color((int) (Math.random() * 255), (int) (Math.random() * 255),
				(int) (Math.random() * 255)));
		board.setSize(600, 400);
		board.setSnakeFrame(this);

		buttons = new JPanel();
		buttons.setBorder(BorderFactory.createLineBorder(Color.black));
		buttons.setBackground(new java.awt.Color(150, 150, 150));

		points = new JLabel();
		points.setText("Puntos: ");
		points.setBackground(new java.awt.Color(190, 190, 190));

		pointsLbl = new JLabel();
		pointsLbl.setText("0");
		pointsLbl.setBackground(new java.awt.Color(190, 190, 190));

		start = new JButton();
		start.setSize(50, 20);
		start.setText("Start");

		pause = new JButton();
		pause.setSize(50, 20);
		pause.setText("Pause");

		// Init keyboard controller
		myController = new KeyboardController();
		myController.setSnakeFrame(this);

		buttons.add(start);
		buttons.add(pause);
		buttons.add(points);
		buttons.add(pointsLbl);

		mainPanel.add(buttons, BorderLayout.PAGE_END);
		mainPanel.add(board, BorderLayout.CENTER);
		this.add(mainPanel);

		this.setVisible(true);

	}

	private void setUIListeners() {
		board.addKeyListener(myController); // add controller to board
		board.setFocusable(true); // allow board to focus

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

	public Snake getSnake() {
		return snake;
	}

	public Square getApple() {
		return apple;
	}

	// change the position where the snake is going
	public void changeSnakeDirection(int key) {
		snake.changeDirection(key);
	}

	private boolean showEndMessage() {
		boolean result;

		result = false;
		if (showEndMessage && !showing) {
			result = true;
			showing = true;
		}

		return result;
	}

	// if playing make snake bigger
	private void makeBigger() {
		if (playing && !inPauseMenu)
			snake.growUp();
	}

	// if is playing trigger snake movement.
	private void moveTriggered() {
		if (playing && !inPauseMenu)
			snake.moveSnake(board.getHeight(), board.getWidth());
	}

	// Start a new game. (reset all values)
	private void startGameAgain() {
		snake = new Snake();
		apple = generateNewApple();
		playing = true;
		showEndMessage = false;
		showing = false;
		inPauseMenu = false;
		board.setBackground(new java.awt.Color((int) (Math.random() * 255), (int) (Math.random() * 255),
				(int) (Math.random() * 255)));
	}

	private Square generateNewApple() {
		int x = ((int) (Math.random() * (mapWidth / 20)) * 20);
		int y = ((int) (Math.random() * (mapHeight / 20)) * 20);
		int color = (int) (Math.random() * 16000000);
		// new apples can't be eated some times...
		while (x < 20 || y < 20 || x == 0 || y == 0 || x > 250 || y > 250) {
			System.out.println("SCORRO");
			x = ((int) (Math.random() * (mapWidth / 20)) * 20);
			y = ((int) (Math.random() * (mapHeight / 20)) * 20);
		}
		
		System.out.println(x + " - " + y + " - " + color);
		Square apple = new Square(x, y, 20, color);

		// Still infinite looping into this...
		while (snake.isOverlappingApple(apple)) {
			System.out.println("Checking is overlapping");
			while (x < 20 || y < 20 || x == 0 || y == 0) {
				System.out.println("SCORRO 2");
				x = ((int) (Math.random() * (mapWidth / 20)) * 20);
				y = ((int) (Math.random() * (mapHeight / 20)) * 20);
			}
			apple = new Square(x, y, 20, color);
		}

		return apple;
	}

	// check if already dead or is in pause menu
	private void checkStatus(int height, int weight) {
		if (playing && !inPauseMenu) {
			if (snake.isDead(height, weight)) {
				// we lost, stop the game and tell player that GAME OVER.
				playing = false;
				showEndMessage = true;
				showing = false;
			}
		}
	}

	// pause current game match (if was playing)
	private void pauseGame() {
		if (playing)
			inPauseMenu = !inPauseMenu;
	}

	// start game button logic
	private void startGamePressed() {
		this.startGameAgain();
		board.requestFocus();
	}

	// pause game button logic
	private void pauseGamePressed() {
		this.pauseGame();
		board.requestFocus();
	}

	private void selectMapSize() {
		String[] mapSizes = { "Pequeño", "Mediano", "Grande" };

		Object selected = JOptionPane.showInputDialog(null, "¿Que tamaño de mapa quieres jugar?", "Seleccion de mapas",
				JOptionPane.DEFAULT_OPTION, null, mapSizes, "0");

		if (selected != null) {
			String selectedString = selected.toString();

			if (selectedString.equals("Pequeño")) {
				mapHeight = 400;
				mapWidth = 400;
			} else if (selectedString.equals("Mediano")) {
				mapHeight = 600;
				mapWidth = 600;
			} else if (selectedString.equals("Grande")) {
				mapHeight = 800;
				mapWidth = 800;
			}
		} else {
			mapHeight = 400;
			mapWidth = 400;
		}
	}

	private void selectGamemode() {
		String[] gameModes = { "Facil", "Intermedio", "Dificil", "Imposible" };

		Object selected = JOptionPane.showInputDialog(null, "¿En qué dificultad quieres jugar?",
				"Seleccion de dificultad", JOptionPane.DEFAULT_OPTION, null, gameModes, "0");

		if (selected != null) {
			String selectedString = selected.toString();

			if (selectedString.equals("Facil")) {
				selectedGm = easyGM;
			} else if (selectedString.equals("Intermedio")) {
				selectedGm = normalGM;
			} else if (selectedString.equals("Dificil")) {
				selectedGm = hardGM;
			} else {
				selectedGm = hardcoreGM;
			}

		} else {
			selectedGm = normalGM;
		}
	}

	private void startGame() {
		// select gamemode first
		selectGamemode();

		timerCount = 0; // timer for game steps

		while (true) { // main game login run

			// game status update
			if (timerCount % 20 == 0) {
				timerCount++;
				for (int i = 0; i < selectedGm; i++) {
					this.moveTriggered();
				}

				if (apple.checkIsTouchingSquare(snake.getSnakeHead())) {

					// We grow up, update points
					pointsLbl.setText(Integer.toString(this.getSnake().getPoints()));
					apple = generateNewApple();
					
					this.makeBigger();
				}

				if (!hackEnabled)
					this.checkStatus(board.getHeight(), board.getWidth()); // Check if already lost the game

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
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
