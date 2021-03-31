package treeB_ex4_ex5;

import exception.InvalidPositionException;
import interfaces.Position;

public class Node<E> implements Position<E> {

	private Node<E> prev, next; // Refer�ncia para os nodos anterior e posterior

	private E element; // Elemento armazenado nesta posi��o

	// Construtor

	public Node(Node<E> newPrev, Node<E> newNext, E elem) {

		prev = newPrev;

		next = newNext;

		element = elem;

	}

	// M�todo da interface Position

	public E element() throws InvalidPositionException {

		if ((prev == null) && (next == null))

			throw new InvalidPositionException("Position is not in a list!");

		return element;

	}

	// M�todos de acesso

	public Node<E> getNext() {
		return next;
	}

	public Node<E> getPrev() {
		return prev;
	}

	// M�todos de atualiza��o

	public void setNext(Node<E> newNext) {
		next = newNext;
	}

	public void setPrev(Node<E> newPrev) {
		prev = newPrev;
	}

	public void setElement(E newElement) {
		element = newElement;
	}

	
}
