package exceptions;

public class ExceededQueueSizeException extends RuntimeException {

	private static final long serialVersionUID = 1841085531631374212L;

	/**
	 * Exception: when you try to add an element when queue is already full.
	 */
	public ExceededQueueSizeException() {
		super("Queue is already full.");
	}

}
