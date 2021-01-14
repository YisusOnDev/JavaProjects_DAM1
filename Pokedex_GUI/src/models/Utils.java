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

	public static BufferedImage getBuferedImageIfValid(String imageUrl) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new URL(imageUrl));
			return img;
		} catch (IOException e) {
			return null;
		}
	}

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
}
