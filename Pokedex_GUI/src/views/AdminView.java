package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import DAO.PokemonDAO;
import models.Pokemon;
import models.Utils;

public class AdminView {

	private JFrame frame;
	private JLabel lblPokedex;
	private JLabel label;
	private JLabel lblPreviewImage;
	private JPanel pokeEditPanel;
	private JLabel lblPokeName;
	private JLabel lblPokeDescription;
	private JLabel lblPokeHeigh;
	private JLabel lblPokeWeight;
	private JLabel lblPokeTypes;
	private JLabel lblPokeAbility;
	private JButton btnPokeNext;
	private JButton btnPokePrevious;
	private JButton btnSignOut;
	private JTextField txtPokeNameText;
	private JTextField txtPokeAbilityText;
	private JTextField txtPokeHeighText;
	private JTextField txtPokeWeightText;
	private JTextArea txtPokeDescriptionText;
	private JButton btnPlaySoundButton;
	private JLabel lblPokeNum;
	private JLabel lblPokeEdit;
	private JButton btnExitAdmin;
	private JTextField txtInsertName;
	private JTextField txtAbilityInsert;
	private JTextField txtHeighInsert;
	private JTextField txtWeightInsert;
	private JTextField txtImageInsert;
	private JTextField txtSoundInsert;
	private JLabel lblPokeInsert;
	private JPanel pokeInsertPanel;
	private JTextArea txtDescriptionInsert;
	private JLabel lblPokeNameInsert;
	private JLabel lblPokeDescriptionInsert;
	private JLabel lblPokeImageInsert;
	private JLabel lblPokeHeighInsert;
	private JLabel lblPokeWeightInsert;
	private JLabel lblPokeAbilityInsert;
	private JLabel lblSoundUrlInsert;
	private JButton btnPokeAddNew;
	private JButton btnClearNewPokeAreas;
	private JButton btnPokeEdit;
	private JScrollPane typeScrollPain;
	private JList<String> listPokeTypesEdit;
	private int indexPokmeonList = 0;
	private ArrayList<Pokemon> allPokemons;
	private LinkedHashMap<String, Integer> availableTypes;
	private String currentUsername;
	private JLabel lblPokeImageEdit;
	private JLabel lblUrlDelSonidoEdit;
	private JTextField txtPokeImgUrlText;
	private JTextField txtPokeSoundURLText;
	private JLabel lblPokeCategory;
	private JTextField txtPokeCategory;
	private JList<String> listTypesInsert;
	private JLabel lblPokeTypesInsert;
	private JScrollPane typeScrollPainInsert;
	private JLabel lblPokeCategoryInsert;
	private JTextField txtCategoryInsert;
	private JButton btnPokeDelete;
	private JLabel lblPokeIdInsert;
	private JTextField txtPokeIdInsert;

	/**
	 * Create the application.
	 * 
	 * @param username
	 */
	public AdminView(String username) {
		currentUsername = username;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		allPokemons = new ArrayList<Pokemon>();
		frame = new JFrame();
		frame.setBounds(100, 100, 1025, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		setDBPokemons();
		setAvailableTypes();
		setUIComponents();
		setListeners();
		fillTypes();
		showPokemon(0);

		frame.setVisible(true);
	}

	/**
	 * Method that fills the 2 JList with all available pokemon types.
	 */
	private void fillTypes() {
		String[] types = new String[availableTypes.size()];
		String[] toSet = availableTypes.keySet().toArray(types);
		listPokeTypesEdit.setListData(toSet);
		listTypesInsert.setListData(toSet);
	}

	/**
	 * Get pokemon' ArrayList from db and sets to local ArrayList variable.
	 */
	private void setDBPokemons() {
		allPokemons = new PokemonDAO().getAllPokemons();
	}

	/**
	 * Method that gets all pokemon types available from db.
	 */
	private void setAvailableTypes() {
		availableTypes = new PokemonDAO().getAvailableCategories();

	}

	/**
	 * Method that sets all UI Components
	 */
	private void setUIComponents() {
		lblPokedex = new JLabel("[MODO ADMIN]");
		lblPokedex.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokedex.setForeground(Color.RED);
		lblPokedex.setFont(new Font("Leelawadee", Font.BOLD, 14));
		lblPokedex.setBounds(483, 25, 130, 23);
		frame.getContentPane().add(lblPokedex);

		label = new JLabel();
		label.setBounds(171, 43, -153, 173);
		frame.getContentPane().add(label);

		lblPreviewImage = new JLabel("");
		lblPreviewImage.setBounds(10, 60, 203, 191);
		frame.getContentPane().add(lblPreviewImage);

		pokeEditPanel = new JPanel();
		pokeEditPanel.setBorder(new LineBorder(new Color(0, 255, 255), 5, true));
		pokeEditPanel.setBounds(223, 60, 319, 368);
		frame.getContentPane().add(pokeEditPanel);
		pokeEditPanel.setLayout(null);

		lblPokeName = new JLabel("Nombre:");
		lblPokeName.setBounds(10, 11, 59, 14);
		pokeEditPanel.add(lblPokeName);

		lblPokeDescription = new JLabel("Descripci\u00F3n:");
		lblPokeDescription.setBounds(10, 267, 82, 14);
		pokeEditPanel.add(lblPokeDescription);

		lblPokeHeigh = new JLabel("Altura:");
		lblPokeHeigh.setBounds(10, 242, 82, 14);
		pokeEditPanel.add(lblPokeHeigh);

		lblPokeWeight = new JLabel("Peso:");
		lblPokeWeight.setBounds(176, 242, 46, 14);
		pokeEditPanel.add(lblPokeWeight);

		lblPokeTypes = new JLabel("Tipo:");
		lblPokeTypes.setBounds(10, 36, 65, 14);
		pokeEditPanel.add(lblPokeTypes);

		lblPokeAbility = new JLabel("Habilidad:");
		lblPokeAbility.setBounds(10, 217, 59, 14);
		pokeEditPanel.add(lblPokeAbility);

		txtPokeNameText = new JTextField("");
		txtPokeNameText.setBounds(70, 11, 140, 14);
		pokeEditPanel.add(txtPokeNameText);

		txtPokeAbilityText = new JTextField("");
		txtPokeAbilityText.setBounds(70, 217, 232, 14);
		pokeEditPanel.add(txtPokeAbilityText);

		txtPokeHeighText = new JTextField("");
		txtPokeHeighText.setBounds(102, 242, 64, 14);
		pokeEditPanel.add(txtPokeHeighText);

		txtPokeWeightText = new JTextField("");
		txtPokeWeightText.setBounds(232, 242, 77, 14);
		pokeEditPanel.add(txtPokeWeightText);

		txtPokeDescriptionText = new JTextArea("");
		txtPokeDescriptionText.setWrapStyleWord(true);
		txtPokeDescriptionText.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPokeDescriptionText.setBounds(102, 265, 207, 92);
		txtPokeDescriptionText.setEditable(true);
		txtPokeDescriptionText.setLineWrap(true);
		pokeEditPanel.add(txtPokeDescriptionText);

		btnPlaySoundButton = new JButton("Sonido");
		btnPlaySoundButton.setBounds(220, 7, 89, 23);
		pokeEditPanel.add(btnPlaySoundButton);

		typeScrollPain = new JScrollPane();
		typeScrollPain.setBounds(67, 36, 235, 99);
		pokeEditPanel.add(typeScrollPain);

		listPokeTypesEdit = new JList<String>();
		typeScrollPain.setViewportView(listPokeTypesEdit);

		lblPokeImageEdit = new JLabel("URL de imagen");
		lblPokeImageEdit.setBounds(10, 167, 89, 14);
		pokeEditPanel.add(lblPokeImageEdit);

		lblUrlDelSonidoEdit = new JLabel("URL del sonido");
		lblUrlDelSonidoEdit.setBounds(10, 192, 89, 14);
		pokeEditPanel.add(lblUrlDelSonidoEdit);

		txtPokeImgUrlText = new JTextField("");
		txtPokeImgUrlText.setBounds(102, 167, 200, 14);
		pokeEditPanel.add(txtPokeImgUrlText);

		txtPokeSoundURLText = new JTextField("");
		txtPokeSoundURLText.setBounds(102, 192, 200, 14);
		pokeEditPanel.add(txtPokeSoundURLText);

		lblPokeCategory = new JLabel("Categor\u00EDa:");
		lblPokeCategory.setBounds(10, 146, 59, 14);
		pokeEditPanel.add(lblPokeCategory);

		txtPokeCategory = new JTextField("Semilla");
		txtPokeCategory.setBounds(70, 146, 232, 14);
		pokeEditPanel.add(txtPokeCategory);

		btnPokeNext = new JButton("Siguiente");
		btnPokeNext.setBounds(124, 288, 89, 23);
		frame.getContentPane().add(btnPokeNext);

		btnPokePrevious = new JButton("Anterior");
		btnPokePrevious.setBounds(26, 288, 89, 23);
		frame.getContentPane().add(btnPokePrevious);

		btnSignOut = new JButton("Cerrar sesi\u00F3n");
		btnSignOut.setBounds(10, 439, 118, 23);
		frame.getContentPane().add(btnSignOut);

		lblPokeNum = new JLabel("N\u00FAmero:");
		lblPokeNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokeNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPokeNum.setBounds(26, 253, 187, 28);
		frame.getContentPane().add(lblPokeNum);

		lblPokeInsert = new JLabel("Insertar Pokemon");
		lblPokeInsert.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokeInsert.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPokeInsert.setBounds(676, 11, 223, 48);
		frame.getContentPane().add(lblPokeInsert);

		lblPokeEdit = new JLabel("Editar Pokemon");
		lblPokeEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokeEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPokeEdit.setBounds(149, 16, 223, 39);
		frame.getContentPane().add(lblPokeEdit);

		btnExitAdmin = new JButton("Volver");
		btnExitAdmin.setBounds(138, 439, 80, 23);
		frame.getContentPane().add(btnExitAdmin);

		pokeInsertPanel = new JPanel();
		pokeInsertPanel.setLayout(null);
		pokeInsertPanel.setBorder(new LineBorder(new Color(0, 255, 255), 5, true));
		pokeInsertPanel.setBounds(552, 60, 431, 368);
		frame.getContentPane().add(pokeInsertPanel);

		lblPokeNameInsert = new JLabel("Nombre:");
		lblPokeNameInsert.setBounds(10, 11, 59, 14);
		pokeInsertPanel.add(lblPokeNameInsert);

		lblPokeDescriptionInsert = new JLabel("Descripci\u00F3n:");
		lblPokeDescriptionInsert.setBounds(10, 267, 82, 14);
		pokeInsertPanel.add(lblPokeDescriptionInsert);

		lblPokeHeighInsert = new JLabel("Altura:");
		lblPokeHeighInsert.setBounds(10, 242, 82, 14);
		pokeInsertPanel.add(lblPokeHeighInsert);

		lblPokeWeightInsert = new JLabel("Peso:");
		lblPokeWeightInsert.setBounds(157, 242, 46, 14);
		pokeInsertPanel.add(lblPokeWeightInsert);

		lblPokeAbilityInsert = new JLabel("Habilidad:");
		lblPokeAbilityInsert.setBounds(10, 217, 59, 14);
		pokeInsertPanel.add(lblPokeAbilityInsert);

		txtInsertName = new JTextField("");
		txtInsertName.setBounds(102, 11, 307, 14);
		pokeInsertPanel.add(txtInsertName);

		txtAbilityInsert = new JTextField("");
		txtAbilityInsert.setBounds(102, 217, 307, 14);
		pokeInsertPanel.add(txtAbilityInsert);

		txtHeighInsert = new JTextField("");
		txtHeighInsert.setBounds(102, 242, 45, 14);
		pokeInsertPanel.add(txtHeighInsert);

		txtWeightInsert = new JTextField("");
		txtWeightInsert.setBounds(203, 242, 55, 14);
		pokeInsertPanel.add(txtWeightInsert);

		txtDescriptionInsert = new JTextArea("");
		txtDescriptionInsert.setWrapStyleWord(true);
		txtDescriptionInsert.setLineWrap(true);
		txtDescriptionInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDescriptionInsert.setEditable(true);
		txtDescriptionInsert.setBounds(102, 265, 307, 92);
		pokeInsertPanel.add(txtDescriptionInsert);

		lblPokeImageInsert = new JLabel("URL de imagen");
		lblPokeImageInsert.setBounds(10, 167, 88, 14);
		pokeInsertPanel.add(lblPokeImageInsert);

		txtImageInsert = new JTextField("");
		txtImageInsert.setBounds(102, 167, 307, 14);
		pokeInsertPanel.add(txtImageInsert);

		lblSoundUrlInsert = new JLabel("URL del sonido");
		lblSoundUrlInsert.setBounds(10, 192, 88, 14);
		pokeInsertPanel.add(lblSoundUrlInsert);

		txtSoundInsert = new JTextField("");
		txtSoundInsert.setBounds(102, 192, 307, 14);
		pokeInsertPanel.add(txtSoundInsert);

		lblPokeTypesInsert = new JLabel("Tipo:");
		lblPokeTypesInsert.setBounds(10, 36, 65, 14);
		pokeInsertPanel.add(lblPokeTypesInsert);

		typeScrollPainInsert = new JScrollPane();
		typeScrollPainInsert.setBounds(102, 36, 307, 95);
		pokeInsertPanel.add(typeScrollPainInsert);

		listTypesInsert = new JList<String>();
		typeScrollPainInsert.setViewportView(listTypesInsert);
		listTypesInsert.setSelectedIndices(new int[] {});

		lblPokeCategoryInsert = new JLabel("Categor\u00EDa:");
		lblPokeCategoryInsert.setBounds(10, 142, 59, 14);
		pokeInsertPanel.add(lblPokeCategoryInsert);

		txtCategoryInsert = new JTextField("");
		txtCategoryInsert.setBounds(102, 142, 307, 14);
		pokeInsertPanel.add(txtCategoryInsert);

		lblPokeIdInsert = new JLabel("Pokedex ID:");
		lblPokeIdInsert.setBounds(268, 242, 76, 14);
		pokeInsertPanel.add(lblPokeIdInsert);

		txtPokeIdInsert = new JTextField("");
		txtPokeIdInsert.setBounds(354, 242, 55, 14);
		pokeInsertPanel.add(txtPokeIdInsert);

		btnPokeAddNew = new JButton("A\u00F1adir Pokemon");
		btnPokeAddNew.setBounds(713, 439, 130, 23);
		frame.getContentPane().add(btnPokeAddNew);

		btnClearNewPokeAreas = new JButton("Limpiar Campos");
		btnClearNewPokeAreas.setBounds(853, 439, 130, 23);
		frame.getContentPane().add(btnClearNewPokeAreas);

		btnPokeEdit = new JButton("Editar Pokemon");
		btnPokeEdit.setBounds(412, 439, 130, 23);
		frame.getContentPane().add(btnPokeEdit);

		btnPokeDelete = new JButton("Borrar Pokemon");
		btnPokeDelete.setBounds(272, 439, 130, 23);
		frame.getContentPane().add(btnPokeDelete);

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
				JOptionPane.showMessageDialog(frame, "You signed out", "INFO", JOptionPane.INFORMATION_MESSAGE);
				new LoginView();
			}

		});

		btnExitAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new PokemonView(currentUsername);
			}

		});

		btnPlaySoundButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Utils.playSound(allPokemons.get(indexPokmeonList).getSoundURL()) == false) {
					JOptionPane.showMessageDialog(frame,
							allPokemons.get(indexPokmeonList).getName() + " no tiene sonido disponible", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		btnPokeEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editCurrentPokemon();
			}

		});

		btnClearNewPokeAreas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clearInsertTextBoxes();
			}

		});

		btnPokeAddNew.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				insertNewPokemon();
			}

		});

		btnPokeDelete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				deletePokemonDialog();
			}

		});
	}

	private void deletePokemonDialog() {

		String[] options = { "Borrar seleccionado", "Borrar por nombre", "Cancelar" };
		int opc = JOptionPane.showOptionDialog(null, "¿Que deseas hacer?", "Selecciona una opcion",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		switch (opc) {
		case 0:
			if (new PokemonDAO().deleteCurrentPokemon(allPokemons.get(indexPokmeonList).getpId()) == true) {
				allPokemons.remove(indexPokmeonList);
				JOptionPane.showMessageDialog(frame, "Pokemon borrado correctamente.", "INFORMACION",
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		case 1:
			String pokeSearchName = JOptionPane.showInputDialog(frame, "Introduce el nombre COMPLETO del pokemon:",
					"Borrado de pokemon por nombre", JOptionPane.INFORMATION_MESSAGE);

			if (pokeSearchName != null) {
				if (pokeSearchName.isBlank()) {
					JOptionPane.showMessageDialog(frame, "Debes introducir el nombre.", "INFO",
							JOptionPane.ERROR_MESSAGE);
				} else {

					if (JOptionPane.showConfirmDialog(null, "¿Estás seguro?") == 0) {
						deletePokemonByName(pokeSearchName);
					}
				}
			}
			break;
		}

	}

	private void deletePokemonByName(String pokeSearchName) {
		boolean foundNDeleted = false;
		for (Pokemon pokemon : allPokemons) {
			if (pokemon.getName().toLowerCase().equals(pokeSearchName.toLowerCase())) {
				new PokemonDAO().deletePokemonFromName(pokemon);
				JOptionPane.showMessageDialog(frame, "Pokemon borrado correctamente", "INFO",
						JOptionPane.INFORMATION_MESSAGE);
				foundNDeleted = true;
				break;
			}
		}

		if (!foundNDeleted) {
			JOptionPane.showMessageDialog(frame, "No existe ningun pokemon con ese nombre.", "INFO",
					JOptionPane.INFORMATION_MESSAGE);
		}

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
		String currentHeight = String.valueOf(allPokemons.get(index).getHeight());
		String currentWeight = String.valueOf(allPokemons.get(index).getWeight());
		String currentDescription = allPokemons.get(index).getDescription();
		String currentAbility = allPokemons.get(index).getAbility();
		String currentImageUrl = allPokemons.get(index).getImageURL();
		String currentSoundURL = allPokemons.get(indexPokmeonList).getSoundURL();
		String[] currentTypes = allPokemons.get(index).getTypes();
		int[] categoriesToSelect = new int[currentTypes.length];

		lblPokeNum.setText("Pokedex ID: " + currentNumber);
		txtPokeNameText.setText(currentName);

		for (int i = 0; i < currentTypes.length; i++) {
			categoriesToSelect[i] = availableTypes.get(currentTypes[i]) - 1;
		}

		listPokeTypesEdit.setSelectedIndices(categoriesToSelect);

		txtPokeDescriptionText.setText(currentDescription);
		txtPokeHeighText.setText(currentHeight);
		txtPokeWeightText.setText(currentWeight);
		txtPokeAbilityText.setText(currentAbility);
		txtPokeImgUrlText.setText(currentImageUrl);
		txtPokeSoundURLText.setText(currentSoundURL);

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

	private void clearInsertTextBoxes() {
		txtInsertName.setText("");
		listTypesInsert.setSelectedIndices(new int[0]);
		txtCategoryInsert.setText("");
		txtImageInsert.setText("");
		txtSoundInsert.setText("");
		txtAbilityInsert.setText("");
		txtHeighInsert.setText("");
		txtWeightInsert.setText("");
		txtDescriptionInsert.setText("");

	}

	/**
	 * Checks if edit fields values are correct values
	 * 
	 * @return true or false
	 */
	private String checkEditValues() {

		if (txtPokeNameText.getText().isBlank() || txtPokeAbilityText.getText().isBlank()
				|| txtPokeHeighText.getText().isBlank() || txtPokeWeightText.getText().isBlank()
				|| txtPokeDescriptionText.getText().isBlank() || txtPokeDescriptionText.getText().isBlank()) {
			return "blank";
		}

		for (Pokemon pokemon : allPokemons) {
			if (pokemon.getName().equals(txtInsertName.getText())) {
				return "duplicatename";
			}
		}

		try {
			Float.parseFloat(txtPokeHeighText.getText());
			Float.parseFloat(txtPokeWeightText.getText());
		} catch (NumberFormatException e) {
			return "numberformat";
		}

		if (listPokeTypesEdit.getSelectedIndices().length == 0) {
			return "notypes";
		}

		if (!Utils.checkIfUrlIsAnImage(txtPokeImgUrlText.getText())) {
			return "img";
		}

		if (Utils.playSound(txtPokeSoundURLText.getText()) == false) {
			return "sound";
		}

		return "ok";
	}

	private void editCurrentPokemon() {
		String isValid = checkEditValues();
		switch (isValid) {
		case "ok":
			String name = txtPokeNameText.getText();
			String ability = txtPokeAbilityText.getText();
			float height = Float.parseFloat(txtPokeHeighText.getText());
			float weight = Float.parseFloat(txtPokeWeightText.getText());
			String category = txtPokeCategory.getText();
			String description = txtPokeDescriptionText.getText();
			String imageUrl = txtPokeImgUrlText.getText();
			String soundUrl = txtPokeSoundURLText.getText();
			int[] nTypes = listPokeTypesEdit.getSelectedIndices();

			List<String> lTypes = listPokeTypesEdit.getSelectedValuesList();
			String[] sTypes = new String[lTypes.size()];
			String[] finalSTypes = lTypes.toArray(sTypes);

			allPokemons.get(indexPokmeonList).updatePokemon(name, ability, height, weight, category, description,
					imageUrl, soundUrl, nTypes, finalSTypes);

			showPokemon(indexPokmeonList);

			JOptionPane.showMessageDialog(frame, "Pokemon editado correctamente.", "AVISO",
					JOptionPane.INFORMATION_MESSAGE);
			break;

		case "blank":
			JOptionPane.showMessageDialog(frame, "No puedes dejar campos vacíos", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;

		case "duplicatename":
			JOptionPane.showMessageDialog(frame, "Ya existe un pokemon con ese nombre, por favor introduzca otro.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			break;

		case "numberformat":
			JOptionPane.showMessageDialog(frame,
					"Los valores peso y altura solo aceptan números (1.1, 2.3, 44.4...). Por favor, introducelos correctamente",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			break;

		case "notypes":
			JOptionPane.showMessageDialog(frame, "Por favor selecciona al menos un tipo", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			break;

		case "img":
			JOptionPane.showMessageDialog(frame, "La URL de la imagen debe ser una URL correcta a una imagen", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			break;

		case "sound":
			JOptionPane.showMessageDialog(frame, "La URL del sonido debe ser una URL correcta a un sonido", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			break;
		}

	}

	/**
	 * Checks if insert fields values are correct values
	 * 
	 * @return true or false
	 */
	private String checkInsertValues() {

		if (txtInsertName.getText().isBlank() || txtCategoryInsert.getText().isBlank()
				|| txtImageInsert.getText().isBlank() || txtSoundInsert.getText().isBlank()
				|| txtAbilityInsert.getText().isBlank() || txtDescriptionInsert.getText().isBlank()) {
			return "blank";
		}

		try {
			Float.parseFloat(txtWeightInsert.getText());
			Float.parseFloat(txtHeighInsert.getText());
			Integer.parseInt(txtPokeIdInsert.getText());
		} catch (NumberFormatException e) {
			return "numberformat";
		}

		for (Pokemon pokemon : allPokemons) {
			if (pokemon.getpId() == Integer.parseInt(txtPokeIdInsert.getText())) {
				return "duplicateid";
			}
		}

		for (Pokemon pokemon : allPokemons) {
			if (pokemon.getName().equals(txtInsertName.getText())) {
				return "duplicatename";
			}
		}

		if (listTypesInsert.getSelectedIndices().length == 0) {
			return "notypes";
		}

		if (!Utils.checkIfUrlIsAnImage(txtImageInsert.getText())) {
			return "img";
		}

		if (Utils.playSound(txtSoundInsert.getText()) == false) {
			return "sound";
		}

		return "ok";
	}

	private void insertNewPokemon() {
		String isValid = checkInsertValues();

		switch (isValid) {
		case "ok":
			int id = Integer.parseInt(txtPokeIdInsert.getText());
			String name = txtInsertName.getText();
			String ability = txtPokeAbilityText.getText();
			float height = Float.parseFloat(txtHeighInsert.getText());
			float weight = Float.parseFloat(txtWeightInsert.getText());
			String category = txtCategoryInsert.getText();
			String description = txtDescriptionInsert.getText();
			String soundURL = txtSoundInsert.getText();
			String imageURL = txtImageInsert.getText();

			int[] nTypes = listTypesInsert.getSelectedIndices();
			List<String> lTypes = listTypesInsert.getSelectedValuesList();
			String[] sTypes = new String[lTypes.size()];
			String[] finalSTypes = lTypes.toArray(sTypes);

			Pokemon pokemonToAdd = new Pokemon(id, name, description, height, weight, ability, category, imageURL,
					soundURL, finalSTypes);

			pokemonToAdd.insertNewPokemon(nTypes);

			allPokemons.add(pokemonToAdd);

			clearInsertTextBoxes();
			break;

		case "blank":
			JOptionPane.showMessageDialog(frame, "No puedes dejar campos vacíos", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;

		case "duplicateid":
			JOptionPane.showMessageDialog(frame, "Ya existe un pokemon con esa Id de Pokedex", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			break;

		case "duplicatename":
			JOptionPane.showMessageDialog(frame, "Ya existe un pokemon con ese nombre, por favor introduzca otro.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			break;

		case "numberformat":
			JOptionPane.showMessageDialog(frame,
					"Los valores peso y altura solo aceptan números (1.1, 2.3, 44.4...). Por favor, introducelos correctamente",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			break;

		case "notypes":
			JOptionPane.showMessageDialog(frame, "Por favor selecciona al menos un tipo", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			break;

		case "img":
			JOptionPane.showMessageDialog(frame, "La URL de la imagen debe ser una URL correcta a una imagen", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			break;

		case "sound":
			JOptionPane.showMessageDialog(frame, "La URL del sonido debe ser una URL correcta a un sonido", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			break;

		}

	}
}
