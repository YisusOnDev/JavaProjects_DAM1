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
import java.util.LinkedHashMap;
import java.util.List;

import javax.imageio.ImageIO;
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
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import models.Pokemon;

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

	/**
	 * Create the application.
	 * 
	 * @param username
	 */
	public AdminView(String username) {
		this.currentUsername = username;
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
		setDBPokemons();
		setAvailableTypes();
		setUIComponents();
		setListeners();
		fillTypes();
		showPokemon(0);

		frame.setVisible(true);
	}

	private void fillTypes() {
		String[] types = new String[availableTypes.size()];
		String[] toSet = availableTypes.keySet().toArray(types);
		listPokeTypesEdit.setListData(toSet);
	}

	private void setDBPokemons() {
		allPokemons = new PokemonDAO().getAllPokemons();
	}

	private void setAvailableTypes() {
		availableTypes = new PokemonDAO().getAvailableCategories();

	}

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
		btnSignOut.setBounds(10, 452, 118, 23);
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
		btnExitAdmin.setBounds(138, 452, 80, 23);
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
		lblPokeWeightInsert.setBounds(276, 242, 46, 14);
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
		txtHeighInsert.setBounds(102, 242, 64, 14);
		pokeInsertPanel.add(txtHeighInsert);

		txtWeightInsert = new JTextField("");
		txtWeightInsert.setBounds(332, 242, 77, 14);
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

		btnPokeAddNew = new JButton("A\u00F1adir Pokemon");
		btnPokeAddNew.setBounds(713, 439, 130, 23);
		frame.getContentPane().add(btnPokeAddNew);

		btnClearNewPokeAreas = new JButton("Limpiar Campos");
		btnClearNewPokeAreas.setBounds(853, 439, 130, 23);
		frame.getContentPane().add(btnClearNewPokeAreas);

		btnPokeEdit = new JButton("Editar Pokemon");
		btnPokeEdit.setBounds(412, 439, 130, 23);
		frame.getContentPane().add(btnPokeEdit);

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
				playCustomSound(indexPokmeonList);
			}

		});

		btnPokeEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editCurrentPokemon();
			}

		});
	}

	private boolean checkEditValue() {

		if (txtPokeNameText.getText().isBlank() || txtPokeAbilityText.getText().isBlank()
				|| txtPokeHeighText.getText().isBlank() || txtPokeWeightText.getText().isBlank()
				|| txtPokeDescriptionText.getText().isBlank()) {
			return true;
		}

		try {
			Float.parseFloat(txtPokeHeighText.getText());
			Float.parseFloat(txtPokeWeightText.getText());
		} catch (NumberFormatException e) {
			return true;
		}
		
		
		if (listPokeTypesEdit.getSelectedIndices().length == 0) {
			return true;
		}
		

		return false;
	}

	private void editCurrentPokemon() {
		if (!checkEditValue()) {
			String name = txtPokeNameText.getText();
			String ability = txtPokeAbilityText.getText();
			float height = Float.parseFloat(txtPokeHeighText.getText());
			float weight = Float.parseFloat(txtPokeWeightText.getText());
			String category = txtPokeCategory.getText();
			String description = txtPokeDescriptionText.getText();
			int[] nTypes = listPokeTypesEdit.getSelectedIndices();
			
			List<String> lTypes = listPokeTypesEdit.getSelectedValuesList();
			String[] sTypes = new String[lTypes.size()];
			String[] finalSTypes = lTypes.toArray(sTypes);
			
			allPokemons.get(indexPokmeonList).updatePokemon(name, ability, height, weight, category, description, nTypes, finalSTypes);
		} else {
			JOptionPane.showMessageDialog(frame, "No puedes dejar campos vacíos, ni sin seleccionar, ni con valores incorrectos...", "ERROR", JOptionPane.ERROR_MESSAGE);
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

		lblPokeNum.setText("Número: " + currentNumber);
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
		BufferedImage img = null;
		try {
			img = ImageIO.read(new URL(currentImageUrl));
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
