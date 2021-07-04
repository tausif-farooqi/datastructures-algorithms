package ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSF {
	static List<List<Node>> graph;
	static boolean[] visited;
	static boolean[] printed;
	static int counter;
	
	public static void main(String[] args) {
		buildGraph();
		int start = 1;
		traverse(start);
		
		System.out.println("Count: " + counter);
	}
	
	public static void traverse(int start) {
		++counter;
		
		int index = start - 1;
		
		if (visited[index]) {
			return;
		}
		
		if (!printed[index]) {
			System.out.println(start);
			printed[index] = true;
		}
		
		visited[index] = true;
		
		List<Node> neighbors = graph.get(index);
		for (Node node : neighbors) {
			int neighborIndex = node.name - 1;
			
			if (visited[neighborIndex] || printed[neighborIndex]) {
				continue;
			}
			
			++counter;
			System.out.println(node.name);
			printed[neighborIndex] = true;
		}
		
		for (Node node : neighbors) {
			if (visited[node.name - 1]) {
				continue;
			}
			
			traverse(node.name);
		}
	}
	
	public static void buildGraph() {
		List<Node> neigbors_1 = Arrays.asList(new Node[] {new Node(2), new Node(3)});
		List<Node> neigbors_2 = Arrays.asList(new Node[] {new Node(1), new Node(4), new Node(5)});
		List<Node> neigbors_3 = Arrays.asList(new Node[] {new Node(1), new Node(5)});
		List<Node> neigbors_4 = Arrays.asList(new Node[] {new Node(2), new Node(5), new Node(6)});
		List<Node> neigbors_5 = Arrays.asList(new Node[] {new Node(2), new Node(5), new Node(6)});
		List<Node> neigbors_6 = Arrays.asList(new Node[] {new Node(4), new Node(5)});
		
		graph = new ArrayList<List<Node>>();
		graph.add(neigbors_1);
		graph.add(neigbors_2);
		graph.add(neigbors_3);
		graph.add(neigbors_4);
		graph.add(neigbors_5);
		graph.add(neigbors_6);
		
		visited = new boolean[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			visited[i] = false;
		}
		
		printed = new boolean[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			printed[i] = false;
		}
	}

}

class Node {
	public int name;
	public int distance;
	
	public Node(int name) {
		this.name = name;
		this.distance = 1;
	}
	
	public Node(int name, int distance) {
		this.name = name;
		this.distance = distance;
	}
}
