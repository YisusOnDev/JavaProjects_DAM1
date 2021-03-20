package mainapp;

import java.util.Comparator;

import models.PunishmentQueue;

public class MainApp {

	public static final Comparator<Integer> DESCENDING_COMPARATOR = new Comparator<Integer>() {
		public int compare(Integer a, Integer b) {
			return a - b;
		}
	};

	public static void main(String[] args) {

		PunishmentQueue<Integer> q = new PunishmentQueue<Integer>(DESCENDING_COMPARATOR);
		q.add(1);
		q.add(3);
		q.add(2);
		q.add(-1);
		q.add(4);
		q.add(10);
		q.add(9);
		q.add(7);
		System.out.println(q);

	}

}
