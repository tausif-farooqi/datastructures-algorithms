package ds.array;

public class ShiftArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		
//		int first = arr[0];
//		
//		for (int i = 1; i < arr.length; i++) {
//			arr[i - 1] = arr[i];
//		}
//		
//		arr[arr.length - 1] = first;
//		
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		System.out.println("-------------");
		
		int last = arr[arr.length - 1];
		
		for (int i = arr.length - 2; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		
		arr[0] = last;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
