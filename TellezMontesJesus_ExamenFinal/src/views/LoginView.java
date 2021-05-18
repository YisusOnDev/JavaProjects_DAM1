package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.UsuarioDAO;
import models.Usuario;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LoginView {

	private JFrame frmLogin;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel lblLogin;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JButton btnLogin;
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
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 395, 235);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		setUIComponents();
		setUIListeners();
	}

	/**
	 * Sets UI Components
	 */
	private void setUIComponents() {
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setBounds(10, 11, 369, 38);
		frmLogin.getContentPane().add(lblLogin);

		usernameField = new JTextField();
		usernameField.setBounds(163, 60, 130, 26);
		frmLogin.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(92, 65, 61, 16);
		frmLogin.getContentPane().add(lblUser);

		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(92, 102, 61, 16);
		frmLogin.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(163, 97, 130, 26);
		frmLogin.getContentPane().add(passwordField);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(68, 152, 117, 29);
		frmLogin.getContentPane().add(btnLogin);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(208, 152, 117, 29);
		frmLogin.getContentPane().add(btnRegister);
		frmLogin.setResizable(false);
		frmLogin.setVisible(true);
	}

	/**
	 * Sets UI Listeners
	 */
	private void setUIListeners() {
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
				new RegisterView();
			}
		});

		var pressButtonLogin = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Login();
				}
			}
		};

		passwordField.addKeyListener(pressButtonLogin);
	}

	/**
	 * Login Button Logic
	 */
	private void Login() {
		UsuarioDAO UsuarioDAO = new UsuarioDAO();
		Usuario user = new Usuario(usernameField.getText(), new String(passwordField.getPassword()));
		if (!UsuarioDAO.login(user))
			JOptionPane.showMessageDialog(btnLogin,
					"Error de inicio de sesión. Comprueba que todos los campos son correctos.");
		else {
			new WelcomeView(user.getUsername());
			frmLogin.setVisible(false);
		}
	}
}
