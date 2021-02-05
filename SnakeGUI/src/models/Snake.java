package models;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {

	private ArrayList<Square> squareList;
	private int iDirection;

	/**
	 * Creates a "new" snake
	 */
	public Snake() {
		squareList = new ArrayList<Square>();

		// create the first square (snake start size)
		squareList.add(new Square(60, 60, 20, (int) (Math.random() * 16000000)));

		// make snake move to down
		int tempDirection = (int) (Math.random() * 4) + 1;

		iDirection = tempDirection;

	}

	// snake movement
	public void moveSnake(int sHeight, int sWidht) {
		Square oldSnakeHead;
		oldSnakeHead = squareList.get(0);

		int newHeadX = oldSnakeHead.getX();
		int newHeadY = oldSnakeHead.getY();

		switch (iDirection) {
		case (Square.Down):
			if (oldSnakeHead.getY() >= sHeight) {
				newHeadY = -20;
			}

			break;
		case (Square.Up):
			if (oldSnakeHead.getY() <= 0) {
				newHeadY = sHeight;
			}

			break;

		case (Square.Left):
			if (oldSnakeHead.getX() <= 0) {
				newHeadX = sWidht;
			}
			break;

		case (Square.Right):
			if (oldSnakeHead.getX() >= sWidht) {
				newHeadX = -20;
			}
			break;
		}

		Square newSnakeHead;
		newSnakeHead = new Square(newHeadX, newHeadY, oldSnakeHead.getLado(), oldSnakeHead.getColor());

		// movemos la cabeza a su nueva posición
		newSnakeHead.moveSide(iDirection);

		// la añadimos a la lista
		squareList.add(0, newSnakeHead);

		// borramos el último cuadrado por la cola (pop del basic)
		squareList.remove(squareList.size() - 1);
	}

	// make snake bigger
	public void growUp() {
		Square newHead;
		Square oldHead;

		// oldHead is just the entire current snake
		oldHead = squareList.get(0);

		// clone oldHead (current) and add 1 new square
		newHead = new Square(oldHead.getX(), oldHead.getY(), oldHead.getLado(), oldHead.getColor());

		newHead.moveSide(iDirection);

		// add newHead to the square list ("new snake")
		squareList.add(0, newHead);
	}

	// check if snake "dead" (hitted itself or got out of game area
	public boolean isDead(int iHeight, int iWidth) {

		boolean result;

		result = isTouchingItSelf();

		return result;
	}

	// check if is touching it self
	private boolean isTouchingItSelf() {
		int iCounter;
		Square head;

		head = squareList.get(0);

		for (iCounter = 1; iCounter < squareList.size(); iCounter++) {
			if (squareList.get(iCounter).checkIsTouchingSquare(head))
				return true;
		}

		return false;
	}

	public boolean isOverlappingApple(Square sq) {
		for (int i = 0; i < squareList.size(); i++) {
			if (squareList.get(i).checkIsTouchingSquare(sq)) {
				return true;
			}
		}
		return false;

	}

	// paint the snake itself
	public void paint(Graphics2D g) {
		int iCounter;
		for (iCounter = 0; iCounter < squareList.size(); iCounter++) {
			squareList.get(iCounter).paint(g);
		}
	}

	// keyboard control for the snake direction trigger
	public void changeDirection(int key) {
		switch (key) {
		case KeyEvent.VK_W:
			iDirection = Square.Up;
			break;
		case KeyEvent.VK_A:
			iDirection = Square.Left;
			break;
		case KeyEvent.VK_S:
			iDirection = Square.Down;
			break;
		case KeyEvent.VK_D:
			iDirection = Square.Right;
			break;
		case KeyEvent.VK_UP:
			iDirection = Square.Up;
			break;
		case KeyEvent.VK_LEFT:
			iDirection = Square.Left;
			break;
		case KeyEvent.VK_DOWN:
			iDirection = Square.Down;
			break;
		case KeyEvent.VK_RIGHT:
			iDirection = Square.Right;
			break;
		}
	}

	public int getPoints() {
		// points are just the snake size
		return squareList.size();
	}

	public Square getSnakeHead() {
		return squareList.get(0);
	}

}