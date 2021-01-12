package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import DAO.PokemonDAO;
import DAO.UserDAO;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import models.Pokemon;

public class AdminView {

	private JFrame frame;
	private JLabel lblPokedex;
	private JLabel label;
	private JLabel lblPreviewImage;
	private JPanel pokeInfoPanel;
	private JLabel lblPokeName;
	private JLabel lblPokeDescription;
	private JLabel lblPokeHeigh;
	private JLabel lblPokeWeight;
	private JLabel lblPokeCategory;
	private JLabel lblPokeAbility;
	private JButton btnPokeNext;
	private JButton btnPokePrevious;
	private JButton btnSignOut;
	private JLabel lblPokeNameText;
	private JLabel lblPokeCategoryText;
	private JLabel lblPokeAbilityText;
	private JLabel lblPokeHeighText;
	private JLabel lblPokeWeightText;
	private JLabel lblPokeDescriptionText;
	private JButton btnPlaySoundButton;
	private JLabel lblPokeNum;

	private int indexPokmeonList = 0;
	private ArrayList<Pokemon> allPokemons;

	/**
	 * Create the application.
	 * @param username 
	 */
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		allPokemons = new ArrayList<Pokemon>();
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setDBPokemons();
		setUIComponents();
		setListeners();
		showPokemon(0);

		frame.setVisible(true);
	}

	private void setDBPokemons() {
		allPokemons = PokemonDAO.getAllPokemons();
	}

	private void setUIComponents() {
		lblPokedex = new JLabel("[MODO ADMIN]");
		lblPokedex.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokedex.setForeground(Color.RED);
		lblPokedex.setFont(new Font("Leelawadee", Font.BOLD, 22));
		lblPokedex.setBounds(10, 3, 187, 38);
		frame.getContentPane().add(lblPokedex);

		label = new JLabel();
		label.setBounds(171, 43, -153, 173);
		frame.getContentPane().add(label);

		lblPreviewImage = new JLabel("");
		lblPreviewImage.setBounds(10, 60, 203, 191);
		frame.getContentPane().add(lblPreviewImage);

		pokeInfoPanel = new JPanel();
		pokeInfoPanel.setBorder(new LineBorder(new Color(0, 255, 255), 5, true));
		pokeInfoPanel.setBounds(223, 60, 319, 251);
		frame.getContentPane().add(pokeInfoPanel);
		pokeInfoPanel.setLayout(null);

		lblPokeName = new JLabel("Nombre:");
		lblPokeName.setBounds(10, 11, 59, 14);
		pokeInfoPanel.add(lblPokeName);

		lblPokeDescription = new JLabel("Descripci\u00F3n:");
		lblPokeDescription.setBounds(10, 111, 82, 14);
		pokeInfoPanel.add(lblPokeDescription);

		lblPokeHeigh = new JLabel("Altura:");
		lblPokeHeigh.setBounds(10, 86, 82, 14);
		pokeInfoPanel.add(lblPokeHeigh);

		lblPokeWeight = new JLabel("Peso:");
		lblPokeWeight.setBounds(176, 86, 46, 14);
		pokeInfoPanel.add(lblPokeWeight);

		lblPokeCategory = new JLabel("Categor\u00EDa:");
		lblPokeCategory.setBounds(10, 36, 65, 14);
		pokeInfoPanel.add(lblPokeCategory);

		lblPokeAbility = new JLabel("Habilidad:");
		lblPokeAbility.setBounds(10, 61, 59, 14);
		pokeInfoPanel.add(lblPokeAbility);

		lblPokeNameText = new JLabel("");
		lblPokeNameText.setBounds(70, 11, 140, 14);
		pokeInfoPanel.add(lblPokeNameText);

		lblPokeCategoryText = new JLabel("");
		lblPokeCategoryText.setBounds(85, 36, 224, 14);
		pokeInfoPanel.add(lblPokeCategoryText);

		lblPokeAbilityText = new JLabel("");
		lblPokeAbilityText.setVerticalAlignment(SwingConstants.TOP);
		lblPokeAbilityText.setBounds(70, 61, 232, 14);
		pokeInfoPanel.add(lblPokeAbilityText);

		lblPokeHeighText = new JLabel("");
		lblPokeHeighText.setBounds(102, 86, 64, 14);
		pokeInfoPanel.add(lblPokeHeighText);

		lblPokeWeightText = new JLabel("");
		lblPokeWeightText.setBounds(232, 86, 77, 14);
		pokeInfoPanel.add(lblPokeWeightText);

		lblPokeDescriptionText = new JLabel("");
		lblPokeDescriptionText.setVerticalAlignment(SwingConstants.TOP);
		lblPokeDescriptionText.setHorizontalAlignment(SwingConstants.LEFT);
		lblPokeDescriptionText.setBounds(102, 111, 207, 92);
		pokeInfoPanel.add(lblPokeDescriptionText);

		btnPlaySoundButton = new JButton("Sonido");
		btnPlaySoundButton.setBounds(220, 7, 89, 23);
		pokeInfoPanel.add(btnPlaySoundButton);

		btnPokeNext = new JButton("Siguiente");
		btnPokeNext.setBounds(124, 288, 89, 23);
		frame.getContentPane().add(btnPokeNext);

		btnPokePrevious = new JButton("Anterior");
		btnPokePrevious.setBounds(26, 288, 89, 23);
		frame.getContentPane().add(btnPokePrevious);

		btnSignOut = new JButton("Cerrar sesi\u00F3n");
		btnSignOut.setBounds(412, 322, 130, 23);
		frame.getContentPane().add(btnSignOut);
		
		lblPokeNum = new JLabel("N\u00FAmero:");
		lblPokeNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokeNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPokeNum.setBounds(26, 253, 187, 28);
		frame.getContentPane().add(lblPokeNum);
		
	}

	private void setListeners() {
		btnPokeNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nextPokemon();
			}

		});

		btnPokePrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				previousPokemon();
			}

		});

		btnSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				JOptionPane.showMessageDialog(frame, "You signed out", "INFO", JOptionPane.INFORMATION_MESSAGE);
				new LoginView();
			}

		});

		btnPlaySoundButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playCustomSound(indexPokmeonList);
			}

		});
	}

	private void nextPokemon() {
		if (indexPokmeonList < allPokemons.size() - 1) {
			showPokemon(++indexPokmeonList);
		}

	}

	private void previousPokemon() {
		if (indexPokmeonList > 0) {
			showPokemon(--indexPokmeonList);
		}

	}

	private void showPokemon(int index) {
		String currentNumber = String.valueOf(allPokemons.get(index).getpId());
		String currentName = allPokemons.get(index).getName();
		String currentCategories = PokemonDAO.getStringCategories(allPokemons.get(index).getName());
		String currentDescription = "<html><p>" + allPokemons.get(index).getDescription() + "</p></html>";
		String currentHeight = String.valueOf(allPokemons.get(index).getHeight()) + "m";
		String currentWeight = String.valueOf(allPokemons.get(index).getWeight()) + "kg";
		String currentAbility = allPokemons.get(index).getAbility();
		String currentUrl = allPokemons.get(index).getImageURL();

		lblPokeNum.setText("Número: " + currentNumber);
		lblPokeNameText.setText(currentName);
		lblPokeCategoryText.setText(currentCategories);
		lblPokeDescriptionText.setText(currentDescription);
		lblPokeHeighText.setText(currentHeight);
		lblPokeWeightText.setText(currentWeight);
		lblPokeAbilityText.setText(currentAbility);

		// Set preview image.
		BufferedImage img = null;
		try {
			img = ImageIO.read(new URL(currentUrl));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(lblPreviewImage.getWidth(), lblPreviewImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblPreviewImage.setIcon(imageIcon);
	}

	private void playCustomSound(int indexPokmeonList) {
		String soundURL = allPokemons.get(indexPokmeonList).getSoundURL();

		BasicPlayer player = new BasicPlayer();
		try {
		    player.open(new URL(soundURL));
		    player.play();
		} catch (BasicPlayerException | MalformedURLException e) {
		    e.printStackTrace();
		}

	}
}
