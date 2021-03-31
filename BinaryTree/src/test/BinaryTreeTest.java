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
import pilha.*;
import treeB_ex4_ex5.LinkedBinaryTree;



class BinaryTreeTest {
	
	//a) buildExpression conforme slide 30.
	LinkedBinaryTree<String> T = BuildExpression("((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))");

	//b) binaryPreorder conforme slide 31.
	@Test
	void binaryPreorderTest() {
		assertEquals("-/*+313+-952+*3-746",T.binaryPreOrder(T, T.root()));
	}
		

	// c) binaryPostorder conforme slide 32.
	@Test
	void binaryPostorderTest() {
		assertEquals("31+3*95-2+/374-*6+-",T.binaryPostOrder(T, T.root()));
	}
	
	
	// d) evaluateExpression conforme slide 34 a 42.
	@Test
	void evaluateExpression() {
		assertEquals(-13.0,T.evaluateExpression(T, T.root()));
	}
	
	
	// e) inorder conforme slide 43.
	@Test
	void inorderTest() {
		assertEquals("3+1*3/9-5+2-3*7-4+6",T.inorder(T, T.root()));
	}
	
	// *******f) makerBTSearch e exiba o seu caminhamento inorder conforme slide 45.
	@Test
	void makeBTSSearchTest() {
		LinkedBinaryTree<Integer> BTS = makerBTSearch();
		
		assertEquals("12, 25, 31, 36, 42, 58, 62, 75, 90",BTS.inorder(BTS,BTS.root(), ", ").substring(0,BTS.inorder(BTS,BTS.root(), ", ").length()-2));
	}
	// g) Método que desenhe a árvore binária de expressão conforme slide 47.
	
	
	
	// h) eulerTour conforme slide 51.
	@Test
	void eulerTourTest() {
		LinkedBinaryTree<Integer> BTS = makerBTSearch();
		assertEquals("-/*+333+111+*333*/+-999-555-+222+/-+*333*-777-444-*+666+-",T.eulerTour(T, T.root()));
	}
	
	// i) printExpression conforme slide 53.
	@Test
	void printExpressionTest() {
		LinkedBinaryTree<Integer> BTS = makerBTSearch();
		assertEquals("((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))",T.printExpression(T, T.root()));
	}

	// j) Método para contar os nodos esquerdos e externos de uma árvore binária.
	@Test
	void contarNodosEsquerdaTest() {
		assertEquals(11,T.contesquerda(T, T.root()));
	}
	
	// k) Método para contar os nodos direitos e externos de uma árvore binária.
	@Test
	void contarNodosDireitaTest() {
		assertEquals(7,T.contdireita(T, T.root()));
	}
	
	@Test
	void desenharArvore() {
		T.desenhaArvore(T, T.root(), 0, 0);
		
	}
	
	public LinkedBinaryTree<String> BuildExpression(String E){
		ArrayStack<LinkedBinaryTree<String>> S = new ArrayStack<LinkedBinaryTree<String>>();
		
		for (int i=0; i<E.length();i++){
			if(E.charAt(i)!=')' && E.charAt(i)!='(') {
				LinkedBinaryTree<String> T = new LinkedBinaryTree<String>();
				T.addRoot(Character.toString(E.charAt(i)));
				S.push(T);
			}
			else if(E.charAt(i)=='(') { 
				
			}
			else if(E.charAt(i)==')') {
				LinkedBinaryTree<String> T2 = new LinkedBinaryTree<String>();
				T2=S.pop();
				LinkedBinaryTree<String> T = new LinkedBinaryTree<String>();
				T=S.pop();
				LinkedBinaryTree<String> T1 = new LinkedBinaryTree<String>();
				T1=S.pop();
				T.attach(T.root(), T1, T2);
				S.push(T);
			}
		}
		return S.pop();
	}
	
	
	public LinkedBinaryTree<Integer> makerBTSearch() {
		LinkedBinaryTree<Integer> novo = new LinkedBinaryTree<Integer>();
		int totalnum = 9;
		int[] num = { 31, 25, 42, 12, 36, 90, 62, 75 };
		Position<Integer> raiz, esquerda, direita, d, f;
		novo.addRoot(58);
		raiz = novo.root();
		esquerda = novo.root();
		direita = novo.root();

		// lado esquerdo
		esquerda = novo.insertLeft(raiz, 31);
		direita = novo.insertRight(esquerda, 42);
		esquerda = novo.insertLeft(esquerda, 25);
		novo.insertLeft(direita, 36);
		novo.insertLeft(esquerda, 12);

		// lado direito
		direita = novo.insertRight(raiz, 90);
		esquerda = novo.insertLeft(direita, 62);
		novo.insertRight(esquerda, 75);

		return novo;

	}

	
}
