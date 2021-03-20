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
	}

	/**
	 * Tester for adding null on add/addall method of PunishmentQueue class.
	 */
	public void nullTest() {
		q.add(1);
		q.add(5);
		q.add(2);
		q.add(3);
		q.add(7);
		q.add(null);
	}

	/**
	 * Tester for adding more than maxSize elements on add/addall method of PunishmentQueue class.
	 */
	public void maxSizeTest() {
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
	}

	/**
	 * Tester for clear method of PunishmentQueue class.
	 */
	public void clearTest() {
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
	}

	/**
	 * Tester for clear method (fail) of PunishmentQueue class.
	 */
	public void clearFailTest() {
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
	}
	
	/**
	 * Tester for addAll method of PunishmentQueue class.
	 */
	public void addAllOk() {
		ArrayList<Integer> fullArrayTest = new ArrayList<Integer>();
		for (int i = 1; i < 11; ++i) {
			fullArrayTest.add(i);
		}
		q.addAll(fullArrayTest);
		System.out.println(q);
	}
}
