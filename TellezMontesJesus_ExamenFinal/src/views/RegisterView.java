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
import javax.swing.SwingConstants;

import DAO.UsuarioDAO;
import models.Usuario;

public class RegisterView {

	private JFrame frmRegister;
	private JTextField tfUsername;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblRegister;
	private JPasswordField passwordField2;
	private JLabel lblRegister2;
	private UsuarioDAO userDAO;
	private JButton btnCancelRegister;

	/**
	 * Create the application.
	 */
	public RegisterView() {
		initialize();
		userDAO = new UsuarioDAO();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.setTitle("Register");
		frmRegister.setBounds(100, 100, 378, 248);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		frmRegister.setResizable(false);

		setUIComponents();
		setListeners();

		frmRegister.setVisible(true);
	}

	/**
	 * Method that sets all UI Components
	 */
	private void setUIComponents() {
		lblUsername = new JLabel("Usuario:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(121, 74, 59, 14);
		frmRegister.getContentPane().add(lblUsername);

		tfUsername = new JTextField();
		tfUsername.setBounds(190, 71, 86, 20);
		frmRegister.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);

		lblPassword = new JLabel("Clave:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(121, 102, 59, 14);
		frmRegister.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(190, 99, 86, 20);
		frmRegister.getContentPane().add(passwordField);

		btnLogin = new JButton("Registrarse");
		btnLogin.setBounds(64, 172, 116, 23);
		frmRegister.getContentPane().add(btnLogin);

		lblRegister = new JLabel("Registro");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblRegister.setBounds(50, 11, 274, 42);
		frmRegister.getContentPane().add(lblRegister);

		lblRegister2 = new JLabel("Confirmar clave:");
		lblRegister2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegister2.setBounds(80, 127, 100, 14);
		frmRegister.getContentPane().add(lblRegister2);

		passwordField2 = new JPasswordField();
		passwordField2.setBounds(190, 124, 86, 20);
		frmRegister.getContentPane().add(passwordField2);

		btnCancelRegister = new JButton("Cancelar");
		btnCancelRegister.setBounds(190, 172, 108, 23);
		frmRegister.getContentPane().add(btnCancelRegister);
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

	/**
	 * Register button pressed Logic
	 */
	private void registerButtonPressed() {
		String username = tfUsername.getText();
		String password = new String(passwordField.getPassword());
		String password2 = new String(passwordField2.getPassword());
		if (!password.isBlank()) {
			if (password.equals(password2)) {
				if (!username.isBlank()) {
					Usuario user = new Usuario(username, password);
					if (userDAO.insert(user)) {
						JOptionPane.showMessageDialog(frmRegister, "Te has registrado correctamente.", "OK",
								JOptionPane.INFORMATION_MESSAGE);
						setLoginFrame();
					} else {
						JOptionPane.showMessageDialog(frmRegister, "Ese usuario ya existe, por favor introduce otro",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frmRegister,
							"El usuario no puede estar vacio o contener espacios en blanco", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(frmRegister, "Las claves no coinciden", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frmRegister, "La clave no puede estar vacia o contener espacios en blanco",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Method that set the user to LoginView again
	 */
	private void setLoginFrame() {
		frmRegister.dispose();
		new LoginView();
	}
}
