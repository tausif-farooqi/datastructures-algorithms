package ds.dp;

import java.util.Arrays;

/**
 * There are N cubes arranged sequentially at equal distances. You start at the first cube (index = 0). You need
 * to jump over the cubes to reach the end. In one jump you can jump a max of X cubes. Jumping on a cube incurs a
 * cost. The cost is different for each cube. Find the minimum cost to reach the last cube.
 * 
 * @author tausif.farooqi
 *
 */
public class JumpCubes {
	private static final int[] PRICE = {20, 30, 40, 25, 15, 20, 28};

	public static void main(String[] args) {
		int numCubes = 7;
		int maxJump = 3;
		int cache[] = new int[numCubes];
		Arrays.fill(cache, -1);
		
		System.out.println(findMinCost(numCubes - 1, maxJump, cache));
	}

	private static int findMinCost(int currentStep, int maxJump, int cache[]) {
		if (currentStep < 0) {
			return 0;
		}
		
		if (cache[currentStep] != -1) {
			return cache[currentStep];
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < maxJump; i++) {
			min = Math.min(min, PRICE[currentStep] + findMinCost(currentStep - i - 1, maxJump, cache));
		}
		
		cache[currentStep] = min;
		
		return min;
	}
}
