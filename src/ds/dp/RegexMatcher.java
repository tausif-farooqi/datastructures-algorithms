package ds.dp;

/**
 * Given a regex and a string, find if the regex matches the string or not.
 * 
 * @author tausif.farooqi
 *
 */
public class RegexMatcher {
	private static int iterations = 0;

	public static void main(String[] args) {
		String s = "ABBBAC";
		String regex = ".*A*";
		Boolean[][] cache = new Boolean[s.length()][regex.length()];

		System.out.println("Matches -> " + matches(s, regex, s.length() - 1, regex.length() - 1, cache));
		System.out.println("Iterations -> " + iterations);
	}
	
	private static boolean matches(String s, String regex, int i, int j, Boolean[][] cache) {
		if (i < 0 && j < 0) {
			return true;
		}
		
		if (i < 0 || j < 0) {
			return false;
		}
		
		if (cache[i][j] != null) {
			return cache[i][j];
		}
		
		++iterations;
		
		String r = String.valueOf(regex.charAt(j));
		
		if ("*".equals(r)) {
			cache[i][j] = matches(s, regex, i - 1, j, cache) || matches(s, regex, i, j - 1, cache);
			return cache[i][j];
		} else if (".".equals(r) || regex.charAt(j) == s.charAt(i)) {
			cache[i][j] = matches(s, regex, i - 1, j - 1, cache);
			return cache[i][j];
		}
		
		cache[i][j] = false;
		
		return cache[i][j];
	}

}
