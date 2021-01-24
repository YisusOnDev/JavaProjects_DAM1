package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Esta clase es también un ejemplo de como Java.awt controla la E/S de teclado.
 * Para tener control de las pulsaciones de teclado tenemos que implementar una clase
 * que herede de KeyListener, que se encarga de escuchar las pulsaciones del teclado
 * Una vez heredamos, sólo implementamos el keyPressed, y el método típico de 
 * "enganche" entre el Control de Teclado y el snakeFrame (controlador del juego)
 * @author andres
 *
 */

public class ControlTeclado implements KeyListener {
	
	//Este es un enlace al controlador del videojuego
	private MySnakeFrame snakeFrame;
	
	
	//si pulsan una tecla se activa este comportamiento. KeyEvent es un objeto con un montón
	//de información, entre otras cosas el código ASCII de la tecla pulsada, que es lo que nos 
	//interesa darle al controlador del videojuego para que se lo pase a la serpiente.
	@Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (snakeFrame != null) {
        	snakeFrame.cambiaDireccion(key); 
        }
    }
	
	public void setSnakeFrame(MySnakeFrame sf) {
		snakeFrame = sf;
	}

	//Estos dos no hace falta reimplementarlos.
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
