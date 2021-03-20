package exceptions;

public class ElementBlockedException extends RuntimeException {

	private static final long serialVersionUID = -5702190771079594131L;

	/**
	 * Exception: when you try to clear a full queue.
	 */
	public ElementBlockedException() {
		super("Queue is full, you can't clear a completed queue.");
	}

}
