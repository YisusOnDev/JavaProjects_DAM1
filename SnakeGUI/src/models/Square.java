package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Square {
	static public final int Up = 1;
	static public final int Down = 2;
	static public final int Left = 3;
	static public final int Right = 4;

	private int posX;
	private int posY;
	private int side;
	private int squareColor;

	public Square(int pX, int pY, int l, int cc) {
		posX = pX;
		posY = pY;
		side = l;
		squareColor = cc;
	}

	// move square(s) (up, right, down or left)
	public void moveSide(int iDirection) {
		switch (iDirection) {
		case Square.Up:
			posY -= side;
			break;
		case Square.Down:
			posY += side;
			break;
		case Square.Left:
			posX -= side;
			break;
		case Square.Right:
			posX += side;

		}
	}

	// check if a square if above another
	public boolean checkIsTouchingSquare(Square otroC) {
		return (otroC.getX() == posX && otroC.getY() == posY);
	}

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public int getLado() {
		return side;
	}

	public int getColor() {
		return squareColor;
	}

	// paint square "logic"
	public void paint(Graphics2D g) {
		g.setColor(new Color(squareColor));
		g.fillRect(posX, posY, side, side);
	}
}
