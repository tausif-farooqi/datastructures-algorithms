package ds.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratePrimes {

	public static void main(String[] args) {
		int n = 100;
		List<Boolean> isPrime = new ArrayList<Boolean>(Collections.nCopies(n + 1, Boolean.TRUE));
		List<Integer> primes = new ArrayList<Integer>();
		
		// 0 and 1 are not primes
		isPrime.set(0, Boolean.FALSE);
		isPrime.set(1, Boolean.FALSE);
		
		for (int i = 2; i <= n; i++) {
			if (isPrime.get(i)) {
				primes.add(i);
				
				// all multiples of i are not primes
				for (int j = i * 2; j < n; j += i) {
					isPrime.set(j, Boolean.FALSE);
				}
			}
		}
		
		System.out.println(primes);

	}

}
