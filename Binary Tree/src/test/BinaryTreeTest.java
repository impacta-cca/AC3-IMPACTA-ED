package test;

import static org.junit.jupiter.api.Assertions.*;
import pilha.*;
import tree.*;

import org.junit.jupiter.api.Test;


class BinaryTreeTest {
	public static void main(String[] args){
	}
	@Test
	void test() {
		LinkedBinaryTree<String> T = BuildExpression("((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))");
		System.out.println(T);
		System.out.println(T);
		
		
		//LinkedBinaryTree<Integer> D = new LinkedBinaryTree<Integer>();
		//D = D.makerBTSearch();
		//System.out.println(D.inorder(D, D.root(),", "));
		//System.out.println(T.eulerTour(T, T.root()));
		//T.printExpression(T, T.root());
		///System.out.println(T.contesquerda(T, T.root()));
		//System.out.println(T.contdireita(T, T.root()));
		T.desenhaArvore(T, T.root(), 0, 0);

		
		//System.out.println(D.parentheticRepresentation(D, D.root()));
		/*System.out.println(T.toString(T));
		
		System.out.println(T.binaryPreOrder(T, T.root()));
		System.out.println(D.evaluateExpression(T,T.root()));
		
	*/
		//System.out.println(T.inorder(T, T.root()));
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
}
