package ex4.exception;

@SuppressWarnings("serial")
public class NonEmptyTreeException extends RuntimeException {

public NonEmptyTreeException(String err) { super(err); }

}