package ds.dp;

import java.util.Arrays;

/**
 * Given a 2d matrix, find the maximum cost to travel from the bottom left corner to the top right corner.
 * Each element of the matrix defines the cost it takes to reach that element. You can only move up or right.
 * 
 * @author tausif.farooqi
 *
 */
public class MaxCostPath {	
	// max cost = 18	
//	private static final int[][] COST = {
//			{20, -10, 0}, 
//			{1, 5, 10}, 
//			{1, 2, 3}
//	};	
	
	// max cost = 24
	private static final int[][] COST = {
			{1, -2, -3}, 
            {1, 15, 10},
            {1, -2, 3}
    };	
	
	// We're calculating from the opposite side, so we change the movement to down or left.
	private static final int[][] DIRECTIONS = {{1, 0}, {0, -1}};
	
	public static void main(String[] args) {
		int[][] cache = fillCache();
		System.out.println("Cost -> " + maxCost(0, COST[0].length - 1, cache));
	}
	
	private static int[][] fillCache() {
		int[][] cache = new int[COST.length][COST[0].length];
		for (int i = 0; i < COST.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		
		return cache;
	}
	
	private static int maxCost(int x, int y, int[][] cache) {
		if (x >= COST.length || y < 0) {
			return Integer.MIN_VALUE;
		}
		
		if (x == COST.length - 1 && y == 0) {
			return COST[COST.length - 1][0];
		}
		
		if (cache[x][y] != -1) {
			return cache[x][y];
		}
		
		int min = Integer.MIN_VALUE;
		
		for (int i = 0; i < DIRECTIONS.length; i++) {
			int nextX = x + DIRECTIONS[i][0];
			int nextY = y + DIRECTIONS[i][1];
			
			min = Math.max(min, maxCost(nextX, nextY, cache));
		}
		
		cache[x][y] = COST[x][y] + min;
		
		return cache[x][y];
	}
}
