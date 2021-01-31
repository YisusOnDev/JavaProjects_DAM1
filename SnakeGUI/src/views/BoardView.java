package views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * Necesitamos una clase JPanel que represente nuestro board y que a la hora de
 * pintarse le diga a la serpiente que también se pinte. Para ello necesita
 * saber quién está controlando el juego (el frame de tipo MySnakeFrame) y
 * hacer un "override" del método paint.
 * 
 * 
 * @author andres
 *
 */

public class BoardView extends JPanel {

	private static final long serialVersionUID = 8108583999581542931L;
	private GameView snakeFrame;

	// comportamiento para "enganchar" el board con el frame controlador.
	public void setSnakeFrame(GameView sf) {
		snakeFrame = sf;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (snakeFrame != null) { // pintamos si tenemos serpiente
			Graphics2D g2d = (Graphics2D) g;
			// configuramos los gráficos para que pinte figuras suaves...
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// le decimos al controlador que nos de la serpiente para pintarla...
			snakeFrame.getSerpiente().pintarse(g2d);
		}
	}
}
