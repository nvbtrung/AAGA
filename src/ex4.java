public class ex4 {
	
	public static boolean decompositionB(Graph graph, Node node) {
		if(graph.nodes.size() <= 1) return true;
		if(node.parents.size() == 1 && node.childs.size() == 0) {
			node.parents.get(0).childs.addAll(node.childs);			
			for(Node child : node.childs) {
				if(!child.parents.contains((node.parents.get(0))))
					child.parents.add(node.parents.get(0));
				if(!node.parents.get(0).childs.contains(child))
					node.parents.get(0).childs.add(child);
				child.parents.remove(node);
			}
			node.parents.get(0).childs.remove(node);
			graph.nodes.remove(node);	
			return true;
		}		
		return false;
	}
	
	public static boolean decompositionT(Graph graph, Node node) {
		if(graph.nodes.size() <= 1) return true;
		if(node.childs.size() == 1 && node.parents.size() == 0) {
			for(Node parent : node.parents) {
				if(!parent.childs.contains(node.childs.get(0)))
					parent.childs.add(node.childs.get(0));
				if(!node.childs.get(0).parents.contains(parent))
					node.childs.get(0).parents.add(parent);
				parent.childs.remove(node);
			}			
			node.childs.get(0).parents.remove(node);
			graph.nodes.remove(node);
			return true;
		}
		return false;
	}
	
	public static boolean decompositionI(Graph graph, Node node) {
		if(graph.nodes.size() <= 1) return true;
		if(node.childs.size() == 1 && node.parents.size() == 1) {
			if(!node.parents.get(0).childs.contains(node.childs.get(0)))
				node.parents.get(0).childs.add(node.childs.get(0));
			if(!node.childs.get(0).parents.contains(node.parents.get(0)))
				node.childs.get(0).parents.add(node.parents.get(0));
			node.parents.get(0).childs.remove(node);
			node.childs.get(0).parents.remove(node);
			graph.nodes.remove(node);
			return true;
		}
		return false;
	}
	
	public static boolean reconnaissance(Graph graph) {
		int count = 0;
		while(graph.nodes.size()> 1) {
			if(count < graph.nodes.size()) {
				if(decompositionI(graph, graph.nodes.get(count)) ||
						(decompositionT(graph, graph.nodes.get(count))) ||
						(decompositionB(graph,graph.nodes.get(count)))) {
					count = 0;
				}				
				else 
					count++;
			}
			else
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/********Graph DAG 1*******/
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
		/************************/
		
		/********Graph DAG 2******
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
		e.addChild(i);
		h.addChild(f);
		*************************/
		System.out.println(reconnaissance(sample1));
	}

}
