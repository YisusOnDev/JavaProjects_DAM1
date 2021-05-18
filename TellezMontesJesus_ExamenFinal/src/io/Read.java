package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Read {
	public static List<String> getSqlConfig(String path) {

		List<String> cfg = new ArrayList<String>();
		File f = new File(path);
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
	}
}
