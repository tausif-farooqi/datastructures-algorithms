package ds.twodarray;

import java.util.Arrays;

public class AppleOrchard {

	public static void main(String[] args) {
		int[][] orchard = {
				{1, 2, 5},
				{4, 20, 8},
				{10, 3, 1}
		};
		int[][] cache = new int[orchard.length][orchard[0].length];
		for (int i = 0; i < orchard.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		
		System.out.println("Max apples -> " + maxApples(orchard, orchard.length - 1, orchard.length - 1, cache));
	}
	
	private static int maxApples(int[][] orchard, int i, int j, int[][] cache) {
		if (i < 0 || j < 0 || i > orchard.length - 1 || j > orchard[0].length - 1) {
			return Integer.MIN_VALUE;
		}

		if (i == 0 && j == 0) {
			return orchard[i][j];
		}
		
		if (cache[i][j] != -1) {
			return cache[i][j];
		}
		
		// up
		int max = maxApples(orchard, i - 1, j, cache);
		
		// left
		max = Math.max(max, maxApples(orchard, i, j - 1, cache));
		
		cache[i][j] = max + orchard[i][j];
		
		return cache[i][j];
	}

}
