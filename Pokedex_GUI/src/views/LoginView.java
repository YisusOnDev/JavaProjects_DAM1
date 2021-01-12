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

		setUIComponents();
		setListeners();

		frame.setVisible(true);
	}

	private void setUIComponents() {
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(91, 80, 59, 14);
		frame.getContentPane().add(lblUsername);

		tfUsername = new JTextField();
		tfUsername.setBounds(160, 77, 86, 20);
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(91, 105, 59, 14);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(160, 102, 86, 20);
		frame.getContentPane().add(passwordField);

		btnLogin = new JButton("Log in");
		btnLogin.setBounds(91, 144, 89, 23);
		frame.getContentPane().add(btnLogin);

		lblBienvenido = new JLabel("Welcome");
		lblBienvenido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblBienvenido.setBounds(124, 11, 107, 42);
		frame.getContentPane().add(lblBienvenido);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(190, 144, 89, 23);
		frame.getContentPane().add(btnRegister);
	}

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
		if (LoginDAO.login(username, password)) {
			System.out.println("Login successfull...");
			frame.dispose();
			new PokemonView(username );
		} else {
			System.out.println("Login failed...");

			JOptionPane.showMessageDialog(frame, "Login failed", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
