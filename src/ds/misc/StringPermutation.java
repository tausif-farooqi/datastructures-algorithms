package ds.misc;

public class StringPermutation {

	public static void main(String[] args) {
		String s = "abc";
		permutation(s, 0, s.length() - 1);
	}
	
	public static void permutation(String s, int x, int y) {
		if (x == y) {
			System.out.println(s);
		}
		
		for (int i = x; i <= y; i++) {
			s = swap(s, x, i);
			permutation(s, x + 1, y);
			s = swap(s, x, i);
		}
	}

	private static String swap(String s, int x, int y) {
		char temp;
		char[] array = s.toCharArray();
		temp = array[x];
		array[x] = array[y];
		array[y] = temp;
		
		return String.valueOf(array);
	}
}
