package ds.dp;

import java.util.Arrays;

/**
 * Given a rod of length N and an array of prices for different lengths of the rod, find the max cost we can get by cutting
 * the rod into smaller pieces.
 * 
 * @author tausif.farooqi
 *
 */
public class RodCutting {
	private static final int[] PRICE = {1, 5, 8, 9, 10, 14, 17, 20, 24, 30};

	public static void main(String[] args) {
		int length = 8;
		int[] cache = new int[length];
		Arrays.fill(cache, -1);
		
		System.out.println(findMaxCost(length, cache));

	}
	
	private static final int findMaxCost(int length, int[] cache) {
		if (length == 0) {
			return 0;
		}
		
		if (cache[length - 1] != -1) {
			return cache[length - 1];
		}
		
		int maxCost = -1;
		for (int i = 0; i < length; i++) {
			maxCost = Math.max(maxCost, PRICE[i] + findMaxCost(length - i - 1, cache));
		}
		
		cache[length - 1] = maxCost;
		
		return maxCost;
	}

}
