package ds.dp;

import java.util.Arrays;

/**
 * Given two strings, find how many steps it takes to convert the first string into the second one. You can perform 3 types
 * of operations on the string - delete, replace, insert.
 * 
 * @author tausif.farooqi
 *
 */
public class EditDistance {

	public static void main(String[] args) {
		String from = "horse";
		String to = "ros";
		int[][] cache = fillCache(from.length(), to.length());
		
		System.out.println("Edit distance -> " + getEditDistance(from, to, from.length() - 1, to.length() - 1, cache));
		
		System.out.println("Edit distance DP -> " + getEditDistanceDP(from, to));
	}
	
	private static int getEditDistance(String from, String to, int i, int j, int[][] cache) {
		// if there are no more characters left in the first string, then we need to insert the remaining number
		// of chars that are left in the second string
		if (i == -1) {
			return j + 1;
		}
		
		// if there are no more characters left in the second string, then we delete the number of chars left in
		// the first string
		if (j == -1) {
			return i + 1;
		}
		
		if (cache[i][j] != -1) {
			return cache[i][j];
		}
		
		// if both characters at the current position are the same then we move the pointers back by 1 and test again
		if (from.charAt(i) == to.charAt(j)) {
			return getEditDistance(from, to, i - 1, j - 1, cache);
		}
		
		int min = Integer.MAX_VALUE;
		
		// insert
		min = Math.min(min, getEditDistance(from, to, i, j - 1, cache));
		
		// replace
		min = Math.min(min, getEditDistance(from, to, i - 1, j - 1, cache));
		
		// delete
		min = Math.min(min, getEditDistance(from, to, i - 1, j, cache));
		
		cache[i][j] = 1 + min;
		
		return cache[i][j];
	}
	
	private static int getEditDistanceDP(String from, String to) {
		int len1 = from.length();
		int len2 = to.length();
		int[][] dist = new int[len1][len2];
		
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (i == 0) {
					dist[i][j] = j; 
				} else if (j == 0) {
					dist[i][j] = i; 
				} else if (from.charAt(i - 1) == to.charAt(j - 1)) {
					dist[i][j] = dist[i - 1][j - 1];
				} else {
					int min = Integer.MAX_VALUE;
					
					min = Math.min(min, dist[i][j - 1]);
					min = Math.min(min, dist[i - 1][j - 1]);
					min = Math.min(min, dist[i - 1][j]);
					
					dist[i][j] = 1 + min;
				}
			}
		}
		
		return dist[len1 - 1][len2 - 1];
	}
	
	private static int[][] fillCache(int len1, int len2) {
		int[][] cache = new int[len1][len2];
		for (int i = 0; i < len1; i++) {
			Arrays.fill(cache[i], -1);
		}
		
		return cache;
	}
	
}
