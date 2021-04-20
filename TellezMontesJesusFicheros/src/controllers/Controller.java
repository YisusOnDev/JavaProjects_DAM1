package controllers;

import java.util.ArrayList;
import java.util.List;

import io.Read;
import models.Weather;
import utils.ConsoleHelper;

public class Controller {
	protected List<Weather> readTable;
	protected List<Weather> writeTable;

	public void run() {
		mainMenu();
	}

	private void mainMenu() {
		do {
			ConsoleHelper.printMainMenu();
			int opc = ConsoleHelper.chooseOptionMenu(1, 3);
			switch (opc) {
			case 1:
				String readPath = ConsoleHelper.getPathandFileMenu("read");
				if (readPath != null) {
					readTable = Read.readFile(readPath);
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

	private void showReadFormat() {
		String hottestMonth = getHottestMonth();
		String coldestMonth = getColdestMonth();
		System.out.println("Hottest month: " + hottestMonth + "\nColdest month: " + coldestMonth);
		showRainyMonths();
		showNonRainyMonths();
		showMaximumAVGAndMinimumMedTemp();
	}

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
