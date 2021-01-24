package views;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.LoginDAO;
import javax.swing.SwingConstants;

public class LoginView {

	private JFrame frame;
	private JTextField tfUsername;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblBienvenido;
	private JButton btnRegister;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 378, 248);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		setUIComponents();
		setListeners();

		frame.setVisible(true);
	}

	/**
	 * Method that sets all UI Components
	 */
	private void setUIComponents() {
		lblUsername = new JLabel("Usuario:");
		lblUsername.setBounds(103, 79, 59, 14);
		frame.getContentPane().add(lblUsername);

		tfUsername = new JTextField();
		tfUsername.setBounds(172, 76, 86, 20);
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);

		lblPassword = new JLabel("Clave:");
		lblPassword.setBounds(103, 104, 59, 14);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(172, 101, 86, 20);
		frame.getContentPane().add(passwordField);

		btnLogin = new JButton("Iniciar sesion");
		btnLogin.setBounds(71, 144, 119, 23);
		frame.getContentPane().add(btnLogin);

		lblBienvenido = new JLabel("Pokedex - Inicio");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblBienvenido.setBounds(71, 11, 236, 42);
		frame.getContentPane().add(lblBienvenido);

		btnRegister = new JButton("Registrarse");
		btnRegister.setBounds(200, 144, 107, 23);
		frame.getContentPane().add(btnRegister);
	}

	/**
	 * Method that set listeners and events
	 */
	private void setListeners() {
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginPressed();
			}
		});

		var loginLogic = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginPressed();
				}
			}
		};

		passwordField.addKeyListener(loginLogic);
		tfUsername.addKeyListener(loginLogic);

		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new RegisterView();
			}
		});
	}

	private void loginPressed() {
		String username = tfUsername.getText();
		String password = new String(passwordField.getPassword());
		if (new LoginDAO().login(username, password)) {
			frame.dispose();
			new PokemonView(username);
		} else {
			JOptionPane.showMessageDialog(frame, "Datos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
