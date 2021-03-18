package tree;

public interface Disc<E> extends Discini {
	
	
	
// Retorna os filhos desta posi��o

	public PositionList<Position<E>> getChildren();

	// Define os filhos desta posi��o

	public void setChildren(PositionList<Position<E>> c);

	// Retorna o pai desta posi��o

	public TreePosition<E> getParent();

	// Define o pai desta posi��o

	public void setParent(TreePosition<E> v);
	
	public int getKbytes();
	
	public String getName();

	

}
