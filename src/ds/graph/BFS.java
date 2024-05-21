package ds.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFS {
	static Map<String, List<Node>> graph;
	static Map<String, Boolean> visited = new HashMap<String, Boolean>();
	static Map<String, Boolean> printed = new HashMap<String, Boolean>();
	static int counter;
	
	public static void main(String[] args) {
		buildGraph();
		traverse("A");
		
		System.out.println("Count: " + counter);
	}
	
	public static void traverse(final String value) {
		++counter;
		
		if (isVisited(value)) {
			return;
		}
		
		if (!isPrinted(value)) {
			System.out.println(value);
			printed.put(value, true);
		}
		
		visited.put(value, true);
		
		List<Node> neighbors = graph.get(value);
		for (Node node : neighbors) {
			if (isVisited(node.name) || isPrinted(node.name)) {
				continue;
			}
			
			++counter;
			System.out.println(node.name);
			printed.put(node.name, true);
		}
		
		for (Node node : neighbors) {
			if (isVisited(node.name)) {
				continue;
			}
			
			traverse(node.name);
		}
	}
	
	static boolean isVisited(String value) {
		return visited.containsKey(value) && visited.get(value);
	}
	
	static boolean isPrinted(String value) {
		return printed.containsKey(value) && printed.get(value);
	}
	
	public static void buildGraph() {
		List<Node> neigbors_1 = Arrays.asList(new Node[] {new Node("B"), new Node("C")});
		List<Node> neigbors_2 = Arrays.asList(new Node[] {new Node("A"), new Node("D"), new Node("E")});
		List<Node> neigbors_3 = Arrays.asList(new Node[] {new Node("A"), new Node("E")});
		List<Node> neigbors_4 = Arrays.asList(new Node[] {new Node("B"), new Node("E"), new Node("F")});
		List<Node> neigbors_5 = Arrays.asList(new Node[] {new Node("B"), new Node("C"), new Node("F")});
		List<Node> neigbors_6 = Arrays.asList(new Node[] {new Node("D"), new Node("E")});
		
		graph = new HashMap<String, List<Node>>();
		graph.put("A", neigbors_1);
		graph.put("B", neigbors_2);
		graph.put("C", neigbors_3);
		graph.put("D", neigbors_4);
		graph.put("E", neigbors_5);
		graph.put("F", neigbors_6);
	}

}

class Node {
	public String name;
	public int distance;
	
	public Node(String name) {
		this.name = name;
		this.distance = 1;
	}
	
	public Node(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}
}
