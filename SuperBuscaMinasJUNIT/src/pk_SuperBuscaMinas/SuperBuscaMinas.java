package pk_SuperBuscaMinas;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Clase para controlar la ventana principal del juego
 *
 */
public class SuperBuscaMinas {

	private JFrame frmBuscaMinas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperBuscaMinas window = new SuperBuscaMinas();
					window.frmBuscaMinas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SuperBuscaMinas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscaMinas = new JFrame();
		Tablero tablero = new Tablero();
		
		frmBuscaMinas.setTitle("Busca Minas");
		frmBuscaMinas.setBounds(0, 0, tablero.WINDOW_HORIZONTAL_SIZE, tablero.WINDOW_VERTICAL_SIZE);
		frmBuscaMinas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmBuscaMinas.getContentPane().setLayout(null);		
		frmBuscaMinas.getContentPane().add(tablero.crearPanelBuscaMinas());		
	}
}
