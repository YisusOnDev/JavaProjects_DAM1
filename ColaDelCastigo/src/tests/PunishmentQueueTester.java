package tests;

import java.util.ArrayList;

import models.PunishmentQueue;

public class PunishmentQueueTester {

	protected PunishmentQueue<Integer> q = new PunishmentQueue<Integer>(
			(Integer n1, Integer n2) -> n1.intValue() - n2.intValue());

	/**
	 * Tester for add method of PunishmentQueue class.
	 */
	public void addTest() {
		try {
			q.add(1);
			q.add(5);
			q.add(2);
			q.add(3);
			q.add(7);
			q.add(9);
			q.add(4);
			q.add(6);
			q.add(8);
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
			q.add(1);
			q.add(5);
			q.add(2);
			q.add(3);
			q.add(7);
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
			q.add(1);
			q.add(5);
			q.add(2);
			q.add(3);
			q.add(7);
			q.add(9);
			q.add(4);
			q.add(6);
			q.add(8);
			q.add(10);
			q.add(24);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tester for clear method of PunishmentQueue class.
	 */
	public void clearTest() {
		try {
			q.add(1);
			q.add(5);
			q.add(2);
			q.add(3);
			q.add(7);
			q.add(9);
			q.add(4);
			q.add(6);
			q.add(8);
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
			q.add(1);
			q.add(5);
			q.add(2);
			q.add(3);
			q.add(7);
			q.add(9);
			q.add(4);
			q.add(6);
			q.add(8);
			q.add(10);
			q.clear();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tester for addAll method of PunishmentQueue class.
	 */
	public void addAllOk() {
		ArrayList<Integer> fullArrayTest = new ArrayList<Integer>();

		for (int i = 1; i < 11; ++i) {
			fullArrayTest.add(i);
		}

		try {
			q.addAll(fullArrayTest);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		System.out.println(q);
	}
}
