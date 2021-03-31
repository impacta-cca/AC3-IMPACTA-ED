/*
  	AC3 - Estrutura de Dados
	Integrantes:
	Arthur Silva
	Carolina Gabrielle
	Larissa Ionafa
	Lucas Silva
	Roberta Yumi
 
 */


package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import interfaces.Position;
import interfaces.PositionList;
import interfaces.TreePosition;
import tree_ex2_e_ex3.DiscNode;
import tree_ex2_e_ex3.LinkedTree;
import tree_ex2_e_ex3.NodePositionList;
import tree_ex2_e_ex3.TreeNode;







class LinkedTreeTestFinal {

	@Test
	void test() {
		TreePosition<String> raiz;

		Position<Position<String>> p, s;

		PositionList<Position<String>> filhos;

		LinkedTree<String> T = criarArvoreT();

		System.out.println(T.parentheticRepresentation(T, T.root()));

		System.out.println(T.toStringpostorder(T, T.root()));
		LinkedTree<DiscNode<String>> D = criarArvoreD();
		
		System.out.println(D.root().element().getName());
		assertFalse(T.isEmpty());

		assertEquals(4, T.height1(T), "Altura da Árvore T");

		assertEquals(4, T.height2(T, T.root()), "Altura da Árvore T");

		assertEquals("[Eletronics R'Us, P&D, Vendas, Internacional, Canadá, América do Sul, "

		+ "Ultramar, África, Europa, Ásia, Austrália, Nacional, Compras, Manufatura, TV, CD, Tuner]",

		T.toString(), "Pré-ordem da Árvore T ");

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

		assertEquals("[Eletronics R'Us, Pesquisa e Desenvolvimento, Vendas, Internacional, Canadá, América do Sul, "

		+ "Ultramar, África, Europa, Ásia, Austrália, Nacional, Compras, Manufatura, TV, CD, Tuner]",

		T.toString(), "Pré-ordem da Árvore T ");

		assertTrue(T.isRoot(raiz));

		T.swapElements(p.element(), s.element());

		assertEquals("[Eletronics R'Us, Vendas, Pesquisa e Desenvolvimento, Internacional, Canadá, América do Sul, "

		+ "Ultramar, África, Europa, Ásia, Austrália, Nacional, Compras, Manufatura, TV, CD, Tuner]",

		T.toString(), "Pré-ordem da Árvore T ");

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

		criarFilho(i, "Canadá");

		criarFilho(i, "América do Sul");

		u = criarFilho(i, "Ultramar");

		// Filhos de Ultramar

		criarFilho(u, "África");

		criarFilho(u, "Europa");

		criarFilho(u, "Ásia");

		criarFilho(u, "Austrália");

		// Filhos de Manufatura

		criarFilho(m, "TV");

		criarFilho(m, "CD");

		criarFilho(m, "Tuner");

		return T;

	}
	
	// método de criação da arvore do DiscNode

	public LinkedTree<DiscNode<String>> criarArvoreD() {

		LinkedTree<DiscNode<String>> T = new LinkedTree<DiscNode<String>>();

		DiscNode<String> raiz, cs252, cs016, projetos, trabalhos, demos, temas;

		
		T.addRoot(new DiscNode<String>("5124 /usuario/rt/cursos/",null,null));

		raiz = (DiscNode) T.root().getElement();
		raiz.setChildren(new NodePositionList<Position<String>>());

		// Filhos da raiz : /usuario/rt/cursos/

		cs252 = criarFilhoD(raiz, "4874 cs252/");

		cs016 = criarFilhoD(raiz, "249 cs016/");

		// filhos do nodo: cs252

		projetos = criarFilhoD(cs252, "4870 projetos/");
		criarFilhoD(cs252, "3 notas/");

		// filhos do nodo: cs016

		criarFilhoD(cs016, "8 notas/");
		temas = criarFilhoD(cs016, "1 temas/");
		// filhos do nodo: projetos
		trabalhos = criarFilhoD(projetos, "1 trabalhos/");
		demos = criarFilhoD(projetos, "1 demos");

		// filhos do nodo: temas
		criarFilhoD(temas, "3 hw1");
		criarFilhoD(temas, "2 hw2");
		criarFilhoD(temas, "4 hw3");
		criarFilhoD(temas, "57 pr1");
		criarFilhoD(temas, "97 pr2");
		criarFilhoD(temas, "74 pr3");

		// filhos do nodo: trabalhos
		criarFilhoD(trabalhos, "26 comprebaixo");
		criarFilhoD(trabalhos, "55 vendealto");

		// filhos do nodo: demos
		criarFilhoD(demos, "4786 mercado");

		return T;

	}

	private DiscNode<String> criarFilhoD(DiscNode<String> p, String n) {

		PositionList<Position<String>> filhos;

		DiscNode<String> aux;
		
		String nome = n.split(n)[0];
		int by = Integer.parseInt(n.split(n)[1]);
		// Obt�m os Filhos de p

		filhos = p.getChildren();

		// Cria um novo filho

		aux = new DiscNode<String>();

		aux.setElement(n);
		aux.setKbyte(by);
		aux.setname(nome);

		aux.setParent(p);

		aux.setChildren(new NodePositionList<Position<String>>());

		filhos.addLast(aux);

		return aux;

	}
}
