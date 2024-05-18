package ds.dp;

public class BinomialCoefficient {
	private static int[][] cache;
	
	public static void main(String[] args) {
		
	}
	
	// coeff(n, k) = coeff(n - 1, k - 1) + coeff(n - 1, k)
	private static int coeff(int n, int k) {
		if (k == 0) {
			return 1;
		}
		
		if (n == k) {
			return 1;
		}
		
		if (cache[n][k] != 0) {
			return cache[n][k];
		}
		
		int result = coeff(n - 1, k - 1) + coeff(n - 1, k);
		cache[n][k] = result;
		
		return result;
	}
}
