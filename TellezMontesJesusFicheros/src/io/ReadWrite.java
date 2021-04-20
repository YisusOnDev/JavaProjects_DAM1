package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Weather;
import utils.ConsoleHelper;

public class ReadWrite {

	/**
	 * Method that read a "weather" file with the given path
	 * 
	 * @param aPath String absolute path
	 * @return a weather list with all file data correctly imported
	 */
	public static List<Weather> readFile(String aPath) {
		List<Weather> weatherList = new ArrayList<Weather>();
		File f = new File(aPath);
		Scanner sc = null;

		try {
			sc = new Scanner(f, "UTF-8");

			// Delete first line
			if (sc.hasNextLine())
				sc.nextLine();

			// Read data
			while (sc.hasNextLine()) {
				var stringChain = sc.nextLine();
				var stringChains = stringChain.split(";");

				for (String s : stringChains) {
					while (s.endsWith(";")) {
						s = s.substring(0, s.length() - 1);
					}

					s = s.trim();
				}
				if (ConsoleHelper.checkIsDouble(stringChains[1]) && ConsoleHelper.checkIsDouble(stringChains[2])
						&& ConsoleHelper.checkIsDouble(stringChains[3])) {
					String month = stringChains[0];
					double maxT = Double.parseDouble((stringChains[1]));
					double minT = Double.parseDouble((stringChains[2]));
					double rainyDays = Double.parseDouble((stringChains[3]));
					weatherList.add(new Weather(month, maxT, minT, rainyDays));
				} else {
					System.out.println("File has incorrect format.");
					return null;
				}
			}
			// System.out.println(weatherList);

		} catch (FileNotFoundException e) {
			System.out.println("File could not be found.");
			// e.printStackTrace();
		} finally {
			sc.close();
		}

		return weatherList;
	}

	/**
	 * Method that write the weather table info into a file on the path received
	 * 
	 * @param route  absolute path
	 * @param curren tList weather list with the info
	 * @return true if succesfully written, false if anything bad occured.
	 */
	public static boolean writeFile(String route, List<Weather> currentList) {
		try {
			FileWriter myWriter = new FileWriter(route);

			for (Weather w : currentList) {
				myWriter.write(w.getMonth() + ";" + w.getMaxT() + ";" + w.getMinT() + ";" + w.getRainyDays());
			}
			myWriter.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
