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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import DAO.PokemonDAO;
import DAO.TeamDAO;
import DAO.UserDAO;
import models.Pokemon;
import models.PokemonTeam;
import models.Utils;

public class PokemonView {

	private JFrame frame;
	private JLabel lblPokedex;
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
	private JLabel lblPokeNameText;
	private JLabel lblPokeTypesText;
	private JLabel lblPokeAbilityText;
	private JLabel lblPokeHeighText;
	private JLabel lblPokeWeightText;
	private JTextArea lblPokeDescriptionText;
	private JButton btnPlaySoundButton;
	private JLabel lblPokeNum;
	private JMenuBar menuBar;
	private JMenu mnMainMenu;
	private JMenuItem mntmAdminPanel;
	private JMenuItem mntmSearchPokemon;
	private JMenuItem mntmLogout;
	private JMenu mnNewMenu2;
	private JMenuItem mntmCreateTeam;

	private String currentUsername;

	private int indexPokmeonList = 0;
	private ArrayList<Pokemon> allPokemons;
	private ArrayList<PokemonTeam> teamPokemons;
	private JLabel lblPokeCategoryText;
	private JLabel lblPokeCategory;
	private JMenuItem mntmManageTeam;

	/**
	 * Create the application with Admin check support
	 * 
	 * @param currentUsername the currentUsername who logged in
	 */
	public PokemonView(String username) {
		currentUsername = username;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		allPokemons = new ArrayList<Pokemon>();
		teamPokemons = new ArrayList<PokemonTeam>();
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		setDBPokemons();
		setUIComponents();
		setListeners();
		showPokemon(0);

		frame.setVisible(true);
	}

	/**
	 * Get pokemon' ArrayList from db and sets to local ArrayList variable.
	 */
	private void setDBPokemons() {
		allPokemons = new PokemonDAO().getAllPokemons();
		teamPokemons = new TeamDAO().getTeamPokemons(currentUsername);
	}

	/**
	 * Method that sets all UI Components
	 */
	private void setUIComponents() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		mnMainMenu = new JMenu("Opciones");
		menuBar.add(mnMainMenu);

		mntmAdminPanel = new JMenuItem("Panel Admin");
		mnMainMenu.add(mntmAdminPanel);

		mntmSearchPokemon = new JMenuItem("Buscar Pokemon");
		mnMainMenu.add(mntmSearchPokemon);

		mntmLogout = new JMenuItem("Cerrar sesi\u00F3n");
		mnMainMenu.add(mntmLogout);

		mnNewMenu2 = new JMenu("Equipo");
		menuBar.add(mnNewMenu2);

		mntmCreateTeam = new JMenuItem("Crear equipo");
		mnNewMenu2.add(mntmCreateTeam);
		mntmCreateTeam.setVisible(false);

		mntmManageTeam = new JMenuItem("Gestionar equipo");
		mnNewMenu2.add(mntmManageTeam);
		mntmManageTeam.setVisible(false);

		lblPokedex = new JLabel("Pokedex");
		lblPokedex.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokedex.setForeground(Color.RED);
		lblPokedex.setFont(new Font("Leelawadee", Font.BOLD, 30));
		lblPokedex.setBounds(171, 3, 192, 46);
		frame.getContentPane().add(lblPokedex);

		label = new JLabel();
		label.setBounds(171, 43, -153, 173);
		frame.getContentPane().add(label);

		lblPreviewImage = new JLabel("");
		lblPreviewImage.setBounds(10, 51, 203, 191);
		frame.getContentPane().add(lblPreviewImage);

		pokeInfoPanel = new JPanel();
		pokeInfoPanel.setBorder(new LineBorder(new Color(0, 255, 255), 5, true));
		pokeInfoPanel.setBounds(223, 50, 319, 252);
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
		btnPokeNext.setBounds(124, 279, 89, 23);
		frame.getContentPane().add(btnPokeNext);

		btnPokePrevious = new JButton("Anterior");
		btnPokePrevious.setBounds(26, 279, 89, 23);
		frame.getContentPane().add(btnPokePrevious);

		lblPokeNum = new JLabel("N\u00FAmero:");
		lblPokeNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokeNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPokeNum.setBounds(26, 244, 187, 28);
		frame.getContentPane().add(lblPokeNum);

		if (!new UserDAO().havePermission(currentUsername)) {
			mntmAdminPanel.setVisible(false);
		}

		if (userHasTeam()) {
			mntmManageTeam.setVisible(true);
			mntmCreateTeam.setVisible(false);
		} else {
			mntmManageTeam.setVisible(false);
			mntmCreateTeam.setVisible(true);
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

		mntmLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.dispose();
				JOptionPane.showMessageDialog(frame, "Has cerrado sesion", "INFO", JOptionPane.INFORMATION_MESSAGE);
				new LoginView();
			}

		});

		btnPlaySoundButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Utils.playSound(allPokemons.get(indexPokmeonList).getSoundURL());
			}

		});

		mntmAdminPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.dispose();
				new AdminView(currentUsername);
			}
		});

		mntmSearchPokemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.dispose();
				new SearchView(currentUsername, allPokemons, false);
			}

		});

		mntmCreateTeam.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.dispose();
				new TeamView(currentUsername, allPokemons, teamPokemons);
			}
		});

		mntmManageTeam.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.dispose();
				new TeamView(currentUsername, allPokemons, teamPokemons);
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

	private boolean userHasTeam() {
		return !teamPokemons.isEmpty();
	}

	private void showPokemon(int index) {
		String currentNumber = String.valueOf(allPokemons.get(index).getpId());
		String currentName = allPokemons.get(index).getName();
		String currentHeight = String.valueOf(allPokemons.get(index).getHeight()) + "m";
		String currentWeight = String.valueOf(allPokemons.get(index).getWeight()) + "kg";
		String currentDescription = allPokemons.get(index).getDescription();
		String currentAbility = allPokemons.get(index).getAbility();
		String currentImageUrl = allPokemons.get(index).getImageURL();
		String currentTypes = allPokemons.get(index).getStringTypes();
		String currentCategory = allPokemons.get(index).getCategory();

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
