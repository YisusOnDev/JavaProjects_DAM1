package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class LoadingScreen {

	/**
	 * Simple method to simulate a loading screen...
	 */
	public static void start() {
		JWindow loadingScreen = new JWindow();

		loadingScreen.getContentPane().add(new JLabel("", new ImageIcon("assets/loading.gif"), SwingConstants.CENTER));
		loadingScreen.setBounds(500, 150, 490, 400);
		loadingScreen.setVisible(true);

		try {
			Thread.sleep(5000);
			loadingScreen.setVisible(false);
			loadingScreen.dispose();
			new MainView();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
