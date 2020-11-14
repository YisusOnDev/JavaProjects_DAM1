import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sumador {
	
	/*
	 * @author Jesús Téllez.	 * 
	 */
	
	private JFrame frame;
	private JTextField textNum1;
	private JTextField textNum2;
	private JTextField textResultado;
	private JTextField textLogger;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sumador window = new Sumador();
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
	public Sumador() {
		initialize();

		textLogger.setText("Sumador iniciado.");
		
		JLabel lblLogger = new JLabel("Logger");
		lblLogger.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogger.setBounds(10, 187, 46, 14);
		frame.getContentPane().add(lblLogger);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnSumar = new JButton("Sumar");
		
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNum1.getText().equals("") || textNum2.getText().equals("")) {
					textLogger.setText("Por favor, introduce un NÚMERO en ambos campos.");
				} else {
					String sum1 = textNum1.getText();
					String sum2 = textNum2.getText();
					boolean isNumber = true;
					
					try {
					     Integer.parseInt(sum1);
					     Integer.parseInt(sum2);
					     isNumber = true;
					}
					catch (NumberFormatException error) {
					    isNumber = false;
					}
					
					int resultado =  Integer.parseInt(sum1) + Integer.parseInt(sum2);
					
					if (isNumber) {
						textResultado.setText(Integer.toString(resultado));
						textLogger.setText("Realizada suma de " + sum1 + " + " + sum2);
					} else {
						textLogger.setText("Por favor, introduce NÚMEROS en ambos campos.");
					}
					
				}
				
			}
		});
		btnSumar.setBounds(66, 227, 89, 23);
		frame.getContentPane().add(btnSumar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //System.exit(0); // A lo bruto
				 frame.dispose(); // Correctamente
			}
		});
		btnSalir.setBounds(255, 227, 89, 23);
		frame.getContentPane().add(btnSalir);
		
		textNum1 = new JTextField();
		textNum1.setBounds(155, 68, 86, 20);
		frame.getContentPane().add(textNum1);
		textNum1.setColumns(10);
		
		textNum2 = new JTextField();
		textNum2.setBounds(155, 101, 86, 20);
		frame.getContentPane().add(textNum2);
		textNum2.setColumns(10);
		
		JLabel lblNumero2 = new JLabel("Numero 2");
		lblNumero2.setBounds(88, 100, 57, 23);
		frame.getContentPane().add(lblNumero2);
		
		JLabel lblNumero1 = new JLabel("Numero 1");
		lblNumero1.setBounds(88, 67, 57, 23);
		frame.getContentPane().add(lblNumero1);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(88, 148, 57, 14);
		frame.getContentPane().add(lblResultado);
		
		textResultado = new JTextField();
		textResultado.setBounds(155, 145, 86, 20);
		frame.getContentPane().add(textResultado);
		textResultado.setColumns(10);
		
		JLabel lblTitle = new JLabel("SUMADOR");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setBounds(66, 13, 278, 44);
		frame.getContentPane().add(lblTitle);
		
		textLogger = new JTextField();
		textLogger.setBounds(66, 184, 358, 20);
		frame.getContentPane().add(textLogger);
		textLogger.setColumns(10);
	}
}
