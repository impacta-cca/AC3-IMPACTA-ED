package tree_ex2_e_ex3;

import interfaces.Position;
import interfaces.PositionList;
import interfaces.TreePosition;

public class TreeNode <E> implements TreePosition<E> {

private E element; // Elemento armazenado neste nodo.
private TreePosition<E> parent; // Nodo pai
private PositionList<Position<E>> children; // Nodos filhos
// Construtor padr�o

public TreeNode() {}

// Construtor principal

public TreeNode(E element, TreePosition<E> parent, PositionList<Position<E>> children) {

setElement(element);

setParent(parent);

setChildren(children);

}

// Retorna o elemento armazenado nesta posi��o.

public E element() { return element; }

// Define o elemento a ser armazenado nesta posi��o

public void setElement(E o) { element = o; }

// Retorna o elemento armazenado nesta posi��o

public E getElement() { return element; }

// Retorna os filhos desta posi��o

public PositionList<Position<E>> getChildren() { return children; }

// Define os filhos desta posi��o

public void setChildren(PositionList<Position<E>> c) { children = c; }

// Retorna o pai desta posi��o

public TreePosition<E> getParent() { return parent; }

// Define o pai desta posi��o

public void setParent(TreePosition<E> v) { parent = v; }



}
