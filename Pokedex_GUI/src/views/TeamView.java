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

import DAO.TeamDAO;
import models.Pokemon;
import models.PokemonTeam;
import models.Utils;

public class TeamView {

	private JFrame frame;
	private JLabel lblTeam;
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
	private JMenu mnOptionsMenu;
	private JMenuItem mntmReturnPokedex;
	private JMenuItem mntmSearch;
	private JMenuItem mntmLogout;
	private JMenu mnActionsMenu;
	private JMenuItem mntmReleasePokemon;
	private JMenuItem mntmChangeMote;
	private JMenuItem mntmChangeLvl;
	private JLabel lblCurrentPokeNumber;

	private String currentUsername;
	private int indexPokmeonList = 0;
	private ArrayList<Pokemon> allPokemons = new ArrayList<Pokemon>();
	private ArrayList<PokemonTeam> teamPokemons = new ArrayList<PokemonTeam>();
	private JLabel lblPokeCategoryText;
	private JLabel lblPokeCategory;
	private JLabel lblPokeLvl;
	private JLabel lblPokeLvlText;
	private JLabel lblMote;
	private JLabel lblPokeMoteTxt;

	/**
	 * @wbp.parser.constructor
	 * 
	 * Create the application with Admin check support
	 * 
	 * @param currentUsername the currentUsername who logged in
	 */
	public TeamView(String username, ArrayList<Pokemon> allReceivedPokemons,
			ArrayList<PokemonTeam> teamReceivedPokemons) {
		currentUsername = username;
		allPokemons = allReceivedPokemons;
		teamPokemons = teamReceivedPokemons;
		initialize();
	}

	/**
	 * Create the application with Admin check support
	 * 
	 * @param currentUsername the currentUsername who logged in
	 */
	public TeamView(String username, ArrayList<Pokemon> allReceivedPokemons) {
		currentUsername = username;
		allPokemons = allReceivedPokemons;
		teamPokemons = new TeamDAO().getTeamPokemons(currentUsername);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 615, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		setUIComponents();
		setListeners();
		if (!teamPokemons.isEmpty()) {
			showPokemon(0);
		} else {
			JOptionPane.showMessageDialog(frame, "No tienes ningún pokemon en tu equipo aún. Deberías de añadir 1",
					"INFO", JOptionPane.INFORMATION_MESSAGE);
		}

		frame.setVisible(true);
	}

	/**
	 * Method that sets all UI Components
	 */
	private void setUIComponents() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		mnOptionsMenu = new JMenu("Opciones");
		menuBar.add(mnOptionsMenu);

		mntmSearch = new JMenuItem("Buscar Pokemon");
		mnOptionsMenu.add(mntmSearch);

		mntmReturnPokedex = new JMenuItem("Volver a la pokedex");
		mnOptionsMenu.add(mntmReturnPokedex);

		mntmLogout = new JMenuItem("Cerrar sesi\u00F3n");
		mnOptionsMenu.add(mntmLogout);

		mnActionsMenu = new JMenu("Acciones");
		menuBar.add(mnActionsMenu);

		mntmReleasePokemon = new JMenuItem("Liberar Pokemon");
		mnActionsMenu.add(mntmReleasePokemon);

		mntmChangeLvl = new JMenuItem("Cambiar nivel");
		mnActionsMenu.add(mntmChangeLvl);

		mntmChangeMote = new JMenuItem("Cambiar mote");
		mnActionsMenu.add(mntmChangeMote);

		lblTeam = new JLabel("Tu equipo");
		lblTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam.setForeground(Color.RED);
		lblTeam.setFont(new Font("Leelawadee", Font.BOLD, 30));
		lblTeam.setBounds(190, 0, 192, 46);
		frame.getContentPane().add(lblTeam);

		label = new JLabel();
		label.setBounds(171, 43, -153, 173);
		frame.getContentPane().add(label);

		lblPreviewImage = new JLabel("");
		lblPreviewImage.setBounds(10, 51, 203, 191);
		frame.getContentPane().add(lblPreviewImage);

		pokeInfoPanel = new JPanel();
		pokeInfoPanel.setBorder(new LineBorder(new Color(0, 255, 255), 5, true));
		pokeInfoPanel.setBounds(223, 50, 361, 252);
		frame.getContentPane().add(pokeInfoPanel);
		pokeInfoPanel.setLayout(null);

		lblPokeName = new JLabel("Nombre:");
		lblPokeName.setBounds(10, 11, 59, 14);
		pokeInfoPanel.add(lblPokeName);

		lblPokeDescription = new JLabel("Descripci\u00F3n:");
		lblPokeDescription.setBounds(10, 163, 77, 14);
		pokeInfoPanel.add(lblPokeDescription);

		lblPokeHeigh = new JLabel("Altura:");
		lblPokeHeigh.setBounds(10, 138, 59, 14);
		pokeInfoPanel.add(lblPokeHeigh);

		lblPokeWeight = new JLabel("Peso:");
		lblPokeWeight.setBounds(176, 138, 46, 14);
		pokeInfoPanel.add(lblPokeWeight);

		lblPokeTypes = new JLabel("Tipo:");
		lblPokeTypes.setBounds(10, 63, 65, 14);
		pokeInfoPanel.add(lblPokeTypes);

		lblPokeAbility = new JLabel("Habilidad:");
		lblPokeAbility.setBounds(10, 113, 59, 14);
		pokeInfoPanel.add(lblPokeAbility);

		lblPokeNameText = new JLabel("");
		lblPokeNameText.setBounds(79, 11, 173, 14);
		pokeInfoPanel.add(lblPokeNameText);

		lblPokeTypesText = new JLabel("");
		lblPokeTypesText.setBounds(80, 63, 224, 14);
		pokeInfoPanel.add(lblPokeTypesText);

		lblPokeHeighText = new JLabel("");
		lblPokeHeighText.setBounds(79, 138, 64, 14);
		pokeInfoPanel.add(lblPokeHeighText);

		lblPokeWeightText = new JLabel("");
		lblPokeWeightText.setBounds(220, 138, 89, 14);
		pokeInfoPanel.add(lblPokeWeightText);

		lblPokeDescriptionText = new JTextArea("");
		lblPokeDescriptionText.setWrapStyleWord(true);
		lblPokeDescriptionText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPokeDescriptionText.setBounds(89, 161, 249, 80);
		lblPokeDescriptionText.setEditable(false);
		lblPokeDescriptionText.setLineWrap(true);
		lblPokeDescriptionText.setOpaque(false);
		pokeInfoPanel.add(lblPokeDescriptionText);

		btnPlaySoundButton = new JButton("Sonido");
		btnPlaySoundButton.setBounds(262, 7, 89, 23);
		pokeInfoPanel.add(btnPlaySoundButton);

		lblPokeAbilityText = new JLabel("");
		lblPokeAbilityText.setBounds(79, 113, 225, 14);
		pokeInfoPanel.add(lblPokeAbilityText);
		lblPokeAbilityText.setVerticalAlignment(SwingConstants.TOP);

		lblPokeCategoryText = new JLabel("");
		lblPokeCategoryText.setVerticalAlignment(SwingConstants.TOP);
		lblPokeCategoryText.setBounds(79, 88, 225, 14);
		pokeInfoPanel.add(lblPokeCategoryText);

		lblPokeCategory = new JLabel("Categoria:");
		lblPokeCategory.setBounds(10, 88, 59, 14);
		pokeInfoPanel.add(lblPokeCategory);

		lblPokeLvl = new JLabel("Nivel:");
		lblPokeLvl.setBounds(10, 38, 46, 14);
		pokeInfoPanel.add(lblPokeLvl);

		lblPokeLvlText = new JLabel("");
		lblPokeLvlText.setBounds(67, 38, 59, 14);
		pokeInfoPanel.add(lblPokeLvlText);

		lblMote = new JLabel("Mote:");
		lblMote.setBounds(136, 38, 46, 14);
		pokeInfoPanel.add(lblMote);

		lblPokeMoteTxt = new JLabel("");
		lblPokeMoteTxt.setBounds(192, 38, 159, 14);
		pokeInfoPanel.add(lblPokeMoteTxt);

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

		lblCurrentPokeNumber = new JLabel("Pokemon 0/6");
		lblCurrentPokeNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPokeNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblCurrentPokeNumber.setBounds(40, 12, 140, 35);
		frame.getContentPane().add(lblCurrentPokeNumber);

	}

	/**
	 * Method that set listeners and events
	 */
	private void setListeners() {
		btnPokeNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!teamPokemons.isEmpty()) {
					nextPokemon();
				} else {
					JOptionPane.showMessageDialog(frame, "No tienes ningún pokemon en tu equipo aún.", "INFO",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}

		});

		btnPokePrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!teamPokemons.isEmpty()) {
					previousPokemon();
				} else {
					JOptionPane.showMessageDialog(frame, "No tienes ningún pokemon en tu equipo aún.", "INFO",
							JOptionPane.INFORMATION_MESSAGE);
				}
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
				if (!teamPokemons.isEmpty()) {
					Utils.playSound(teamPokemons.get(indexPokmeonList).getObj().getSoundURL());
				} else {
					JOptionPane.showMessageDialog(frame, "No tienes ningún pokemon en tu equipo aun.", "INFO",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});

		mntmReturnPokedex.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.dispose();
				new PokemonView(currentUsername);
			}
		});

		mntmSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (new TeamDAO().getTeamPokemons(currentUsername).size() == 6) {
					JOptionPane.showMessageDialog(frame,
							"Ya tienes 6 pokemon en tu equipo, antes de meter otro mas debes de liberar a uno.", "INFO",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					frame.dispose();
					new SearchView(currentUsername, allPokemons, true);
				}
			}
		});

		mntmReleasePokemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (!teamPokemons.isEmpty()) {
					deleteCurrentPokemon();
					teamPokemons = new TeamDAO().getTeamPokemons(currentUsername);
					if (!teamPokemons.isEmpty()) {
						showPokemon(0);
					} else {
						JOptionPane.showMessageDialog(frame,
								"Has eliminado el ultimo pokemon que tenias, tu equipo se ha cerrado.", "INFO",
								JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						new PokemonView(currentUsername);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "No tienes ningún pokemon en tu equipo aun.", "INFO",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});

		mntmChangeMote.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!teamPokemons.isEmpty()) {
					String puttedMote;

					int moteDialogButton = JOptionPane.YES_NO_OPTION;
					int moteDialogResult = JOptionPane.showConfirmDialog(frame, "¿Quieres ponerle un mote al pokemon?",
							"Poner mote", moteDialogButton);

					if (moteDialogResult == 0) {
						puttedMote = JOptionPane.showInputDialog(frame, "Introduce el mote deseado:",
								"Poner mote al pokemon", JOptionPane.INFORMATION_MESSAGE);
						if (puttedMote != null) {
							if (puttedMote.isBlank()) {
								JOptionPane.showMessageDialog(frame, "Debes introducir un mote", "INFO",
										JOptionPane.ERROR_MESSAGE);
							} else {
								teamPokemons.get(indexPokmeonList).setMote(puttedMote);
								new TeamDAO().updateTeamPokemon(teamPokemons.get(indexPokmeonList));
								JOptionPane.showMessageDialog(frame, "Pokemon actualizado.", "INFO",
										JOptionPane.INFORMATION_MESSAGE);
								showPokemon(indexPokmeonList);
							}
						}
						
					}
				} else {
					JOptionPane.showMessageDialog(frame, "No tienes ningún pokemon en tu equipo aun.", "INFO",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});

		mntmChangeLvl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!teamPokemons.isEmpty()) {
					int puttedLvl = 1;

					int lvlDialogButton = JOptionPane.YES_NO_OPTION;
					int lvlDialogResult = JOptionPane.showConfirmDialog(frame, "¿Quieres ponerle nivel al pokemon?",
							"Poner nivel", lvlDialogButton);

					if (lvlDialogResult == 0) {
						String tempLvl = JOptionPane.showInputDialog(frame, "Introduce el nivel deseado:",
								"Poner nivel al pokemon", JOptionPane.INFORMATION_MESSAGE);

						if (!Utils.checkStringIsIntNumberOption(tempLvl, 1, 100)) {
							JOptionPane.showMessageDialog(frame, "El nivel debe ser un numero entre 1 y 100", "INFO",
									JOptionPane.ERROR_MESSAGE);
						} else {
							puttedLvl = Integer.parseInt(tempLvl);
							teamPokemons.get(indexPokmeonList).setLvl(puttedLvl);
							new TeamDAO().updateTeamPokemon(teamPokemons.get(indexPokmeonList));
							JOptionPane.showMessageDialog(frame, "Pokemon actualizado.", "INFO",
									JOptionPane.INFORMATION_MESSAGE);
							showPokemon(indexPokmeonList);
						}

					} else {

					}

				} else {
					JOptionPane.showMessageDialog(frame, "No tienes ningún pokemon en tu equipo aun.", "INFO",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});

	}

	/**
	 * Method to delete current pokemon
	 */
	private void deleteCurrentPokemon() {
		if (new TeamDAO().deleteTeamPokemon(teamPokemons.get(indexPokmeonList))) {
			JOptionPane.showMessageDialog(frame, "Has liberado correctamente al pokemon.", "INFO",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(frame, "No se ha podido liberar al pokemon.", "INFO",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private void nextPokemon() {

		if (indexPokmeonList < teamPokemons.size() - 1) {
			showPokemon(++indexPokmeonList);
		}

	}

	private void previousPokemon() {
		if (indexPokmeonList > 0) {
			showPokemon(--indexPokmeonList);
		}

	}

	private void showPokemon(int index) {
		int toshowIndex = (index + 1);
		lblCurrentPokeNumber.setText("Pokemon " + toshowIndex + "/6 ");
		Pokemon objPokemon = teamPokemons.get(index).getObj();
		String currentNumber = String.valueOf(objPokemon.getpId());
		String currentName = objPokemon.getName();
		String currentHeight = String.valueOf(objPokemon.getHeight()) + "m";
		String currentWeight = String.valueOf(objPokemon.getWeight()) + "kg";
		String currentDescription = objPokemon.getDescription();
		String currentAbility = objPokemon.getAbility();
		String currentImageUrl = objPokemon.getImageURL();
		String currentTypes = objPokemon.getStringTypes();
		String currentCategory = objPokemon.getCategory();

		String currentMote = teamPokemons.get(index).getMote();
		String currentLvl = String.valueOf(teamPokemons.get(index).getLvl());

		lblPokeNum.setText("Pokedex ID: " + currentNumber);
		lblPokeNameText.setText(currentName);
		lblPokeCategoryText.setText(currentCategory);
		lblPokeAbilityText.setText(currentAbility);
		lblPokeDescriptionText.setText(currentDescription);
		lblPokeHeighText.setText(currentHeight);
		lblPokeWeightText.setText(currentWeight);
		lblPokeLvlText.setText(currentLvl);
		lblPokeMoteTxt.setText(currentMote);
		lblPokeTypesText.setText(currentTypes);

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
			JOptionPane.showMessageDialog(frame, currentName + " no dispone de imagen aun", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
