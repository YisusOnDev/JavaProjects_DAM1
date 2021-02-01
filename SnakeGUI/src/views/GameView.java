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
import panels.BoardPanel;

public class GameView extends JFrame {

	private static final long serialVersionUID = -6786273410349931728L;

	private Snake snake;
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

	private boolean hackEnabled = true; // enable or disable godmode (never RIP)

	public GameView() {
		snake = new Snake();
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
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel(new BorderLayout());

		board = new BoardPanel();
		board.setBorder(BorderFactory.createLineBorder(Color.black));
		board.setBackground(new java.awt.Color(250, 240, 200));
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
			snake.moveSnake();
	}

	// Start a new game. (reset all values)
	private void startGameAgain() {
		snake = new Snake();
		playing = true;
		showEndMessage = false;
		showing = false;
		inPauseMenu = false;
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

	private void startGame() {
		timerCount = 0; // timer for game steps

		while (true) { // main game login run

			// game status update
			if (timerCount % 20 == 0) {
				if (timerCount == 60) {
					timerCount = 0;
					this.makeBigger();

					// We grow up, update points
					pointsLbl.setText(Integer.toString(this.getSnake().getPoints()));
				} else {
					timerCount++;
					this.moveTriggered();
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
