package exception;

public class EmptyTreeException extends RuntimeException {

	// Exce��o lan�ada se a lista estiver vazia e tentar,

	// por exemplo, obter o primeiro elemento da lista

	// usando o m�todo first.

	public EmptyTreeException(String err) {

	super(err);

	}
	
}