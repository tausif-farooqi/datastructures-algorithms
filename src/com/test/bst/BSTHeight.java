package com.test.bst;

public class BSTHeight {

	public static void main(String[] args) {
		Node tree = buildTree();
		BSTUtils.printTree(tree);
		System.out.println("\nHeight: " + height(tree));
		
	}

	private static int height(Node node) {
		if (node == null) {
			return -1;
		}
				
		int leftHeight = height(node.getLeft());
		int rightHeight = height(node.getRight());
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	private static Node buildTree() {
		Node root = new Node(15);
		root.addLeft(10);
		root.addRight(20);
		root.getLeft().addLeft(8);
		root.getLeft().addRight(12);
		root.getLeft().getRight().addRight(14);
		root.getRight().addLeft(16);
		root.getRight().addRight(25);
		
		return root;
	}
}
