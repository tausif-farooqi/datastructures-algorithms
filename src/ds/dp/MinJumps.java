package ds.dp;

import java.util.Arrays;

/**
 * Given an array of non-negative integers "nums", you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 * 
 * @author tausif.farooqi
 *
 */
public class MinJumps {
	private static final int[] NUMS = {2, 1};
	//private static final int[] NUMS = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
	//private static final int[] NUMS = {2, 3, 1, 1, 4};

	public static void main(String[] args) {
		int[] cache = new int[NUMS.length];
		Arrays.fill(cache, -1);
		System.out.println(minJumps(0, cache));
	}
	
	private static int minJumps(int currentIndex, int[] cache) {
		if (currentIndex >= NUMS.length - 1) {
			return 0;
		}
		
		if (cache[currentIndex] > 0) {
			return cache[currentIndex];
		}
		
		int maxJumps = NUMS[currentIndex];
		int min = Integer.MAX_VALUE;
		
		for (int i = maxJumps; i >= 1; i--) {
			int jumps = 1 + minJumps(currentIndex + i, cache);
			if (jumps > 0) {
				min = Math.min(min, jumps);					
			}
		}
		
		cache[currentIndex] = min;
		
		return cache[currentIndex];
	}

}
