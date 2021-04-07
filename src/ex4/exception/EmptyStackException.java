package ex4.exception;

@SuppressWarnings("serial")

public class EmptyStackException extends RuntimeException {
	public EmptyStackException(String err) {
		super(err);
	}

}
