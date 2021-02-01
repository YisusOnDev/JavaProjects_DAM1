package models;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import views.GameView;

public class KeyboardController implements KeyListener {

	private GameView snakeFrame;

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (snakeFrame != null) {
			snakeFrame.changeSnakeDirection(key);
		}
	}

	public void setSnakeFrame(GameView sf) {
		snakeFrame = sf;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}
