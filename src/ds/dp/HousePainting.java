package ds.dp;

import java.util.Arrays;

/**
 * There are a row of 3 houses. Each house can be painted with one of the three colors: red, blue, or green.
 * The cost of painting each house with a certain color is different. You have to paint all the houses such
 * no two adjacent houses have the same color. Find the minimum cost of painting.
 * 
 * Assume that the index of red = 0, blue = 1, and green = 2.
 * 
 * @author tausif.farooqi
 *
 */
public class HousePainting {
	private static final int[][] COST = {{17, 2, 17}, {16, 16, 5}, {14, 3, 9}};
	private static final int[] COLORS = {0, 1, 2};
	private static int iterations = 0;
	private static int iterationsMemo = 0;
	private static int[][] cache = new int[3][3];
	
	public static void main(String[] args) {
		// initialize cache
		for (int i = 0; i < cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		
		int minCost = Integer.MAX_VALUE;
		
		for (int color = 0; color < COLORS.length; color++) {
			minCost = Math.min(minCost, findCost(0, color));
		}
		
		int minCostMemo = Integer.MAX_VALUE;
		
		for (int color = 0; color < COLORS.length; color++) {
			minCostMemo = Math.min(minCostMemo, findCostMemo(0, color));
		}
		
		System.out.println("Min cost (without memoization) = " + minCost);
		System.out.println("Iterations (without memoization) = " + iterations);
		System.out.println("Min cost (with memoization) = " + minCostMemo);
		System.out.println("Iterations (with memoization) = " + iterationsMemo);
	}
	
	private static int findCost(int house, int color) {
		if (house == COST.length) {
			return 0;
		}
		
		++iterations;
		
		int color1 = (color + 1) % COLORS.length;
		int color2 = (color + 2) % COLORS.length;
		
		return COST[house][color] + Math.min(findCost(house + 1, color1), findCost(house + 1, color2));
	}
	
	private static int findCostMemo(int house, int color) {
		if (house == COST.length) {
			return 0;
		}
		
		if (cache[house][color] != -1) {
			return cache[house][color];
		}
		
		++iterationsMemo;
		
		int color1 = (color + 1) % COLORS.length;
		int color2 = (color + 2) % COLORS.length;
		
		cache[house][color] = COST[house][color] + Math.min(findCost(house + 1, color1), findCost(house + 1, color2));
		
		return cache[house][color];
	}
}
