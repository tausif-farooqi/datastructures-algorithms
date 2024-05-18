package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BSTPairWithSum {

	public static void main(String[] args) {
		Node tree = buildTree();
		BSTUtils.printTree(tree);
		List<Integer> list = new ArrayList<Integer>();
		getAscendingOrder(tree, list);
		
		System.out.println("");
		System.out.println(list);
		
		int target = 40;
		int[] pair = findPair(list, target);
		if (pair == null) {
			System.out.println("\nNo pair could be found for target " + target);
		} else {
			System.out.println("\n" + pair[0] + " + " + pair[1] + " = " + target);
		}
	}
	
	public static int[] findPair(List<Integer> list, int target) {
		int i = 0;
		int j = list.size() - 1;
		int sum = 0;
		
		while (i < j) {
			Integer int1 = list.get(i);
			Integer int2 = list.get(j);
			sum = int1 + int2;
			
			if (sum == target) {
				return new int[] {int1, int2};
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}
		
		return null;
	}

	private static void getAscendingOrder(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}
				
		if (node.getLeft() != null) {
			getAscendingOrder(node.getLeft(), list);
		}
		
		list.add(node.getValue());
		
		if (node.getRight() != null) {
			getAscendingOrder(node.getRight(), list);
		}
	}
	
	private static Node buildTree() {
		Node root = new Node(15);
		root.addLeft(10);
		root.addRight(20);
		root.getLeft().addLeft(8);
		root.getLeft().addRight(12);
		root.getRight().addLeft(16);
		root.getRight().addRight(25);
		
		return root;
	}
}
