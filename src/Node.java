import java.util.ArrayList;
import java.util.List;

public class Node {
	public String label;
	public List<Node> parents;
	public List<Node> childs;
	
	public Node(String label) {
		this.label = label;
		this.parents = new ArrayList<Node>();
		this.childs = new ArrayList<Node>();
	}
	
	public void addChild(Node child) {
		this.childs.add(child);
		child.parents.add(this);
	}
}
