package com.test.bst;

public class BSTDifferenceBetweenOddEvenLevels {

	public static void main(String[] args) {
		Node tree = buildTree();
		BSTUtils.printTree(tree);
		int[] sums = new int[] {0, 0};
		sumOddEven(tree, 1, sums);
		
		System.out.println("Odd: " + sums[0]);
		System.out.println("Even: " + sums[1]);
		
	}

	private static void sumOddEven(Node node, int level, int[] oddEvenSum) {
		if (node == null) {
			return;
		}
				
		int val = node.getValue();

		if (level % 2 == 1) {
			oddEvenSum[0] += val;
		} else {
			oddEvenSum[1] += val;
		}
				
		int nextLevel = level + 1;
		
		if (node.getLeft() != null) {
			sumOddEven(node.getLeft(), nextLevel, oddEvenSum);
		}
		
		if (node.getRight() != null) {
			sumOddEven(node.getRight(), nextLevel, oddEvenSum);
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
