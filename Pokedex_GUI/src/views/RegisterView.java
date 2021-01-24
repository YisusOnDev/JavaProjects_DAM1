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

import DAO.UserDAO;
import javax.swing.SwingConstants;

public class RegisterView {

	private JFrame frame;
	private JTextField tfUsername;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblRegister;
	private JPasswordField passwordField2;
	private JLabel lblRegister2;
	private UserDAO userDAO;
	private JButton btnCancelRegister;

	/**
	 * Create the application.
	 */
	public RegisterView() {
		initialize();
		userDAO = new UserDAO();
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
		lblUsername.setBounds(121, 74, 59, 14);
		frame.getContentPane().add(lblUsername);

		tfUsername = new JTextField();
		tfUsername.setBounds(190, 71, 86, 20);
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);

		lblPassword = new JLabel("Clave");
		lblPassword.setBounds(121, 102, 59, 14);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(190, 99, 86, 20);
		frame.getContentPane().add(passwordField);

		btnLogin = new JButton("Registrarse");
		btnLogin.setBounds(83, 172, 97, 23);
		frame.getContentPane().add(btnLogin);

		lblRegister = new JLabel("Pokedex - Registro");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblRegister.setBounds(50, 11, 274, 42);
		frame.getContentPane().add(lblRegister);

		lblRegister2 = new JLabel("Confirmar clave:");
		lblRegister2.setBounds(80, 127, 100, 14);
		frame.getContentPane().add(lblRegister2);

		passwordField2 = new JPasswordField();
		passwordField2.setBounds(190, 124, 86, 20);
		frame.getContentPane().add(passwordField2);

		btnCancelRegister = new JButton("Cancelar");
		btnCancelRegister.setBounds(190, 172, 89, 23);
		frame.getContentPane().add(btnCancelRegister);
	}

	/**
	 * Method that set listeners and events
	 */
	private void setListeners() {
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registerButtonPressed();
			}
		});

		btnCancelRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setLoginFrame();
			}
		});

		var registerLogic = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					registerButtonPressed();
				}
			}
		};

		passwordField2.addKeyListener(registerLogic);
	}

	private void registerButtonPressed() {
		String username = tfUsername.getText();
		String password = new String(passwordField.getPassword());
		String password2 = new String(passwordField2.getPassword());
		if (!password.isBlank()) {
			if (password.equals(password2)) {
				if (!username.isBlank()) {
					if (!userDAO.checkUsername(username)) {
						userDAO.registerUser(username, password2);
						JOptionPane.showMessageDialog(frame, "Te has registrado correctamente.", "OK",
								JOptionPane.INFORMATION_MESSAGE);
						setLoginFrame();
					} else {
						JOptionPane.showMessageDialog(frame, "Ese usuario ya existe, por favor introduce otro", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "El usuario no puede estar vacio o contener espacios en blanco", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Las claves no coinciden", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "La clave no puede estar vacia o contener espacios en blanco", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void setLoginFrame() {
		frame.dispose();
		new LoginView();
	}
}
