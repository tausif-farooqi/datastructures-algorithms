package ds.array;

public class ArrayRotate {

	public static void main(String[] args) {
		String[] arr = {"A", "B", "C", "D", "E"};
		int places = 3;
		
		for (int i = 0; i < places; i++) {
			rotate(arr);			
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
	
	public static void rotate(String[] array) {
		int length = array.length;
		String last = array[length - 1];
		for (int i = 0; i < length - 1; i++) {
			array[length - i - 1] = array[length - i - 2];
		}
		
		array[0] = last;
	}

}
