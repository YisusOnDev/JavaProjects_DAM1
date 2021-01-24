package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.PokemonDAO;
import models.Pokemon;

public class SearchView {

	private JFrame frame;
	private JTextField txtNumber;
	private JLabel lblNumber;
	private JLabel lblName;
	private JButton btnSearch;
	private JLabel lblSearch;
	private JLabel lblType;
	private JButton btnReturn;
	private JTextField txtName;
	private JScrollPane typeScrollPain;
	private String currentUsername;
	private JCheckBox chckbxName;
	private JCheckBox chckbxTypes;
	private JCheckBox chckbxNumber;

	private ArrayList<Pokemon> allPokemons;
	private LinkedHashMap<String, Integer> availableTypes = new PokemonDAO().getAvailableCategories();
	private JList<String> listTypes;
	private boolean parentIsTeam = false;

	/**
	 * Create the application.
	 */
	public SearchView(String username, ArrayList<Pokemon> pokeList, boolean parentIsTeamFlag) {
		currentUsername = username;
		allPokemons = pokeList;
		parentIsTeam = parentIsTeamFlag;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 378, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		setUIComponents();
		setListeners();
		fillTypes();

		frame.setVisible(true);
	}

	/**
	 * Method that sets all UI Components
	 */
	private void setUIComponents() {
		lblNumber = new JLabel("N\u00FAmero Pokedex:");
		lblNumber.setBounds(33, 67, 115, 14);
		frame.getContentPane().add(lblNumber);

		txtNumber = new JTextField();
		txtNumber.setBounds(144, 64, 183, 20);
		frame.getContentPane().add(txtNumber);
		txtNumber.setEnabled(false);
		txtNumber.setColumns(10);

		lblName = new JLabel("Nombre:");
		lblName.setBounds(33, 95, 115, 14);
		frame.getContentPane().add(lblName);

		btnSearch = new JButton("Buscar");
		btnSearch.setBounds(90, 212, 89, 23);
		frame.getContentPane().add(btnSearch);

		lblSearch = new JLabel("Buscar Pokemon");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSearch.setBounds(10, 11, 352, 42);
		frame.getContentPane().add(lblSearch);

		lblType = new JLabel("Tipo(s):");
		lblType.setBounds(33, 120, 115, 14);
		frame.getContentPane().add(lblType);

		btnReturn = new JButton("Volver");
		btnReturn.setBounds(189, 212, 89, 23);
		frame.getContentPane().add(btnReturn);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(144, 92, 183, 20);
		txtName.setEnabled(false);
		frame.getContentPane().add(txtName);

		typeScrollPain = new JScrollPane();
		typeScrollPain.setBounds(144, 120, 183, 66);
		frame.getContentPane().add(typeScrollPain);

		listTypes = new JList<String>();
		typeScrollPain.setViewportView(listTypes);
		listTypes.setEnabled(false);
		listTypes.setSelectedIndices(new int[] {});

		chckbxNumber = new JCheckBox("");
		chckbxNumber.setBounds(6, 64, 21, 23);
		frame.getContentPane().add(chckbxNumber);

		chckbxName = new JCheckBox("");
		chckbxName.setBounds(6, 90, 21, 23);
		frame.getContentPane().add(chckbxName);

		chckbxTypes = new JCheckBox("");
		chckbxTypes.setBounds(6, 116, 21, 23);
		frame.getContentPane().add(chckbxTypes);
	}

	/**
	 * Method that set listeners and events
	 */
	private void setListeners() {
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkInputIsValid()) {
					searchFilteredPokemon();
				}

			}
		});

		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				if (parentIsTeam) {
					new TeamView(currentUsername, allPokemons);
				} else {
					new PokemonView(currentUsername);
				}

			}
		});

		chckbxName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxName.isSelected()) {
					txtName.setEnabled(true);
				} else {
					txtName.setText("");
					txtName.setEnabled(false);
				}
			}
		});

		chckbxNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNumber.isSelected()) {
					txtNumber.setEnabled(true);
				} else {
					txtNumber.setText("");
					txtNumber.setEnabled(false);
				}
			}
		});

		chckbxTypes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxTypes.isSelected()) {
					listTypes.setEnabled(true);
				} else {
					listTypes.setSelectedIndices(new int[0]);
					listTypes.setEnabled(false);
				}
			}
		});
	}

	/**
	 * Method that fills the 2 JList with all available pokemon types.
	 */
	private void fillTypes() {
		String[] types = new String[availableTypes.size()];
		String[] toSet = availableTypes.keySet().toArray(types);
		listTypes.setListData(toSet);
	}
	
	private void searchFilteredPokemon() {
		ArrayList<Pokemon> filteredPokemons = new ArrayList<Pokemon>();
		boolean canContinue = false;
		for (Pokemon p : allPokemons) {
			if (chckbxNumber.isSelected()) {
				if (p.getpId() != Integer.parseInt(txtNumber.getText())) {
					canContinue = true;
				}
			}
			if (chckbxName.isSelected()) {
				if (!p.getName().toLowerCase().contains(txtName.getText().toLowerCase())) {
					canContinue = true;
				}
			}
			if (chckbxTypes.isSelected()) {
				List<String> types = Arrays.asList(p.getTypes());
				String[] currentTypes = new String[availableTypes.size()];
				String[] toSet = availableTypes.keySet().toArray(currentTypes);
				for (int i = 0; i < listTypes.getSelectedIndices().length; i++) {
					String currentType = toSet[listTypes.getSelectedIndices()[i]];
					if (!types.contains(currentType)) {
						canContinue = true;
					}
				}
			}
			if (canContinue) {
				canContinue = false;
				continue;
			}
			filteredPokemons.add(p);

		}

		if (!filteredPokemons.isEmpty()) {
			frame.setVisible(false);
			if (parentIsTeam) {
				new TeamSearchPokemonView(frame, currentUsername, filteredPokemons);
			} else {
				new SearchedPokemonView(frame, currentUsername, filteredPokemons);
			}

		} else {
			JOptionPane.showMessageDialog(frame, "No se han encontrado resultados", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

	private boolean checkInputIsValid() {
		if (chckbxNumber.isSelected()) {
			try {
				Integer.parseInt(txtNumber.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(frame,
						"Si quieres bucar por ID de pokedex tienes que introducir un numero entero", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		if (chckbxName.isSelected()) {
			if (txtName.getText().isBlank()) {
				JOptionPane.showMessageDialog(frame, "Si quieres buscar por nombre, debes introducir un nombre", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		if (chckbxTypes.isSelected()) {
			if (listTypes.getSelectedIndices().length == 0) {
				JOptionPane.showMessageDialog(frame, "Si quieres buscar por tipos debes de seleccionar al menos 1",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		// Also if no checkbox is checked the result will be just all the pokemon'

		return true;

	}
}
