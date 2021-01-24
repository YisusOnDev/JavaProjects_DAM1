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

		btnLogin = new JButton("Register");
		btnLogin.setBounds(79, 175, 89, 23);
		frame.getContentPane().add(btnLogin);

		lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblRegister.setBounds(124, 11, 107, 42);
		frame.getContentPane().add(lblRegister);

		lblRegister2 = new JLabel("Confirm Password");
		lblRegister2.setBounds(50, 130, 100, 14);
		frame.getContentPane().add(lblRegister2);

		passwordField2 = new JPasswordField();
		passwordField2.setBounds(160, 127, 86, 20);
		frame.getContentPane().add(passwordField2);

		btnCancelRegister = new JButton("Cancel");
		btnCancelRegister.setBounds(178, 175, 89, 23);
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
						JOptionPane.showMessageDialog(frame, "You have successfully registered.", "OK",
								JOptionPane.INFORMATION_MESSAGE);
						setLoginFrame();
					} else {
						JOptionPane.showMessageDialog(frame, "That username alredy exist, please try again...", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Username can't be empty or only whitespaces...", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Passwords doesn't match, please try again...", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Password can't be empty or only whitespaces...", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void setLoginFrame() {
		frame.dispose();
		new LoginView();
	}
}
