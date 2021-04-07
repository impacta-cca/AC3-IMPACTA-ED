/*
  	AC3 - Estrutura de Dados
	Integrantes:
	Arthur Silva
	Carolina Gabrielle
	Larissa Ionafa
	Lucas Silva
	Roberta Yumi
 
 */


package ex3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ex2.interfaces.Position;
import ex2.interfaces.PositionList;
import ex2.interfaces.TreePosition;
import ex2.tree.DiscNode;
import ex2.tree.LinkedTree;
import ex2.tree.NodePositionList;
import ex2.tree.TreeNode;

class LinkedTreeTestFinal {
	TreePosition<String> raiz;

	Position<Position<String>> p, s;

	PositionList<Position<String>> filhos;

	LinkedTree<String> T = criarArvoreT();
	@Test
	void test() {
		assertFalse(T.isEmpty());
		
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
	
	
	//a)
		@Test
		void ParentheticRepresentationTest() {
			System.out.print(T.parentheticRepresentation(T, T.root()));
		}
	
	
	//b)
	@Test
	void PosOrderTestTest() {
		String saida = "P&D\n"
				+ "Canadá\n"
				+ "América do Sul\n"
				+ "África\n"
				+ "Europa\n"
				+ "Ásia\n"
				+ "Austrália\n"
				+ "Ultramar\n"
				+ "Internacional\n"
				+ "Nacional\n"
				+ "Vendas\n"
				+ "Compras\n"
				+ "TV\n"
				+ "CD\n"
				+ "Tuner\n"
				+ "Manufatura\n"
				+ "Eletronics R'Us";
		assertEquals(saida,T.toStringpostorder(T, T.root()));
	}
	
	//d)
	@Test
	void depthTest() {
		//teste para capturar  a profundidade do filho da esquerda do root
		assertEquals(1, T.depth(T,T.root().getChildren().first().element()), "A profundidade da Arvore");
	}
	
	// e)
	@Test
	void height1Test() {
		assertEquals(4, T.height1(T), "Altura da Árvore T");
		
	}
	// f)
	@Test
	void height2Test() {
		assertEquals(4, T.height2(T, T.root()), "Altura da Árvore T");
				
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
