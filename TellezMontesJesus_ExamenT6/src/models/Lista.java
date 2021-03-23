package models;

import java.util.Arrays;

public class Lista<T> {

	private T[] elementos; // the array of elements atribute.
	private int index; // current index of the list.
	private int arraySize; // helper atribute to know every time the array size.

	/**
	 * Constructor for list. Set index to -1, initialize the elementos Array to 0
	 * also sets the arraySize to 0.
	 */
	@SuppressWarnings("unchecked")
	public Lista() {
		this.arraySize = 0;
		this.elementos = (T[]) new Object[arraySize];
		this.index = -1;
	}

	/**
	 * Method that adds an element to the list (if the element is not null) raising
	 * up the size of the list (Array). Also set this.index to the last element
	 * index.
	 * 
	 * @param element the element that need to be added.
	 */
	public void add(T element) {
		if (element != null) {
			this.index += 1;
			this.arraySize += 1;

			T[] tempArray = Arrays.copyOf(elementos, arraySize);
			tempArray[index] = element;
			this.elementos = tempArray;
		} else {
			throw new NullPointerException("You can add null elements to the list.");
		}
	}

	/**
	 * Method that returns the next element of the index circularly. Also set the
	 * current index to the current element index.
	 * 
	 * @return the next index circularly
	 */
	public T getNext() {
		int nextIndex = index + 1;

		if (nextIndex >= arraySize || nextIndex < 0) {
			this.index = 0;
			return elementos[index];
		} else {
			this.index = nextIndex;
			return elementos[nextIndex];
		}
	}

	/**
	 * Method that returns the previous element of the index. circularly. Also set
	 * the index to the current element index.
	 * 
	 * @return the previous index circularly
	 */
	public T getPrev() {
		int prevIndex = index - 1;
		if (prevIndex < 0) {
			this.index = arraySize - 1;
		} else {
			this.index = prevIndex;
		}

		return elementos[index];
	}

	/**
	 * Method that returns the element at the current index
	 * 
	 * @return the element at the current index
	 */
	public T getCurrent() {
		return elementos[index];
	}

	/**
	 * Method to set the current index to the given one.
	 * 
	 * @param i the index wanted
	 * @return -1 if index is out of bounds, i if setted correctly.
	 */
	public int setIndex(int i) {
		int indexToSet = i;

		if (indexToSet < 0 || indexToSet >= arraySize) {
			return -1;
		} else {
			this.index = indexToSet;
			return i;
		}
	}

	/**
	 * Method that removes (if exist) the given element. Generates a new array with
	 * new size. Sets the index to the previous element's index.
	 * 
	 * @param element the element to remove
	 */
	public void remove(T element) {
		if (element != null) {
			int checkIndex = -1;
			for (int index = 0; index < elementos.length; index++) {
				if (elementos[index].equals(element)) {
					checkIndex = index;
					break;
				}
			}

			if (checkIndex > -1) {
				int tempIndex = 0;

				this.arraySize -= 1;
				this.setIndex(checkIndex);

				elementos[index] = null;

				T[] tempArray = Arrays.copyOf(elementos, elementos.length - 1);

				for (T ob : elementos) {
					if (ob != null) {
						tempArray[tempIndex] = ob;
						tempIndex += 1;
					}
				}

				elementos = tempArray;

			}
		}
	}
}
