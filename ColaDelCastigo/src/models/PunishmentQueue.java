package models;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

import exceptions.ElementBlockedException;
import exceptions.ExceededQueueSizeException;
import exceptions.TakeYourNullOutOfHereException;

public class PunishmentQueue<E> extends PriorityQueue<E> {

	private static final long serialVersionUID = 7969165372995763516L;

	private final static int MAX_QUEUE_SIZE = 10; // Max elements in the queue.

	/**
	 * Constructor for PunishmentQueue with comparatow (How to compare any element
	 * w/ other)
	 * 
	 * @param comparator The comparator itself.
	 */
	public PunishmentQueue(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Override add method from Queue, added error management (don't add more
	 * elements if queue is full, don't add nulls)
	 */
	@Override
	public boolean add(E arg0) throws ExceededQueueSizeException, TakeYourNullOutOfHereException {
		if (arg0 != null) {
			if (this.size() < 10) {
				super.add(arg0);
				return true;
			} else {
				throw new ExceededQueueSizeException();
			}
		} else {
			throw new TakeYourNullOutOfHereException();
		}
	}

	/**
	 * Override addAll method from Queue. As add method this overrided method checks
	 * after adding 1 element that queue is not already full).
	 */
	@Override
	public boolean addAll(Collection<? extends E> arg0)
			throws ExceededQueueSizeException, TakeYourNullOutOfHereException {
		int currentSize = this.size();

		if (currentSize + arg0.size() <= MAX_QUEUE_SIZE) {
			for (E element : arg0) {
				this.add(element);
			}
			return true;

		} else {
			throw new ExceededQueueSizeException();
		}
	}

	/**
	 * Override clear method from Queue. Added "security" check, if queue is already
	 * full you can't clear it).
	 */
	@Override
	public void clear() {
		if (this.size() < 10) {
			super.clear();
		} else {
			throw new ElementBlockedException();
		}
	}

}
