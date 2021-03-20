package exceptions;

public class TakeYourNullOutOfHereException extends NullPointerException {

	private static final long serialVersionUID = 8481553842741894741L;

	/**
	 * Exception: when you try to add a null element.
	 */
	public TakeYourNullOutOfHereException() {
		super("We don't want nulls around here buddy.");
	}

}
