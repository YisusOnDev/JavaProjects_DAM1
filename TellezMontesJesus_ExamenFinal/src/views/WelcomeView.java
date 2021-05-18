package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import DAO.AlumnoDAO;

public class WelcomeView {

	private JFrame frmMenu;
	private JTable tblResults;

	/**
	 * Create the application.
	 */
	public WelcomeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 650, 500);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);

		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(144, 24, 196, 16);
		frmMenu.getContentPane().add(lblBienvenido);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(155, 243, 117, 29);
		frmMenu.getContentPane().add(btnBuscar);

		tblResults = new JTable();

		//TODO hacer que la tabla aparezca debajo de bienvenido y que sea scrolleable.
		
		frmMenu.setVisible(true);

	}

	private void populateTable() {
		var lista = AlumnoDAO.getAll();

		//TODO rellenar la tabla tblResults con la lista de alumnos.
	}
}
