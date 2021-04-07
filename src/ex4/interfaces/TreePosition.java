package ex4.interfaces;

public interface TreePosition<E> extends Position<E> {

	// Define o elemento a ser armazenado nesta posi��o

	public void setElement(E o);

	// Retorna o elemento armazenado nesta posi��o

	public E getElement();

	// Retorna os filhos desta posi��o

	public PositionList<Position<E>> getChildren();

	// Define os filhos desta posi��o

	public void setChildren(PositionList<Position<E>> c);

	// Retorna o pai desta posi��o

	public TreePosition<E> getParent();

	// Define o pai desta posi��o

	public void setParent(TreePosition<E> v);

	}








