package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FarthestCity {
	// Map that holds the shortest distance between two cities
	private static Map<String, Integer> shortestDistanceMap = new HashMap<String, Integer>();
	// Map that re-organizes the city data in a graph like structure
	private static Map<Integer, List<int[]>> cityGraph;
	
	public static void main(String[] args) {
		int[][] cityData = new int[][] {
			new int[] {1, 2, 3}, 
			new int[] {1, 3, 5}, 
			new int[] {2, 4, 1}, 
			new int[] {3, 5, 3},
			new int[] {2, 6, 1},
			new int[] {6, 5, 2}
			};
			
		// build the graph from the data
		buildGraph(cityData);
		
		// find the distances, assuming our origin is city "1", we can change this to any origin
		// (just keep the first two parameters with the same value)
		findCityDistances(1, 1, 0, null);
		
		// prints the shortest distance to the farthest city (farthest to the "origin" provided earlier
		int shortest = -1;
		String path = "";
		Iterator<String> keys = shortestDistanceMap.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			int distance = shortestDistanceMap.get(key);
			if (distance > shortest) {
				shortest = distance;
				path = key;
			}
		}
		
		System.out.println(path + ": " + shortest);
	}
	 
	/**
	 * Builds a graph-like structure for the provided city data.
	 * 
	 * @param data The provided city data
	 * @return A map that represents the city data as a graph-like structure
	 */
	private static Map<Integer, List<int[]>> buildGraph(int[][] data) {
		cityGraph = new HashMap<Integer, List<int[]>>();
		for (int i = 0; i < data.length; i++) {
			int[] edge = data[i];
			addCityToGraph(edge, 0, 1);
			addCityToGraph(edge, 1, 0);
		}
		
		return cityGraph;
	}

	/**
	 * Adds a city to the graph.
	 * 
	 * @param edge An int array that contains two cities and the distance between them
	 * @param fromCity The index in the int array from the "from city"
	 * @param toCity The index in the int array the "to city"
	 */
	private static void addCityToGraph(int[] edge, int fromCity, int toCity) {
		int city = edge[fromCity];
		
		List<int[]> nextCities = cityGraph.get(city); 
		if (nextCities == null) {
			nextCities = new ArrayList<int[]>();
		}
		
		int[] cityDistance = new int[] {edge[toCity], edge[2]};
		nextCities.add(cityDistance);
		
		cityGraph.put(city, nextCities);
	}

	/**
	 * Finds the distances of all cities from the given origin.
	 * 
	 * @param origin The origin city
	 * @param current The current city being visited
	 * @param totalDist The total distance covered during traversing from the origin to the current city
	 * @param visited A set of cities that were visited
	 */
	private static void findCityDistances(int origin, int current, int totalDist, Set<Integer> visited) {
		// if visited set is null then initialize it and add the "origin" as visited
		if (visited == null) {
			visited = new HashSet<Integer>();
			visited.add(origin);
		}
		
		// get the neighboring cities and iterate through them and find the distances
		List<int[]> nextCities = cityGraph.get(current);
		for (int[] cityDistance: nextCities) {
			// if the current city is also the origin then reset the total distance as zero
			if (origin == current) {
				totalDist = 0;
			}

			int city = cityDistance[0];
			
			// if the city has already been visited then ignore it
			if (visited.contains(city)) {
				continue;
			}
			
			totalDist += cityDistance[1];
			addCityDistance(origin, city, totalDist);
			visited.add(city);
			
			// go further down the graph
			findCityDistances(origin, city, totalDist, visited);
			
			// we're back at the parent city, so update the distance and the visited set
			// cities set
			totalDist -= cityDistance[1];
			visited.remove(city);
		}
	}
	
	/**
	 * Updates the distance map
	 * @param origin The origin city
	 * @param city The destination city
	 * @param distance The total distance
	 */
	private static void addCityDistance(int origin, int city, int distance) {
		String key = origin + " -> " + city;
		Integer dist = shortestDistanceMap.get(key);
		if (dist == null || distance < dist) {
			shortestDistanceMap.put(key, distance);
		}
	}
}