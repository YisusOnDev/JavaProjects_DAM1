package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.UsuarioDAO;
import models.Usuario;

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
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		setUIComponents();
		setUIListeners();
	}

	private void setUIComponents() {
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(180, 33, 61, 16);
		frmLogin.getContentPane().add(lblLogin);

		usernameField = new JTextField();
		usernameField.setBounds(180, 94, 130, 26);
		frmLogin.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		lblUser = new JLabel("User");
		lblUser.setBounds(131, 99, 61, 16);
		frmLogin.getContentPane().add(lblUser);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(104, 148, 61, 16);
		frmLogin.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(180, 143, 130, 26);
		frmLogin.getContentPane().add(passwordField);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(75, 199, 117, 29);
		frmLogin.getContentPane().add(btnLogin);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(240, 199, 117, 29);
		frmLogin.getContentPane().add(btnRegister);
		frmLogin.setResizable(false);
		frmLogin.setVisible(true);
	}

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
	}

	private void Login() {
		UsuarioDAO UsuarioDAO = new UsuarioDAO();
		Usuario user = new Usuario(usernameField.getText(), new String(passwordField.getPassword()));
		if (!UsuarioDAO.login(user))
			JOptionPane.showMessageDialog(btnLogin, "Error de inicio de sesión.");
		else {
			new WelcomeView(user.getUsername());
			frmLogin.setVisible(false);
		}
	}
}
