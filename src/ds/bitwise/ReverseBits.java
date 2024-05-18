package ds.bitwise;

public class ReverseBits {

	public static void main(String[] args) {
		long num = 957821109111L;
		String binary = Long.toBinaryString(num);
		System.out.println(String.format("Number %s in binary %s", num, binary));
		
		int strLen = binary.length();
		int loopLen = strLen / 2;
		
		for (int i = 0; i < loopLen; i++) {
			num = swapBits(num, i, strLen - i - 1);
		}
		
		System.out.println(String.format("Reversed number is %s and it's binary equivalent is %s", num, Long.toBinaryString(num)));
	}
	
	private static long swapBits(long num, int i, int j) {
		long bit1 = (num >>> i) & 1;
		long bit2 = (num >>> j) & 1;
		
		if (bit1 == bit2) {
			// both bits are the same so reversal will have no effect, so we just return the number as is
			return num;
		}
		
		long mask = (1L << i) | (1L << j);
		return num ^ mask;
	}

}
