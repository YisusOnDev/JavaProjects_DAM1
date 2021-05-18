package views;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.AlumnoDAO;
import models.Alumno;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeView {

	private JFrame frmMenu;
	private JTable tblResults;
	private JLabel lblWelcome;
	private JButton btnExit;
	private DefaultTableModel tblResultsTableModel;
	private TableRowSorter<TableModel> rowSorter;

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
		frmMenu.setTitle("Menu Alumnos");
		frmMenu.setBounds(100, 100, 650, 540);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);

		setUIComponents();
		setUIListeners();

	}

	/**
	 * Sets UI Components
	 */
	private void setUIComponents() {
		lblWelcome = new JLabel("Bienvenido: " + curUsername);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcome.setBounds(20, 11, 604, 51);
		frmMenu.getContentPane().add(lblWelcome);

		tblResults = new JTable();
		String dataCol[] = { "ID", "Nombre", "Nota" };
		tblResultsTableModel = new DefaultTableModel(dataCol, 0);

		tblResults = new JTable(tblResultsTableModel) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tblResults.setDragEnabled(false);
		tblResults.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(tblResults);
		scrollPane.setBounds(10, 73, 614, 377);
		frmMenu.getContentPane().add(scrollPane);
		populateTable();

		rowSorter = new TableRowSorter<>(tblResults.getModel());
		tblResults.setRowSorter(rowSorter);
		tblResults.setAutoCreateRowSorter(true);

		btnExit = new JButton("Cerrar sesion");
		btnExit.setBounds(460, 477, 161, 23);
		frmMenu.getContentPane().add(btnExit);

		populateTable();
		frmMenu.setResizable(false);
		frmMenu.setVisible(true);
	}

	/**
	 * Sets UI Listensers
	 */
	private void setUIListeners() {
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				new LoginView();
			}
		});
	}

	/**
	 * Method that fill tblResults with DB Data
	 */
	private void populateTable() {
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		ArrayList<Alumno> alumnList = alumnoDAO.getAll();

		tblResultsTableModel.setRowCount(0);

		for (Alumno a : alumnList) {
			Object[] detailRow = { a.getNumero(), a.getNombre(), a.getNota() };
			tblResultsTableModel.addRow(detailRow);
		}
	}
}
