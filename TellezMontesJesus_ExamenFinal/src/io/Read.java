package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Read {
	/**
	 * Method that reads a SQL CONFIG file thats in into the received path and
	 * return a list of string with database name, user and password
	 * 
	 * @param path file cfg path
	 * @return List<String> with name, username and password of the database
	 * @throws Exception 
	 */
	public static List<String> getSqlConfig(String path) throws Exception {

		List<String> cfg = new ArrayList<String>();
		File f = new File(path);
		if (f.exists()) {
			Scanner sc = null;
			try {
				sc = new Scanner(f, "UTF-8");

				// Read data
				while (sc.hasNextLine()) {
					var stringChain = sc.nextLine();
					var stringChains = stringChain.split("=");
					for (String s : stringChains) {
						s = s.trim();
						if (!s.equals("dbName") && !s.equals("username") && !s.equals("password")) {
							cfg.add(s);
						}
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				sc.close();
			}
			return cfg;
		} else {
			throw new Exception("File does not exist");
		}
	}
}
