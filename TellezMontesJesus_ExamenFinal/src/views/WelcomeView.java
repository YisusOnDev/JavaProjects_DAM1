package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import DAO.AlumnoDAO;

public class WelcomeView {

	private JFrame frmMenu;
	private JTable tblResults;
	private JLabel lblWelcome;
	
	private String curUsername;

	/**
	 * Create the application.
	 */
	public WelcomeView(String username) {
		this.curUsername = username;
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
		
		setUIComponents();
		setUIListeners();

		

	}
	
	private void setUIComponents() {
		lblWelcome = new JLabel("Bienvenido: " + curUsername);
		lblWelcome.setBounds(144, 24, 196, 16);
		frmMenu.getContentPane().add(lblWelcome);

		tblResults = new JTable();
		//TODO hacer que la tabla aparezca debajo de bienvenido y que sea scrolleable.
		//
		populateTable();
		
		frmMenu.setVisible(true);
	}
	
	private void setUIListeners() {
		//
	}

	private void populateTable() {
		var lista = AlumnoDAO.getAll();

		//TODO rellenar la tabla tblResults con la lista de alumnos.
	}
}
