package ds.dp;

import java.util.Arrays;

/**
 * Given two strings, find the longest common subsequence in both strings.
 * 
 * @author tausif.farooqi
 *
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// longest sub-sequence = CEMG (4)
		String first = "ACHEFMGLP";
		String second = "XYCEPQMLG";
		
		int[][] cache = new int[first.length()][second.length()];
		for (int i = 0; i < first.length(); i++) {
			Arrays.fill(cache[i], -1);
		}

		// for the top-down approach, we start at the end of the strings
		System.out.println(longestSubsequence(first, second, first.length() - 1, second.length() - 1, cache));
		
		// bottom-up approach
		System.out.println(longestSubsequenceBottomUp(first, second));
	}

	private static int longestSubsequence(String first, String second, int i, int j, int[][] cache) {
		if (i < 0 || j < 0) {
			return 0;
		}
		
		if (cache[i][j] != -1) {
			return cache[i][j];
		}
		
		if (first.charAt(i) == second.charAt(j)) {
			cache[i][j] = 1 + longestSubsequence(first, second, i - 1, j - 1, cache);
			return cache[i][j];
		}
		
		cache[i][j] = Math.max(longestSubsequence(first, second, i - 1, j, cache), longestSubsequence(first, second, i, j - 1, cache));
		return cache[i][j];
	}
	
	/**
	 * For the bottom up approach, we start from the beginning of the string.
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	private static int longestSubsequenceBottomUp(String first, String second) {
		int[][] longest = new int[first.length()][second.length()];
		longest[0][0] = first.charAt(0) == second.charAt(0) ? 1 : 0;
		
		for (int i = 0; i < first.length(); i++) {
			for (int j = 0; j < second.length(); j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				
				if (first.charAt(i) == second.charAt(j)) {
					longest[i][j] = longest[i - 1][j - 1] + 1;
				} else {
					if (i > 0) {
						longest[i][j] = longest[i - 1][j];
					}
					
					if (j > 0) {
						longest[i][j] = Math.max(longest[i][j], longest[i][j - 1]);						
					}
				}
			}
		}
		
		return longest[first.length() - 1][second.length() - 1];
	}
}
