package ds.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 10, 2, 11, 17, 9, 4};
		quickSort(numbers, 0, numbers.length - 1);
		
		System.out.println("\nResult -> ");
		printArray(numbers, 0, numbers.length - 1);
	}
	
	private static void quickSort(int[] nums, int start, int end) {
        System.out.println("\n\nquickSort: start - " + start + " end - " + end);
        System.out.print("In -> "); 
        printArray(nums, start, end);
        
        if (start >= end) {
            return;
        }
        
        int pivot = nums[end];
        int pivotPosition = end;
        int index = start;
        
        while (index < pivotPosition) {
            if (nums[index] > pivot) {
                int shiftNum = nums[index];
                --pivotPosition;
                nums[index] = nums[pivotPosition];
                nums[pivotPosition] = pivot;
                nums[pivotPosition + 1] = shiftNum;
            } else {
            	++index;            	
            }
            
        }
        
        System.out.print("\nOut -> "); 
        printArray(nums, start, end);
        
        quickSort(nums, start, pivotPosition - 1);
        quickSort(nums, pivotPosition + 1, end);
	}
	
	private static void printArray(int[] nums, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(nums[i] + ", ");
		}
	}
}
