package controllers;

import utils.ConsoleHelper;

public class Controller {
	public void run() {
		mainMenu();
	}

	private void mainMenu() {
		do {
			ConsoleHelper.printMainMenu();
			int opc = ConsoleHelper.chooseOptionMenu(1, 3);
			switch (opc) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;

			}
		} while (ConsoleHelper.yesNo("Do more? Yes (1) No (0)"));
	}
}
