package ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {

	public static void main(String[] args) {
		int[] input = {3, 2, 3, 1, 2, 4, 5, 5, 6};
		int k = 4;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(input.length, Collections.reverseOrder());
        
        for (int i = 0; i < input.length; i++) {
            pq.offer(input[i]);
        }
        
        Integer result = -1;
        for (int i = 0; i < k; i++) {
            result = (Integer) pq.poll();
        }
        
        System.out.println(result);
	}

}
