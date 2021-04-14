package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Show;

public class Read {

	public static List<Show> getShowList() {

		List<Show> showList = new ArrayList<Show>();
		File f = new File("assets/bettercsv2.csv");
		boolean isString = false;
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

				String stringWithQuotes = "";
				for (String s : stringChains) {
					while (s.endsWith(";")) {
						s = s.substring(0, s.length() - 1);
					}

					s = s.trim();
				}
				
				//System.out.println(stringChains[0] + " " + stringChains[1] + " " + stringChains[2] + " "
				//		+ stringChains[3] + " " + stringChains[4] + " " + stringChains[5]);

				showList.add(new Show(stringChains[0], stringChains[1], stringChains[2], stringChains[3], stringChains[4], stringChains[5]));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return showList;
	}

	public static <E> List<E> readFileList(String path) {

		List<E> List = new ArrayList<E>();
		File f = new File(path);
		boolean isString = false;
		Scanner sc = null;
		try {
			sc = new Scanner(f, "UTF-8");

			// Delete first line
			if (sc.hasNextLine())
				sc.nextLine();

			// Read data
			while (sc.hasNextLine()) {
				var stringChain = sc.nextLine();
				var stringChains = stringChain.split(",");

				String stringWithQuotes = "";
				for (String s : stringChains) {
					// Escape full strings
					if (s.startsWith("\"")) {
						isString = true;
					}
					if (isString) {
						stringWithQuotes += s + ",";
					}
					if (s.endsWith("\"")) {
						isString = false;
						s = stringWithQuotes;
						stringWithQuotes = "";
					}

					s = s.replaceAll("\"", "");
					while (s.endsWith(",")) {
						s = s.substring(0, s.length() - 1);
					}
					s = s.trim();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return List;
	}
}
