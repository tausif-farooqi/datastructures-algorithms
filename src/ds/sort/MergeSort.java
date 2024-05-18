package ds.sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 10, 2, 11, 9, 15, 16, 17, 4, 5};
		sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");			
		}
	}
	
	public static void sort(int[] numbers) {
		if (numbers.length < 2) {
			return;
		}
		
		int len1 = numbers.length / 2;
		int len2 = numbers.length - len1;
		
		int[] part1 = new int[len1];
		for (int i = 0; i < len1; i++) {
			part1[i] = numbers[i];
		}
		
		int[] part2 = new int[len2];
		for (int i = len1; i < numbers.length; i++) {
			part2[i - len1] = numbers[i];
		}
		
		sort(part1);
		sort(part2);
		merge(numbers, part1, part2);
		
	}

	private static void merge(int[] numbers, int[] part1, int[] part2) {
		int i = 0, j = 0, k = 0;
		int len1 = part1.length;
		int len2 = part2.length;
		
		while (i < len1 && j < len2) {
			if (part1[i] < part2[j]) {
				numbers[k++] = part1[i++];
			} else {
				numbers[k++] = part2[j++];
			}
		}
		
		while (i < len1) {
			numbers[k++] = part1[i++];
		}
		
		while (j < len2) {
			numbers[k++] = part2[j++];
		}
	}
}
