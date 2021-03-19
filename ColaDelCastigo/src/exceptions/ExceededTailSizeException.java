package exceptions;

public class ExceededTailSizeException extends RuntimeException {

	private static final long serialVersionUID = 1841085531631374212L;
	private static final int MAXQUEUESIZE = 10;
	
	public ExceededTailSizeException() {
		super("Tail is full.");
	}
	

}
