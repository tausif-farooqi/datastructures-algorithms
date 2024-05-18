package ds.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = {5, 1, 7, 3, 2, 9};
		int len = array.length;
		
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		for (int i = 0; i < len; i++) {
			System.out.println(array[i]);
		}
	}

}
