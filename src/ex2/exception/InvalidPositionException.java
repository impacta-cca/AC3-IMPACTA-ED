package ex2.exception;

@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException {

	public InvalidPositionException(String err) {
		super(err);
	}

}
