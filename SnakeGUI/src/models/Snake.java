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
		iDirection = Square.Down;

	}

	// Moverse. Una serpiente sabe moverse
	public void moveSnake() {

		Square nuevaCabeza;
		Square antiguaCabeza;

		// Primero cogemos la cabeza y la duplicamos
		antiguaCabeza = squareList.get(0);
		nuevaCabeza = new Square(antiguaCabeza.getX(), antiguaCabeza.getY(), antiguaCabeza.getLado(),
				antiguaCabeza.getColor());

		// movemos la cabeza a su nueva posición
		nuevaCabeza.moveSide(iDirection);

		// la añadimos a la lista
		squareList.add(0, nuevaCabeza);

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
	public boolean isDead(int iHeight, int iWeight) {
		boolean result;

		result = (isTouchingItSelf() || isOutOfGameArea(iHeight, iWeight));

		return result;
	}

	// check if is touching it self
	private boolean isTouchingItSelf() {
		int iCounter;
		Square head;

		head = squareList.get(0);

		for (iCounter = 1; iCounter < squareList.size(); iCounter++) {
			if (squareList.get(iCounter).checkIsTouchingItself(head))
				return true;
		}

		return false;
	}

	// check if we get out of game focus (window area)
	private boolean isOutOfGameArea(int iHeight, int iWeight) {
		// Use the head square of the snake as "base"
		Square snakeHead = squareList.get(0);

		return (snakeHead.getX() < 0 || snakeHead.getX() > iWeight || snakeHead.getY() < 0
				|| snakeHead.getY() > iHeight);
	}

	// la serpiente también sabe pintarse
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

}