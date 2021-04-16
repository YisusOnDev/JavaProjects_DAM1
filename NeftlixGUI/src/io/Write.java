package io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import models.Show;

public class Write {

	public static boolean writeBookmarkFile(String route, List<Show> currentList) {
		try {
			FileWriter myWriter = new FileWriter(route);
			myWriter.write("﻿title;rating;ratinglevel;ratingdescription;release_year;user_rating_score;user_rating_size \n");
			for (Show show : currentList) {
				if (show.isFavourite()) {
					myWriter.write(show.getTitle() + ";" +  show.getRating() + ";" +  show.getRatinglevel() + ";" + 
							show.getRatingdescription() + ";" +  show.getRelease_year() + ";" + show.getUser_rating_score() + ";" + show.getUser_rating_size() + "\n");
				}
			}
			myWriter.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
