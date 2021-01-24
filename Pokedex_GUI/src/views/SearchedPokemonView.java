package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import DAO.UserDAO;
import models.Pokemon;
import models.Utils;

public class SearchedPokemonView {

	private JFrame frame;
	private JLabel lblSearched;
	private JLabel label;
	private JLabel lblPreviewImage;
	private JPanel pokeInfoPanel;
	private JLabel lblPokeName;
	private JLabel lblPokeDescription;
	private JLabel lblPokeHeigh;
	private JLabel lblPokeWeight;
	private JLabel lblPokeTypes;
	private JLabel lblPokeAbility;
	private JButton btnPokeNext;
	private JButton btnPokePrevious;
	private JButton btnSignOut;
	private JLabel lblPokeNameText;
	private JLabel lblPokeTypesText;
	private JLabel lblPokeAbilityText;
	private JLabel lblPokeHeighText;
	private JLabel lblPokeWeightText;
	private JTextArea lblPokeDescriptionText;
	private JButton btnPlaySoundButton;
	private JLabel lblPokeNum;
	private JButton btnPokeAdmin;
	private JButton btnSearch;
	private JLabel lblPokeCategoryText;
	private JLabel lblPokeCategory;

	private String currentUsername;
	private JFrame parentFrame;
	private int indexPokmeonList = 0;
	private ArrayList<Pokemon> searchedPokemons;

	/**
	 * Create the application with Admin check support
	 * 
	 * @param searchFrame      the parent frame
	 * @param currentUsername  the currentUsername who logged in
	 * @param filteredPokemons the arraylist with all filtered pokemons
	 */
	public SearchedPokemonView(JFrame searchFrame, String username, ArrayList<Pokemon> filteredPokemons) {
		currentUsername = username;
		parentFrame = searchFrame;
		searchedPokemons = filteredPokemons;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		setUIComponents();
		setListeners();
		showPokemon(0);

		frame.setVisible(true);
	}

	/**
	 * Method that sets all UI Components
	 */
	private void setUIComponents() {
		lblSearched = new JLabel("Resultado de la busqueda");
		lblSearched.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearched.setForeground(Color.RED);
		lblSearched.setFont(new Font("Leelawadee", Font.BOLD, 30));
		lblSearched.setBounds(21, 11, 407, 46);
		frame.getContentPane().add(lblSearched);

		label = new JLabel();
		label.setBounds(171, 43, -153, 173);
		frame.getContentPane().add(label);

		lblPreviewImage = new JLabel("");
		lblPreviewImage.setBounds(10, 60, 203, 191);
		frame.getContentPane().add(lblPreviewImage);

		pokeInfoPanel = new JPanel();
		pokeInfoPanel.setBorder(new LineBorder(new Color(0, 255, 255), 5, true));
		pokeInfoPanel.setBounds(223, 60, 319, 304);
		frame.getContentPane().add(pokeInfoPanel);
		pokeInfoPanel.setLayout(null);

		lblPokeName = new JLabel("Nombre:");
		lblPokeName.setBounds(10, 11, 59, 14);
		pokeInfoPanel.add(lblPokeName);

		lblPokeDescription = new JLabel("Descripci\u00F3n:");
		lblPokeDescription.setBounds(10, 138, 82, 14);
		pokeInfoPanel.add(lblPokeDescription);

		lblPokeHeigh = new JLabel("Altura:");
		lblPokeHeigh.setBounds(10, 111, 82, 14);
		pokeInfoPanel.add(lblPokeHeigh);

		lblPokeWeight = new JLabel("Peso:");
		lblPokeWeight.setBounds(176, 111, 46, 14);
		pokeInfoPanel.add(lblPokeWeight);

		lblPokeTypes = new JLabel("Tipo:");
		lblPokeTypes.setBounds(10, 36, 65, 14);
		pokeInfoPanel.add(lblPokeTypes);

		lblPokeAbility = new JLabel("Habilidad:");
		lblPokeAbility.setBounds(10, 86, 59, 14);
		pokeInfoPanel.add(lblPokeAbility);

		lblPokeNameText = new JLabel("");
		lblPokeNameText.setBounds(79, 11, 140, 14);
		pokeInfoPanel.add(lblPokeNameText);

		lblPokeTypesText = new JLabel("");
		lblPokeTypesText.setBounds(80, 36, 224, 14);
		pokeInfoPanel.add(lblPokeTypesText);

		lblPokeHeighText = new JLabel("");
		lblPokeHeighText.setBounds(79, 111, 64, 14);
		pokeInfoPanel.add(lblPokeHeighText);

		lblPokeWeightText = new JLabel("");
		lblPokeWeightText.setBounds(232, 111, 77, 14);
		pokeInfoPanel.add(lblPokeWeightText);

		lblPokeDescriptionText = new JTextArea("");
		lblPokeDescriptionText.setWrapStyleWord(true);
		lblPokeDescriptionText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPokeDescriptionText.setBounds(89, 136, 215, 131);
		lblPokeDescriptionText.setEditable(false);
		lblPokeDescriptionText.setLineWrap(true);
		lblPokeDescriptionText.setOpaque(false);
		pokeInfoPanel.add(lblPokeDescriptionText);

		btnPlaySoundButton = new JButton("Sonido");
		btnPlaySoundButton.setBounds(220, 7, 89, 23);
		pokeInfoPanel.add(btnPlaySoundButton);

		lblPokeAbilityText = new JLabel("");
		lblPokeAbilityText.setBounds(79, 86, 225, 14);
		pokeInfoPanel.add(lblPokeAbilityText);
		lblPokeAbilityText.setVerticalAlignment(SwingConstants.TOP);

		lblPokeCategoryText = new JLabel("Semilla");
		lblPokeCategoryText.setVerticalAlignment(SwingConstants.TOP);
		lblPokeCategoryText.setBounds(79, 61, 225, 14);
		pokeInfoPanel.add(lblPokeCategoryText);

		lblPokeCategory = new JLabel("Categoria:");
		lblPokeCategory.setBounds(10, 61, 59, 14);
		pokeInfoPanel.add(lblPokeCategory);

		btnPokeNext = new JButton("Siguiente");
		btnPokeNext.setBounds(124, 288, 89, 23);
		frame.getContentPane().add(btnPokeNext);

		btnPokePrevious = new JButton("Anterior");
		btnPokePrevious.setBounds(26, 288, 89, 23);
		frame.getContentPane().add(btnPokePrevious);

		btnSignOut = new JButton("Cerrar sesi\u00F3n");
		btnSignOut.setBounds(412, 375, 130, 23);
		frame.getContentPane().add(btnSignOut);

		lblPokeNum = new JLabel("N\u00FAmero:");
		lblPokeNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokeNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPokeNum.setBounds(26, 253, 187, 28);
		frame.getContentPane().add(lblPokeNum);

		btnPokeAdmin = new JButton("Panel Admin");
		btnPokeAdmin.setVerticalAlignment(SwingConstants.TOP);
		btnPokeAdmin.setBounds(438, 15, 105, 23);
		frame.getContentPane().add(btnPokeAdmin);

		btnSearch = new JButton("Volver a buscar");
		btnSearch.setBounds(58, 322, 128, 23);
		frame.getContentPane().add(btnSearch);

		if (!new UserDAO().havePermission(currentUsername)) {
			btnPokeAdmin.setVisible(false);
		}

	}

	/**
	 * Method that set listeners and events
	 */
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
				JOptionPane.showMessageDialog(frame, "Has cerrado sesion", "INFO", JOptionPane.INFORMATION_MESSAGE);
				new LoginView();
			}

		});

		btnPlaySoundButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Utils.playSound(searchedPokemons.get(indexPokmeonList).getSoundURL());
			}

		});

		btnPokeAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new AdminView(currentUsername);
			}

		});

		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				parentFrame.setVisible(true);
			}

		});

	}

	private void nextPokemon() {
		if (indexPokmeonList < searchedPokemons.size() - 1) {
			showPokemon(++indexPokmeonList);
		}

	}

	private void previousPokemon() {
		if (indexPokmeonList > 0) {
			showPokemon(--indexPokmeonList);
		}

	}

	private void showPokemon(int index) {
		String currentNumber = String.valueOf(searchedPokemons.get(index).getpId());
		String currentName = searchedPokemons.get(index).getName();
		String currentHeight = String.valueOf(searchedPokemons.get(index).getHeight()) + "m";
		String currentWeight = String.valueOf(searchedPokemons.get(index).getWeight()) + "kg";
		String currentDescription = searchedPokemons.get(index).getDescription();
		String currentAbility = searchedPokemons.get(index).getAbility();
		String currentImageUrl = searchedPokemons.get(index).getImageURL();
		String currentTypes = searchedPokemons.get(index).getStringTypes();
		String currentCategory = searchedPokemons.get(index).getCategory();

		lblPokeNum.setText("Pokedex ID: " + currentNumber);
		lblPokeNameText.setText(currentName);
		lblPokeTypesText.setText(currentTypes);
		lblPokeDescriptionText.setText(currentDescription);
		lblPokeHeighText.setText(currentHeight);
		lblPokeWeightText.setText(currentWeight);
		lblPokeAbilityText.setText(currentAbility);
		lblPokeCategoryText.setText(currentCategory);

		// Set preview image.
		BufferedImage img = Utils.getBuferedImageIfValid(currentImageUrl);
		if (img != null) {
			Image dimg = img.getScaledInstance(lblPreviewImage.getWidth(), lblPreviewImage.getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(dimg);
			lblPreviewImage.setIcon(imageIcon);
		} else {
			BufferedImage rescueImg = Utils.getBuferedImageIfValid(
					"https://upload.wikimedia.org/wikipedia/commons/5/51/Pokebola-pokeball-png-0.png");
			Image dimg = rescueImg.getScaledInstance(lblPreviewImage.getWidth(), lblPreviewImage.getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(dimg);
			lblPreviewImage.setIcon(imageIcon);
			JOptionPane.showMessageDialog(frame, currentName + " no dispone de imagen aún", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
