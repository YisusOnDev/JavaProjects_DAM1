package mainapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import models.Alumno;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainApp {

	private JFrame frame;
	private JTextField textNumAlum;
	private JTextField textNombreAlum;
	private JTextField textGrupoAlum;
	private int indiceListaAlumnos = 0;
	private static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		listaAlumnos = new ArrayList<Alumno>();
		listaAlumnos.add(new Alumno(1, "Carlos Saborido", " 1 DAM"));
		listaAlumnos.add(new Alumno(2, "Pepe Villuela", "1 DAW"));
		listaAlumnos.add(new Alumno(3, "Lidia Dominguez", "1 DAM"));
		listaAlumnos.add(new Alumno(4, "Rebecca García Jimenez", "1 DAM"));

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 204));
		frame.getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("Alta de Alumnos");
		lblTitle.setBounds(0, 11, 434, 26);
		lblTitle.setForeground(new Color(51, 102, 204));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTitle);

		textNumAlum = new JTextField();
		textNumAlum.setBounds(118, 79, 86, 20);
		frame.getContentPane().add(textNumAlum);
		textNumAlum.setColumns(10);

		textNombreAlum = new JTextField();
		textNombreAlum.setBounds(118, 110, 152, 20);
		frame.getContentPane().add(textNombreAlum);
		textNombreAlum.setColumns(10);

		textGrupoAlum = new JTextField();
		textGrupoAlum.setBounds(118, 141, 86, 20);
		frame.getContentPane().add(textGrupoAlum);
		textGrupoAlum.setColumns(10);

		JLabel lblGrupoAlum = new JLabel("Grupo");
		lblGrupoAlum.setBounds(10, 143, 98, 14);
		lblGrupoAlum.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblGrupoAlum);

		JLabel lblNumAlum_1 = new JLabel("Numero Alumno");
		lblNumAlum_1.setBounds(10, 81, 98, 14);
		lblNumAlum_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNumAlum_1);

		JLabel lblNombreAlum = new JLabel("Nombre");
		lblNombreAlum.setBounds(10, 112, 98, 14);
		lblNombreAlum.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNombreAlum);

		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (indiceListaAlumnos > 0) {
					mostrarAlumno(listaAlumnos, --indiceListaAlumnos);
				} else {
					indiceListaAlumnos = listaAlumnos.size() - 1;
					mostrarAlumno(listaAlumnos, indiceListaAlumnos);
				}
			}
		});
		btnAnterior.setBounds(19, 211, 89, 23);
		frame.getContentPane().add(btnAnterior);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (indiceListaAlumnos < listaAlumnos.size() -1) {
					mostrarAlumno(listaAlumnos, ++indiceListaAlumnos);
				} else {
					indiceListaAlumnos = 0;
					mostrarAlumno(listaAlumnos, indiceListaAlumnos);
				}
				
			}
		});
		btnSiguiente.setBounds(118, 211, 89, 23);
		frame.getContentPane().add(btnSiguiente);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnSalir.setBounds(335, 211, 89, 23);
		frame.getContentPane().add(btnSalir);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(335, 78, 89, 23);
		frame.getContentPane().add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String indiceAlumno = textNumAlum.getText();
				
			}
		});
		btnGuardar.setBounds(335, 109, 89, 23);
		frame.getContentPane().add(btnGuardar);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Recibe una lista y un indice y muestra lo que ahí en él.
	 * @param lista
	 * @param indice
	 */
	public void mostrarAlumno(ArrayList<Alumno> lista, int indice) {
		textNumAlum.setText(lista.get(indice).getNum());
		textNombreAlum.setText(lista.get(indice).getNombre());
		textGrupoAlum.setText(lista.get(indice).getGrupo());
	}

}