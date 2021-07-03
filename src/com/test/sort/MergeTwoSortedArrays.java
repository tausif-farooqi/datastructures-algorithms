package com.test.sort;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5, 7, 10, 12};
		int[] arr2 = {0, 2, 6, 8, 9, 12, 17, 20};
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] > arr2[j]) {
					reorder(arr1, arr2, i, j);
				}
			}
		}
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
		System.out.println("----------------");
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

	}
	
	private static void reorder(int[] arr1, int[] arr2, int arr1Index, int arr2Index) {
		int last = arr1[arr1.length - 1];
		
		// push all elements in arr1 (between the swap index and last index) by 1 index
		for (int i = arr1.length - 2; i >= arr1Index; i--) {
			arr1[i + 1] = arr1[i];
		}
		
		// replace the element
		arr1[arr1Index] = arr2[arr2Index];
		
		merge(arr2, arr2Index, last);
		
	}

	private static void merge(int[] arr2, int arr2Index, int last) {
		// pull all the elements in arr2 (between the first index and swap index) by 1 index
		for (int i = arr2Index + 1; i < arr2.length; i++) {
			int curr = arr2[i];
			if (arr2[i] > last) {
				// last has been merged so exit the loop
				arr2[i - 1] = last;
				return;
			} else {
				
				arr2[i - 1] = arr2[i];
			}
		}
		
		// if this was the largest number then put it at the end
		arr2[arr2.length - 1] = last;
	}

}
