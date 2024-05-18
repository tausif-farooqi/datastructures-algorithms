package ds.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphDFS {
	public void dfs(int vertex, int[][] graph, boolean[] visited, List<Integer> order) {
		if (visited[vertex]) {
			return;
		}
		
		visited[vertex] = true;
		order.add(vertex);
		
		for (int i = 0; i < graph[vertex].length; i++) {
			int currentVertex = graph[vertex][i];
			dfs(currentVertex, graph, visited, order);
		}
	}
	
	public static void main(String[] args) {
		int[][] graph = {{1, 3}, {}, {8}, {4, 5, 2}, {6}, {}, {7}, {}, {}};
		boolean[] visited = new boolean[9];
		List<Integer> order = new ArrayList<Integer>();
		
		GraphDFS graphDfs = new GraphDFS();
		graphDfs.dfs(0, graph, visited, order);
		
		for (int i = 0; i < order.size(); i++) {
			System.out.println(order.get(i));
		}
	}
}
