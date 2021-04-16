package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Show;

public class Read {

	/**
	 * Read default show list csv
	 * 
	 * @return an ArrayList with all shows loaded from default csv file
	 */
	public static List<Show> getShowList() {

		List<Show> showList = new ArrayList<Show>();
		File f = new File("assets/bettercsv2.csv");
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

				showList.add(new Show(stringChains[0], stringChains[1], stringChains[2], stringChains[3],
						stringChains[4], stringChains[5], stringChains[6]));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return showList;
	}

	public static List<Show> readBookmarkFile(String filepath) {

		List<Show> showList = new ArrayList<Show>();
		File f = new File(filepath);
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

				showList.add(new Show(stringChains[0], stringChains[1], stringChains[2], stringChains[3],
						stringChains[4], stringChains[5], stringChains[6], true));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return showList;
	}
}
