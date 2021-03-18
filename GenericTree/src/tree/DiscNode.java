package tree;

public class DiscNode<E> {
	
	private int kbytes;
	private String name;
	
	private E[] element;
	
	private TreePosition<E> parent; // Nodo pai

	private PositionList<Position<E>> children; // Nodos filhos

	// Construtor padrão

	public DiscNode() {}

	// Construtor principal

	public DiscNode(String name,int kbytes, TreePosition<E> parent, PositionList<Position<E>> children) {

	this.kbytes = kbytes;
	this.name = name;

	setParent(parent);

	setChildren(children);

	}
	
	
	

	
	
	
	
	
	public int getKbytes(){ return kbytes; }
	
	public String getName()  { return name; }
	
	public void setKbytes(E[] element){ kbytes = Integer.parseInt((String) element[0]); }
	
	public void setName(E[] element)  { name = (String) element[1]; }
	
	

	
	
	public PositionList<Position<E>> getChildren() { return children; }

	// Define os filhos desta posição

	public void setChildren(PositionList<Position<E>> c) { children = c; }

	// Retorna o pai desta posição

	public TreePosition<E> getParent() { return parent; }

	// Define o pai desta posição

	public void setParent(TreePosition<E> v) { parent = v; }

	
	


	
	
	
	
	
	

}
