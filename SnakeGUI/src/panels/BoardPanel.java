package panels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import views.GameView;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 8108583999581542931L;
	private GameView snakeFrame;

	// set the parent frame to the board
	public void setSnakeFrame(GameView sf) {
		snakeFrame = sf;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (snakeFrame != null) { // if we have the snake frame then paint.
			Graphics2D g2d = (Graphics2D) g;

			// graphics "cfg"
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// get the snake and print
			snakeFrame.getSnake().paint(g2d);
		}
	}
}
