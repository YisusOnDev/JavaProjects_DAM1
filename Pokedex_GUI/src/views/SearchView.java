package views;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.PokemonDAO;
import models.Pokemon;
import javax.swing.JCheckBox;

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
	private ArrayList<Pokemon> filteredPokemons;
	private LinkedHashMap<String, Integer> availableTypes;
	private JList<String> listTypes;

	/**
	 * Create the application.
	 */
	public SearchView(String username, ArrayList<Pokemon> pokeList) {
		currentUsername = username;
		allPokemons = pokeList;
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
		frame.getContentPane().add(txtName);
		
		typeScrollPain = new JScrollPane();
		typeScrollPain.setBounds(144, 120, 183, 66);
		frame.getContentPane().add(typeScrollPain);
		
		listTypes = new JList<String>();
		typeScrollPain.setViewportView(listTypes);
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
				frame.setVisible(false);
				searchFilteredPokemon();
				
				
				//new SearchedPokemonView(frame, currentUsername, allPokemons);
				
			}
		});

		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new PokemonView(currentUsername);
			}
		});

	}
	
	/**
	 * Method that fills the 2 JList with all available pokemon types.
	 */
	private void fillTypes() {
		availableTypes = new PokemonDAO().getAvailableCategories();
		String[] types = new String[availableTypes.size()];
		String[] toSet = availableTypes.keySet().toArray(types);
		listTypes.setListData(toSet);
	}
	
	private void searchFilteredPokemon() {
		filteredPokemons = new ArrayList<Pokemon>();
		int[] nTypes = listTypes.getSelectedIndices();
	}
}
