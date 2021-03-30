package tree;

import tree.TreeNode;
import tree.TreePosition;
import tree.Position;
import tree.PositionList;

public class DiscNode<E> extends TreeNode<E> {
	
	private E element; // Elemento armazenado neste nodo.
	private TreePosition<E> parent; // Nodo pai
	private PositionList<Position<E>> children; // Nodos filhos
	// Construtor padrão
	private int KByte;
	private String Name;

	public DiscNode() { }

	// Construtor principal

	public DiscNode(E element, TreePosition<E> parent, PositionList<Position<E>> children) {

	setElement(element);

	setParent(parent);

	setChildren(children);

	}

	// Retorna o elemento armazenado nesta posição.

	public E element() { return element; }

	// Define o elemento a ser armazenado nesta posição

	public void setElement(E o) { element = o; }

	// Retorna o elemento armazenado nesta posição

	public E getElement() { return element; }

	// Retorna os filhos desta posição

	public PositionList<Position<E>> getChildren() { return children; }

	// Define os filhos desta posição

	public void setChildren(PositionList<Position<E>> c) { children = c; }

	// Retorna o pai desta posição

	public TreePosition<E> getParent() { return parent; }

	// Define o pai desta posição

	public void setParent(TreePosition<E> v) { parent = v; }

	
	public int getKbytes() {
		return KByte;
	}
	public void setKbyte(int sbyte) {KByte = sbyte; 	}

	public String getName() {
		return Name;
	}
	
	

}
