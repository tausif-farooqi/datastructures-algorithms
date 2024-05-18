package ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteDupesSortedArray {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 1, 2, 3, 3, 5, 6, 7, 7, 7, 7, 7, 9);
		int current = list.get(0);
		
		// option 1 - needs extra space
		List<Integer> noDupes = new ArrayList<Integer>();
		
		noDupes.add(current);
		
		for (int i = 1; i < list.size(); i++) {
			if (current == list.get(i)) {
				// skip to the next element
				continue;
			}
			
			current = list.get(i);
			noDupes.add(current);
		}

		System.out.println(noDupes);
		
		// option 2 - O(1) extra space
		current = list.get(0);
		int nextIndexToWrite = 1;
		
		for (int i = 1; i < list.size(); i++) {
			if (current == list.get(i)) {
				// skip to the next element
				continue;
			}
			
			current = list.get(i);
			list.set(nextIndexToWrite, current);
			++nextIndexToWrite;
		}
		
		list = list.subList(0, nextIndexToWrite);
		
		System.out.println(list);
	}

}
