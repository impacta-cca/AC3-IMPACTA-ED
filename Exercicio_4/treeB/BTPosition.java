package treeB;

public interface BTPosition<E> extends Position<E>{

	// Retorna o elemento armazenado nesta posi��o

	public E element();

	// Define o elemento armazenado nesta posi��o

	public void setElement(E o);

	// Retorna o filho da esquerda desta posi��o

	public BTPosition<E> getLeft();

	// Define o filho da esquerda desta posi��o

	public void setLeft(BTPosition<E> v);

	// Retorna o filho da direita desta posi��o

	public BTPosition<E> getRight();

	// Define o filho da direita desta posi��o

	public void setRight(BTPosition<E> v);

	// Retorna o pai desta posi��o

	public BTPosition<E> getParent();

	// Define o pai desta posi��o

	public void setParent(BTPosition<E> v);

	}