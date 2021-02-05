package views;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView {

	private JFrame frame;

	private JLabel lblTitle;
	private JLabel lblDifficulty;
	private JComboBox<String> cBoxDifficulty;
	private JComboBox<String> cBoxSize;
	private JLabel lblSize;
	private JButton btnPlay;

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 224);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		setUIComponents();
		setListeners();

		frame.setVisible(true);

	}

	private void setUIComponents() {
		lblTitle = new JLabel("El juego de la serpiente");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(63, 11, 288, 37);
		frame.getContentPane().add(lblTitle);

		lblDifficulty = new JLabel("Dificultad:");
		lblDifficulty.setBounds(92, 69, 90, 14);
		frame.getContentPane().add(lblDifficulty);

		cBoxDifficulty = new JComboBox<String>();
		cBoxDifficulty.setBounds(192, 65, 128, 22);
		frame.getContentPane().add(cBoxDifficulty);

		cBoxSize = new JComboBox<String>();
		cBoxSize.setBounds(192, 94, 128, 22);
		frame.getContentPane().add(cBoxSize);

		lblSize = new JLabel("Tama\u00F1o:");
		lblSize.setBounds(92, 98, 90, 14);
		frame.getContentPane().add(lblSize);

		btnPlay = new JButton("Jugar");
		btnPlay.setBounds(157, 142, 89, 23);
		frame.getContentPane().add(btnPlay);

	}

	private void setListeners() {
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playButtonPressed();
			}
		});

	}
	
	private void playButtonPressed() {
		new GameView();
	}
}
