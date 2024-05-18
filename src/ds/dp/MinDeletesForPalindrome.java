package ds.dp;

import java.util.Arrays;

/**
 * Given a string S, find the minimum number of deletions required to make it a palindrome.
 * 
 * @author tausif.farooqi
 *
 */
public class MinDeletesForPalindrome {
	private static int iterations = 0;

	public static void main(String[] args) {
		String s = "kazyake";		
		int[][] cache = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			Arrays.fill(cache[i], -1);
		}
		
		System.out.println("Result -> " + minDeletes(s, 0, s.length() - 1, cache));
		System.out.println("iterations -> " + iterations);
	}
	
	private static int minDeletes(String s, int start, int end, int[][] cache) {
		if (cache[start][end] != -1) {
			return cache[start][end];
		}
		
		while (start < end) {
			++iterations;
			
			if (s.charAt(start) == s.charAt(end)) {
				++start;
				--end;
			} else {
				cache[start][end] = 1 + Math.min(minDeletes(s, start, end - 1, cache), minDeletes(s, start + 1, end, cache));
				return cache[start][end];
			}
		}
		
		return 0;
	}
}
