package controllers;

import java.util.ArrayList;
import java.util.List;

import io.ReadWrite;
import models.Weather;
import utils.ConsoleHelper;

public class Controller {
	protected List<Weather> readTable;
	protected List<Weather> writeTable;

	/**
	 * Run App
	 */
	public void run() {
		mainMenu();
	}

	/**
	 * Main Menu for App
	 */
	private void mainMenu() {
		do {
			ConsoleHelper.printMainMenu();
			int opc = ConsoleHelper.chooseOptionMenu(1, 3);
			switch (opc) {
			case 1:
				String readPath = ConsoleHelper.getPathandFileMenu("read");
				if (readPath != null) {
					readTable = ReadWrite.readFile(readPath);
					showReadFormat();
				} else {
					System.out.println("An error occured (could not load file)");
					mainMenu();
				}
				break;
			case 2:
				String writePath = ConsoleHelper.getPathandFileMenu("write");
				if (writePath != null) {
					createWeathersLoop();
					if (writeTable != null && writeTable.size() > -1) {
						boolean done = ReadWrite.writeFile(writePath, writeTable);
						if (done) {
							System.out.println("File write succesfully");
						} else {
							System.out.println(
									"An error occurred while trying to write the file (Bad path or bad file type).");
						}
					} else {
						System.out.println("You need to fill with atleast 1 month data before write a new file.");
						mainMenu();
					}
				} else {
					System.out.println("An error occured...");
					mainMenu();
				}
				break;
			case 3:

				break;

			}
		} while (ConsoleHelper.yesNo("Do more? Yes (1) No (0)"));

	}

	/**
	 * Method that prompt you to create a entry on the weather write table (loop)
	 */
	private void createWeathersLoop() {
		writeTable = new ArrayList<Weather>();
		do {
			String month = ConsoleHelper.readString("Type month:");
			double maxT = ConsoleHelper.readDouble("Type max temperature (double number): ");
			double minT = ConsoleHelper.readDouble("Type min temperature (double number): ");
			double rainyDays = ConsoleHelper
					.readDouble("Type rainy days count (0 if none) temperature (double number): ");

			writeTable.add(new Weather(month, maxT, minT, rainyDays));

		} while (ConsoleHelper.yesNo("Add more? Yes (1) No (0)"));

	}

	/**
	 * Method that prints month info properly "formatted"
	 */
	private void showReadFormat() {
		String hottestMonth = getHottestMonth();
		String coldestMonth = getColdestMonth();
		System.out.println("Hottest month: " + hottestMonth + "\nColdest month: " + coldestMonth);
		showRainyMonths();
		showNonRainyMonths();
		showMaximumAVGAndMinimumMedTemp();
	}

	/**
	 * Method that show maximum, minimum and avg temperature of all months
	 */
	private void showMaximumAVGAndMinimumMedTemp() {
		int div = readTable.size() + 1;
		double maxMed = 0.0;
		double minMed = 0.0;

		for (Weather weather : readTable) {
			maxMed += weather.getMaxT();
			minMed += weather.getMinT();
		}

		System.out.println("AVG Max Temperatures: " + maxMed / div + "Cº \n AVG Min Temperatures: " + minMed / div
				+ "Cº\nAVG Temperature: " + maxMed / minMed + "Cº");
	}

	/**
	 * Method to get hottest (max temp) month
	 * 
	 * @return hottest month name
	 */

	private String getHottestMonth() {
		double currentTemp = Double.MIN_VALUE;
		String month = null;
		for (Weather weather : readTable) {
			if (weather.getMaxT() > currentTemp) {
				currentTemp = weather.getMaxT();
				month = weather.getMonth();
			}
		}
		return month;
	}

	/**
	 * Method to get coldest (minimum temp) month
	 * 
	 * @return coldest month name
	 */
	private String getColdestMonth() {
		double currentTemp = Double.MAX_VALUE;
		String month = null;
		for (Weather weather : readTable) {
			if (weather.getMinT() < currentTemp) {
				currentTemp = weather.getMaxT();
				month = weather.getMonth();
			}
		}
		return month;
	}

	/**
	 * Method to show rainy month(s) names on a "string chain"
	 */
	private void showRainyMonths() {
		String toPrint = "Rainy months: ";
		for (Weather weather : readTable) {
			if (weather.getRainyDays() > 0) {
				toPrint += weather.getMonth() + ". ";
			}
		}

		if (toPrint.isBlank() || toPrint.isEmpty()) {
			toPrint = "None";
		} else {
			System.out.println(toPrint);
		}
	}

	/**
	 * Method to show the months with 0 rainy days
	 */
	private void showNonRainyMonths() {
		String toPrint = "Non Rainy months: ";
		for (Weather weather : readTable) {
			if (weather.getRainyDays() <= 0) {
				toPrint += weather.getMonth() + ". ";
			}
		}

		if (toPrint.isBlank() || toPrint.isEmpty()) {
			toPrint = "None";
		} else {
			System.out.println(toPrint);
		}
	}
}
