
public class ex4 {

	
	public boolean decompositionB(Graph graph, Node node) {
		if(graph.nodes.size() <= 1) return true;
		if(node.parents.size() == 1) {
			node.parents.get(0).childs.addAll(node.childs);
			graph.nodes.remove(node);	
			return true;
		}		
		return false;
	}
	
	public boolean decompositionT(Graph graph, Node node) {
		if(graph.nodes.size() <= 1) return true;
		if(node.childs.size() == 1) {
			for(Node parent : node.parents) {
				parent.childs.add(node.childs.get(0));
			}
			graph.nodes.remove(node);
			return true;
		}
		return false;
	}
	
	public boolean decompositionI(Graph graph, Node node) {
		if(graph.nodes.size() <= 1) return true;
		if(node.childs.size() == 1 && node.parents.size() == 1) {
			node.parents.get(0).addChild(node.childs.get(0));
			graph.nodes.remove(node);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Graph DAG 1*/
		Graph sample1 = new Graph();
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		Node i = new Node("i");
		Node j = new Node("j");
		sample1.nodes.add(a);
		sample1.nodes.add(b);
		sample1.nodes.add(c);
		sample1.nodes.add(d);
		sample1.nodes.add(e);
		sample1.nodes.add(f);
		sample1.nodes.add(g);
		sample1.nodes.add(h);
		sample1.nodes.add(i);
		sample1.nodes.add(j);
		a.addChild(b);
		a.addChild(d);
		b.addChild(c);
		d.addChild(c);
		c.addChild(e);
		c.addChild(h);
		c.addChild(j);
		e.addChild(f);
		h.addChild(i);
		f.addChild(g);
		i.addChild(g);
		
	}

}
