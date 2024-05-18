package ds.dp;

import java.util.Arrays;

/**
 * Given a matrix, find the minimum cost to travel from the top left corner to the bottom right corner.
 * Each element of the matrix defines the cost it takes to reach that element. You can only move down 
 * or right.
 * 
 * @author tausif.farooqi
 *
 */
public class MinCostPath {
//	private static final int[][] COST = {
//			{0, 47, 8, 18, 1},
//			{43, 25, 39, 36, 13},
//			{22, 8, 13, 38, 46},
//			{41, 41, 40, 25, 44},
//			{29, 43, 22, 50, 10}
//	};
	
//	private static final int[][] COST = {
//			{1,3,1},
//			{1,5,1},
//			{4,2,1}
//	};
	
	private static final int[][] COST = {
			{1,2,4},
			{4,5,6}
	};	
	
	// We're calculating from the opposite side, so we change the movement to up or left.
	private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}};
	
	public static void main(String[] args) {
		int[][] cache = fillCache();
		System.out.println("Min top down -> " + minCost(COST.length - 1, COST[0].length - 1, cache));
		
		System.out.println("Min bottom up -> " + minCostBottomUp());
	}
	
	private static int[][] fillCache() {
		int[][] cache = new int[COST.length][COST[0].length];
		for (int i = 0; i < COST.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		
		return cache;
	}
	
	private static int minCost(int x, int y, int[][] cache) {
		if (x < 0 || y < 0) {
			return Integer.MAX_VALUE;
		}
		
		if (x == 0 && y == 0) {
			return COST[0][0];
		}
		
		if (cache[x][y] != -1) {
			return cache[x][y];
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < DIRECTIONS.length; i++) {
			int nextX = x + DIRECTIONS[i][0];
			int nextY = y + DIRECTIONS[i][1];
			
			min = Math.min(min, minCost(nextX, nextY, cache));
		}
		
		cache[x][y] = COST[x][y] + min;
		
		return cache[x][y];
	}
	
	/**
	 * For the bottom-up solution, we traverse the original direction.
	 * 
	 * @return
	 */
	private static int minCostBottomUp() {
		int[][] minCost = new int[COST.length][COST[0].length];
		minCost[0][0] = COST[0][0];
		
		for (int i = 0; i < COST.length; i++) {
			for (int j = 0; j < COST[0].length; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				
				minCost[i][j] = Integer.MAX_VALUE;
				if (i - 1 >= 0) {
					minCost[i][j] = minCost[i - 1][j] + COST[i][j];
				}
				
				if (j - 1 >= 0) {
					minCost[i][j] = Math.min(minCost[i][j], minCost[i][j - 1] + COST[i][j]);
				}
			}
		}
		
		return minCost[COST.length - 1][COST[0].length - 1];
	}

}
