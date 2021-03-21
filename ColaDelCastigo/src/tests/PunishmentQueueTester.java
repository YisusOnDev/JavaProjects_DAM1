package tests;

import java.util.ArrayList;
import java.util.List;

import models.PunishmentQueue;

public class PunishmentQueueTester {

	protected PunishmentQueue<String> q = new PunishmentQueue<String>((String s1, String s2) -> s2.compareTo(s1));

	/**
	 * Tester for add method of PunishmentQueue class.
	 */
	public void addTest() {
		try {
			q.add("a");
			q.add("f");
			q.add("b");
			q.add("c");
			q.add("g");
			q.add("i");
			q.add("j");
			q.add("k");
			q.add("m");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println(q);
	}

	/**
	 * Tester for adding null on add/addall method of PunishmentQueue class.
	 */
	public void nullTest() {
		try {
			q.add("a");
			q.add("f");
			q.add("b");
			q.add("c");
			q.add("g");
			q.add(null);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tester for adding more than maxSize elements on add/addall method of
	 * PunishmentQueue class.
	 */
	public void maxSizeTest() {
		try {
			q.add("a");
			q.add("f");
			q.add("b");
			q.add("c");
			q.add("g");
			q.add("i");
			q.add("j");
			q.add("k");
			q.add("m");
			q.add("o");
			q.add("p");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tester for clear method of PunishmentQueue class.
	 */
	public void clearTest() {
		try {
			q.add("a");
			q.add("f");
			q.add("b");
			q.add("c");
			q.add("g");
			q.add("i");
			q.add("j");
			q.add("k");
			q.add("m");
			System.out.println(q);
			q.clear();
			System.out.println(q);

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tester for clear method (fail) of PunishmentQueue class.
	 */
	public void clearFailTest() {
		try {
			q.add("a");
			q.add("f");
			q.add("b");
			q.add("c");
			q.add("g");
			q.add("i");
			q.add("j");
			q.add("k");
			q.add("m");
			q.add("o");
			q.clear();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tester for addAll method of PunishmentQueue class.
	 */
	public void addAllOk() {
		List<String> fullArrayTest = new ArrayList<String>();

		fullArrayTest.add("a");
		fullArrayTest.add("f");
		fullArrayTest.add("b");
		fullArrayTest.add("c");
		fullArrayTest.add("g");
		fullArrayTest.add("i");
		fullArrayTest.add("j");
		fullArrayTest.add("k");
		fullArrayTest.add("m");
		fullArrayTest.add("o");

		try {
			q.addAll(fullArrayTest);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		System.out.println(q);
	}
}
