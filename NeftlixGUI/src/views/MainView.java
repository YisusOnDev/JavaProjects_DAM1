package views;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import io.Read;
import models.Show;

public class MainView {
	private JLabel lblWindowTitle;
	private JFrame frame;
	private JTable showListTable;
	private JTextField textFieldSearch;
	private ButtonGroup filterButtons;
	private JRadioButton rdbtnTitleFilter;
	private JRadioButton rdbtnRatingFilter;
	private JRadioButton rdbtnDescriptionFilter;
	private JRadioButton rdbtnYearFilter;
	private JButton searchButton;
	private JButton btnMoreInfo;
	private DefaultTableModel showListTableModel;

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
		frame.setBounds(100, 100, 1280, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		setUIComponents();

		frame.setVisible(true);
	}

	private void setUIComponents() {
		lblWindowTitle = new JLabel("NETFLIX TITLE MANAGER");
		lblWindowTitle.setForeground(new Color(204, 0, 0));
		lblWindowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindowTitle.setFont(new Font("Yu Gothic UI", Font.BOLD, 42));
		lblWindowTitle.setBounds(10, 11, 1244, 93);
		frame.getContentPane().add(lblWindowTitle);

		rdbtnTitleFilter = new JRadioButton("Filter by title");
		rdbtnTitleFilter.setBounds(41, 111, 144, 23);
		frame.getContentPane().add(rdbtnTitleFilter);

		rdbtnRatingFilter = new JRadioButton("Filter by rating");
		rdbtnRatingFilter.setBounds(41, 137, 144, 23);
		frame.getContentPane().add(rdbtnRatingFilter);

		rdbtnDescriptionFilter = new JRadioButton("Filter by description");
		rdbtnDescriptionFilter.setBounds(193, 111, 155, 23);
		frame.getContentPane().add(rdbtnDescriptionFilter);

		rdbtnYearFilter = new JRadioButton("Filter by year");
		rdbtnYearFilter.setBounds(193, 137, 155, 23);
		frame.getContentPane().add(rdbtnYearFilter);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(389, 137, 487, 23);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);

		searchButton = new JButton("Search");
		searchButton.setBounds(910, 137, 344, 23);
		frame.getContentPane().add(searchButton);

		btnMoreInfo = new JButton("+ Information about this title");
		btnMoreInfo.setBounds(1026, 617, 228, 23);
		frame.getContentPane().add(btnMoreInfo);

		String dataCol[] = { "Title", "Rating", "Rating description", "Rating level", "Release Year", "User rating score"};
		showListTableModel = new DefaultTableModel(dataCol, 0);
		showListTable = new JTable(showListTableModel) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		showListTable.setDragEnabled(false);
		showListTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(showListTable);
		scrollPane.setBounds(10, 167, 1244, 439);
		frame.getContentPane().add(scrollPane);
		fillShowListTable();

		filterButtons = new ButtonGroup();
		filterButtons.add(rdbtnTitleFilter);
		filterButtons.add(rdbtnRatingFilter);
		filterButtons.add(rdbtnDescriptionFilter);
		filterButtons.add(rdbtnYearFilter);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void fillShowListTable() {
		List<Show> fullShowList = Read.getShowList();

		for (Show show : fullShowList) {
			Object[] detailRow = {show.getTitle(), show.getRating(), show.getRatinglevel(), show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score()};
			showListTableModel.addRow(detailRow);
		}

	}
}
