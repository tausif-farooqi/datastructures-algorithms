package ds.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class TotalPrimes {
	private static Map<Long, Boolean> mem = new HashMap<>();
	private static Map<String, Boolean> mem2 = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(primeDigitSums(8));
	}
	
    /*
     * Complete the 'primeDigitSums' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int primeDigitSums(int n) {
        BigInteger min = BigInteger.TEN.pow(n - 1);
        BigInteger max =  BigInteger.TEN.pow(n);
        int total = 0;
        int[] digits = {3, 4, 5};
        
        for (BigInteger i = min; i.compareTo(max) != 0; i = i.add(BigInteger.ONE)) {
        	boolean allPrimes = true;

        	for (int j = 0; j < digits.length; j++) {
                
            	if (!isAllConsecutiveSumPrimes(i, digits[j])) {
                	allPrimes = false;
                	break;
                }
            }
            
            if (allPrimes) {
            	++total;
            }
        }
        
        return total;
    }
    
    private static boolean isAllConsecutiveSumPrimes(BigInteger n, int digits) {
        String num = n.toString();
        int len = num.length() - digits;
        boolean allPrimes = true;
        
        for (int i = 0; i <= len; i++) {
            String substring = num.substring(i, i + digits);
            if (mem2.get(substring) != null) {
            	return mem2.get(substring);
            }
            
			String[] sub = substring.split("");
            int sum = 0;
            
            for (int j = 0; j < sub.length; j++) {
            	sum += Integer.parseInt(sub[j]);
            }
            
            if (!isPrime(sum)) {
                allPrimes = false;
                mem2.put(substring, false);
                break;
            }
            
            mem2.put(substring, true);
        }
        
        return allPrimes;
    }
    
    private static boolean isPrime(long n) {
        Boolean val = mem.get(n);
        if (val != null) {
            return val;
        }
        
        if (n <= 1) {
            mem.put(n, false);
            return false;
        }
        
        val = true;
        long mid = n / 2;
        
        for (long i = 2; i <= mid; i++) {
            if (n % i == 0) {
                val = false;
                break;
            }
        }
        
        mem.put(n, val);
        
        return val;
    }	

}
