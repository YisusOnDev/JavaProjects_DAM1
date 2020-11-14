import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PantallaAlumnos {

	private JFrame frame;
	private JTextField textNumAlum;
	private JTextField textNombreAlum;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAlumnos window = new PantallaAlumnos();
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
	public PantallaAlumnos() {
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
		lblTitle.setForeground(new Color(51, 102, 204));
		lblTitle.setBounds(0, 11, 434, 26);
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
		
		textField = new JTextField();
		textField.setBounds(118, 141, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblGrupoAlum = new JLabel("Grupo");
		lblGrupoAlum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGrupoAlum.setBounds(10, 143, 98, 14);
		frame.getContentPane().add(lblGrupoAlum);
		
		JLabel lblNumAlum_1 = new JLabel("Numero Alumno");
		lblNumAlum_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumAlum_1.setBounds(10, 81, 98, 14);
		frame.getContentPane().add(lblNumAlum_1);
		
		JLabel lblNombreAlum = new JLabel("Nombre");
		lblNombreAlum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreAlum.setBounds(10, 112, 98, 14);
		frame.getContentPane().add(lblNombreAlum);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(19, 211, 89, 23);
		frame.getContentPane().add(btnAnterior);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(118, 211, 89, 23);
		frame.getContentPane().add(btnSiguiente);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(335, 211, 89, 23);
		frame.getContentPane().add(btnSalir);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(335, 78, 89, 23);
		frame.getContentPane().add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(335, 109, 89, 23);
		frame.getContentPane().add(btnGuardar);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
