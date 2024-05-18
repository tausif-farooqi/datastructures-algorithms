package ds.dp;

/**
 * Given three integers, , , and , compute and print the  term of a modified Fibonacci sequence.

Example



Return .


 * @author tausif.farooqi
 *
 */
public class ModifiedFibonacci {
	public static void main(String[] args) {
		System.out.println(fibonacciModified(0, 1, 5));
	}
	
    public static int fibonacciModified(int t1, int t2, int n) {
    // Write your code here
    // t3 = t1 + t2^2
    // t4 = t2 + t3^2
    
        int[] mem = new int[n];
        mem[0] = t1;
        mem[1] = t2;
    
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 2] + (int) Math.pow(mem[i - 1],  2);
        }

        return mem[n - 1];
    }
}
