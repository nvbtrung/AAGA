import java.util.List;

public class Node {
	public String label;
	public List<Node> parents;
	public List<Node> childs;
	
	public Node(String label) {
		this.label = label;
		this.parents = null;
		this.childs = null;
	}
	
	public void addChild(Node child) {
		this.childs.add(child);
		child.parents.add(this);
	}
}
