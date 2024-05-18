package ds.bitwise;

public class SwapBits {

	public static void main(String[] args) {
		long number = 47;
		System.out.println(Long.toBinaryString(number));
		
		Long swapped = swapBits(number, 3, 4);
		System.out.println(swapped);
		System.out.println(Long.toBinaryString(swapped));

	}
	
	private static Long swapBits(Long number, int pos1, int pos2) {
		long pos1Bit = (number >>> pos1) & 1;
		long pos2Bit = (number >>> pos2) & 1;
		
		if (pos1Bit == pos2Bit) {
			return number;
		}
		
		long mask = (1L << pos1) | (1L << pos2);
		
		return number ^ mask;
	}

}
