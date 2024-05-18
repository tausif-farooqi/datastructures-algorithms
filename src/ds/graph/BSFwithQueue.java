package ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSFwithQueue {
	static List<List<Vertex>> graph;
	static boolean[] visited;
	static int counter;

	public static void main(String[] args) {
		buildGraph();
		int start = 1;
		traverse(start);
	}

	public static void traverse(int start) {
		++counter;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);

		while (!queue.isEmpty()) {
			Integer elment = queue.poll();
			int index = elment - 1;

			if (!visited[index]) {
				System.out.println(elment);
				visited[index] = true;
			}

			List<Vertex> vertices = graph.get(index);

			for (Vertex vertex : vertices) {
				int neighbourIndex = vertex.name - 1;
				if (!visited[neighbourIndex]) {
					queue.add(vertex.name);
				}

				++counter;
			}
		}

		System.out.println("Count: " + counter);
	}

	public static void buildGraph() {
		List<Vertex> neigbors_1 = Arrays.asList(new Vertex[] { new Vertex(2), new Vertex(3) });
		List<Vertex> neigbors_2 = Arrays.asList(new Vertex[] { new Vertex(1), new Vertex(4), new Vertex(5) });
		List<Vertex> neigbors_3 = Arrays.asList(new Vertex[] { new Vertex(1), new Vertex(5) });
		List<Vertex> neigbors_4 = Arrays.asList(new Vertex[] { new Vertex(2), new Vertex(5), new Vertex(6) });
		List<Vertex> neigbors_5 = Arrays.asList(new Vertex[] { new Vertex(2), new Vertex(5), new Vertex(6) });
		List<Vertex> neigbors_6 = Arrays.asList(new Vertex[] { new Vertex(4), new Vertex(5) });

		graph = new ArrayList<List<Vertex>>();
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
	}

}

class Vertex {
	public int name;
	public int distance;

	public Vertex(int name) {
		this.name = name;
		this.distance = 1;
	}

	public Vertex(int name, int distance) {
		this.name = name;
		this.distance = distance;
	}
}
