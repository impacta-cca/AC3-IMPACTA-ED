package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tree.LinkedTree;
import tree.NodePositionList;
import tree.Position;
import tree.PositionList;
import tree.TreeNode;
import tree.TreePosition;

class LinkedTreeTest {

	@Test

	void test() {

		TreePosition<String> raiz;

		Position<Position<String>> p, s;

		PositionList<Position<String>> filhos;

		LinkedTree<String> T = criarArvoreT();

		
		System.out.println(T.parentheticRepresentation(T, T.root()));
		
		//System.out.println(T.toString());

		System.out.println(T.toStringpostorder(T, T.root()));

		assertFalse(T.isEmpty());
		System.out.println(T.height1(T));

		assertEquals(4, T.height1(T), "Altura da �rvore T");
		
		
		T.postorder(T, T.root());
		assertEquals(4, T.height1(T), "Altura da �rvore T");

		assertEquals(4, T.height2(T, T.root()), "Altura da �rvore T");

		/*assertEquals("[Eletronics R'Us, P&D, Vendas, Internacional, Canad�, Am�rica do Sul, "
=======
		assertEquals("[Eletronics R'Us, P&D, Vendas, Internacional, Canad�, Am�rica do Sul, "
>>>>>>> branch 'main' of https://github.com/impacta-cca/AC3-IMPACTA-ED.git

				+ "Ultramar, �frica, Europa, �sia, Austr�lia, Nacional, Compras, Manufatura, TV, CD, Tuner]",

<<<<<<< HEAD
				T.toString(), "Pr�-ordem da �rvore T ");*/

		raiz = T.root();

		filhos = raiz.getChildren();

		p = filhos.first();

		assertEquals("P&D", p.element().element(), "P&D");

		assertTrue(T.isExternal(p.element()));

		assertEquals(raiz, T.parent(p.element()), "Deve ser a raiz");

		s = filhos.next(p);

		assertEquals("Vendas", s.element().element(), "Vendas");

		assertTrue(T.isInternal(s.element()));

		assertEquals(1, T.depth(T, s.element()), "");

		T.replace(p.element(), "Pesquisa e Desenvolvimento");

		assertEquals("[Eletronics R'Us, Pesquisa e Desenvolvimento, Vendas, Internacional, Canad�, Am�rica do Sul, "

				+ "Ultramar, �frica, Europa, �sia, Austr�lia, Nacional, Compras, Manufatura, TV, CD, Tuner]",

				T.toString(), "Pr�-ordem da �rvore T ");

		assertTrue(T.isRoot(raiz));

		T.swapElements(p.element(), s.element());

		assertEquals("[Eletronics R'Us, Vendas, Pesquisa e Desenvolvimento, Internacional, Canad�, Am�rica do Sul, "

				+ "Ultramar, �frica, Europa, �sia, Austr�lia, Nacional, Compras, Manufatura, TV, CD, Tuner]",

				T.toString(), "Pr�-ordem da �rvore T ");

	}
	

	private TreeNode<String> criarFilho(TreeNode<String> p, String n) {

		PositionList<Position<String>> filhos;

		TreeNode<String> aux;

// Obt�m os Filhos de p

		filhos = p.getChildren();

// Cria um novo filho

		aux = new TreeNode<String>();

		aux.setElement(n);

		aux.setParent(p);

		aux.setChildren(new NodePositionList<Position<String>>());

		filhos.addLast(aux);

		return aux;

	}
	
	

	public LinkedTree<String> criarArvoreT() {

		LinkedTree<String> T = new LinkedTree<String>();

		TreeNode<String> raiz, v, m, i, u;

		T.addRoot("Eletronics R'Us");

		raiz = (TreeNode<String>) T.root();

		raiz.setChildren(new NodePositionList<Position<String>>());

// Filhos da raiz: Eletronic R'Us

		criarFilho(raiz, "P&D");

		v = criarFilho(raiz, "Vendas");

		criarFilho(raiz, "Compras");

		m = criarFilho(raiz, "Manufatura");

// Filhos de Vendas

		i = criarFilho(v, "Internacional");

		criarFilho(v, "Nacional");

// Filhos de Internacional

		criarFilho(i, "Canad�");

		criarFilho(i, "Am�rica do Sul");

		u = criarFilho(i, "Ultramar");

// Filhos de Ultramar

		criarFilho(u, "�frica");

		criarFilho(u, "Europa");

		criarFilho(u, "�sia");

		criarFilho(u, "Austr�lia");

// Filhos de Manufatura

		criarFilho(m, "TV");

		criarFilho(m, "CD");

		criarFilho(m, "Tuner");

		return T;

	}
	

}
