package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import io.Read;
import io.Write;
import models.Show;

public class MainView {
	private JLabel lblWindowTitle;
	private JFrame frame;
	private JTable showListTable;
	private JTextField textFieldSearch;
	private ButtonGroup filterButtons;
	private JCheckBox rdbtnTitleFilter;
	private JCheckBox rdbtnRatingFilter;
	private JCheckBox rdbtnDescriptionFilter;
	private JCheckBox rdbtnYearFilter;
	private JButton searchButton;
	private JButton btnSaveBookmark;
	private DefaultTableModel showListTableModel;
	private TableRowSorter<TableModel> rowSorter;
	private JButton btnSeeBookmarkList;
	private List<Show> fullShowList;

	private boolean viewingBookmarkFlag = false;

	private final int TITLE_FILTER = 1;
	private final int RATING_FILTER = 2;
	private final int DESCRIPTION_FILTER = 3;
	private final int YEAR_FILTER = 4;
	private JButton btnLoadBookmark;
	private JButton btnShowAllList;

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
		frame = new JFrame("Netflix Title Manager");
		ImageIcon img = new ImageIcon("assets/netflixicon.png");
		frame.setIconImage(img.getImage());
		frame.setBounds(100, 100, 1280, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		setUIComponents();
		setUIListeners();

		frame.setVisible(true);
	}

	/**
	 * Sets UI components
	 */
	private void setUIComponents() {
		lblWindowTitle = new JLabel("NETFLIX TITLE MANAGER");
		lblWindowTitle.setForeground(new Color(204, 0, 0));
		lblWindowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindowTitle.setFont(new Font("Yu Gothic UI", Font.BOLD, 42));
		lblWindowTitle.setBounds(10, 11, 1244, 93);
		frame.getContentPane().add(lblWindowTitle);

		rdbtnTitleFilter = new JCheckBox("Filter by title");
		rdbtnTitleFilter.setBounds(41, 111, 144, 23);
		frame.getContentPane().add(rdbtnTitleFilter);

		rdbtnRatingFilter = new JCheckBox("Filter by rating");
		rdbtnRatingFilter.setBounds(41, 137, 144, 23);
		frame.getContentPane().add(rdbtnRatingFilter);

		rdbtnDescriptionFilter = new JCheckBox("Filter by description");
		rdbtnDescriptionFilter.setBounds(193, 111, 155, 23);
		frame.getContentPane().add(rdbtnDescriptionFilter);

		rdbtnYearFilter = new JCheckBox("Filter by year");
		rdbtnYearFilter.setBounds(193, 137, 155, 23);
		frame.getContentPane().add(rdbtnYearFilter);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(389, 137, 487, 23);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);

		searchButton = new JButton("Search");
		searchButton.setBounds(910, 137, 344, 23);
		frame.getContentPane().add(searchButton);

		btnSaveBookmark = new JButton("Save bookmark to file");
		btnSaveBookmark.setBounds(554, 617, 228, 23);
		btnSaveBookmark.setVisible(false);
		frame.getContentPane().add(btnSaveBookmark);

		String dataCol[] = { "Title", "Rating", "Rating description", "Rating level", "Release Year",
				"User rating score", "User rating size", "Favourite" };
		showListTableModel = new DefaultTableModel(dataCol, 0);

		// Override some methods in order to use as our needs...
		showListTable = new JTable(showListTableModel) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				switch (column) {
				case 7:
					return true;
				default:
					return false;
				}
			}

			@Override
			public void setValueAt(Object val, int row, int col) {
				if (col == 7) {
					if (viewingBookmarkFlag) {
						for (Show show : fullShowList) {
							if (show.getTitle().equals(showListTableModel.getValueAt(row, 0))) {
								show.setFavourite(!show.isFavourite());
							}
						}
					} else {
						Show showToEdit = fullShowList.get(row);
						showToEdit.setFavourite(!showToEdit.isFavourite());
					}
				}
				super.setValueAt(val, row, col);
			}

			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 7:
					return Boolean.class;
				default:
					return String.class;
				}
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

		rowSorter = new TableRowSorter<>(showListTable.getModel());
		showListTable.setRowSorter(rowSorter);
		showListTable.setAutoCreateRowSorter(true);

		btnSeeBookmarkList = new JButton("See/Update bookmark list");
		btnSeeBookmarkList.setBounds(1026, 617, 228, 23);
		frame.getContentPane().add(btnSeeBookmarkList);

		btnLoadBookmark = new JButton("Load bookmark from file");
		btnLoadBookmark.setBounds(316, 617, 228, 23);
		btnLoadBookmark.setVisible(false);
		frame.getContentPane().add(btnLoadBookmark);

		btnShowAllList = new JButton("Show all shows");
		btnShowAllList.setBounds(792, 617, 228, 23);
		frame.getContentPane().add(btnShowAllList);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Sets UI Elements Listeners...
	 */
	private void setUIListeners() {
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textFieldSearch.getText();
				doSearch(text);
			}
		});
		textFieldSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textFieldSearch.getText();
				doSearch(text);
			}
		});
		btnSeeBookmarkList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openBookmarkedShows();
			}
		});
		btnShowAllList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refillShowListTable();
			}
		});
		btnSaveBookmark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFavToFile();
			}
		});
		btnLoadBookmark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readFavFile();
			}
		});

	}

	/**
	 * Method to fill JTable with Shows contents loaded from file.
	 */
	private void fillShowListTable() {
		viewingBookmarkFlag = false;
		fullShowList = Read.getShowList();
		showListTableModel.setRowCount(0);

		for (Show show : fullShowList) {
			Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
					show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
					show.getUser_rating_size(), show.isFavourite() };
			showListTableModel.addRow(detailRow);
		}

	}

	/**
	 * Method to REFILL the JTable with memory data of fullShowList
	 */
	private void refillShowListTable() {
		viewingBookmarkFlag = false;
		toggleReadWriteBookMarkButtons();
		showListTableModel.setRowCount(0);

		for (Show show : fullShowList) {
			Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
					show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
					show.getUser_rating_size(), show.isFavourite() };
			showListTableModel.addRow(detailRow);
		}
	}

	/**
	 * Method to make a search with or without filters.
	 * 
	 * @param text text from text field
	 */
	private void doSearch(String text) {
		int filterApplied = getSelectedFilters();

		if (filterApplied == 0 && text.trim().length() == 0 || text.isBlank()) {
			JOptionPane.showMessageDialog(frame,
					"Please fill the search text field in order to search with an enabled filter.",
					"Please fill search field", JOptionPane.WARNING_MESSAGE);
			if (!viewingBookmarkFlag) {
				refillShowListTable();
			} else {
				openBookmarkedShows();
			}

		} else {
			switch (filterApplied) {

			case 0:
				rowSorter.setRowFilter(RowFilter.regexFilter(text));
				break;

			case TITLE_FILTER:
				if (text.trim().length() == 0 || text.isBlank() && !viewingBookmarkFlag) {
					refillShowListTable();
				} else if (text.trim().length() == 0 || text.isBlank() && viewingBookmarkFlag) {
					openBookmarkedShows();
				} else {
					fillFilteredShowListTable(TITLE_FILTER, text);
				}
				break;

			case RATING_FILTER:
				if (text.trim().length() == 0 || text.isBlank() && !viewingBookmarkFlag) {
					refillShowListTable();
				} else if (text.trim().length() == 0 || text.isBlank() && viewingBookmarkFlag) {
					openBookmarkedShows();
				} else {
					fillFilteredShowListTable(RATING_FILTER, text);
				}
				break;

			case DESCRIPTION_FILTER:
				if (text.trim().length() == 0 || text.isBlank() && !viewingBookmarkFlag) {
					refillShowListTable();
				} else if (text.trim().length() == 0 || text.isBlank() && viewingBookmarkFlag) {
					openBookmarkedShows();
				} else {
					fillFilteredShowListTable(DESCRIPTION_FILTER, text);
				}
				break;

			case YEAR_FILTER:
				if (text.trim().length() == 0 || text.isBlank() && !viewingBookmarkFlag) {
					refillShowListTable();
				} else if (text.trim().length() == 0 || text.isBlank() && viewingBookmarkFlag) {
					openBookmarkedShows();
				} else {
					fillFilteredShowListTable(YEAR_FILTER, text);
				}
				break;

			}
			toggleReadWriteBookMarkButtons();
		}

	}

	/**
	 * Method to get the filter to apply on search
	 * 
	 * @return int (Number of filter)
	 */
	private int getSelectedFilters() {
		if (rdbtnTitleFilter.isSelected()) {
			return TITLE_FILTER;

		} else if (rdbtnRatingFilter.isSelected()) {
			return RATING_FILTER;

		} else if (rdbtnDescriptionFilter.isSelected()) {
			return DESCRIPTION_FILTER;

		} else if (rdbtnYearFilter.isSelected()) {
			return YEAR_FILTER;

		} else {
			return 0;
		}
	}

	/**
	 * Method to fill JTable with filtered data
	 * 
	 * @param filter filtered applied
	 * @param text   text to search with the filter
	 */
	private void fillFilteredShowListTable(int filter, String text) {
		showListTableModel.setRowCount(0);

		switch (filter) {

		case TITLE_FILTER:
			for (Show show : fullShowList) {
				if (show.getTitle().contains(text)) {
					if (viewingBookmarkFlag) {
						if (show.isFavourite()) {
							Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
									show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
									show.isFavourite() };
							showListTableModel.addRow(detailRow);
						}
					} else {
						Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
								show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
								show.isFavourite() };
						showListTableModel.addRow(detailRow);
					}
				}
			}
			break;

		case RATING_FILTER:
			for (Show show : fullShowList) {
				if (show.getRating().contains(text)) {
					if (viewingBookmarkFlag) {
						if (show.isFavourite()) {
							Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
									show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
									show.isFavourite() };
							showListTableModel.addRow(detailRow);
						}
					} else {
						Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
								show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
								show.isFavourite() };
						showListTableModel.addRow(detailRow);
					}
				}
			}
			break;

		case DESCRIPTION_FILTER:
			for (Show show : fullShowList) {
				if (show.getRatinglevel().contains(text)) {
					if (viewingBookmarkFlag) {
						if (show.isFavourite()) {
							Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
									show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
									show.isFavourite() };
							showListTableModel.addRow(detailRow);
						}
					} else {
						Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
								show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
								show.isFavourite() };
						showListTableModel.addRow(detailRow);
					}
				}
			}
			break;

		case YEAR_FILTER:
			for (Show show : fullShowList) {
				if (show.getRelease_year().contains(text)) {
					if (viewingBookmarkFlag) {
						if (show.isFavourite()) {
							Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
									show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
									show.isFavourite() };
							showListTableModel.addRow(detailRow);
						}
					} else {
						Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
								show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
								show.isFavourite() };
						showListTableModel.addRow(detailRow);
					}
				}
			}
			break;

		}

		if (showListTableModel.getRowCount() <= 0) {
			JOptionPane.showMessageDialog(frame, "No results found in this search.", "No data found",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Method to fill JTable with only bookmarked Shows
	 */
	private void openBookmarkedShows() {
		viewingBookmarkFlag = true;
		toggleReadWriteBookMarkButtons();
		showListTableModel.setRowCount(0);
		for (Show show : fullShowList) {
			if (show.isFavourite()) {
				Object[] detailRow = { show.getTitle(), show.getRating(), show.getRatinglevel(),
						show.getRatingdescription(), show.getRelease_year(), show.getUser_rating_score(),
						show.getUser_rating_size(), show.isFavourite() };
				showListTableModel.addRow(detailRow);
			}
		}
	}

	/**
	 * Method to show or not the bookmark load/save buttons
	 */
	private void toggleReadWriteBookMarkButtons() {
		if (viewingBookmarkFlag) {
			btnLoadBookmark.setVisible(true);
			btnSaveBookmark.setVisible(true);
		} else {
			btnLoadBookmark.setVisible(false);
			btnSaveBookmark.setVisible(false);
		}
	}
	
	/**
	 * Method to save bookmarked shows to a file
	 */
	private void saveFavToFile() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setFileFilter(filter);
		int result = fileChooser.showSaveDialog(frame);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath() + ".csv";
			System.out.println(filePath);
			try {
				File myObj = new File(filePath);
				if (myObj.createNewFile()) {
					boolean written = Write.writeBookmarkFile(filePath, fullShowList);
					if (written) {
						JOptionPane.showMessageDialog(frame, "File saved correctly.", "File saved",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame, "An error has occured while trying to save the file...",
								"File error", JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(frame, "File already exist...", "Error on saving file",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "Error...", "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to read bookamark file
	 */
	private void readFavFile() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setFileFilter(filter);
		int result = fileChooser.showOpenDialog(frame);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();
			System.out.println(filePath);
			List<Show> bookmarkedShowsFile = Read.readBookmarkFile(filePath);
			if (bookmarkedShowsFile != null) {
				Show foundShow = null;
				fullShowList = Read.getShowList();
				for (Show bookShow : bookmarkedShowsFile) {
					for (Show show : fullShowList) {
						if (bookShow.getTitle().equals(show.getTitle())) {
							foundShow = show;
						}
					}
					if (foundShow != null) {
						fullShowList.remove(foundShow);
						fullShowList.add(bookShow);
						foundShow = null;
					}
				}

				refillShowListTable();
				JOptionPane.showMessageDialog(frame, "Bookmarks succesfull loaded from file.", "Bookmarks loaded",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
