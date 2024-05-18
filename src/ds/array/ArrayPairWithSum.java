package ds.array;

import java.util.HashMap;
import java.util.Map;

public class ArrayPairWithSum {
	
	public static int[] findPairWithSum(int[] array, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		
		for (int i = 0; i < array.length; i++) {
			Integer value = map.get(array[i]);
			if (value != null) {
				return new int[] {value, i};
			}
			
			int num = target - array[i];
			map.put(num, i);
		}
		
		return null;
	}

	public static void main(String[] args) {
		int[] result = findPairWithSum(new int[] {3, 5, 4, 9, 2}, 13);
		
		if (result == null) {
			System.out.println("No result");
		} else {			
			System.out.println("[" + result[0] + ", " + result[1] + "]");
		}

	}

}
