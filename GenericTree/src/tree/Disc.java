package tree;

public interface Disc<E> extends Discini {
	
	
	
// Retorna os filhos desta posição

	public PositionList<Position<E>> getChildren();

	// Define os filhos desta posição

	public void setChildren(PositionList<Position<E>> c);

	// Retorna o pai desta posição

	public TreePosition<E> getParent();

	// Define o pai desta posição

	public void setParent(TreePosition<E> v);
	
	public int getKbytes();
	
	public String getName();

	

}
