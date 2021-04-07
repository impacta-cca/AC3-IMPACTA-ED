package ex4.exception;

@SuppressWarnings("serial")
public class EmptyListException extends RuntimeException {

/* Exce��o lan�ada se a lista estiver vazia e tentar, por

* exemplo, obter o primeiro elemento da lista usando o m�todo

* first. */

public EmptyListException(String err) { super(err); }

}
