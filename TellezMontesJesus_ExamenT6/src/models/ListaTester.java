package models;

public class ListaTester {
	// Tester class for Lista Class.

	public static void addTest() {
		Lista<Integer> lista = new Lista<Integer>();
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;

		lista.add(a);
		lista.add(b);
		lista.add(c);
		lista.add(d);

		System.out.println(lista.getCurrent());
	}

	public static void getNextorPreviousTest() {
		Lista<Integer> lista = new Lista<Integer>();
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;

		lista.add(a);
		lista.add(b);
		lista.add(c);
		lista.add(d);

		System.out.println("Next: " + lista.getNext());

		System.out.println("Previous: " + lista.getPrev());
	}

	public static void setAndGetCurrentTest() {
		Lista<Integer> lista = new Lista<Integer>();
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;

		lista.add(a);
		lista.add(b);
		lista.add(c);
		lista.add(d);

		lista.setIndex(1);

		System.out.println("Current before: " + lista.getCurrent());

		lista.setIndex(10);

		System.out.println("Current after: " + lista.getCurrent());
	}

	public static void removeTestOk() {
		Lista<Integer> lista = new Lista<Integer>();
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;

		lista.add(a);
		lista.add(b);
		lista.add(c);
		lista.add(d);

		lista.remove(c);

		System.out.print("Current after removing some element: " + lista.getCurrent());
	}

	public static void removeTestFail() {
		Lista<Integer> lista = new Lista<Integer>();
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;

		lista.add(a);
		lista.add(b);
		lista.add(c);
		lista.add(d);

		lista.remove(e);

		System.out.print("Current after failed on removing some element: " + lista.getCurrent());
	}
}
