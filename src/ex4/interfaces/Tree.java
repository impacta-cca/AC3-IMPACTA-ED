package ex4.interfaces;

import java.util.Iterator;

import ex4.exception.BoundaryViolationException;
import ex4.exception.EmptyTreeException;
import ex4.exception.InvalidPositionException;

public interface Tree<E> extends Iterable<E> {
	// Retorna a quantidade de nodos da �rvore.

	public int size();

	// Retorna se a �rvore est� vazia.

	public boolean isEmpty();

	// Retorna um iterador sobre os elementos armazenados na �rvore.

	public Iterator<E> iterator();

	// Retorna uma cole��o iter�vel dos nodos.

	public Iterable<Position<E>> positions();

	// Substitui o elemento armazenado em um dado nodo.

	public E replace(Position<E> v, E e) throws InvalidPositionException;

	// Retorna a raiz da �rvore.

	public Position<E> root() throws EmptyTreeException;

	// Retorna o pai de um dado nodo.

	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException;

	// Retorna uma cole��o iter�vel dos filhos de um dado nodo.

	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;

	// Retorna se um dado nodo � interno.

	public boolean isInternal(Position<E> v) throws InvalidPositionException;

	// Retorna se um dado nodo � externo.

	public boolean isExternal(Position<E> v) throws InvalidPositionException;

	// Retorna se um dado nodo � a raiz da �rvore.

	public boolean isRoot(Position<E> v) throws InvalidPositionException;
	

}
