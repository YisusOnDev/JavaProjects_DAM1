package mainapp;

import java.util.Queue;

import models.PunishmentTail;

public class MainApp {

	public static void main(String[] args) {

		Queue<Integer> q = new PunishmentTail<Integer>((Integer a, Integer b) -> a - b);

	}

}
