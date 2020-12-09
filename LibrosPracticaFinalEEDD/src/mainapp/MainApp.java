package mainapp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import models.Libro;

public class MainApp {

	private JFrame frame;
	private JTextField textFieldISBN;
	private JTextField textFieldTitulo;
	private JTextField textFieldPrecio;
	private JComboBox<String> comboBoxAutor;
	private JCheckBox chckbxStock;
	private JLabel lblLogger;
	private ArrayList<Libro> lista;
	private int currentI = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
		inicializaArrayLibros();
		inicializaComboAutores();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(Color.BLACK));
		layeredPane.setBounds(31, 11, 469, 187);
		frame.getContentPane().add(layeredPane);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 56, 46, 14);
		layeredPane.add(lblTitulo);

		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setBounds(10, 81, 46, 14);
		layeredPane.add(lblISBN);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 110, 46, 14);
		layeredPane.add(lblAutor);

		chckbxStock = new JCheckBox("En Stock");
		chckbxStock.setBounds(69, 135, 97, 14);
		layeredPane.add(chckbxStock);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 157, 46, 14);
		layeredPane.add(lblPrecio);

		comboBoxAutor = new JComboBox<String>();
		comboBoxAutor.setBounds(66, 106, 197, 22);
		layeredPane.add(comboBoxAutor);

		textFieldISBN = new JTextField();
		textFieldISBN.setBounds(66, 78, 135, 20);
		layeredPane.add(textFieldISBN);
		textFieldISBN.setColumns(10);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(66, 53, 309, 20);
		layeredPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(66, 156, 86, 20);
		layeredPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		JLabel lblTituloApp = new JLabel("Datos de Libros ");
		lblTituloApp.setForeground(Color.BLUE);
		lblTituloApp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTituloApp.setBounds(69, 0, 268, 47);
		layeredPane.add(lblTituloApp);

		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentI > 0) {
					mostrarDatos(--currentI);
				}

			}
		});
		btnAnterior.setBounds(41, 212, 89, 23);
		frame.getContentPane().add(btnAnterior);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentI < lista.size() - 1) {
					mostrarDatos(++currentI);
				}
			}
		});
		btnSiguiente.setBounds(140, 212, 89, 23);
		frame.getContentPane().add(btnSiguiente);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearFrameProperly();
			}
		});
		btnNuevo.setBounds(312, 212, 89, 23);
		frame.getContentPane().add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveCurrentData();
			}
		});
		btnGuardar.setBounds(411, 212, 89, 23);
		frame.getContentPane().add(btnGuardar);

		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isFrameClear() && currentI >= 0 && currentI < lista.size()) {
					System.out.println(lista.get(currentI));
					lblLogger.setText("[Logger] Libro mostrado en Consola.");
				} else {
					lblLogger.setText("[Logger] No hay ningún libro seleccionado que imprimir por consola.");
				}
			}
		});
		btnImprimir.setBounds(411, 246, 89, 23);
		frame.getContentPane().add(btnImprimir);

		lblLogger = new JLabel("");
		lblLogger.setBackground(Color.WHITE);
		lblLogger.setBounds(31, 280, 469, 14);
		frame.getContentPane().add(lblLogger);

		lblLogger.setText("[Logger] Programa iniciado.");
		
		JButton btnMostrarTodos = new JButton("Mostrar Todos");
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Libro libro : lista) {
					System.out.println(libro);
				}
				lblLogger.setText("[Logger] Mostrado todos los libros");
			}
		});
		btnMostrarTodos.setBounds(281, 246, 120, 23);
		frame.getContentPane().add(btnMostrarTodos);
	}

	@SuppressWarnings("unchecked")
	private void inicializaComboAutores() {
		comboBoxAutor.addItem("");
		comboBoxAutor.addItem("George Orwell");
		comboBoxAutor.addItem("Miguel de Cervantes");
		comboBoxAutor.addItem("Julio Verne");
	}

	private void inicializaArrayLibros() {
		lista = new ArrayList<Libro>();
		Libro libro = new Libro("Viaje al Centro de la Tierra", "12345", "Julio Verne", true, 20.00);
		Libro libro1 = new Libro("1984", "23423421", "George Orwell", false, 23.00);
		lista.add(libro);
		lista.add(libro1);
	}

	private void mostrarDatos(int i) {
		Libro libro = lista.get(i);
		textFieldTitulo.setText(libro.getTitulo());
		textFieldISBN.setText(libro.getIsbn());
		comboBoxAutor.setSelectedItem(libro.getAutor());
		chckbxStock.setSelected(libro.isEnStock());
		textFieldPrecio.setText(libro.getPrecio().toString());
		lblLogger.setText("[Logger] Valores refrescados.");
	}

	private void clearFrameProperly() {
		textFieldTitulo.setText("");
		textFieldISBN.setText("");
		comboBoxAutor.setSelectedItem("");
		chckbxStock.setSelected(false);
		textFieldPrecio.setText("");
		lblLogger.setText("[Logger] Campos vaciados, si quieres añadir un libro escribe los valores y GUARDA.");
	}

	private void saveCurrentData() {
		if (isFrameClear()) {
			String titulo = textFieldTitulo.getText();
			String ISBN = textFieldISBN.getText();
			String selectedCombo = comboBoxAutor.getSelectedItem().toString();
			boolean stock = chckbxStock.isSelected();
			String precio = textFieldPrecio.getText();
			double precioNumber;
			try {
				precioNumber = Double.parseDouble(precio);
				Libro libro = new Libro(titulo, ISBN, selectedCombo, stock,  Double.parseDouble(precio));
				lista.add(libro);
				lblLogger.setText("[Logger] Libro añadido correctamente.");
			} catch (Exception e) {
				lblLogger.setText("[Logger] El precio introducido debe ser númerico.");
			}
		} else {
			lblLogger.setText("[Logger] Todos los parametros de texto deben estar rellenos.");
		}
	}

	private boolean isFrameClear() {
		if (!textFieldTitulo.getText().equalsIgnoreCase("") && !textFieldISBN.getText().equalsIgnoreCase("")
				&& !comboBoxAutor.getSelectedItem().toString().equalsIgnoreCase("")
				&& !textFieldPrecio.getText().equalsIgnoreCase("")) {
			return true;
		} else {
			return false;
		}

	}

}
