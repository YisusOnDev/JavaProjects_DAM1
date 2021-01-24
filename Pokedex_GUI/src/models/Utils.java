package models;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

public class Utils {

	/**
	 * Method to play a sound, alternally checks if partially valid
	 * 
	 * @param soundURL the sound url (needs to end with .mp3)
	 * @return true if played false if failed
	 */
	public static boolean playSound(String soundURL) {
		// Initialize sound libs of JavaFX
		com.sun.javafx.application.PlatformImpl.startup(() -> {
		});

		if (!soundURL.endsWith(".mp3")) {
			return false;
		}

		try {
			// Create media player and load sound from url
			MediaPlayer mediaPlayer = new MediaPlayer(new Media(soundURL));

			// Play sound
			mediaPlayer.play();

			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		} catch (MediaException exception) {
			return false;
		} catch (Exception exception) {
			return false;
		}

	}

	/**
	 * Method to generate a bufferedImage from image url
	 * 
	 * @param imageUrl the image URL
	 * @return the bufferedImage if valid, null if invalid / can't load
	 */
	public static BufferedImage getBuferedImageIfValid(String imageUrl) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new URL(imageUrl));
			return img;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Method that checks if the given url is an image
	 * 
	 * @param imageUrl the image url
	 * @return true if is an image, false if fails
	 */
	public static boolean checkIfUrlIsAnImage(String imageUrl) {
		try {
			BufferedImage image = ImageIO.read(new URL(imageUrl));
			if (image != null) {
				return true;
			} else {
				return false;
			}

		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	public static boolean checkStringIsIntNumberOption(String n, int min, int max) {
		int number = 0;
		try {
			number = Integer.parseInt(n);
		} catch (NumberFormatException e) {
			return false;
		}
		
		if (number >= min && number <= max) {
			return true;
		} else {
			return false;
		}
	}
}
