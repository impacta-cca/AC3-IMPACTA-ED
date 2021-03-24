package tree;

import java.util.Iterator;

public class LinkedTree<E> implements Tree<E> {
	protected TreePosition<E> root; // Referï¿½ncia para a raï¿½z

	protected int size; // Nï¿½mero de Nodos

	// Cria uma ï¿½rvore vazia

	public LinkedTree() {

		root = null; // Inicia uma ï¿½rvore vazia

		size = 0;

	}

	// Retorna um nï¿½mero de nodos da ï¿½rvore

	public int size() {

		return size;

	}

	// Retorna se a ï¿½rvore estï¿½ vazia

	public boolean isEmpty() {
		return (size == 0);
	}

	// Retorna se um nodo ï¿½ interno

	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		return !isExternal(v);
	}

	// Retorna se um nodo ï¿½ externo

	public boolean isExternal(Position<E> v) throws InvalidPositionException {

		TreePosition<E> vv = checkPosition(v);

		return (vv.getChildren() == null) || vv.getChildren().isEmpty();

	}

	// Retorna se um nodo ï¿½ a raï¿½z

	public boolean isRoot(Position<E> v) throws InvalidPositionException {

		checkPosition(v);

		return (v == root());

	}

	// Retorna a raï¿½z da ï¿½rvore

	public TreePosition<E> root() throws EmptyTreeException {

		if (root == null)
			throw new EmptyTreeException("The tree is empty");

		return root;

	}

	// Retorna o pai de um nodo

	public TreePosition<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {

		TreePosition<E> vv = checkPosition(v);

		TreePosition<E> parentPos = vv.getParent();

		if (parentPos == null)
			throw new BoundaryViolationException("No parent");

		return parentPos;

	}

	// Retorna uma coleï¿½ï¿½o iterï¿½vel dos filhos de um nodo

	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {

		TreePosition<E> vv = checkPosition(v);

		return vv.getChildren();

	}

	// Retorna uma coleï¿½ï¿½o iterï¿½vel dos nodos da ï¿½rvore.

	public Iterable<Position<E>> positions() {

		PositionList<Position<E>> positions = new NodePositionList<Position<E>>();

		if (size != 0)
			preorderPositions(root(), positions);

		return positions;

	}

	// Retorna um iterator dos elementos armazenados nos nodos

	public Iterator<E> iterator() {

		Iterable<Position<E>> positions = positions();

		PositionList<E> elements = new NodePositionList<E>();

		for (Position<E> pos : positions)
			elements.addLast(pos.element());

		return elements.iterator();

	}

	// Troca o elemento de um nodo

	public E replace(Position<E> v, E o) throws InvalidPositionException {

		TreePosition<E> vv = checkPosition(v);

		E temp = v.element();

		vv.setElement(o);

		return temp;

	}

	// Mï¿½todos de atualizaï¿½ï¿½o adicionais

	// Adiciona um nodo raï¿½z para uma ï¿½rvore vazia

	public TreePosition<E> addRoot(E e) throws NonEmptyTreeException {

		if (!isEmpty())
			throw new NonEmptyTreeException("Tree already has a root");

		size = 1;

		root = createNode(e, null, null);

		return root;

	}

	// Troca os elementos de dos nodos

	public void swapElements(Position<E> v, Position<E> w) throws InvalidPositionException {

		TreePosition<E> vv = checkPosition(v);

		TreePosition<E> ww = checkPosition(w);

		E temp = w.element();

		ww.setElement(v.element());

		vv.setElement(temp);

	}

	// Mï¿½todos auxiliares

	// Se v ï¿½ um bom nodo da ï¿½rvore, cast para TreePosition, caso contrï¿½rio, lanï¿½a
	// exceï¿½ï¿½o

	protected TreePosition<E> checkPosition(Position<E> v) throws InvalidPositionException {

		if (v == null || !(v instanceof TreePosition))
			throw new InvalidPositionException("The position is invalid");

		return (TreePosition<E>) v;

	}

	// Cria um novo nodo da ï¿½rvore

	protected TreePosition<E> createNode(E element, TreePosition<E> parent, PositionList<Position<E>> children) {

		return new TreeNode<E>(element, parent, children);

	}

	// Cria uma lista armazenando os nodos das subï¿½rvore de um nodo

	// ordenado de acordo com a travessia das subï¿½rvores

	protected void preorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException {

		pos.addLast(v);

		for (Position<E> w : children(v))
			preorderPositions(w, pos);

	}

	public String toString() {
		return toString(this);
	}

	public static <E> String toString(LinkedTree<E> T) {

		String s = "";

		// for (E i : T) { s += ", " + i; }

		// OU

		for (Iterator<E> it = T.iterator(); it.hasNext();) {

			s += ", " + it.next().toString();

		}

		s = (s.length() == 0 ? s : s.substring(2));

		return "[" + s + "]";

	}

	public String parentheticRepresentation(Tree<E> T, Position<E> v) {

		String s = v.element().toString(); // aï¿½ï¿½o principal de visita
		String tabs = "\t";
		if (T.isInternal(v)) {

			Boolean firstTime = true;

			for (Position<E> w : T.children(v)) {

				if (firstTime) {
					// primeiro filho

					s += "(\n" + tabs + parentheticRepresentation(T, w);

					firstTime = false;

				} else {
					// filhos seguintes

					s += "," + parentheticRepresentation(T, w);

				}

				s += ")"; // fecha parï¿½nteses

			}

		}

		return s;

	}
	
	
	public int depth(LinkedTree<E> T, Position<E> v) {
		/**
		 * Se v for raiz, profundidade = 0 Se nao, chama depth com o filho do nodo
		 * recursivamente Soma +1 a profundiade maxima dos filhos
		 */
		if (T.isRoot(v)) {
			return 0;
		}
		return 1 + depth(T, T.parent(v));
	}
	

	public int height1(LinkedTree<E> T) {
		/**
		 * Percorrer a lista T Verificar se o Position v da lista T um nodo externo
		 * se sim, o inteiro h recebe o maior entre o proprio h e o depth de v na lista T
		 */
		int h = 0;
		for (Position<E> v : T.positions()) {
			if (T.isExternal(v)) {
				h = Math.max(h, T.depth(T, v));
			}
		}
		return h;
	}
		
	public String toStringpostorder(LinkedTree<E> T, Position<E> v) {
		String teste="";
		for (Position<E> w : T.children(v)) {
			teste +=toStringpostorder(T, w)+"\n";
		}
		
		teste += v.element();
		return teste;
		
	}
	
	public void postorder(LinkedTree<E> T, Position<E> v) {
		boolean teste=true;
		for (Position<E> w : T.children(v)) {
			postorder(T, w);
		}
		
		System.out.println(v.element()+" Visitado");
		
	}
	
	
	public int diskSpace(LinkedTree<DiscNode> T, TreePosition<DiscNode> v) {

		int s = v.getElement().getKbytes(); // inicia com o tamanho do próprio nodo

		for (Position<DiscNode> w : v.getChildren()) {

		// acrescenta o espaço ocupado pelos filhos de v calculado recursivamente

		s += diskSpace(T, (TreePosition<DiscNode>)w);

		}

		if (T.isInternal(v)) {

		// imprime o nome e o espaço ocupado em disco

		System.out.println(v.getElement().getName() + ": " + s);

		}

		return s;

		}
	
	
	

	


	public int height2(LinkedTree<E> T, Position<E> v) {
		/**
		 * Apenas se o nodo for interno Percorre ate altura maxima do filho e atribui
		 * para h h retorna a altura maxima + 1
		 */
		if (!T.isExternal(v)) {
			int h = 0;
			for (Position<E> w : T.children(v)) {
				h = Math.max(h, height2(T, w));
			}
			return h + 1;
		}
		return 0;
	}


// EXERCï¿½CIO PARA OS ALUNOS

// Implementar:

// depth 
// ------------Ok!

// height1
// ------------Ok!

// height2
// ------------Ok!

// parentheticRepresentation
// ------------Ok!

// toStringPostorder
// ------------Ok!

}
